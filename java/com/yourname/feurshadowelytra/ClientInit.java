package com.yourname.feurshadowelytra;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientInit {
    public static void register() {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
            bus.addListener(ClientInit::onAddLayers);
        });
    }

    private static void onAddLayers(EntityRenderersEvent.AddLayers event) {
        for (String skin : event.getSkins()) {
            net.minecraft.client.renderer.entity.player.PlayerRenderer r = event.getSkin(skin);
            if (r != null) {
                r.addLayer(new SpriteWingsLayer(r));
            }
        }
    }
}
