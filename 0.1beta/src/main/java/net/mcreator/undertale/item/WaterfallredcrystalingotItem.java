package net.mcreator.undertale.item;

import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.undertale.UndertaleMod;

public class WaterfallredcrystalingotItem extends Item {
	public WaterfallredcrystalingotItem() {
		super(new Item.Properties().attributes(ItemAttributeModifiers.builder()
				.add(Attributes.BURNING_TIME, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(UndertaleMod.MODID, "waterfallredcrystalingot_0"), -0.1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND).build()));
	}
}