package com.ohmyjarona.direcraft_carrionarts;





import java.util.function.Supplier;

import com.ohmyjarona.direcraft_carrionarts.item.ModItem;
import com.ohmyjarona.direcraft_carrionarts.block.ModBlock;
import com.ohmyjarona.direcraft_carrionarts.block.ModCustomBlock;

import net.minecraft.world.item.ItemStack;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTab {
	
	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, DirecraftCarrionArts.MODID);
	
	public static final Supplier<CreativeModeTab> CARRIONARTS_TAB = CREATIVE_TABS.register("maintab", () -> CreativeModeTab.builder()
		    .title(Component.translatable("itemgroup." + DirecraftCarrionArts.MODID + ".maintab"))
		    .icon(() -> new ItemStack(ModItem.BONE_SHARD.get()))
		    .displayItems((params, output) -> {
		        output.accept(ModItem.BONE_SHARD.get());
		        output.accept(ModItem.GELATIN.get());
		        output.accept(ModItem.ADIPOSE.get());
		        output.accept(ModItem.OFFAL.get());
		        output.accept(ModItem.SCRAP_SINEW.get());
		        output.accept(ModItem.TOUGH_CORDAGE.get());
		        output.accept(ModItem.CHITIN_SHELL.get());
		        output.accept(ModItem.MARSHMALLOW.get());
		        
		        output.accept(ModItem.BONE_KNIFE.get());
		        output.accept(ModItem.BONE_ADZE.get());		        
		        output.accept(ModItem.BONE_MATTOCK.get());
		        
		        output.accept(ModItem.BONE_SHIELD.get());
		        output.accept(ModItem.CARAPACE_SHIELD.get());
		        output.accept(ModItem.TURTLE_SHIELD.get());
		        
		        output.accept(ModItem.BONE_LAMELLAR_HELMET.get());
		        output.accept(ModItem.BONE_LAMELLAR_CHESTPLATE.get());
		        output.accept(ModItem.BONE_LAMELLAR_LEGGINGS.get());
		        output.accept(ModItem.BONE_LAMELLAR_BOOTS.get());
		        
		        output.accept(ModItem.CARAPACE_HELMET.get());
		        output.accept(ModItem.CARAPACE_CHESTPLATE.get());
		        output.accept(ModItem.CARAPACE_LEGGINGS.get());
		        output.accept(ModItem.CARAPACE_BOOTS.get());
		        
		        output.accept(ModItem.TURTLESHELL_CHESTPLATE.get());
		        output.accept(ModItem.TURTLESHELL_LEGGINGS.get());
		        output.accept(ModItem.TURTLESHELL_BOOTS.get());		        
		        
		        output.accept(ModBlock.FEATHER_DOWN_BLOCK.get());
		        
		        output.accept(ModCustomBlock.SKULL_BOVINE.get());
		        output.accept(ModCustomBlock.SKULL_CARNIVORA.get());
		        output.accept(ModCustomBlock.SKULL_UNGULATE.get());
		    })
		    .build()
		);
	
	public static void register(IEventBus eventBus) {
		CREATIVE_TABS.register(eventBus);
	}
}
