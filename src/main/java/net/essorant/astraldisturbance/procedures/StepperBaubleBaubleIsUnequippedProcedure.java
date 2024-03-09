package net.essorant.astraldisturbance.procedures;

import net.minecraft.world.entity.Entity;

public class StepperBaubleBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setMaxUpStep((float) 0.6);
	}
}
