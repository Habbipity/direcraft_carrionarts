package com.ohmyjarona.direcraft_carrionarts.item;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import com.ohmyjarona.direcraft_carrionarts.DirecraftCarrionArts;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModArmorMaterial {

	public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, DirecraftCarrionArts.MODID);
	
	public static void register(IEventBus eventBus) {
		ARMOR_MATERIALS.register(eventBus);
	}
	
	
	public static final Holder<ArmorMaterial> BONE_LAMELLAR_MATERIAL = ARMOR_MATERIALS.register("bone_lamellar", 
				() -> new ArmorMaterial(
						Util.make(new EnumMap<>(ArmorItem.Type.class), map -> { //Armor Stats
				            map.put(ArmorItem.Type.BOOTS, 1);
				            map.put(ArmorItem.Type.LEGGINGS, 4);
				            map.put(ArmorItem.Type.CHESTPLATE, 5);
				            map.put(ArmorItem.Type.HELMET, 2);
				            map.put(ArmorItem.Type.BODY, 4);
				        }), 
						15, 
						SoundEvents.ARMOR_EQUIP_GENERIC, 
						() -> Ingredient.of(ModItem.BONE_SHARD), 
						List.of(
								new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "bone_lamellar")),
								new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "bone_lamellar"))
								), 
						0, 
						0));

	public static final Holder<ArmorMaterial> TURTLESHELL_MATERIAL = ARMOR_MATERIALS.register("turtleshell", 
			() -> new ArmorMaterial(
					Util.make(new EnumMap<>(ArmorItem.Type.class), map -> { //Armor Stats
			            map.put(ArmorItem.Type.BOOTS, 3);
			            map.put(ArmorItem.Type.LEGGINGS, 5);
			            map.put(ArmorItem.Type.CHESTPLATE, 7);
			            map.put(ArmorItem.Type.HELMET, 2);
			            map.put(ArmorItem.Type.BODY, 9);
			        }), 
					15, 
					SoundEvents.ARMOR_EQUIP_GENERIC, 
					() -> Ingredient.of(ModItem.BONE_SHARD), 
					List.of(
							new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "turtleshell")),
							new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "turtleshell"))
							), 
					0, 
					0));
	
	public static final Holder<ArmorMaterial> CARAPACE_MATERIAL = ARMOR_MATERIALS.register("carapace", 
			() -> new ArmorMaterial(
					Util.make(new EnumMap<>(ArmorItem.Type.class), map -> { //Armor Stats
			            map.put(ArmorItem.Type.BOOTS, 3);
			            map.put(ArmorItem.Type.LEGGINGS, 5);
			            map.put(ArmorItem.Type.CHESTPLATE, 7);
			            map.put(ArmorItem.Type.HELMET, 2);
			            map.put(ArmorItem.Type.BODY, 9);
			        }), 
					15, 
					SoundEvents.ARMOR_EQUIP_GENERIC, 
					() -> Ingredient.of(ModItem.CHITIN_SHELL), 
					List.of(
							new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "carapace")),
							new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "carapace"))
							), 
					0, 
					0));
}
