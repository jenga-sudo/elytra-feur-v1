package com.yourname.feurshadowelytra.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CurioElytraRenderer implements ICurioRenderer {

    private final ResourceLocation texture;

    public CurioElytraRenderer(ResourceLocation texture) {
        this.texture = texture;
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack,
            T entity,
            PoseStack poseStack,
            RenderLayerParent<T, M> renderLayerParent,
            MultiBufferSource buffer,
            int light,
            float limbSwing,
            float limbSwingAmount,
            float partialTicks,
            float ageInTicks,
            float netHeadYaw,
            float headPitch) {

        ElytraModel<T> model = new ElytraModel<>(renderLayerParent.getModel());
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