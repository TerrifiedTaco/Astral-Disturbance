
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.essorant.astraldisturbance.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.essorant.astraldisturbance.AstralDisturbanceMod;

public class AstralDisturbanceModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AstralDisturbanceMod.MODID);
	public static final RegistryObject<CreativeModeTab> ASTRAL_DISTURBANCE_CREATIVE_TAB = REGISTRY.register("astral_disturbance_creative_tab", () -> CreativeModeTab.builder()
			.title(Component.translatable("item_group.astral_disturbance.astral_disturbance_creative_tab")).icon(() -> new ItemStack(AstralDisturbanceModBlocks.ASTRAL_STONE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(AstralDisturbanceModBlocks.ASTRAL_GRASS.get().asItem());
				tabData.accept(AstralDisturbanceModBlocks.ASTRAL_STONE.get().asItem());
				tabData.accept(AstralDisturbanceModBlocks.ASTRAL_ORE.get().asItem());
				tabData.accept(AstralDisturbanceModBlocks.ASTRAL_CRYSTAL_BLOCK.get().asItem());
				tabData.accept(AstralDisturbanceModItems.WATER_WALKING_BAUBLE.get());
				tabData.accept(AstralDisturbanceModItems.FLOATER_BAUBLE.get());
			})

			.build());
}
