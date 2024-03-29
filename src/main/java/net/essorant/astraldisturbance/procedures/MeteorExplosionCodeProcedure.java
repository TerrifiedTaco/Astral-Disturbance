package net.essorant.astraldisturbance.procedures;

import net.minecraft.client.*;
import net.minecraft.client.player.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import team.lodestar.lodestone.registry.common.particle.*;
import team.lodestar.lodestone.systems.easing.*;
import team.lodestar.lodestone.systems.particle.builder.*;
import team.lodestar.lodestone.systems.particle.data.*;
import team.lodestar.lodestone.systems.particle.data.color.*;
import team.lodestar.lodestone.systems.particle.data.spin.*;

import team.lodestar.lodestone.systems.particle.render_types.*;
import team.lodestar.lodestone.systems.particle.screen.*;

import net.minecraft.world.level.LevelAccessor;

import java.awt.*;

import static net.minecraft.util.Mth.*;

public class MeteorExplosionCodeProcedure {
	
    public static void execute(double posX, double posY, double posZ, double startSize, double endSize, double duration, double amount) {
        final LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
        	Color startingColor = new Color(120, 80, 220);
			Color endingColor = new Color(150, 220, 255);
        	for (int i = 0; i < (int) amount; i++) {
	                WorldParticleBuilder.create(LodestoneParticleRegistry.STAR_PARTICLE)
	                    .setScaleData(GenericParticleData.create((float) startSize, ((float) endSize / (int) amount) * (i + 1)).build())
	                    .setTransparencyData(GenericParticleData.create(0.75f, 0.0f).build())
	                    .setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4f).setEasing(Easing.BOUNCE_IN_OUT).build())
	                    .setSpinData(SpinParticleData.create(0.4f, 0.01f).setSpinOffset((player.level().getGameTime() * 0.2f) % ((int) duration / (int) amount) * (i + 1)).setEasing(Easing.QUARTIC_IN).build())
	                    .setLifetime(((int) duration / (int) amount) * (i + 1))
	                    .addMotion(0, 0.00f, 0)
	                    .enableNoClip()
	                    .setForceSpawn(true)
	                    .spawn(player.level(), posX, posY, posZ);
	            startingColor = new Color(100, 140, 255);
	            endingColor = new Color(170, 220, 255);
	                WorldParticleBuilder.create(LodestoneParticleRegistry.WISP_PARTICLE)
	                    .setScaleData(GenericParticleData.create((float) startSize, ((float) endSize / (int) amount) * (i + 1)).build())
	                    .setTransparencyData(GenericParticleData.create(0.40f, 0.0f).build())
	                    .setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4f).setEasing(Easing.BOUNCE_IN_OUT).build())
	                    .setSpinData(SpinParticleData.create(0.4f, 0.01f).setSpinOffset((player.level().getGameTime() * 0.2f) % ((int) duration / (int) amount) * (i + 1)).setEasing(Easing.QUARTIC_IN).build())
	                    .setLifetime(((int) duration / (int) amount) * (i + 1))
	                    .addMotion(0, 0.00f, 0)
	                    .enableNoClip()
	                    .setForceSpawn(true)
	                    .spawn(player.level(), posX, posY, posZ);
        	}
        }
    }
}