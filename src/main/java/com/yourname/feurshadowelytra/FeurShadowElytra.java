package com.yourname.feurshadowelytra;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(FeurShadowElytra.MODID)
public class FeurShadowElytra {
    public static final String MODID = "feur_shadow_elytra";
    public FeurShadowElytra() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(bus);
        bus.addListener(ModCreative::addToTab);
    }
}