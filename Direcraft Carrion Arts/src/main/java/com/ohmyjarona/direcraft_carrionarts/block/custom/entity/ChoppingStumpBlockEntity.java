package com.ohmyjarona.direcraft_carrionarts.block.custom.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

public class ChoppingStumpBlockEntity extends BlockEntity{

	public ChoppingStumpBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		super(type, pos, blockState);
		// TODO Auto-generated constructor stub
	}
	/*
	public ChoppingStumpBlockEntity(BlockPos pos, BlockState blockState) {
		super(ModBlockEntity.CHOPPING_STUMP_BE.get(), pos, blockState);
	}
	
	public final ItemStackHandler inventory = new ItemStackHandler(1) {
		@Override
		protected int getStackLimit(int slot, ItemStack stack) {
			return 1;
		}
		
		@Override
		protected void onContentsChanged(int slot) {
			setChanged();
			if (!level.isClientSide()) {
				level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
			}
		}
	};
	
	public void clearContents() {
		inventory.setStackInSlot(0,  ItemStack.EMPTY);
	}
	
	
	public void drops() {
		SimpleContainer inv = new SimpleContainer(inventory.getSlots());
		
		for (int i = 0; i < inventory.getSlots(); i++) {
			inv.setItem(i,  inventory.getStackInSlot(i));
		}
		
		Containers.dropContents(this.level, this.worldPosition, inv);
	}
	
	
	@Override
	protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
		super.saveAdditional(tag, registries);
		tag.put("inventory", inventory.serializeNBT(registries));
	}

	
	@Override
	protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
		inventory.deserializeNBT(registries, tag.getCompound("inventory"));
	}
	*/
}
