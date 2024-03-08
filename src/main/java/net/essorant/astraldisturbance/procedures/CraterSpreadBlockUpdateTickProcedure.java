package net.essorant.astraldisturbance.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.essorant.astraldisturbance.init.AstralDisturbanceModBlocks;

public class CraterSpreadBlockUpdateTickProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double x_off = 0;
		double y_off = 0;
		double z_off = 0;
		double stage = 0;
		stage = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "stage");
		if (10 > stage) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			stage = stage + 1;
			for (Direction directioniterator : Direction.values()) {
				x_off = directioniterator.getStepX() + x;
				y_off = directioniterator.getStepY() + y;
				z_off = directioniterator.getStepZ() + z;
				if (!(world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).is(BlockTags.create(new ResourceLocation("astral_disturbance:crater_safe_blocks")))) {
					world.setBlock(BlockPos.containing(x_off, y_off, z_off), AstralDisturbanceModBlocks.CRATER_SPREAD_BLOCK.get().defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x_off, y_off, z_off);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("stage", stage);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else if (Math.random() > (stage - 10) / 10) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			stage = stage + 1;
			for (Direction directioniterator : Direction.values()) {
				x_off = directioniterator.getStepX() + x;
				y_off = directioniterator.getStepY() + y;
				z_off = directioniterator.getStepZ() + z;
				if (!(world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).is(BlockTags.create(new ResourceLocation("astral_disturbance:crater_safe_blocks")))) {
					world.setBlock(BlockPos.containing(x_off, y_off, z_off), AstralDisturbanceModBlocks.CRATER_SPREAD_BLOCK.get().defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x_off, y_off, z_off);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("stage", stage);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (Math.random() > (stage - 15) / 10 && !(world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).is(BlockTags.create(new ResourceLocation("astral_disturbance:crater_safe_blocks")))) {
				world.setBlock(BlockPos.containing(x, y + 1, z), AstralDisturbanceModBlocks.CRATER_SPREAD_BLOCK.get().defaultBlockState(), 3);
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y + 1, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("stage", stage);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), AstralDisturbanceModBlocks.GRAVITY_PLACER_BLOCK.get().defaultBlockState(), 3);
			{
				BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent != null) {
					final int _slotid = 0;
					final ItemStack _setstack = new ItemStack(Blocks.AMETHYST_BLOCK);
					_setstack.setCount(1);
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
			return true;
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == AstralDisturbanceModBlocks.CRATER_SPREAD_BLOCK.get()) {
			CraterSpreadBlockUpdateTickProcedure.execute(world, x, (y - 1), z);
		}
		return true;
	}
}
