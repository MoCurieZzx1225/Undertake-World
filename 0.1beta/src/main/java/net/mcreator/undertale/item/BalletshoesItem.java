package net.mcreator.undertale.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.undertale.UndertaleMod;

import java.util.List;

public class BalletshoesItem extends Item {
	public BalletshoesItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)
				.attributes(ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 8, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
						.add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.8, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
						.add(Attributes.ARMOR, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(UndertaleMod.MODID, "balletshoes_0"), 2, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND)
						.add(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(UndertaleMod.MODID, "balletshoes_1"), 0.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
						.add(Attributes.GRAVITY, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(UndertaleMod.MODID, "balletshoes_2"), -0.01, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND)
						.add(Attributes.JUMP_STRENGTH, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(UndertaleMod.MODID, "balletshoes_3"), 0.2, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.undertale.balletshoes.description_0"));
	}
}