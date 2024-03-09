
package net.essorant.astraldisturbance.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class StepperBaubleItem extends Item implements ICurioItem {

	public StepperBaubleItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		StepperBaubleWhileBaubleIsEquippedTickProcedure.execute();
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		StepperBaubleBaubleIsEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		StepperBaubleBaubleIsUnequippedProcedure.execute();
	}

}
