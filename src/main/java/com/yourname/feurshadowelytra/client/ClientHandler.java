package com.yourname.feurshadowelytra.client;

import com.yourname.feurshadowelytra.FeurShadowElytra;
import com.yourname.feurshadowelytra.ModItems;
import com.yourname.feurshadowelytra.item.CurioElytraItem;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(modid = FeurShadowElytra.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientHandler {
    
    private static CurioElytraRenderer renderer;
    
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            renderer = new CurioElytraRenderer();
            
            // Register renderer for all elytra items
            CuriosRendererRegistry.register(ModItems.PRINCESS_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.PHOENIX_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.ANGEL_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.BLACK_DRAGON_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.WHITE_DRAGON_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.STEAM_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.LEAF_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.FAIRY_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.PARROT_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.OWL_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.RIVER_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.LIGHT_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.FIRE_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.WESTERN_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.RAINBOW_ELYTRA.get(), () -> renderer);
            CuriosRendererRegistry.register(ModItems.FLOWERING_ELYTRA.get(), () -> renderer);
        });
    }
    
    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // The elytra model is already registered by vanilla
    }
    
    @SubscribeEvent
    public static void onEntityRendererRegister(EntityRenderersEvent.AddLayers event) {
        // Initialize the model after entity model set is available
        EntityModelSet modelSet = event.getEntityModels();
        ElytraModel<LivingEntity> elytraModel = new ElytraModel<>(modelSet.bakeLayer(ModelLayers.ELYTRA));
        if (renderer != null) {
            renderer.setModel(elytraModel);
        }
    }
}
