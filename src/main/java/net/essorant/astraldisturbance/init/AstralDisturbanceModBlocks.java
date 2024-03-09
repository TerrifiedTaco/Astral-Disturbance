
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
import net.essorant.astraldisturbance.block.BiomeSpreadBlockBlock;
import net.essorant.astraldisturbance.block.AstralStoneBlock;
import net.essorant.astraldisturbance.block.AstralOreNaturalBlock;
import net.essorant.astraldisturbance.block.AstralOreBlock;
import net.essorant.astraldisturbance.block.AstralGrassBlock;
import net.essorant.astraldisturbance.block.AstralCrystalBlockBlock;
import net.essorant.astraldisturbance.AstralDisturbanceMod;

public class AstralDisturbanceModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, AstralDisturbanceMod.MODID);
	public static final RegistryObject<Block> ASTRAL_GRASS = REGISTRY.register("astral_grass", () -> new AstralGrassBlock());
	public static final RegistryObject<Block> ASTRAL_STONE = REGISTRY.register("astral_stone", () -> new AstralStoneBlock());
	public static final RegistryObject<Block> ASTRAL_ORE = REGISTRY.register("astral_ore", () -> new AstralOreBlock());
	public static final RegistryObject<Block> ASTRAL_CRYSTAL_BLOCK = REGISTRY.register("astral_crystal_block", () -> new AstralCrystalBlockBlock());
	public static final RegistryObject<Block> CRATER_SPREAD_BLOCK = REGISTRY.register("crater_spread_block", () -> new CraterSpreadBlockBlock());
	public static final RegistryObject<Block> GRAVITY_PLACER_BLOCK = REGISTRY.register("gravity_placer_block", () -> new GravityPlacerBlockBlock());
	public static final RegistryObject<Block> ASTRAL_ORE_NATURAL = REGISTRY.register("astral_ore_natural", () -> new AstralOreNaturalBlock());
	public static final RegistryObject<Block> BIOME_SPREAD_BLOCK = REGISTRY.register("biome_spread_block", () -> new BiomeSpreadBlockBlock());
}
