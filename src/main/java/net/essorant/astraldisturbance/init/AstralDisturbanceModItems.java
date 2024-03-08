
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.essorant.astraldisturbance.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.essorant.astraldisturbance.item.FloaterBaubleItem;
import net.essorant.astraldisturbance.AstralDisturbanceMod;

public class AstralDisturbanceModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AstralDisturbanceMod.MODID);
	public static final RegistryObject<Item> FLOATER_BAUBLE = REGISTRY.register("floater_bauble", () -> new FloaterBaubleItem());
	public static final RegistryObject<Item> CRATER_SPREAD_BLOCK = block(AstralDisturbanceModBlocks.CRATER_SPREAD_BLOCK);
	public static final RegistryObject<Item> GRAVITY_PLACER_BLOCK = block(AstralDisturbanceModBlocks.GRAVITY_PLACER_BLOCK);
	public static final RegistryObject<Item> ASTRAL_STONE = block(AstralDisturbanceModBlocks.ASTRAL_STONE);
	public static final RegistryObject<Item> ASTRAL_ORE_NATURAL = block(AstralDisturbanceModBlocks.ASTRAL_ORE_NATURAL);
	public static final RegistryObject<Item> ASTRAL_ORE = block(AstralDisturbanceModBlocks.ASTRAL_ORE);
	public static final RegistryObject<Item> BIOME_SPREAD_BLOCK = block(AstralDisturbanceModBlocks.BIOME_SPREAD_BLOCK);
	public static final RegistryObject<Item> ASTRAL_GRASS = block(AstralDisturbanceModBlocks.ASTRAL_GRASS);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
