package com.ohmyjarona.direcraft_carrionarts.item;

import com.ohmyjarona.direcraft_carrionarts.DirecraftCarrionArts;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperty {
	public static void addCustomItemProperties() {
		
		ItemProperties.register(
				ModItem.BONE_SHIELD.get(), ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "blocking"), 
				(stack, level, entity, seed) -> 
				(!(entity == null)? 
						entity.isUsingItem() ? 1f: 0f 
						: 
						0f));
		
		ItemProperties.register(
				ModItem.TURTLE_SHIELD.get(), ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "blocking"), 
				(stack, level, entity, seed) -> 
				(!(entity == null)? 
						entity.isUsingItem() ? 1f: 0f 
						: 
						0f));
		
		ItemProperties.register(
				ModItem.CARAPACE_SHIELD.get(), ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "blocking"), 
				(stack, level, entity, seed) -> 
				(!(entity == null)? 
						entity.isUsingItem() ? 1f: 0f 
						: 
						0f));

	}
	
}
