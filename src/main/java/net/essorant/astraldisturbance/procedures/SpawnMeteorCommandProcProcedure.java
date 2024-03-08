package net.essorant.astraldisturbance.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class SpawnMeteorCommandProcProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		SpawnMeteorProcProcedure.execute(world, (new Object() {
			public double getX() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "position").getX();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getX()), (new Object() {
			public double getY() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "position").getY();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getY()), (new Object() {
			public double getZ() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "position").getZ();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getZ()));
	}
}
