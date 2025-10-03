package com.yourname.feurshadowelytra;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.AbstractClientPlayer;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;

import java.io.InputStreamReader;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SpriteWingsLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    private Map<String,String> map;

    public SpriteWingsLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> parent) {
        super(parent);
        try (var is = SpriteWingsLayer.class.getResourceAsStream("/assets/feur_shadow_elytra/elytra_textures.json")) {
            map = new Gson().fromJson(new InputStreamReader(is), new TypeToken<Map<String,String>>(){}.getType());
        } catch (Exception e) { map = Map.of(); }
    }

    @Override
    public void render(PoseStack pose, MultiBufferSource buf, int light, AbstractClientPlayer p, float limb, float limbAmount, float partial, float age, float headYaw, float headPitch) {
        ItemStack chest = p.getInventory().armor.get(2);
        if (chest.isEmpty() || !(chest.getItem() instanceof ElytraItem)) return;

        String id = chest.getItem().builtInRegistryHolder().key().location().toString();
        String texName = map.get(id);
        if (texName == null) return;

        ResourceLocation tex = new ResourceLocation(FeurShadowElytra.MODID, "textures/wings/" + texName);
        VertexConsumer vc = buf.getBuffer(RenderType.entityCutout(tex));

        pose.pushPose();

        // Position the wings slightly behind the back
        pose.translate(0.0F, 0.85F, 0.2F);
        // Rotate a bit to follow body yaw
        float spread = 0.6F; // wing spread
        float wingWidth = 0.9F, wingHeight = 1.0F, wingThickness = 0.01F;

        // Left wing
        pose.pushPose();
        pose.translate(0.2F, -0.6F, wingThickness);
        pose.mulPose(com.mojang.math.Axis.YP.rotationDegrees(40F));
        drawQuad(pose, vc, light, -wingWidth, 0, 0, 0, 0, 1, 1, wingHeight);
        pose.popPose();

        // Right wing
        pose.pushPose();
        pose.translate(-0.2F, -0.6F, wingThickness);
        pose.mulPose(com.mojang.math.Axis.YN.rotationDegrees(40F));
        // mirror U coords by swapping
        drawQuadMirroredU(pose, vc, light, 0, 0, wingWidth, 0, 0, 1, 1, wingHeight);
        pose.popPose();

        pose.popPose();
    }

    private static void drawQuad(PoseStack pose, VertexConsumer vc, int light, float x1, float y1, float x2, float z, float u1, float v1, float u2, float v2, float height) {
        var m = pose.last().pose();
        var n = pose.last().normal();
        vc.vertex(m, x1, y1, z).color(1f,1f,1f,1f).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
        vc.vertex(m, x2, y1, z).color(1f,1f,1f,1f).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
        vc.vertex(m, x2, y1+height, z).color(1f,1f,1f,1f).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
        vc.vertex(m, x1, y1+height, z).color(1f,1f,1f,1f).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
    }

    private static void drawQuadMirroredU(PoseStack pose, VertexConsumer vc, int light, float x1, float y1, float x2, float z, float u1, float v1, float u2, float v2, float height) {
        var m = pose.last().pose();
        var n = pose.last().normal();
        vc.vertex(m, x1, y1, z).color(1f,1f,1f,1f).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
        vc.vertex(m, x2, y1, z).color(1f,1f,1f,1f).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
        vc.vertex(m, x2, y1+height, z).color(1f,1f,1f,1f).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
        vc.vertex(m, x1, y1+height, z).color(1f,1f,1f,1f).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
    }
}
