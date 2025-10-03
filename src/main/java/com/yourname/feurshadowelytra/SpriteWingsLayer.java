package com.yourname.feurshadowelytra;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.function.Predicate;

public class SpriteWingsLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    public SpriteWingsLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> parent) {
        super(parent);
    }

    private static final TagKey<Item> TAG_FORGE_ELYTRA = ItemTags.create(new ResourceLocation("forge","elytra"));
    private static final TagKey<Item> TAG_CURIOS_ELYTRA = ItemTags.create(new ResourceLocation("curios","elytra"));

    private static boolean isElytraLike(ItemStack s) {
        if (s.isEmpty()) return false;
        if (s.getItem() instanceof ElytraItem) return true;
        if (s.is(TAG_FORGE_ELYTRA)) return true;
        if (s.is(TAG_CURIOS_ELYTRA)) return true;
        return false;
    }

    private static ItemStack findCuriosElytra(AbstractClientPlayer p) {
        if (!ModList.get().isLoaded("curios")) return ItemStack.EMPTY;
        try {
            Class<?> curiosApi = Class.forName("top.theillusivec4.curios.api.CuriosApi");
            Method getHelper = curiosApi.getMethod("getCuriosHelper");
            Object helper = getHelper.invoke(null);
            Method findFirstCurio = helper.getClass().getMethod(
                    "findFirstCurio",
                    net.minecraft.world.entity.LivingEntity.class,
                    java.util.function.Predicate.class
            );
            @SuppressWarnings("unchecked")
            Optional<?> res = (Optional<?>) findFirstCurio.invoke(helper, p, (Predicate<ItemStack>) SpriteWingsLayer::isElytraLike);
            if (res.isPresent()) {
                Object slotResult = res.get();
                Method stackGetter = slotResult.getClass().getMethod("stack");
                return (ItemStack) stackGetter.invoke(slotResult);
            }
        } catch (Throwable ignored) {}
        return ItemStack.EMPTY;
    }

    @Override
    public void render(PoseStack pose, MultiBufferSource buf, int light,
                       AbstractClientPlayer p, float limb, float limbAmount, float partial,
                       float age, float headYaw, float headPitch) {

        ItemStack src = p.getItemBySlot(EquipmentSlot.CHEST);
        if (src.isEmpty() || !isElytraLike(src)) {
            ItemStack curios = findCuriosElytra(p);
            if (!curios.isEmpty()) src = curios;
        }
        if (src.isEmpty() || !isElytraLike(src)) return;

        ResourceLocation tex = new ResourceLocation(FeurShadowElytra.MODID, "textures/wings/wing3.png");
        VertexConsumer vc = buf.getBuffer(RenderType.entityCutoutNoCull(tex));

        pose.pushPose();
        this.getParentModel().body.translateAndRotate(pose);

        if (p.isCrouching()) {
            pose.translate(0.0F, 0.2F, 0.1F);
            pose.mulPose(Axis.XP.rotationDegrees(10.0F));
        }

        float w = 1.25F;
        float h = 1.75F;
        float z = 0.02F;

        pose.pushPose();
        pose.translate(0.38F, -0.68F, 0.18F + z);
        pose.mulPose(Axis.YP.rotationDegrees(18.0F));
        quad(pose, vc, light, -w, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, h);
        pose.popPose();

        pose.pushPose();
        pose.translate(-0.38F, -0.68F, 0.18F + z);
        pose.mulPose(Axis.YN.rotationDegrees(18.0F));
        quadMirrorU(pose, vc, light, 0.0F, 0.0F, w, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, h);
        pose.popPose();

        pose.popPose();
    }

    private static void quad(PoseStack p, VertexConsumer v, int light,
                             float x1, float y1, float x2, float z,
                             float u1, float v1, float u2, float v2, float h) {
        var m = p.last().pose();
        var n = p.last().normal();
        v.vertex(m, x1, y1, z).color(1,1,1,1).uv(u1,v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n,0,0,1).endVertex();
        v.vertex(m, x2, y1, z).color(1,1,1,1).uv(u2,v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n,0,0,1).endVertex();
        v.vertex(m, x2, y1+h, z).color(1,1,1,1).uv(u2,v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n,0,0,1).endVertex();
        v.vertex(m, x1, y1+h, z).color(1,1,1,1).uv(u1,v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n,0,0,1).endVertex();
    }

    private static void quadMirrorU(PoseStack p, VertexConsumer v, int light,
                                    float x1, float y1, float x2, float z,
                                    float u1, float v1, float u2, float v2, float h) {
        var m = p.last().pose();
        var n = p.last().normal();
        v.vertex(m, x1, y1, z).color(1,1,1,1).uv(u2,v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n,0,0,1).endVertex();
        v.vertex(m, x2, y1, z).color(1,1,1,1).uv(u1,v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n,0,0,1).endVertex();
        v.vertex(m, x2, y1+h, z).color(1,1,1,1).uv(u1,v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n,0,0,1).endVertex();
        v.vertex(m, x1, y1+h, z).color(1,1,1,1).uv(u2,v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(n,0,0,1).endVertex();
    }
}
