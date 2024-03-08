
package net.essorant.astraldisturbance.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import net.essorant.astraldisturbance.procedures.SkyboxDrawToggleProcedure;

import com.mojang.brigadier.arguments.BoolArgumentType;

@Mod.EventBusSubscriber
public class SkyboxDrawTestCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("should_there_be_a_comically_large_letter_e_in_the_skybox").requires(s -> s.hasPermission(3)).then(Commands.argument("exist", BoolArgumentType.bool()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			SkyboxDrawToggleProcedure.execute(world, arguments);
			return 0;
		})));
	}
}
