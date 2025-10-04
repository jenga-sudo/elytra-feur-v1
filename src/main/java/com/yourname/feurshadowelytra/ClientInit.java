package com.yourname.feurshadowelytra;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;

@Mod.EventBusSubscriber(modid = FeurShadowElytra.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientInit {
    @SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers event) {
        for (String skin : event.getSkins()) {
            PlayerRenderer r = event.getSkin(skin);
            if (r != null) {
                r.addLayer(new SpriteWingsLayer(r));
            }
        }
    }
}