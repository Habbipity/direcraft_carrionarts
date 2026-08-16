package com.ohmyjarona.direcraft_carrionarts.entity;

import java.util.function.Supplier;

import com.ohmyjarona.direcraft_carrionarts.DirecraftCarrionArts;
import com.ohmyjarona.direcraft_carrionarts.entity.ThrownJavelinEntity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntity {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, DirecraftCarrionArts.MODID);
	
	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
	
	public static final Supplier<EntityType<ThrownJavelinEntity>> JAVELIN =
			ENTITY_TYPES.register("javelin_thrown", 
					() -> EntityType.Builder.<ThrownJavelinEntity>of(ThrownJavelinEntity::new, MobCategory.MISC)
					.sized(0.5f, 0.5f)
					.build("javelin_thrown"));
}
