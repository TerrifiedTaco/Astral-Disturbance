
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.essorant.astraldisturbance.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.essorant.astraldisturbance.item.FloaterBaubleItem;
import net.essorant.astraldisturbance.AstralDisturbanceMod;

public class AstralDisturbanceModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AstralDisturbanceMod.MODID);
	public static final RegistryObject<Item> FLOATER_BAUBLE = REGISTRY.register("floater_bauble", () -> new FloaterBaubleItem());
}
