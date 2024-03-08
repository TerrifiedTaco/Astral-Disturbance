package net.essorant.astraldisturbance.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandFunction;

import net.essorant.astraldisturbance.init.AstralDisturbanceModBlocks;

import java.util.Optional;

public class CraterSpreadBlockUpdateTickProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double x_off = 0;
		double y_off = 0;
		double z_off = 0;
		double stage = 0;
		ItemStack itemToUse = ItemStack.EMPTY;
		if (world instanceof ServerLevel _level && _level.getServer() != null) {
			Optional<CommandFunction> _fopt = _level.getServer().getFunctions().get(new ResourceLocation("astral_disturbance:spawn_meteorite_biome"));
			if (_fopt.isPresent())
				_level.getServer().getFunctions().execute(_fopt.get(), new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null));
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("astral_disturbance:crater_ignite")))) {
			world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fill ~5 ~ ~5 ~-5 ~15 ~-5 minecraft:fire replace #astral_disturbance:crater_ignite");
		}
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
			if (Math.random() > (stage - 15) / 10 && !(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("astral_disturbance:crater_safe_blocks")))) {
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
			if (Math.random() > (stage - 10) / 15) {
				{
					BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent != null) {
						final int _slotid = 0;
						final ItemStack _setstack = new ItemStack(AstralDisturbanceModBlocks.ASTRAL_ORE_NATURAL.get());
						_setstack.setCount(1);
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
			} else {
				{
					BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent != null) {
						final int _slotid = 0;
						final ItemStack _setstack = new ItemStack(AstralDisturbanceModBlocks.ASTRAL_STONE.get());
						_setstack.setCount(1);
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
			}
			for (Direction directioniterator : Direction.Plane.HORIZONTAL) {
				x_off = directioniterator.getStepX() + x;
				y_off = directioniterator.getStepY() + y;
				z_off = directioniterator.getStepZ() + z;
				if (!(world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).is(BlockTags.create(new ResourceLocation("astral_disturbance:crater_safe_blocks")))) {
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
		}
		for (Direction directioniterator : Direction.Plane.HORIZONTAL) {
			x_off = directioniterator.getStepX() + x;
			y_off = directioniterator.getStepY() + y;
			z_off = directioniterator.getStepZ() + z;
			if ((world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).getBlock() == AstralDisturbanceModBlocks.CRATER_SPREAD_BLOCK.get()) {
				CraterSpreadBlockUpdateTickProcedure.execute(world, x_off, y_off, z_off);
			}
		}
		return true;
	}
}
