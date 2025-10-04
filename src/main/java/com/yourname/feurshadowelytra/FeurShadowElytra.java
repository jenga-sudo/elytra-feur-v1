package com.yourname.feurshadowelytra;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;

@Mod(FeurShadowElytra.MODID)
public class FeurShadowElytra {
    public static final String MODID = "feur_shadow_elytra";

    public FeurShadowElytra() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.REGISTER.register(modBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
