package net.essorant.astraldisturbance.procedures;

import net.minecraft.world.entity.Entity;

public class StepperBaubleBaubleIsEquippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setMaxUpStep(1);
	}
}
