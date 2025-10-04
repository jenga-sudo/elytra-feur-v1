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
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.Method;
import java.util.Locale;

@OnlyIn(Dist.CLIENT)
public class SpriteWingsLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    private static final TagKey<Item> TAG_FORGE_ELYTRA = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "elytra"));
    private static final TagKey<Item> TAG_CURIOS_ELYTRA = TagKey.create(Registries.ITEM, new ResourceLocation("curios", "elytra"));
    private static final ResourceLocation FALLBACK_TEX = new ResourceLocation(FeurShadowElytra.MODID, "textures/wings/_placeholder.png");

    public SpriteWingsLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> parent) {
        super(parent);
    }

    @Override
    public void render(PoseStack pose, MultiBufferSource buffers, int light, AbstractClientPlayer p, float limb, float limbAmount, float partial, float age, float headYaw, float headPitch) {
        ItemStack stack = findElytraLike(p);
        if (stack.isEmpty()) return;

        ResourceLocation tex = textureFor(stack);
        if (tex == null) tex = FALLBACK_TEX;

        pose.pushPose();
        pose.translate(0.0D, 0.95D, 0.22D);
        float scale = 2.25F;
        pose.scale(scale, scale, scale);

        float flap = (Mth.cos((p.tickCount + partial) * 0.15F) * 0.02F);

        pose.pushPose();
        pose.mulPose(Axis.YP.rotationDegrees(7.5F));
        pose.mulPose(Axis.ZP.rotation(flap));
        drawWing(pose, buffers, light, tex, true);
        pose.popPose();

        pose.pushPose();
        pose.mulPose(Axis.YP.rotationDegrees(-7.5F));
        pose.mulPose(Axis.ZP.rotation(-flap));
        drawWing(pose, buffers, light, tex, false);
        pose.popPose();

        pose.popPose();
    }

    private void drawWing(PoseStack pose, MultiBufferSource buffers, int light, ResourceLocation tex, boolean left) {
        VertexConsumer vc = buffers.getBuffer(RenderType.entityTranslucent(tex));
        var last = pose.last();
        float w = 0.18F;
        float h = 0.40F;
        float x0 = left ? -0.06F - w : 0.06F;
        float x1 = left ? -0.06F : 0.06F + w;
        float y0 = -0.20F;
        float y1 = y0 + h;
        float u0 = left ? 0F : 1F;
        float u1 = left ? 1F : 0F;
        float v0 = 0F, v1 = 1F;
        float z = 0.0F;

        vc.vertex(last.pose(), x0, y1, z).color(255,255,255,255).uv(u0, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(last.normal(), 0, 0, 1).endVertex();
        vc.vertex(last.pose(), x1, y1, z).color(255,255,255,255).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(last.normal(), 0, 0, 1).endVertex();
        vc.vertex(last.pose(), x1, y0, z).color(255,255,255,255).uv(u1, v0).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(last.normal(), 0, 0, 1).endVertex();
        vc.vertex(last.pose(), x0, y0, z).color(255,255,255,255).uv(u0, v0).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(last.normal(), 0, 0, 1).endVertex();
    }

    private static boolean isElytraLike(ItemStack s) {
        if (s.getItem() instanceof ElytraItem) return true;
        if (s.is(TAG_FORGE_ELYTRA)) return true;
        if (s.is(TAG_CURIOS_ELYTRA)) return true;
        Holder<Item> h = s.getItemHolder();
        return h != null && (h.is(TAG_FORGE_ELYTRA) || h.is(TAG_CURIOS_ELYTRA));
    }

    private static ItemStack findElytraLike(AbstractClientPlayer p) {
        ItemStack chest = p.getInventory().getArmor(2);
        if (isElytraLike(chest)) return chest;

        try {
            Class<?> curiosApi = Class.forName("top.theillusivec4.curios.api.CuriosApi");
            Method getHelper = curiosApi.getMethod("getCuriosHelper");
            Object helper = getHelper.invoke(null);
            Method findFirst = helper.getClass().getMethod("findFirstCurio", net.minecraft.world.entity.LivingEntity.class, java.util.function.Predicate.class);
            java.util.Optional<?> slotResult = (java.util.Optional<?>) findFirst.invoke(helper, p, (java.util.function.Predicate<ItemStack>) SpriteWingsLayer::isElytraLike);
            if (slotResult.isPresent()) {
                Object res = slotResult.get();
                Method getStack = res.getClass().getMethod("stack");
                ItemStack st = (ItemStack) getStack.invoke(res);
                if (!st.isEmpty()) return st;
            }
        } catch (Throwable ignored) { }
        return ItemStack.EMPTY;
    }

    private static ResourceLocation textureFor(ItemStack stack) {
        try {
            ResourceLocation key = ForgeRegistries.ITEMS.getKey(stack.getItem());
            if (key == null) return FALLBACK_TEX;
            String path = key.getPath().toLowerCase(Locale.ROOT);
            path = path.replace("_wings_chestplate", "").replace("_chestplate", "").replace("_wings_item", "").replace("_wings", "");
            return new ResourceLocation(FeurShadowElytra.MODID, "textures/wings/" + path + ".png");
        } catch (Throwable t) {
            return FALLBACK_TEX;
        }
    }
}