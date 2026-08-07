package com.ohmyjarona.dire_vulture.block;

import java.util.function.Supplier;

import com.ohmyjarona.dire_vulture.DirecraftVultureCulture;
import com.ohmyjarona.dire_vulture.item.ModItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlock {
	public static final DeferredRegister.Blocks BLOCKS = 
			DeferredRegister.createBlocks(DirecraftVultureCulture.MODID);
	
	private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
		
		DeferredBlock<T> toReturn = BLOCKS.register(name, block);
		return toReturn;
	}
	
	private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
		ModItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
			
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
	
	//======================= Define blocks below =======================
	
	public static final DeferredBlock<Block> TESTBLOCK = registerBlock("testblock", 
			() -> new Block(BlockBehaviour.Properties.of()
					.strength(1)
					.sound(SoundType.BAMBOO)
			));
}
