package com.yourname.feurshadowelytra;

import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FeurShadowElytra.MODID);

    public static final RegistryObject<Item> PRINCESS = ITEMS.register("princess_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> PHOENIX = ITEMS.register("phoenix_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> ANGEL = ITEMS.register("angel_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> BLACK_DRAGON = ITEMS.register("black_dragon_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> WHITE_DRAGON = ITEMS.register("white_dragon_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> STEAM = ITEMS.register("steam_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> LEAF = ITEMS.register("leaf_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> FAIRY = ITEMS.register("fairy_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> PARROT = ITEMS.register("parrot_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> OWL = ITEMS.register("owl_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> RIVER = ITEMS.register("river_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> LIGHT = ITEMS.register("light_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> FIRE = ITEMS.register("fire_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> WESTERN = ITEMS.register("western_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> RAINBOW = ITEMS.register("rainbow_wings", () -> new ElytraItem(new Item.Properties().durability(432)));
    public static final RegistryObject<Item> FLOWERING = ITEMS.register("flowering_wings", () -> new ElytraItem(new Item.Properties().durability(432)));

    public static void register() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
    }
}
