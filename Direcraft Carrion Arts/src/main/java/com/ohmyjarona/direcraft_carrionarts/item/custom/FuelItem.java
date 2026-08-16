package com.ohmyjarona.direcraft_carrionarts.item.custom;

import javax.annotation.Nullable;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class FuelItem extends Item{

	protected int burnTime = 60;
	
	public FuelItem(Properties properties, int burnTime) {
		super(properties);
		this.burnTime = burnTime;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
		return this.burnTime;
		
	}
	
}
