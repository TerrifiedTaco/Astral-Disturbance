
package net.essorant.astraldisturbance.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.essorant.astraldisturbance.procedures.FloaterBaubleWhileBaubleIsEquippedTickProcedure;

import java.util.List;

public class FloaterBaubleItem extends Item implements ICurioItem {
	public FloaterBaubleItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		FloaterBaubleWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity());
	}
}
