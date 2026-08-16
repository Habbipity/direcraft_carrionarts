package com.ohmyjarona.direcraft_carrionarts.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ohmyjarona.direcraft_carrionarts.DirecraftCarrionArts;
import com.ohmyjarona.direcraft_carrionarts.entity.ThrownJavelinEntity;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class JavelinThrownModel extends EntityModel<ThrownJavelinEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(DirecraftCarrionArts.MODID, "javelin_thrown"), "main");
	private final ModelPart root;

	public JavelinThrownModel (ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -6.625F, 1.0F, 1.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(24, 29).addBox(0.0F, -1.5F, -7.625F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(24, 25).addBox(-1.5F, 0.0F, -7.625F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-0.5F, -0.5F, 0.375F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.3F)), PartPose.offset(-0.5F, 23.5F, -5.375F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			int color) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		
	}

	@Override
	public void setupAnim(ThrownJavelinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// TODO Auto-generated method stub
		
	}}