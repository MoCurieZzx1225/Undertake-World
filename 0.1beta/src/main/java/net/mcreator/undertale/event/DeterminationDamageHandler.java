package com.undertale.event;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import java.util.Optional;

@EventBusSubscriber(modid = "undertale")
public class DeterminationDamageHandler {

    private static final ResourceKey<Enchantment> DETERMINATION_KEY = ResourceKey.create(
        Registries.ENCHANTMENT,
        ResourceLocation.fromNamespaceAndPath("undertale", "determination")
    );

    @SubscribeEvent
    public static void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) {
            return;
        }

        ItemStack weapon = attacker.getMainHandItem();
        if (weapon.isEmpty()) {
            return;
        }

        var enchantRegistry = attacker.level().registryAccess()
            .registryOrThrow(Registries.ENCHANTMENT);
        
        Optional<Holder.Reference<Enchantment>> enchantHolder = enchantRegistry.getHolder(DETERMINATION_KEY);
        
        if (enchantHolder.isEmpty()) {
            return;
        }

        int enchantLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantHolder.get(), weapon);
        if (enchantLevel <= 0) {
            return;
        }

        int experienceLevel = 0;
        if (attacker instanceof Player player) {
            experienceLevel = player.experienceLevel;
        }

        float damageMultiplier = 1.0f + (experienceLevel * 0.01f);
        float originalDamage = event.getAmount();
        float newDamage = originalDamage * damageMultiplier;

        event.setAmount(newDamage);
    }
}