package net.essorant.astraldisturbance.procedures;

import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Camera;
import team.lodestar.lodestone.systems.screenshake.ScreenshakeInstance;
import net.minecraft.client.Minecraft;
import team.lodestar.lodestone.handlers.ScreenshakeHandler;
import team.lodestar.lodestone.systems.easing.Easing;

public class DoScreenshakeProcedure {
	public static void execute(int duration, float intensity) {
		Camera camera = Minecraft.getInstance().gameRenderer.getMainCamera();
		ScreenshakeInstance screenShake = new ScreenshakeInstance(duration);
		screenShake.setIntensity(intensity);
		screenShake.setEasing(Easing.SINE_IN, Easing.SINE_OUT);

		ScreenshakeHandler.addScreenshake(screenShake);
	}
}
