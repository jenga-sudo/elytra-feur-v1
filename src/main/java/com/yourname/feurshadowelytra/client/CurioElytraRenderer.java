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
import top.theillusivec4.curios.api.client.SlotContext;

public class CurioElytraRenderer implements ICurioRenderer {

    private final ResourceLocation texture;

    public CurioElytraRenderer(ResourceLocation texture) {
        this.texture = texture;
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack,
            SlotContext slotContext,
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

        T entity = slotContext.entity(); // 타입 명확화
        ElytraModel<T> model = new ElytraModel<>(renderLayerParent.getModel().root().getChild("body"));
        renderLayerParent.getModel().copyPropertiesTo(model);

        // 실제 렌더링 코드 예시 (텍스처 적용 등)
        model.renderToBuffer(
                poseStack,
                buffer.getBuffer(model.renderType(texture)),
                light,
                net.minecraft.client.renderer.entity.layers.ElytraLayer.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F
        );
    }
}