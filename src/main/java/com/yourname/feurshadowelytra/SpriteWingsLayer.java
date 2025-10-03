package com.yourname.feurshadowelytra;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;

import java.io.InputStreamReader;
import java.util.Map;

public class SpriteWingsLayer extends RenderLayer<net.minecraft.client.player.AbstractClientPlayer, PlayerModel<net.minecraft.client.player.AbstractClientPlayer>> {
    private final Map<String,String> map;

    public SpriteWingsLayer(RenderLayerParent<net.minecraft.client.player.AbstractClientPlayer, PlayerModel<net.minecraft.client.player.AbstractClientPlayer>> parent) {
        super(parent);
        Map<String,String> tmp;
        try (var is = SpriteWingsLayer.class.getResourceAsStream("/assets/feur_shadow_elytra/elytra_textures.json")) {
            tmp = new Gson().fromJson(new InputStreamReader(is), new TypeToken<Map<String,String>>(){}.getType());
        } catch (Exception e) {
            tmp = Map.of();
        }
        this.map = tmp;
    }

    @Override
    public void render(PoseStack pose, MultiBufferSource buf, int light,
                       net.minecraft.client.player.AbstractClientPlayer p, float limb, float limbAmount, float partial,
                       float age, float headYaw, float headPitch) {

        ItemStack chest = p.getInventory().armor.get(2);
        if (chest.isEmpty() || !(chest.getItem() instanceof ElytraItem)) return;

        String id = chest.getItem().builtInRegistryHolder().key().location().toString();
        String texName = map.get(id);
        if (texName == null) return;

        ResourceLocation tex = new ResourceLocation(FeurShadowElytra.MODID, "textures/wings/" + texName);
        VertexConsumer vc = buf.getBuffer(RenderType.entityCutout(tex));

        pose.pushPose();
        pose.translate(0.0D, 0.85D, 0.2D);

        float wingWidth  = 0.9F;
        float wingHeight = 1.0F;
        float z = 0.01F;

        pose.pushPose();
        pose.translate(0.2D, -0.6D, z);
        pose.mulPose(Axis.YP.rotationDegrees(40F));
        drawQuad(pose, vc, light, -wingWidth, 0.0F, 0.0F, z, 0.0F, 0.0F, 1.0F, 1.0F, wingHeight);
        pose.popPose();

        pose.pushPose();
        pose.translate(-0.2D, -0.6D, z);
        pose.mulPose(Axis.YN.rotationDegrees(40F));
        drawQuadMirroredU(pose, vc, light, 0.0F, 0.0F, wingWidth, z, 0.0F, 0.0F, 1.0F, 1.0F, wingHeight);
        pose.popPose();

        pose.popPose();
    }

    private static void drawQuad(PoseStack pose, VertexConsumer vc, int light,
                                 float x1, float y1, float x2, float z,
                                 float u1, float v1, float u2, float v2, float height) {
        var m = pose.last().pose();
        var n = pose.last().normal();
        vc.vertex(m, x1, y1, z).color(1f,1f,1f,1f).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
        vc.vertex(m, x2, y1, z).color(1f,1f,1f,1f).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
        vc.vertex(m, x2, y1 + height, z).color(1f,1f,1f,1f).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
        vc.vertex(m, x1, y1 + height, z).color(1f,1f,1f,1f).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
    }

    private static void drawQuadMirroredU(PoseStack pose, VertexConsumer vc, int light,
                                          float x1, float y1, float x2, float z,
                                          float u1, float v1, float u2, float v2, float height) {
        var m = pose.last().pose();
        var n = pose.last().normal();
        vc.vertex(m, x1, y1, z).color(1f,1f,1f,1f).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
        vc.vertex(m, x2, y1, z).color(1f,1f,1f,1f).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
        vc.vertex(m, x2, y1 + height, z).color(1f,1f,1f,1f).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
        vc.vertex(m, x1, y1 + height, z).color(1f,1f,1f,1f).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0,0,1).endVertex();
    }
}
