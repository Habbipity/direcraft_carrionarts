package com.ohmyjarona.direcraft_carrionarts.fluid;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;

public class CustomFluidTypeBase extends FluidType{
	private float DEFAULT_FOG_START = 1f;
	private float DEFAULT_FOG_END = 6f;
	
	
	private final ResourceLocation stillTexture;
	private final ResourceLocation flowingTexture;
	private final ResourceLocation overlayTexture;
	private final int tintColor;
	private final Vector3f fogColor;
	
	public CustomFluidTypeBase(final ResourceLocation stillTex, final ResourceLocation flowTex, final ResourceLocation overlay,
			final int tintColor, final Vector3f fogColor, final Properties properties) {
		
		super(properties);
		
		this.stillTexture = stillTex;
		this.flowingTexture = flowTex;
		this.overlayTexture = overlay;
		this.tintColor = tintColor;
		this.fogColor = fogColor;
	}

	@Override 
    public boolean canConvertToSource(FluidStack stack) {
        return false;
    }
    
	@Override 
    public boolean supportsBoating(Boat boat) {
        return true;
    }
	
	public ResourceLocation getStillTexture() {
		return stillTexture;
	}
	
	public ResourceLocation getFlowingTexture() {
		return flowingTexture;
	}	
	
	public ResourceLocation getOverlayTexture() {
		return overlayTexture;
	}
	
	public int getTintColor() {
		return tintColor;
	}	
	
	public Vector3f getFogColor() {
		return fogColor;
	}
	
	
	@Override
	public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
		consumer.accept(new IClientFluidTypeExtensions() {
			@Override
			public ResourceLocation getStillTexture() {
				return stillTexture;
			}
			@Override
			public ResourceLocation getFlowingTexture() {
				return flowingTexture;
			}	
			@Override
			public ResourceLocation getOverlayTexture() {
				return overlayTexture;
			}
			@Override
			public int getTintColor() {
				return tintColor;
			}	
			@Override
			public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance,
					float darkenWorldAmount, Vector3f fluidFogColor) {
				return fogColor;
			}
			
			@Override
			public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, 
					float nearDistance, float farDistance, FogShape shape) {
				RenderSystem.setShaderFogStart(DEFAULT_FOG_START);
				RenderSystem.setShaderFogEnd(DEFAULT_FOG_END);
				
			}
			
		});
		
	}
}
