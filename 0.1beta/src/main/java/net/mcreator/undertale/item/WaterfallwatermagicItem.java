package net.mcreator.undertale.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.undertale.init.UndertaleModFluids;

public class WaterfallwatermagicItem extends BucketItem {
	public WaterfallwatermagicItem() {
		super(UndertaleModFluids.WATERFALLWATERMAGIC.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}