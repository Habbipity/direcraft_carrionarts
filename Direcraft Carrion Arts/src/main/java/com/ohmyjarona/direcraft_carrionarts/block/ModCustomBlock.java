package com.ohmyjarona.direcraft_carrionarts.block;

import java.util.function.Supplier;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.ohmyjarona.direcraft_carrionarts.DirecraftCarrionArts;
import com.ohmyjarona.direcraft_carrionarts.block.custom.CustomBlock;
import com.ohmyjarona.direcraft_carrionarts.block.custom.SkullBlock;
import com.ohmyjarona.direcraft_carrionarts.item.ModItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCustomBlock {
    public static final Logger LOGGER = LogUtils.getLogger();
	
	public static final DeferredRegister.Blocks BLOCKS = 
			DeferredRegister.createBlocks(DirecraftCarrionArts.MODID);
	
	private static <T extends CustomBlock> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
		DeferredBlock<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	
	
	private static <T extends CustomBlock> void registerBlockItem(String name, DeferredBlock<T> block) {
		ModItem.ITEMS.register(name, () -> ((CustomBlock)block.get()).buildCustomBlockItem());
	}
			
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
	
	//======================= Define blocks below =======================
	
	public static final DeferredBlock<SkullBlock> SKULL_CARNIVORA = registerBlock("skull_carnivora", 
			() -> new SkullBlock(BlockBehaviour.Properties.of()
					.strength(1)
					.sound(SoundType.BONE_BLOCK)
					.explosionResistance(0)
					.noOcclusion()
			));
	
	
	public static final DeferredBlock<SkullBlock> SKULL_UNGULATE = registerBlock("skull_ungulate", 
			() -> new SkullBlock(BlockBehaviour.Properties.of()
					.strength(1)
					.sound(SoundType.BONE_BLOCK)
					.explosionResistance(0)
					.noOcclusion()
			));
}
