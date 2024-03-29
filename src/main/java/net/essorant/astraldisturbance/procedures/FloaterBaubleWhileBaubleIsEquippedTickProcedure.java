package net.essorant.astraldisturbance.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class FloaterBaubleWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() && !entity.isInWater() && !((world.getBlockState(BlockPos.containing(x, y - 0.05, z))).getBlock() == Blocks.WATER)) {
			entity.setNoGravity(true);
			entity.fallDistance = 0;
		} else {
			entity.setNoGravity(false);
		}
	}
}
