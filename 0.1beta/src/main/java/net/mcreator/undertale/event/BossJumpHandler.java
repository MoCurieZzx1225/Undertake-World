package com.undertale.event;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.*;

@EventBusSubscriber(modid = "undertale")
public class BossJumpHandler {

    private static final double JUMP_RADIUS = 4.0;
    private static final double JUMP_HEIGHT = 2.5;
    private static final int JUMP_TICKS = 10;
    
    private static final Map<UUID, JumpData> activeJumps = new HashMap<>();
    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onBossHurt(LivingIncomingDamageEvent event) {
        LivingEntity target = event.getEntity();
        
        // 检测是否为 Undyue
        if (!isUndyue(target)) return;
        if (!(target.level() instanceof ServerLevel serverLevel)) return;
        
        // 防止重复跳跃
        if (activeJumps.containsKey(target.getUUID())) {
            return;
        }

        Entity attacker = event.getSource().getEntity();
        if (attacker == null) return;

        // 寻找最近的敌对实体
        LivingEntity centerEntity = findNearestEnemy(target, serverLevel);
        if (centerEntity == null) return;

        // 计算目标位置
        Vec3 centerPos = centerEntity.position();
        Vec3 jumpTarget = calculateRandomPositionOnCircle(centerPos, JUMP_RADIUS);
        
        startJump(target, jumpTarget);
    }

    @SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post event) {
        Iterator<Map.Entry<UUID, JumpData>> iterator = activeJumps.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<UUID, JumpData> entry = iterator.next();
            JumpData data = entry.getValue();
            LivingEntity boss = data.boss;
            
            if (!boss.isAlive() || boss.level().isClientSide()) {
                iterator.remove();
                continue;
            }
            
            data.currentTick++;
            
            if (data.currentTick > JUMP_TICKS) {
                iterator.remove();
                continue;
            }
            
            double progress = (double) data.currentTick / JUMP_TICKS;
            double heightOffset = 4 * JUMP_HEIGHT * progress * (1 - progress);
            
            double newX = data.startX + data.deltaX * data.currentTick;
            double newZ = data.startZ + data.deltaZ * data.currentTick;
            double newY = data.startY + heightOffset;
            
            // 地面碰撞检测 - 确保不会穿墙
            BlockPos pos = BlockPos.containing(newX, newY, newZ);
            if (!boss.level().getBlockState(pos).isSolid() && 
                !boss.level().getBlockState(pos.above()).isSolid()) {
                boss.setPos(newX, newY, newZ);
                boss.setDeltaMovement(0, 0, 0);
            }
        }
    }

    // ==================== 检测 Undyue ====================
    
    /**
     * 通过类名检测是否为 Undyue 实体
     */
    private static boolean isUndyue(LivingEntity entity) {
        // MCreator 生成的实体类名通常是 UndyueEntity
        return entity.getClass().getSimpleName().equals("UndyueEntity");
    }

    // ==================== 跳跃逻辑 ====================

    private static void startJump(LivingEntity boss, Vec3 target) {
        Vec3 start = boss.position();
        
        double deltaX = (target.x - start.x) / JUMP_TICKS;
        double deltaZ = (target.z - start.z) / JUMP_TICKS;
        
        activeJumps.put(boss.getUUID(), new JumpData(
            boss, start.x, start.y, start.z, deltaX, deltaZ
        ));
    }

    private static Vec3 calculateRandomPositionOnCircle(Vec3 center, double radius) {
        double angle = RANDOM.nextDouble() * 2 * Math.PI;
        double offsetX = Math.cos(angle) * radius;
        double offsetZ = Math.sin(angle) * radius;
        return new Vec3(center.x + offsetX, center.y, center.z + offsetZ);
    }

    private static LivingEntity findNearestEnemy(LivingEntity boss, ServerLevel level) {
        double searchRadius = 16.0;
        AABB searchBox = boss.getBoundingBox().inflate(searchRadius);

        List<LivingEntity> nearbyEntities = level.getNearbyEntities(
            LivingEntity.class,
            TargetingConditions.forCombat().range(searchRadius),
            boss,
            searchBox
        );

        LivingEntity nearest = null;
        double nearestDistance = Double.MAX_VALUE;

        for (LivingEntity entity : nearbyEntities) {
            if (entity == boss) continue;
            if (isHostile(boss, entity)) {
                double dist = boss.distanceToSqr(entity);
                if (dist < nearestDistance) {
                    nearestDistance = dist;
                    nearest = entity;
                }
            }
        }

        return nearest;
    }

    private static boolean isHostile(LivingEntity entity1, LivingEntity entity2) {
        if (entity1 instanceof Mob mob1 && entity2 instanceof Mob mob2) {
            return mob1.getTarget() == entity2 || mob2.getTarget() == entity1;
        }
        if (entity1 instanceof net.minecraft.world.entity.player.Player) {
            return entity2 instanceof Mob && ((Mob) entity2).getTarget() == entity1;
        }
        if (entity2 instanceof net.minecraft.world.entity.player.Player) {
            return entity1 instanceof Mob && ((Mob) entity1).getTarget() == entity2;
        }
        return false;
    }

    private static class JumpData {
        final LivingEntity boss;
        final double startX, startY, startZ;
        final double deltaX, deltaZ;
        int currentTick = 0;

        JumpData(LivingEntity boss, double startX, double startY, double startZ, 
                 double deltaX, double deltaZ) {
            this.boss = boss;
            this.startX = startX;
            this.startY = startY;
            this.startZ = startZ;
            this.deltaX = deltaX;
            this.deltaZ = deltaZ;
        }
    }
}