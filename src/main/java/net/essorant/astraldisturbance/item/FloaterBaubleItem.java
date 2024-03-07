
package net.essorant.astraldisturbance.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class FloaterBaubleItem extends Item implements ICurioItem {

	public FloaterBaubleItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		FloaterBaubleWhileBaubleIsEquippedTickProcedure.execute();
	}

}
