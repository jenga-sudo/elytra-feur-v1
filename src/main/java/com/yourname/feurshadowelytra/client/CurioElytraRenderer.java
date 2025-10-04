package com.yourname.feurshadowelytra.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.yourname.feurshadowelytra.FeurShadowElytra;
import com.yourname.feurshadowelytra.item.CurioElytraItem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CurioElytraRenderer implements ICurioRenderer {
    
    private ElytraModel<LivingEntity> model;
    
    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack,
            SlotContext slotContext,
            PoseStack poseStack,
            RenderLayerParent<T, M> renderLayerParent,
            MultiBufferSource multiBufferSource,
            int light,
            float limbSwing,
            float limbSwingAmount,
            float partialTicks,
            float ageInTicks,
            float netHeadYaw,
            float headPitch) {
        
        if (model == null) {
            return;
        }
        
        T entity = slotContext.entity();
        
        // Get the texture name from the item
        String textureName = "elytra";
        if (stack.getItem() instanceof CurioElytraItem curioElytra) {
            textureName = curioElytra.getTextureName();
        }
        
        ResourceLocation texture = new ResourceLocation(FeurShadowElytra.MODID, 
            "textures/entity/wings/" + textureName + ".png");
        
        // Set up the model
        model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        renderLayerParent.getModel().copyPropertiesTo(model);
        
        // Render the elytra
        VertexConsumer vertexConsumer = ItemRenderer.getArmorFoilBuffer(
            multiBufferSource, 
            RenderType.armorCutoutNoCull(texture), 
            false, 
            stack.hasFoil()
        );
        
        model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
    
    public void setModel(ElytraModel<LivingEntity> model) {
        this.model = model;
    }
}
