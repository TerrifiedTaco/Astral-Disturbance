package net.essorant.astraldisturbance.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class GravityPlacerBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AIR)) {
			world.setBlock(BlockPos.containing(x, y, z), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "blockID"))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
		}
	}
}
