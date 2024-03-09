package net.essorant.astraldisturbance.procedures;

import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class ScreenshakeCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		double duration = 0;
		double intensity = 0;
		duration = DoubleArgumentType.getDouble(arguments, "duration");
		intensity = DoubleArgumentType.getDouble(arguments, "intensity");
		DoScreenshakeProcedure.execute((int) duration, (float) intensity);
	}
}
