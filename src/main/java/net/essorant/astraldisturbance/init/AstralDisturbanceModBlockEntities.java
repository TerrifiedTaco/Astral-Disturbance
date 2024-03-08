
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.essorant.astraldisturbance.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.essorant.astraldisturbance.block.entity.GravityPlacerBlockBlockEntity;
import net.essorant.astraldisturbance.block.entity.CraterSpreadBlockBlockEntity;
import net.essorant.astraldisturbance.block.entity.BiomeSpreadBlockBlockEntity;
import net.essorant.astraldisturbance.AstralDisturbanceMod;

public class AstralDisturbanceModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AstralDisturbanceMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> CRATER_SPREAD_BLOCK = register("crater_spread_block", AstralDisturbanceModBlocks.CRATER_SPREAD_BLOCK, CraterSpreadBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GRAVITY_PLACER_BLOCK = register("gravity_placer_block", AstralDisturbanceModBlocks.GRAVITY_PLACER_BLOCK, GravityPlacerBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIOME_SPREAD_BLOCK = register("biome_spread_block", AstralDisturbanceModBlocks.BIOME_SPREAD_BLOCK, BiomeSpreadBlockBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
