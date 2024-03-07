package net.essorant.astraldisturbance.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.essorant.astraldisturbance.network.AstralDisturbanceModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class SkyboxDrawToggleProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		AstralDisturbanceModVariables.WorldVariables.get(world).put_e_into_the_sky = BoolArgumentType.getBool(arguments, "exist");
		AstralDisturbanceModVariables.WorldVariables.get(world).syncData(world);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Set to: " + BoolArgumentType.getBool(arguments, "exist"))), false);
	}
}
