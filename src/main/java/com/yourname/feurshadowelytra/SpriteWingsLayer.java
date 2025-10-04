package com.yourname.feurshadowelytra;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.Optional;

public class SpriteWingsLayer<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {
    public SpriteWingsLayer(RenderLayerParent<T, M> parent) {
        super(parent);
    }

    private static boolean isOurElytra(ItemStack s) {
        Item it = s.getItem();
        return it == Items.ELYTRA || (it instanceof WingElytraItem);
    }

    private static String pickName(ItemStack s) {
        String def = "angel";
        try {
            var key = ForgeRegistries.ITEMS.getKey(s.getItem());
            if (key != null && key.getNamespace().equals("feur_shadow_elytra")) {
                String path = key.getPath();
                return path.replace("_elytra","");
            }
        } catch (Exception ignored) {}
        return def;
    }

    @Override
    public void render(PoseStack pose, MultiBufferSource buf, int light, T p,
                       float limb, float limbAmount, float partial, float age, float headYaw, float headPitch) {
        ItemStack chest = p.getInventory().armor.get(2);
        ItemStack fly = isOurElytra(chest) ? chest : ItemStack.EMPTY;
        if (fly.isEmpty()) return;

        String name = pickName(fly);
        ResourceLocation tex = new ResourceLocation("feur_shadow_elytra", "textures/wings/" + name + ".png");
        VertexConsumer vc = buf.getBuffer(RenderType.entityTranslucent(tex));

        pose.pushPose();
        pose.translate(0.0, 0.9, 0.2);
        float scale = 1.6f;
        pose.scale(scale, scale, scale);

        float size = 16f;
        drawQuad(pose, vc, light, -size, 0, 0, 0f, 0f, 1f, 1f, size);
        drawQuadMirroredU(pose, vc, light, 0, 0, 0, 0f, 0f, 1f, 1f, size);

        pose.popPose();
    }

    private void drawQuad(PoseStack pose, VertexConsumer vc, int light,
                          float x, float y, float z, float u0, float v0, float u1, float v1, float h) {
        var m = pose.last().pose();
        vc.vertex(m, x, y, z).color(255,255,255,255).uv(u0, v0).uv2(light).endVertex();
        vc.vertex(m, x + h, y, z).color(255,255,255,255).uv(u1, v0).uv2(light).endVertex();
        vc.vertex(m, x + h, y + h, z).color(255,255,255,255).uv(u1, v1).uv2(light).endVertex();
        vc.vertex(m, x, y + h, z).color(255,255,255,255).uv(u0, v1).uv2(light).endVertex();
    }

    private void drawQuadMirroredU(PoseStack pose, VertexConsumer vc, int light,
                          float x, float y, float z, float u0, float v0, float u1, float v1, float h) {
        var m = pose.last().pose();
        vc.vertex(m, x, y, z).color(255,255,255,255).uv(u1, v0).uv2(light).endVertex();
        vc.vertex(m, x + h, y, z).color(255,255,255,255).uv(u0, v0).uv2(light).endVertex();
        vc.vertex(m, x + h, y + h, z).color(255,255,255,255).uv(u0, v1).uv2(light).endVertex();
        vc.vertex(m, x, y + h, z).color(255,255,255,255).uv(u1, v1).uv2(light).endVertex();
    }
}
