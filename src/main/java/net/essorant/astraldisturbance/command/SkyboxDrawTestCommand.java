
package net.essorant.astraldisturbance.command;

@Mod.EventBusSubscriber
public class SkyboxDrawTestCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("should_there_be_a_comically_large_letter_e_in_the_skybox")

				.then(Commands.argument("exist", BoolArgumentType.bool()).executes(arguments -> {
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
