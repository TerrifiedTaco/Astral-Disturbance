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

import net.minecraft.world.level.LevelAccessor;

import java.awt.Color;

public class HProcedure {
    public static void execute(double posX, double posY, double posZ) {
        final LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            Color startingColor = new Color(255, 60, 0);
            Color endingColor = new Color(255, 190, 70);
                WorldParticleBuilder.create(LodestoneParticleRegistry.STAR_PARTICLE)
                    .setScaleData(GenericParticleData.create(2, 23).build())
                    .setTransparencyData(GenericParticleData.create(0.75f, 0.25f).build())
                    .setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4f).setEasing(Easing.BOUNCE_IN_OUT).build())
                    .setSpinData(SpinParticleData.create(0.2f, 0.4f).setSpinOffset((player.level().getGameTime() * 0.2f) % 6.28f).setEasing(Easing.QUARTIC_IN).build())
                    .setLifetime(60)
                    .addMotion(0, 0.00f, 0)
                    .enableNoClip()
                    .spawn(player.level(), posX, posY, posZ);
            Color startingColor2 = new Color(255, 170, 40);
            Color endingColor2 = new Color(255, 230, 220);
                WorldParticleBuilder.create(LodestoneParticleRegistry.WISP_PARTICLE)
                    .setScaleData(GenericParticleData.create(3, 26).build())
                    .setTransparencyData(GenericParticleData.create(0.40f, 0.30f).build())
                    .setColorData(ColorParticleData.create(startingColor2, endingColor2).setCoefficient(1.4f).setEasing(Easing.BOUNCE_IN_OUT).build())
                    .setSpinData(SpinParticleData.create(0.2f, 0.4f).setSpinOffset((player.level().getGameTime() * 0.2f) % 6.28f).setEasing(Easing.QUARTIC_IN).build())
                    .setLifetime(60)
                    .addMotion(0, 0.00f, 0)
                    .enableNoClip()
                    .spawn(player.level(), posX, posY, posZ);
            
        }
    }
}