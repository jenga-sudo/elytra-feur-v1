package com.yourname.feurshadowelytra;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "feur_shadow_elytra", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientInit {
    @SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers e) {
        PlayerRenderer r1 = e.getSkin("default");
        if (r1 != null) r1.addLayer(new SpriteWingsLayer(r1));
        PlayerRenderer r2 = e.getSkin("slim");
        if (r2 != null) r2.addLayer(new SpriteWingsLayer(r2));
    }
}
