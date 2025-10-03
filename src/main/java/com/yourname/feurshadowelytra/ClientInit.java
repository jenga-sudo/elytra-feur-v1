package com.yourname.feurshadowelytra;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;

public class ClientInit {
    public static void register() {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientOnly::init);
    }
    private static class ClientOnly {
        static void init() { MinecraftForge.EVENT_BUS.register(new ClientOnly()); }
        @SubscribeEvent
        public void addLayers(EntityRenderersEvent.AddLayers e) {
            e.getSkins().forEach(skin -> {
                var r = e.getSkin(skin);
                if (r != null) r.addLayer(new SpriteWingsLayer(r));
            });
        }
    }
}
