package com.ohmyjarona.direcraft_carrionarts.item.custom;


import com.ohmyjarona.direcraft_carrionarts.DirecraftCarrionArts;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;

public class CustomShieldItem extends ShieldItem{

    public static ResourceLocation BLOCKING_PROPERTY_RESOURCE_LOCATION = 
    		ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "blocking");
    
	public CustomShieldItem(Properties properties) {
		super(properties);
	}

    @Override
    public String getDescriptionId(ItemStack stack) {
        return super.getDescriptionId(stack);
    }
	
}
