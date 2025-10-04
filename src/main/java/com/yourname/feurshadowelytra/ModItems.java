package com.yourname.feurshadowelytra;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FeurShadowElytra.MODID);

    public static final RegistryObject<Item> PRINCESS_ELYTRA = ITEMS.register("princess_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PHOENIX_ELYTRA = ITEMS.register("phoenix_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ANGEL_ELYTRA = ITEMS.register("angel_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLACK_DRAGON_ELYTRA = ITEMS.register("black_dragon_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> WHITE_DRAGON_ELYTRA = ITEMS.register("white_dragon_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> STEAM_ELYTRA = ITEMS.register("steam_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> LEAF_ELYTRA = ITEMS.register("leaf_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> FAIRY_ELYTRA = ITEMS.register("fairy_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PARROT_ELYTRA = ITEMS.register("parrot_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> OWL_ELYTRA = ITEMS.register("owl_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RIVER_ELYTRA = ITEMS.register("river_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> LIGHT_ELYTRA = ITEMS.register("light_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> FIRE_ELYTRA = ITEMS.register("fire_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> WESTERN_ELYTRA = ITEMS.register("western_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RAINBOW_ELYTRA = ITEMS.register("rainbow_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> FLOWERING_ELYTRA = ITEMS.register("flowering_elytra", () -> new WingElytraItem(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON)));

    public static void register() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
    }
}
