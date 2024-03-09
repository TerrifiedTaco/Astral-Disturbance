
package net.essorant.astraldisturbance.command;

@Mod.EventBusSubscriber
public class ScreenshakeCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("screenshake")

				.then(Commands.argument("duration", DoubleArgumentType.doubleArg(1)).then(Commands.argument("intensity", DoubleArgumentType.doubleArg(0.5)))));
	}

}
