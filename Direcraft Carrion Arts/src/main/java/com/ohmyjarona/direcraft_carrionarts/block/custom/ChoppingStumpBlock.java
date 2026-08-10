package com.ohmyjarona.direcraft_carrionarts.block.custom;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import com.mojang.serialization.MapCodec;
import com.ohmyjarona.direcraft_carrionarts.block.custom.entity.ChoppingStumpBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;

public class ChoppingStumpBlock extends BaseEntityBlock{

	protected ChoppingStumpBlock(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		// TODO Auto-generated method stub
		return null;
	}

/*
	public static final MapCodec<ChoppingStumpBlock> CODEC = simpleCodec(ChoppingStumpBlock::new);
	
	public ChoppingStumpBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}
	
	@Override
	protected RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ChoppingStumpBlockEntity(pos, state);
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
		if (state.getBlock() != newState.getBlock()) {
			
			if (level.getBlockEntity(pos) instanceof ChoppingStumpBlockEntity choppingStumpBlockEntity) {
				choppingStumpBlockEntity.drops();
				level.updateNeighbourForOutputSignal(pos, this);
			}
			
		}
		super.onRemove(state,  level,  pos,  newState,  movedByPiston);
	}
	
	@Override
    protected ItemInteractionResult useItemOn(
            ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
            
			if (level.getBlockEntity(pos) instanceof ChoppingStumpBlockEntity choppingStumpEntity) {
				if (choppingStumpEntity.inventory.getStackInSlot(0).isEmpty() && !stack.isEmpty()) {
					//If Entity Inventory is empty and Player Hand is not empty, move item to Entity Inventory
					choppingStumpEntity.inventory.insertItem(0, stack.copy(), false);
					stack.shrink(1);
					
					//Cosmetic FX
					level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 2f);
				}else if (stack.isEmpty()) 
				{
					//If Player Hand is empty, let them take item from this inventory
					ItemStack stackToTake = choppingStumpEntity.inventory.extractItem(0,  1,  false);
					player.setItemInHand(InteractionHand.MAIN_HAND, stackToTake);
					choppingStumpEntity.clearContents();
					
					//Cosmetic FX
					level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 1f);
				}
				
			}
		return ItemInteractionResult.SUCCESS;
        }*/
}
