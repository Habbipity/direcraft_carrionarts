package com.ohmyjarona.direcraft_carrionarts.block;

import com.ohmyjarona.direcraft_carrionarts.block.custom.CustomBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;


public class DirectionalBlock extends CustomBlock implements SimpleWaterloggedBlock{

	public DirectionalBlock(BlockBehaviour.Properties properties) {
		super(properties);
        this.registerDefaultState(
                this.stateDefinition
                    .any()
                    .setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH)
                    .setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false))
            );
	}
	
    @Override
    protected BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(HorizontalDirectionalBlock.FACING, rot.rotate(state.getValue(HorizontalDirectionalBlock.FACING)));
    }
	
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(blockpos);
        BlockState blockstate = this.defaultBlockState()
            .setValue(HorizontalDirectionalBlock.FACING, context.getHorizontalDirection())
            .setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
        return blockstate;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HorizontalDirectionalBlock.FACING, BlockStateProperties.WATERLOGGED);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }
    
}
