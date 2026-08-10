package com.ohmyjarona.direcraft_carrionarts.block.custom.entity;


import java.util.function.Supplier;

import com.ohmyjarona.direcraft_carrionarts.DirecraftCarrionArts;
import com.ohmyjarona.direcraft_carrionarts.block.ModBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntity {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
			DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, DirecraftCarrionArts.MODID);
	
	/*
	public static final Supplier<BlockEntityType<ChoppingStumpBlockEntity>> CHOPPING_STUMP_BE =
			BLOCK_ENTITIES.register("chopping_stump_be", () -> BlockEntityType.Builder.of(
					ChoppingStumpBlockEntity::new, ModBlock.CHOPPING_STUMP.get()).build(null));*/
	
	public static void register(IEventBus eventBus) {
		BLOCK_ENTITIES.register(eventBus);
	}
}
