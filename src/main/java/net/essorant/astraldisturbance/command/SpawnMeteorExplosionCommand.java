
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
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.Commands;

import net.essorant.astraldisturbance.procedures.SpawnMeteorExplosionProcedureProcedure;

import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class SpawnMeteorExplosionCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("meteor_explosion").requires(s -> s.hasPermission(4)).then(Commands.argument("position", BlockPosArgument.blockPos()).then(Commands.argument("startSize", DoubleArgumentType.doubleArg(0))
				.then(Commands.argument("endSize", DoubleArgumentType.doubleArg(0)).then(Commands.argument("duration", DoubleArgumentType.doubleArg(0)).then(Commands.argument("amount", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
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

					SpawnMeteorExplosionProcedureProcedure.execute(arguments);
					return 0;
				})))))));
	}
}
