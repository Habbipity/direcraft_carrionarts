package com.ohmyjarona.direcraft_carrionarts.fluid;

import java.util.function.Supplier;

import org.joml.Vector3f;

import com.ohmyjarona.direcraft_carrionarts.DirecraftCarrionArts;
import com.ohmyjarona.direcraft_carrionarts.block.ModBlock;
import com.ohmyjarona.direcraft_carrionarts.item.ModItem;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModFluidType {
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, DirecraftCarrionArts.MODID);
	
	public static void register(IEventBus eventBus) {
		FLUID_TYPES.register(eventBus);
	}
	
	
	
	
	public static final Supplier<FluidType> BLOOD_FLUID_TYPE = register("blood_fluid_type", FluidType.Properties.create());
	
	public static final ResourceLocation BLOOD_STILL_RL = ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "block/blood_still");
	public static final ResourceLocation BLOOD_FLOW_RL = ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "block/blood_flowing");
	public static final ResourceLocation BLOOD_OVERLAY_RL = ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "block/blood_still");
	
	private static Supplier<FluidType> register(String name, FluidType.Properties properties){
		return FLUID_TYPES.register("name", () -> new CustomFluidTypeBase(
				BLOOD_STILL_RL,
				BLOOD_FLOW_RL,
				BLOOD_OVERLAY_RL,
				0xA1E03800,
				new Vector3f(224f/255f, 180f/255f, 180f/255f),
				properties
				));
	}
	
	public static final BaseFlowingFluid.Properties BLOOD_PROPERTIES = new BaseFlowingFluid.Properties(
			ModFluidType.BLOOD_FLUID_TYPE, ModFluid.SOURCE_BLOOD, ModFluid.FLOWING_BLOOD
			)
			.slopeFindDistance(1)
			.levelDecreasePerBlock(3)
			.tickRate(20)
			.block(ModBlock.BLOOD_FLUID_BLOCK)
			.bucket(ModItem.BLOOD_BUCKET)
			;
}
