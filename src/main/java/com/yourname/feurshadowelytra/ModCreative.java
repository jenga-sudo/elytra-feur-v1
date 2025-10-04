package com.yourname.feurshadowelytra;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FeurShadowElytra.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreative {
    @SubscribeEvent
    public static void addToTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.PRINCESS_ELYTRA);
            event.accept(ModItems.PHOENIX_ELYTRA);
            event.accept(ModItems.ANGEL_ELYTRA);
            event.accept(ModItems.BLACK_DRAGON_ELYTRA);
            event.accept(ModItems.WHITE_DRAGON_ELYTRA);
            event.accept(ModItems.STEAM_ELYTRA);
            event.accept(ModItems.LEAF_ELYTRA);
            event.accept(ModItems.FAIRY_ELYTRA);
            event.accept(ModItems.PARROT_ELYTRA);
            event.accept(ModItems.OWL_ELYTRA);
            event.accept(ModItems.RIVER_ELYTRA);
            event.accept(ModItems.LIGHT_ELYTRA);
            event.accept(ModItems.FIRE_ELYTRA);
            event.accept(ModItems.WESTERN_ELYTRA);
            event.accept(ModItems.RAINBOW_ELYTRA);
            event.accept(ModItems.FLOWERING_ELYTRA);
        }
    }
}