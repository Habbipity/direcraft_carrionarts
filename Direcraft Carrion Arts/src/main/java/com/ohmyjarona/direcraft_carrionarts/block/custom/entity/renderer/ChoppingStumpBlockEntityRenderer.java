package com.ohmyjarona.direcraft_carrionarts.block.custom.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.ohmyjarona.direcraft_carrionarts.block.custom.entity.ChoppingStumpBlockEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class ChoppingStumpBlockEntityRenderer implements BlockEntityRenderer<ChoppingStumpBlockEntity> {

	
	public ChoppingStumpBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}
	
	@Override
	public void render(ChoppingStumpBlockEntity blockEntity, float partialTick, PoseStack poseStack,
			MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
			ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
			ItemStack stack = blockEntity.inventory.getStackInSlot(0);
			
			poseStack.pushPose();
			poseStack.translate(0.5f, 0.4f, 0.5f);
			poseStack.scale(1, 1, 1);
			poseStack.mulPose(Axis.XP.rotationDegrees(90f));
			
			itemRenderer.renderStatic(
					stack, 
					ItemDisplayContext.FIXED, 
					getLightLevel(blockEntity.getLevel(), blockEntity.getBlockPos()), 
					OverlayTexture.NO_OVERLAY, 
					poseStack, 
					bufferSource, 
					blockEntity.getLevel(), 
					1);
			poseStack.popPose();
	}

	private int getLightLevel(Level level, BlockPos pos) {
		int blockLight = level.getBrightness(LightLayer.BLOCK, pos);
		int skyLight = level.getBrightness(LightLayer.SKY, pos);
		
		return LightTexture.pack(blockLight, skyLight);
	}
	
}
