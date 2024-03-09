package net.essorant.astraldisturbance.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ScreenshakeCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		double duration = 0;
		double intensity = 0;
		duration = DoubleArgumentType.getDouble(arguments, "duration");
		intensity = DoubleArgumentType.getDouble(arguments, "intensity");
		DoScreenshakeProcedure.execute((int) duration, (float) intensity);
	}
}
