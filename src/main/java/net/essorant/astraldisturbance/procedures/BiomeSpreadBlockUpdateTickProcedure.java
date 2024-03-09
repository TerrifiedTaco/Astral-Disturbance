package net.essorant.astraldisturbance.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.essorant.astraldisturbance.init.AstralDisturbanceModBlocks;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Comparator;

public class BiomeSpreadBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Direction playerDirection = Direction.NORTH;
		ItemStack itemToUse = ItemStack.EMPTY;
		ItemStack thisItem = ItemStack.EMPTY;
		Entity player = null;
		double spread = 0;
		double x_off = 0;
		double z_off = 0;
		double y_off = 0;
		double i = 0;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fillbiome ~ ~ ~ ~ ~ ~ astral_disturbance:meteorite_biome");
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("astral_disturbance:crater_safe_blocks")))) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fillbiome ~ ~ ~ ~ ~12 ~ astral_disturbance:meteorite_biome");
		} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("astral_disturbance:crater_ignite")))) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fill ~3 ~ ~3 ~-3 ~15 ~-3 minecraft:fire replace #astral_disturbance:crater_ignite");
		}
		spread = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "spread") + 0.5 + Math.random() * 0.5;
		if (spread <= 24) {
			for (Direction directioniterator : Direction.values()) {
				i = 1;
				while (i < 23 - spread) {
					x_off = x + directioniterator.getStepX() * i;
					y_off = y + directioniterator.getStepY() * i;
					z_off = z + directioniterator.getStepZ() * i;
					if (!(world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).is(BlockTags.create(new ResourceLocation("astral_disturbance:crater_safe_blocks")))
							&& world.getBlockState(BlockPos.containing(x_off, y_off, z_off)).canOcclude()) {
						itemToUse = (new ItemStack((world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).getBlock()));
						world.setBlock(BlockPos.containing(x_off, y_off, z_off), AstralDisturbanceModBlocks.BIOME_SPREAD_BLOCK.get().defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x_off, y_off, z_off);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("spread", (i + spread));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						{
							BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x_off, y_off, z_off));
							if (_ent != null) {
								final int _slotid = 0;
								final ItemStack _setstack = itemToUse;
								_setstack.setCount(1);
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
					} else {
						break;
					}
					i = 1 + i;
					if (world.getBlockState(BlockPos.containing(x_off, y_off + 1, z_off)).canOcclude() && !(directioniterator.getAxis() == Direction.Axis.Y)) {
						break;
					}
				}
			}
			if (AstralDisturbanceModBlocks.BIOME_SPREAD_BLOCK.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				for (Direction directioniterator : Direction.values()) {
					i = 1;
					while (i < 22 - spread) {
						x_off = x + directioniterator.getStepX() * i;
						y_off = y + 1 + directioniterator.getStepY() * i;
						z_off = z + directioniterator.getStepZ() * i;
						if (!(world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).is(BlockTags.create(new ResourceLocation("astral_disturbance:crater_safe_blocks")))
								&& world.getBlockState(BlockPos.containing(x_off, y_off, z_off)).canOcclude()) {
							itemToUse = (new ItemStack((world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).getBlock()));
							world.setBlock(BlockPos.containing(x_off, y_off, z_off), AstralDisturbanceModBlocks.BIOME_SPREAD_BLOCK.get().defaultBlockState(), 3);
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x_off, y_off, z_off);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("spread", (i + spread));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							{
								BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x_off, y_off, z_off));
								if (_ent != null) {
									final int _slotid = 0;
									final ItemStack _setstack = itemToUse;
									_setstack.setCount(1);
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable)
											((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
									});
								}
							}
						} else {
							break;
						}
						i = 1 + i;
						if (world.getBlockState(BlockPos.containing(x_off, y_off + 1, z_off)).canOcclude() && !(directioniterator.getAxis() == Direction.Axis.Y)) {
							break;
						}
					}
				}
			}
		}
		player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 512, 512, 512), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
		playerDirection = Direction.NORTH;
		if (!(null == player)) {
			playerDirection = (player.getDirection()).getOpposite();
		}
		if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() && false) {
			x_off = x + playerDirection.getStepX();
			y_off = y + playerDirection.getStepY();
			z_off = z + playerDirection.getStepZ();
			if (AstralDisturbanceModBlocks.BIOME_SPREAD_BLOCK.get() == (world.getBlockState(BlockPos.containing(x_off, y_off, z_off))).getBlock()) {
				BiomeSpreadBlockUpdateTickProcedure.execute(world, x_off, y_off, z_off);
			}
		}
		itemToUse = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 0));
		if (itemToUse.is(ItemTags.create(new ResourceLocation("astral_disturbance:grass_like"))) && spread > Math.random() + 8) {
			world.setBlock(BlockPos.containing(x, y, z), AstralDisturbanceModBlocks.ASTRAL_GRASS.get().defaultBlockState(), 3);
			if ((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())).is(ItemTags.create(new ResourceLocation("astral_disturbance:flower_like")))) {
				if (Math.random() < 0.5) {
					world.setBlock(BlockPos.containing(x, y + 1, z), AstralDisturbanceModBlocks.LARGE_METEOR_BLOOM.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y + 1, z), AstralDisturbanceModBlocks.SMALL_METEOR_BLOOM.get().defaultBlockState(), 3);
				}
			}
		} else {
			world.setBlock(BlockPos.containing(x, y, z), AstralDisturbanceModBlocks.ASTRAL_STONE.get().defaultBlockState(), 3);
			if (Math.random() < 0.02) {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR) {
					world.setBlock(BlockPos.containing(x, y + 1, z), AstralDisturbanceModBlocks.ASTRAL_CRYSTAL_BLOCK.get().defaultBlockState(), 3);
				}
			}
		}
	}
}
