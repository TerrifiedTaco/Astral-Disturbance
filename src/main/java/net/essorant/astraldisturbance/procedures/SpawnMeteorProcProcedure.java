package net.essorant.astraldisturbance.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.essorant.astraldisturbance.init.AstralDisturbanceModBlocks;

public class SpawnMeteorProcProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		y_pos = y;
		while ((world.getBlockState(BlockPos.containing(x, y_pos, z))).getBlock() == Blocks.AIR) {
			y_pos = 1 - y_pos;
			if (y_pos < 0) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Could not find suitable spot for meteorite! (Too low)"), false);
				break;
			}
		}
		while (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y_pos, z))) {
			y_pos = 1 + y_pos;
			if (y_pos > 256) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Could not find suitable spot for meteorite! (Too high)"), false);
				break;
			}
		}
		world.setBlock(BlockPos.containing(x, y_pos, z), AstralDisturbanceModBlocks.CRATER_SPREAD_BLOCK.get().defaultBlockState(), 3);
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y_pos, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("stage", 0);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
