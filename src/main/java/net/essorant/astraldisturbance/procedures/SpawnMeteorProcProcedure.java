package net.essorant.astraldisturbance.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

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
		world.setBlock(BlockPos.containing(x, y_pos, z), AstralDisturbanceModItems.DELETED_MOD_ELEMENT.get().defaultBlockState(), 3);
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
