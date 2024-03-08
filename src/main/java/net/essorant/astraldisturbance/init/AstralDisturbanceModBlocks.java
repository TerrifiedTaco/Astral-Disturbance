
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.essorant.astraldisturbance.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.essorant.astraldisturbance.block.GravityPlacerBlockBlock;
import net.essorant.astraldisturbance.block.CraterSpreadBlockBlock;
import net.essorant.astraldisturbance.AstralDisturbanceMod;

public class AstralDisturbanceModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, AstralDisturbanceMod.MODID);
	public static final RegistryObject<Block> CRATER_SPREAD_BLOCK = REGISTRY.register("crater_spread_block", () -> new CraterSpreadBlockBlock());
	public static final RegistryObject<Block> GRAVITY_PLACER_BLOCK = REGISTRY.register("gravity_placer_block", () -> new GravityPlacerBlockBlock());
}
