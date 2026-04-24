package net.mcreator.undertale.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelundyue<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("undertale", "modelundyue"), "main");
	public final ModelPart bone_main;
	public final ModelPart bone_hand;
	public final ModelPart bone_high;
	public final ModelPart bone_hanf;
	public final ModelPart bone1;
	public final ModelPart bone3;
	public final ModelPart bone4;
	public final ModelPart bone5;
	public final ModelPart bone_handl;
	public final ModelPart bone_lear;
	public final ModelPart bone_handr;
	public final ModelPart bone_rear;
	public final ModelPart leg_right;
	public final ModelPart bone;
	public final ModelPart bone6;
	public final ModelPart leg_left;
	public final ModelPart bone2;
	public final ModelPart bone7;
	public final ModelPart bone_legl;
	public final ModelPart bone_legr;

	public Modelundyue(ModelPart root) {
		this.bone_main = root.getChild("bone_main");
		this.bone_hand = this.bone_main.getChild("bone_hand");
		this.bone_high = this.bone_hand.getChild("bone_high");
		this.bone_hanf = this.bone_high.getChild("bone_hanf");
		this.bone1 = this.bone_hanf.getChild("bone1");
		this.bone3 = this.bone1.getChild("bone3");
		this.bone4 = this.bone3.getChild("bone4");
		this.bone5 = this.bone4.getChild("bone5");
		this.bone_handl = this.bone_hand.getChild("bone_handl");
		this.bone_lear = this.bone_handl.getChild("bone_lear");
		this.bone_handr = this.bone_hand.getChild("bone_handr");
		this.bone_rear = this.bone_handr.getChild("bone_rear");
		this.leg_right = this.bone_main.getChild("leg_right");
		this.bone = this.leg_right.getChild("bone");
		this.bone6 = this.bone.getChild("bone6");
		this.leg_left = this.bone_main.getChild("leg_left");
		this.bone2 = this.leg_left.getChild("bone2");
		this.bone7 = this.bone2.getChild("bone7");
		this.bone_legl = this.bone_main.getChild("bone_legl");
		this.bone_legr = this.bone_main.getChild("bone_legr");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone_main = partdefinition.addOrReplaceChild("bone_main", CubeListBuilder.create().texOffs(0, 14).addBox(-3.0F, 6.0F, -1.0F, 6.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 0.0F));
		PartDefinition bone_hand = bone_main.addOrReplaceChild("bone_hand",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(40, 30).addBox(-2.0F, 7.0F, -2.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, 1.0F));
		PartDefinition bone_high = bone_hand.addOrReplaceChild("bone_high", CubeListBuilder.create().texOffs(40, 26).addBox(-2.0F, -35.0F, -1.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 32.0F, -1.0F));
		PartDefinition bone_hanf = bone_high.addOrReplaceChild("bone_hanf", CubeListBuilder.create().texOffs(0, 31).addBox(-2.0F, -4.0F, -2.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -34.0F, 4.0F));
		PartDefinition bone1 = bone_hanf.addOrReplaceChild("bone1", CubeListBuilder.create().texOffs(12, 32).addBox(2.0F, -38.0F, 3.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 32.0F, -4.0F));
		PartDefinition bone3 = bone1.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(40, 34).addBox(3.0F, -35.0F, 5.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 41).addBox(5.0F, -31.0F, 5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bone5 = bone4.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(28, 42).addBox(8.0F, -32.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bone_handl = bone_hand.addOrReplaceChild("bone_handl", CubeListBuilder.create().texOffs(28, 18).addBox(-4.0F, -33.0F, -2.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 32.0F, -1.0F));
		PartDefinition bone_lear = bone_handl.addOrReplaceChild("bone_lear", CubeListBuilder.create().texOffs(22, 0).addBox(-6.0F, -31.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bone_handr = bone_hand.addOrReplaceChild("bone_handr", CubeListBuilder.create().texOffs(28, 30).addBox(3.0F, -33.0F, -2.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 32.0F, -1.0F));
		PartDefinition bone_rear = bone_handr.addOrReplaceChild("bone_rear", CubeListBuilder.create().texOffs(22, 5).addBox(4.0F, -31.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition leg_right = bone_main.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(0, 45).addBox(-1.0F, -1.7137F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 9.0F, -1.0F));
		PartDefinition bone = leg_right.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(38, 0).addBox(-3.0F, 0.5F, -0.7135F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.2137F, 0.7135F));
		PartDefinition bone6 = bone.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(12, 41).addBox(-2.0F, -0.5F, -0.7135F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 11.0F, 0.0F));
		PartDefinition leg_left = bone_main.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(40, 41).addBox(-1.0F, -1.2988F, -0.9375F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 8.0F, 0.0F));
		PartDefinition bone2 = leg_left.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(40, 13).addBox(0.0F, 0.0F, -0.1688F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.2988F, -0.7687F));
		PartDefinition bone7 = bone2.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(20, 41).addBox(-1.0F, -1.0F, -1.1688F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 11.0F, 1.0F));
		PartDefinition bone_legl = bone_main.addOrReplaceChild("bone_legl", CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 21.0F, 0.0F));
		PartDefinition bone_legr = bone_main.addOrReplaceChild("bone_legr", CubeListBuilder.create().texOffs(18, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 21.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		bone_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg_right.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.bone_legl.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.bone_legr.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leg_left.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}