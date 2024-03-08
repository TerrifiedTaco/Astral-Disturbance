package net.essorant.astraldisturbance.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.essorant.astraldisturbance.init.AstralDisturbanceModBlocks;

public class AstralOreNaturalBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double x_off = 0;
		double y_off = 0;
		double z_off = 0;
		ItemStack itemToUse = ItemStack.EMPTY;
		for (Direction directioniterator : Direction.values()) {
			x_off = x + directioniterator.getStepX();
			y_off = y + directioniterator.getStepY();
			z_off = z + directioniterator.getStepZ();
			if ((world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).getBlock() == Blocks.AIR) {
				if (Math.random() <= 0.33) {
					world.setBlock(BlockPos.containing(x_off, y_off, z_off), Blocks.AMETHYST_CLUSTER.defaultBlockState(), 3);
					{
						Direction _dir = directioniterator;
						BlockPos _pos = BlockPos.containing(x_off, y_off, z_off);
						BlockState _bs = world.getBlockState(_pos);
						Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else {
							_property = _bs.getBlock().getStateDefinition().getProperty("axis");
							if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
								world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
				}
			} else if (!(world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).is(BlockTags.create(new ResourceLocation("astral_disturbance:crater_safe_blocks")))) {
				itemToUse = (new ItemStack((world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).getBlock()));
				world.setBlock(BlockPos.containing(x_off, y_off, z_off), AstralDisturbanceModBlocks.BIOME_SPREAD_BLOCK.get().defaultBlockState(), 3);
				{
					BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x_off, y_off, z_off));
					if (_ent != null) {
						final int _slotid = 0;
						final ItemStack _setstack = itemToUse;
						_setstack.setCount(1);
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
			}
		}
		world.setBlock(BlockPos.containing(x, y, z), AstralDisturbanceModBlocks.ASTRAL_ORE.get().defaultBlockState(), 3);
	}
}
