package com.yourname.feurshadowelytra;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FeurShadowElytra.MODID)
public class ModCreative {
    @SubscribeEvent
    public static void add(BuildCreativeModeTabContentsEvent e) {
        if (e.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            e.accept(ModItems.PRINCESS);
            e.accept(ModItems.PHOENIX);
            e.accept(ModItems.ANGEL);
            e.accept(ModItems.BLACK_DRAGON);
            e.accept(ModItems.WHITE_DRAGON);
            e.accept(ModItems.STEAM);
            e.accept(ModItems.LEAF);
            e.accept(ModItems.FAIRY);
            e.accept(ModItems.PARROT);
            e.accept(ModItems.OWL);
            e.accept(ModItems.RIVER);
            e.accept(ModItems.LIGHT);
            e.accept(ModItems.FIRE);
            e.accept(ModItems.WESTERN);
            e.accept(ModItems.RAINBOW);
            e.accept(ModItems.FLOWERING);
        }
    }
}
