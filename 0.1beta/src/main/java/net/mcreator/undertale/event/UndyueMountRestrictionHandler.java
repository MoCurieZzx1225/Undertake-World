package com.undertale.event;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Boat;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityMountEvent;

@EventBusSubscriber(modid = "undertale")
public class UndyueMountRestrictionHandler {

    @SubscribeEvent
    public static void onEntityMount(EntityMountEvent event) {
        // 只拦截"骑上"的行为，不拦截"下来"
        if (!event.isMounting()) {
            return;
        }

        Entity rider = event.getEntityMounting();
        Entity mount = event.getEntityBeingMounted();

        // 只有 Undyue 尝试骑乘时才处理
        if (!isUndyue(rider)) {
            return;
        }

        // 检查目标是否是载具（船、矿车等）
        if (isVehicle(mount)) {
            // 取消骑乘
            event.setCanceled(true);
        }
    }

    /**
     * 判断实体是否为 Undyue
     */
    private static boolean isUndyue(Entity entity) {
        return entity.getClass().getSimpleName().equals("UndyueEntity");
    }

    /**
     * 判断实体是否为载具
     */
    private static boolean isVehicle(Entity entity) {
        return entity instanceof Boat
            || entity instanceof AbstractMinecart;
        // ChestBoat 是 Boat 的子类，已被包含
    }
}