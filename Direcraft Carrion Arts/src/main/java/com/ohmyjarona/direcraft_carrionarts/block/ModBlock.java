package com.ohmyjarona.direcraft_carrionarts.block;

import java.util.function.Supplier;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.ohmyjarona.direcraft_carrionarts.DirecraftCarrionArts;
import com.ohmyjarona.direcraft_carrionarts.block.custom.CarrionPileBlock;
import com.ohmyjarona.direcraft_carrionarts.block.custom.ChoppingStumpBlock;
import com.ohmyjarona.direcraft_carrionarts.item.ModItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlock {
    public static final Logger LOGGER = LogUtils.getLogger();
	
	public static final DeferredRegister.Blocks BLOCKS = 
			DeferredRegister.createBlocks(DirecraftCarrionArts.MODID);
	
	private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
		DeferredBlock<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	
	
	private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
		ModItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
			
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
	
	//======================= Define blocks below =======================
	
	public static final DeferredBlock<Block> FEATHER_DOWN_BLOCK = registerBlock("feather_down_block", 
			() -> new Block(BlockBehaviour.Properties.of()
					.strength(0.4f)
					.sound(SoundType.WOOL)
					.ignitedByLava()
					.explosionResistance(0)
			));
	
	public static final DeferredBlock<CarrionPileBlock> CARRION_PILE = registerBlock("carrion_pile", 
			() -> new CarrionPileBlock(BlockBehaviour.Properties.of()
					.strength(0.4f)
					.sound(SoundType.SLIME_BLOCK)
					.explosionResistance(0)
					.noOcclusion()
					.noCollission()
			));
	

	
	
	
	public static final DeferredBlock<Block> CHOPPING_STUMP = registerBlock("chopping_stump_block", 
			() -> new ChoppingStumpBlock(BlockBehaviour.Properties.of().noOcclusion()));	
}
