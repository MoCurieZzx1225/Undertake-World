package net.mcreator.undertale.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.InteractionResult;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.undertale.procedures.PortalProcedure;
import net.mcreator.undertale.UndertaleMod;

public class MagicstoneItem extends Item {
	public MagicstoneItem() {
		super(new Item.Properties().rarity(Rarity.UNCOMMON).attributes(ItemAttributeModifiers.builder()
				.add(Attributes.MAX_HEALTH, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(UndertaleMod.MODID, "magicstone_0"), 3, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.OFFHAND).build()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		return PortalProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
	}
}