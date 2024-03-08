package net.essorant.astraldisturbance.procedures;

import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SpawnMeteorExplosionProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		double startSize = 0;
		double endSize = 0;
		double duration = 0;
		double amount = 0;
		posX = new Object() {
			public double getX() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "position").getX();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getX();
		posY = new Object() {
			public double getY() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "position").getY();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getY();
		posZ = new Object() {
			public double getZ() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "position").getZ();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getZ();
		startSize = DoubleArgumentType.getDouble(arguments, "startSize");
		endSize = DoubleArgumentType.getDouble(arguments, "endSize");
		duration = DoubleArgumentType.getDouble(arguments, "duration");
		amount = DoubleArgumentType.getDouble(arguments, "amount");
		MeteorExplosionCodeProcedure.execute(posX, posY, posZ, startSize, endSize, duration, amount);
	}
}
