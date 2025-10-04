package com.yourname.feurshadowelytra;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ElytraItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FeurShadowElytra.MODID);

    public static final RegistryObject<Item> PRINCESS_ELYTRA = ITEMS.register("princess_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> PHOENIX_ELYTRA = ITEMS.register("phoenix_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> ANGEL_ELYTRA = ITEMS.register("angel_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> BLACK_DRAGON_ELYTRA = ITEMS.register("black_dragon_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> WHITE_DRAGON_ELYTRA = ITEMS.register("white_dragon_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> STEAM_ELYTRA = ITEMS.register("steam_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> LEAF_ELYTRA = ITEMS.register("leaf_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> FAIRY_ELYTRA = ITEMS.register("fairy_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> PARROT_ELYTRA = ITEMS.register("parrot_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> OWL_ELYTRA = ITEMS.register("owl_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> RIVER_ELYTRA = ITEMS.register("river_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> LIGHT_ELYTRA = ITEMS.register("light_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> FIRE_ELYTRA = ITEMS.register("fire_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> WESTERN_ELYTRA = ITEMS.register("western_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> RAINBOW_ELYTRA = ITEMS.register("rainbow_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> FLOWERING_ELYTRA = ITEMS.register("flowering_elytra", () -> new ElytraItem(new Item.Properties().stacksTo(1).durability(432)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}