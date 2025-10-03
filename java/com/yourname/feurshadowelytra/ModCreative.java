package com.yourname.feurshadowelytra;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModCreative {
    public static void register() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ModCreative::onBuildTabs);
    }

    private static void onBuildTabs(BuildCreativeModeTabContentsEvent e) {
        if (e.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            e.accept(ModItems.PRINCESS.get());
            e.accept(ModItems.PHOENIX.get());
            e.accept(ModItems.ANGEL.get());
            e.accept(ModItems.BLACK_DRAGON.get());
            e.accept(ModItems.WHITE_DRAGON.get());
            e.accept(ModItems.STEAM.get());
            e.accept(ModItems.LEAF.get());
            e.accept(ModItems.FAIRY.get());
            e.accept(ModItems.PARROT.get());
            e.accept(ModItems.OWL.get());
            e.accept(ModItems.RIVER.get());
            e.accept(ModItems.LIGHT.get());
            e.accept(ModItems.FIRE.get());
            e.accept(ModItems.WESTERN.get());
            e.accept(ModItems.RAINBOW.get());
            e.accept(ModItems.FLOWERING.get());
        }
    }
}
