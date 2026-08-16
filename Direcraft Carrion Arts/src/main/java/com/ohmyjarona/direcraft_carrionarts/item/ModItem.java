package com.ohmyjarona.direcraft_carrionarts.item;

import java.util.function.Supplier;

import com.ohmyjarona.direcraft_carrionarts.DirecraftCarrionArts;
import com.ohmyjarona.direcraft_carrionarts.fluid.ModFluid;
import com.ohmyjarona.direcraft_carrionarts.item.custom.AdzeItem;
import com.ohmyjarona.direcraft_carrionarts.item.custom.CustomShieldItem;
import com.ohmyjarona.direcraft_carrionarts.item.custom.DrinkableBottleItem;
import com.ohmyjarona.direcraft_carrionarts.item.custom.FuelItem;
import com.ohmyjarona.direcraft_carrionarts.item.custom.JavelinItem;
import com.ohmyjarona.direcraft_carrionarts.item.custom.MattockItem;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItem {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DirecraftCarrionArts.MODID);
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
	
	//========= Basic Items =========
	public static final DeferredItem<Item> BONE_SHARD = ITEMS.register("bone_shard", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> GELATIN = ITEMS.register("gelatin", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> SCRAP_SINEW = ITEMS.register("scrap_sinew", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> CHITIN_SHELL = ITEMS.register("chitin_shell", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> ANIMAL_PARCHMENT = ITEMS.register("animal_parchment", () -> new Item(new Item.Properties()));
	
	public static final DeferredItem<FuelItem> COW_CHIP = ITEMS.register("cow_chip", () -> new FuelItem(new Item.Properties(), 600));
		
	
	//public static final DeferredItem<Item> THICK_PELT = ITEMS.register("thick_pelt", () -> new Item(new Item.Properties()));
	//public static final DeferredItem<Item> ANIMAL_HAIR = ITEMS.register("animal_hair", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> TOUGH_CORDAGE = ITEMS.register("tough_cordage", () -> new Item(new Item.Properties()));
	
	//========= Tools and Equipment =========
	
	public static final DeferredItem<JavelinItem> JAVELIN = ITEMS.register("javelin", 
			() -> new JavelinItem(new Item.Properties().stacksTo(8)));
	
	public static final DeferredItem<DrinkableBottleItem> BLOOD_BOTTLE = ITEMS.register("blood_bottle", () 
			-> new DrinkableBottleItem(new Item.Properties().food(new FoodProperties.Builder()
					.nutrition(2)
					.saturationModifier(0.4f)
					.build()).craftRemainder(Items.GLASS_BOTTLE)));
	
	public static final Supplier<BucketItem> BLOOD_BUCKET = ITEMS.register("blood_bucket", () -> 
		new BucketItem(ModFluid.SOURCE_BLOOD.get(), new Item.Properties()
		.stacksTo(1)
		.craftRemainder(Items.BUCKET)
		));
	
	
	public static final Tier BONE_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 190, 5f, 1f, 14,
			() -> Ingredient.of(ModItem.BONE_SHARD));
	
	public static final Supplier<SwordItem> BONE_KNIFE = ITEMS.register("bone_knife", () -> 
		new SwordItem(BONE_TIER, new Item.Properties().attributes(SwordItem.createAttributes(
			BONE_TIER, 
			2, //Damage Bonus 
			-3.2f)))); //Attack Speed Modifier
	
	public static final Supplier<AdzeItem> BONE_ADZE = ITEMS.register("bone_adze", () -> 
	new AdzeItem(BONE_TIER, new Item.Properties().attributes(AdzeItem.createAttributes(
		BONE_TIER, 
		1.5f, //Damage Bonus 
		-3f))
		)); //Attack Speed Modifier
	
	public static final Supplier<MattockItem> BONE_MATTOCK = ITEMS.register("bone_mattock", () -> 
	new MattockItem(BONE_TIER, new Item.Properties().attributes(MattockItem.createAttributes(
		BONE_TIER, 
		2.5f, //Damage Bonus 
		-2.8f)))); //Attack Speed Modifier
	
	public static final Supplier<CustomShieldItem> BONE_SHIELD = ITEMS.register("bone_shield", () -> 
		new CustomShieldItem(new Item.Properties()));
	
	public static final Supplier<CustomShieldItem> TURTLE_SHIELD = ITEMS.register("turtle_shield", () -> 
	new CustomShieldItem(new Item.Properties()));
	
	public static final Supplier<CustomShieldItem> CARAPACE_SHIELD = ITEMS.register("carapace_shield", () -> 
	new CustomShieldItem(new Item.Properties()));
	
	//========= Food Items =========
	public static final DeferredItem<Item> MARSHMALLOW = ITEMS.register("marshmallow", () 
			-> new Item(new Item.Properties().food(new FoodProperties.Builder()
					.nutrition(2)
					.saturationModifier(0.4f)
					.build())));
	
	public static final DeferredItem<Item> ADIPOSE = ITEMS.register("adipose", () 
			-> new Item(new Item.Properties().food(new FoodProperties.Builder()
			.nutrition(2)
			.saturationModifier(0.8f)
			.build())));
	
	public static final DeferredItem<Item> OFFAL = ITEMS.register("offal", () 
			-> new Item(new Item.Properties().food(new FoodProperties.Builder()
			.nutrition(4)
			.saturationModifier(0.6f)
			.build())));
	
	//========= Armor Sets =========
	//Bone Lamellar Set
	public static final DeferredItem<ArmorItem> BONE_LAMELLAR_HELMET = ITEMS.registerItem("bone_helmet", props -> new ArmorItem(
			ModArmorMaterial.BONE_LAMELLAR_MATERIAL,ArmorItem.Type.HELMET,props
		));
	public static final DeferredItem<ArmorItem> BONE_LAMELLAR_CHESTPLATE = ITEMS.registerItem("bone_chestplate", props -> new ArmorItem(
			ModArmorMaterial.BONE_LAMELLAR_MATERIAL,ArmorItem.Type.CHESTPLATE,props
		));	
	public static final DeferredItem<ArmorItem> BONE_LAMELLAR_LEGGINGS = ITEMS.registerItem("bone_leggings", props -> new ArmorItem(
			ModArmorMaterial.BONE_LAMELLAR_MATERIAL,ArmorItem.Type.LEGGINGS,props
		));	
	public static final DeferredItem<ArmorItem> BONE_LAMELLAR_BOOTS = ITEMS.registerItem("bone_boots", props -> new ArmorItem(
			ModArmorMaterial.BONE_LAMELLAR_MATERIAL,ArmorItem.Type.BOOTS,props
		));	
	
	//Turtleshell Set
	public static final DeferredItem<ArmorItem> TURTLESHELL_CHESTPLATE = ITEMS.registerItem("turtleshell_chestplate", props -> new ArmorItem(
			ModArmorMaterial.TURTLESHELL_MATERIAL,ArmorItem.Type.CHESTPLATE,props
		));	
	public static final DeferredItem<ArmorItem> TURTLESHELL_LEGGINGS = ITEMS.registerItem("turtleshell_leggings", props -> new ArmorItem(
			ModArmorMaterial.TURTLESHELL_MATERIAL,ArmorItem.Type.LEGGINGS,props
		));	
	public static final DeferredItem<ArmorItem> TURTLESHELL_BOOTS = ITEMS.registerItem("turtleshell_boots", props -> new ArmorItem(
			ModArmorMaterial.TURTLESHELL_MATERIAL,ArmorItem.Type.BOOTS,props
		));	
	
	//Carapace Set
	public static final DeferredItem<ArmorItem> CARAPACE_HELMET = ITEMS.registerItem("carapace_helmet", props -> new ArmorItem(
			ModArmorMaterial.CARAPACE_MATERIAL,ArmorItem.Type.HELMET,props
		));
	public static final DeferredItem<ArmorItem> CARAPACE_CHESTPLATE = ITEMS.registerItem("carapace_chestplate", props -> new ArmorItem(
			ModArmorMaterial.CARAPACE_MATERIAL,ArmorItem.Type.CHESTPLATE,props
		));	
	public static final DeferredItem<ArmorItem> CARAPACE_LEGGINGS = ITEMS.registerItem("carapace_leggings", props -> new ArmorItem(
			ModArmorMaterial.CARAPACE_MATERIAL,ArmorItem.Type.LEGGINGS,props
		));	
	public static final DeferredItem<ArmorItem> CARAPACE_BOOTS = ITEMS.registerItem("carapace_boots", props -> new ArmorItem(
			ModArmorMaterial.CARAPACE_MATERIAL,ArmorItem.Type.BOOTS,props
		));	
}

