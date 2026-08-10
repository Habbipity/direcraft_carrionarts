package com.ohmyjarona.direcraft_carrionarts.fluid;

import java.util.function.Supplier;

import com.ohmyjarona.direcraft_carrionarts.DirecraftCarrionArts;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.crafting.FluidIngredientType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;


public class ModFluid {
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, DirecraftCarrionArts.MODID);
	public static final DeferredRegister<FluidIngredientType<?>> FLUID_INGREDIENTS = DeferredRegister.create(NeoForgeRegistries.FLUID_INGREDIENT_TYPES, DirecraftCarrionArts.MODID);
	

	public static void register(IEventBus eventBus) {
		FLUIDS.register(eventBus);
	}
	
	
	//==================================================================
	//Blood Fluid

	
	public static final Supplier<FlowingFluid> SOURCE_BLOOD = FLUIDS.register("blood_source_fluid", () -> new BaseFlowingFluid.Source(ModFluidType.BLOOD_PROPERTIES));
	public static final Supplier<FlowingFluid> FLOWING_BLOOD = FLUIDS.register("blood_flowing_fluid", () -> new BaseFlowingFluid.Flowing(ModFluidType.BLOOD_PROPERTIES));


	

	

	
}
