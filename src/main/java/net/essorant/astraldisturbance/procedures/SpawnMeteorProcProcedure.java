package net.essorant.astraldisturbance.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;

import net.essorant.astraldisturbance.init.AstralDisturbanceModBlocks;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class SpawnMeteorProcProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		x_pos = new Object() {
			public double getX() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "location").getX();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getX();
		y_pos = new Object() {
			public double getY() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "location").getY();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getY();
		z_pos = new Object() {
			public double getZ() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "location").getZ();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getZ();
		while ((world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos))).getBlock() == Blocks.AIR) {
			y_pos = 1 - y_pos;
			if (y_pos < 0) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Could not find suitable spot for meteorite! (Too low)"), false);
				break;
			}
		}
		while (!world.canSeeSkyFromBelowWater(BlockPos.containing(x_pos, y_pos, z_pos))) {
			y_pos = 1 + y_pos;
			if (y_pos > 256) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Could not find suitable spot for meteorite! (Too high)"), false);
				break;
			}
		}
		world.setBlock(BlockPos.containing(x_pos, y_pos, z_pos), AstralDisturbanceModBlocks.CRATER_SPREAD_BLOCK.get().defaultBlockState(), 3);
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x_pos, y_pos, z_pos);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("stage", 0);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
