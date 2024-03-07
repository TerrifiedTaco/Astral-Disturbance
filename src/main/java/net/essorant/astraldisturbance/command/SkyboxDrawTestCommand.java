
package net.essorant.astraldisturbance.command;

@Mod.EventBusSubscriber
public class SkyboxDrawTestCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("should_there_be_a_comically_large_letter_e_in_the_skybox")

				.then(Commands.argument("exist", BoolArgumentType.bool())));
	}

}
