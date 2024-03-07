package net.essorant.astraldisturbance.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class SkyboxDrawToggleProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		AstralDisturbanceModVariables.WorldVariables.get(world).put_e_into_the_sky = BoolArgumentType.getBool(arguments, "exist");
		AstralDisturbanceModVariables.WorldVariables.get(world).syncData(world);
	}
}
