
package net.essorant.astraldisturbance.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class AstralBranchLargeBlock extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public AstralBranchLargeBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.NETHER_WOOD).strength(0.5f, 2f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default ->
				Shapes.or(box(3, 2.04329, -15.8097, 13, 12.04329, 0.1903), box(5, 4.04329, 0.1903, 11, 10.04329, 16.1903), box(7, 6.04329, 16.1903, 9, 8.04329, 31.1903), box(2, 5, -6, 4, 13, -4), box(6.74025, -3.85819, -8, 8.74025, -1.85819, 0),
						box(8, -3, -6, 16, -1, -4), box(11, 6, 8, 16, 8, 10), box(-1, 4, 6, 5, 6, 8), box(9, 7, 1, 11, 14, 3), box(4.86777, 11.43669, 13.61504, 5.86777, 12.43669, 16.61504), box(5.80711, 9.13639, 8.63869, 6.80711, 13.13639, 9.63869));
			case NORTH -> Shapes.or(box(3, 2.04329, 15.8097, 13, 12.04329, 31.8097), box(5, 4.04329, -0.1903, 11, 10.04329, 15.8097), box(7, 6.04329, -15.1903, 9, 8.04329, -0.1903), box(12, 5, 20, 14, 13, 22),
					box(7.25975, -3.85819, 16, 9.25975, -1.85819, 24), box(0, -3, 20, 8, -1, 22), box(0, 6, 6, 5, 8, 8), box(11, 4, 8, 17, 6, 10), box(5, 7, 13, 7, 14, 15), box(10.13223, 11.43669, -0.61504, 11.13223, 12.43669, 2.38496),
					box(9.19289, 9.13639, 6.36131, 10.19289, 13.13639, 7.36131));
			case EAST ->
				Shapes.or(box(-15.8097, 2.04329, 3, 0.1903, 12.04329, 13), box(0.1903, 4.04329, 5, 16.1903, 10.04329, 11), box(16.1903, 6.04329, 7, 31.1903, 8.04329, 9), box(-6, 5, 12, -4, 13, 14), box(-8, -3.85819, 7.25975, 0, -1.85819, 9.25975),
						box(-6, -3, 0, -4, -1, 8), box(8, 6, 0, 10, 8, 5), box(6, 4, 11, 8, 6, 17), box(1, 7, 5, 3, 14, 7), box(13.61504, 11.43669, 10.13223, 16.61504, 12.43669, 11.13223), box(8.63869, 9.13639, 9.19289, 9.63869, 13.13639, 10.19289));
			case WEST -> Shapes.or(box(15.8097, 2.04329, 3, 31.8097, 12.04329, 13), box(-0.1903, 4.04329, 5, 15.8097, 10.04329, 11), box(-15.1903, 6.04329, 7, -0.1903, 8.04329, 9), box(20, 5, 2, 22, 13, 4),
					box(16, -3.85819, 6.74025, 24, -1.85819, 8.74025), box(20, -3, 8, 22, -1, 16), box(6, 6, 11, 8, 8, 16), box(8, 4, -1, 10, 6, 5), box(13, 7, 9, 15, 14, 11), box(-0.61504, 11.43669, 4.86777, 2.38496, 12.43669, 5.86777),
					box(6.36131, 9.13639, 5.80711, 7.36131, 13.13639, 6.80711));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		if (context.getClickedFace().getAxis() == Direction.Axis.Y)
			return this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, flag);
		return this.defaultBlockState().setValue(FACING, context.getClickedFace()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
