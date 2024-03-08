package net.essorant.astraldisturbance.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;

public class SpawnMeteorCommandProcProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		SpawnMeteorProcProcedure.execute(world, arguments);
	}
}
