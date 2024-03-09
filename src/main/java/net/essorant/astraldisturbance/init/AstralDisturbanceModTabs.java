
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.essorant.astraldisturbance.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.essorant.astraldisturbance.AstralDisturbanceMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AstralDisturbanceModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AstralDisturbanceMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(AstralDisturbanceModItems.FLOATER_BAUBLE.get());
			tabData.accept(AstralDisturbanceModItems.STEPPER_BAUBLE.get());
			tabData.accept(AstralDisturbanceModItems.WATER_WALKING_BAUBLE.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(AstralDisturbanceModBlocks.ASTRAL_STONE.get().asItem());
			tabData.accept(AstralDisturbanceModBlocks.ASTRAL_ORE.get().asItem());
			tabData.accept(AstralDisturbanceModBlocks.ASTRAL_GRASS.get().asItem());
			tabData.accept(AstralDisturbanceModBlocks.ASTRAL_CRYSTAL_BLOCK.get().asItem());
			tabData.accept(AstralDisturbanceModBlocks.SMALL_METEOR_BLOOM.get().asItem());
			tabData.accept(AstralDisturbanceModBlocks.LARGE_METEOR_BLOOM.get().asItem());
		}
	}
}
