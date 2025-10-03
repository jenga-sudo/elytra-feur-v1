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
import net.minecraftforge.fml.ModList;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.io.InputStreamReader;
import java.util.Map;
import java.util.Optional;

public class SpriteWingsLayer extends RenderLayer<net.minecraft.client.player.AbstractClientPlayer, PlayerModel<net.minecraft.client.player.AbstractClientPlayer>> {
    private final Map<String,String> map;

    public SpriteWingsLayer(RenderLayerParent<net.minecraft.client.player.AbstractClientPlayer, PlayerModel<net.minecraft.client.player.AbstractClientPlayer>> parent) {
        super(parent);
        Map<String,String> tmp;
        try (var is = SpriteWingsLayer.class.getResourceAsStream("/assets/" + FeurShadowElytra.MODID + "/elytra_textures.json")) {
            tmp = new Gson().fromJson(new InputStreamReader(is), new TypeToken<Map<String,String>>(){}.getType());
        } catch (Exception e) {
            tmp = Map.of();
        }
        this.map = tmp;
    }

    private static boolean isElytraLike(ItemStack s) {
        return s.is(new ResourceLocation("forge","elytra"))
                || s.is(new ResourceLocation("curios","elytra"))
                || (s.getItem() instanceof ElytraItem);
    }

    @Override
    public void render(PoseStack pose, MultiBufferSource buf, int light,
                       net.minecraft.client.player.AbstractClientPlayer p, float limb, float limbAmount, float partial,
                       float age, float headYaw, float headPitch) {

        ItemStack src = p.getItemBySlot(net.minecraft.world.entity.EquipmentSlot.CHEST);

        if (src.isEmpty() || !isElytraLike(src)) {
            if (ModList.get().isLoaded("curios")) {
                Optional<SlotResult> found = CuriosApi.getCuriosHelper().findFirstCurio(p, SpriteWingsLayer::isElytraLike);
                if (found.isPresent()) src = found.get().stack();
            }
        }
        if (src.isEmpty() || !isElytraLike(src)) return;

        String id = src.getItem().builtInRegistryHolder().key().location().toString();
        String texName = map.get(id);
        if (texName == null || texName.isEmpty()) texName = "wing3.png";

        ResourceLocation tex = new ResourceLocation(FeurShadowElytra.MODID, "textures/wings/" + texName);
        VertexConsumer vc = buf.getBuffer(RenderType.entityCutoutNoCull(tex));

        pose.pushPose();

        // Anchor to player body (reduces sliding with animations)
        this.getParentModel().body.translateAndRotate(pose);

        // Raise and pull closer to the back
        pose.translate(0.0F, -0.05F, 0.16F);
        pose.scale(1.05F, 1.05F, 1.05F);

        float w = 0.95F;
        float h = 1.15F;
        float z = 0.0F;

        // Right wing
        pose.pushPose();
        pose.translate(0.30F, -0.52F, z);
        pose.mulPose(Axis.YP.rotationDegrees(14.0F));
        drawQuad(pose, vc, light, -w, 0.0F, 0.0F, z, 0.0F, 0.0F, 1.0F, 1.0F, h);
        pose.popPose();

        // Left wing
        pose.pushPose();
        pose.translate(-0.30F, -0.52F, z);
        pose.mulPose(Axis.YN.rotationDegrees(14.0F));
        drawQuadMirroredU(pose, vc, light, 0.0F, 0.0F, w, z, 0.0F, 0.0F, 1.0F, 1.0F, h);
        pose.popPose();

        pose.popPose();
    }

    private static void drawQuad(PoseStack pose, VertexConsumer vc, int light,
                                 float x1, float y1, float x2, float z,
                                 float u1, float v1, float u2, float v2, float height) {
        var m = pose.last().pose();
        var n = pose.last().normal();
        vc.vertex(m, x1, y1, z).color(1F,1F,1F,1F).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0F,0F,1F).endVertex();
        vc.vertex(m, x2, y1, z).color(1F,1F,1F,1F).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0F,0F,1F).endVertex();
        vc.vertex(m, x2, y1 + height, z).color(1F,1F,1F,1F).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0F,0F,1F).endVertex();
        vc.vertex(m, x1, y1 + height, z).color(1F,1F,1F,1F).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0F,0F,1F).endVertex();
    }

    private static void drawQuadMirroredU(PoseStack pose, VertexConsumer vc, int light,
                                          float x1, float y1, float x2, float z,
                                          float u1, float v1, float u2, float v2, float height) {
        var m = pose.last().pose();
        var n = pose.last().normal();
        vc.vertex(m, x1, y1, z).color(1F,1F,1F,1F).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0F,0F,1F).endVertex();
        vc.vertex(m, x2, y1, z).color(1F,1F,1F,1F).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0F,0F,1F).endVertex();
        vc.vertex(m, x2, y1 + height, z).color(1F,1F,1F,1F).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0F,0F,1F).endVertex();
        vc.vertex(m, x1, y1 + height, z).color(1F,1F,1F,1F).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n, 0F,0F,1F).endVertex();
    }
}
