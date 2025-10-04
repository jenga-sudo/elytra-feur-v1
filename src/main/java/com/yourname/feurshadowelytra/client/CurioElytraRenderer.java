package com.yourname.feurshadowelytra.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CurioElytraRenderer implements ICurioRenderer {

    private final ResourceLocation texture;
    private final ElytraModel<LivingEntity> model;

    public CurioElytraRenderer(ResourceLocation texture, ModelPart modelPart) {
        this.texture = texture;
        this.model = new ElytraModel<>(modelPart);
    }

    @Override
    public void render(ItemStack stack,
                      LivingEntity entity,
                      PoseStack poseStack,
                      RenderLayerParent<LivingEntity, EntityModel<LivingEntity>> renderLayerParent,
                      MultiBufferSource buffer,
                      int light,
                      float limbSwing,
                      float limbSwingAmount,
                      float partialTicks,
                      float ageInTicks,
                      float netHeadYaw,
                      float headPitch) {

        renderLayerParent.getModel().copyPropertiesTo(model);

        model.renderToBuffer(
                poseStack,
                buffer.getBuffer(model.renderType(texture)),
                light,
                net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F
        );
    }
}