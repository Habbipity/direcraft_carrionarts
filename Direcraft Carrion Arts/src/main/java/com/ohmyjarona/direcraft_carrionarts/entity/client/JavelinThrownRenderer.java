package com.ohmyjarona.direcraft_carrionarts.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ohmyjarona.direcraft_carrionarts.DirecraftCarrionArts;
import com.ohmyjarona.direcraft_carrionarts.entity.ThrownJavelinEntity;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;

public class JavelinThrownRenderer extends EntityRenderer<ThrownJavelinEntity>{

	private JavelinThrownModel model;
	
	public JavelinThrownRenderer(Context context) {
		super(context);
		this.model = new JavelinThrownModel(context.bakeLayer(JavelinThrownModel.LAYER_LOCATION));
	}

	
	@Override
	public void render(ThrownJavelinEntity entity, float entityYaw, float partialTicks, PoseStack poseStack,
			MultiBufferSource buffer, int packedLight) {
		poseStack.pushPose();
		
		VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(buffer, this.model.renderType(this.getTextureLocation(entity)), false, false);
		
		this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, packedLight);
		poseStack.popPose();
		super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
	}
	
	
	@Override
	public ResourceLocation getTextureLocation(ThrownJavelinEntity entity) {
		// TODO Auto-generated method stub
		return ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "textures/entity/javelin/javelin_thrown.png");
	}

}
