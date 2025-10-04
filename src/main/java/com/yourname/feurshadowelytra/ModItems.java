package com.yourname.feurshadowelytra;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "feur_shadow_elytra");

    public static final RegistryObject<Item> PRINCESS = ITEMS.register("princess_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> PHOENIX = ITEMS.register("phoenix_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> ANGEL = ITEMS.register("angel_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> BLACK_DRAGON = ITEMS.register("black_dragon_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> WHITE_DRAGON = ITEMS.register("white_dragon_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> STEAM = ITEMS.register("steam_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> LEAF = ITEMS.register("leaf_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> FAIRY = ITEMS.register("fairy_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> PARROT = ITEMS.register("parrot_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> OWL = ITEMS.register("owl_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> RIVER = ITEMS.register("river_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> LIGHT = ITEMS.register("light_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> FIRE = ITEMS.register("fire_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> WESTERN = ITEMS.register("western_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> RAINBOW = ITEMS.register("rainbow_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> FLOWERING = ITEMS.register("flowering_wings_chestplate", WingElytraItem::new);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
