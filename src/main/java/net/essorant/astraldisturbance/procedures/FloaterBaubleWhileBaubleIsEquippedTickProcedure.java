package net.essorant.astraldisturbance.procedures;

import net.minecraft.world.entity.Entity;

public class FloaterBaubleWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			entity.setNoGravity(true);
			entity.fallDistance = 0;
		} else {
			entity.setNoGravity(false);
		}
	}
}
