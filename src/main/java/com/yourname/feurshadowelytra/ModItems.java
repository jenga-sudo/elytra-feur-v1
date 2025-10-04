package com.yourname.feurshadowelytra;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.yourname.feurshadowelytra.item.CurioElytraItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "feur_shadow_elytra");

    public static final RegistryObject<Item> PRINCESS_ELYTRA = ITEMS.register("princess_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> PHOENIX_ELYTRA = ITEMS.register("phoenix_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> ANGEL_ELYTRA = ITEMS.register("angel_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> BLACK_DRAGON_ELYTRA = ITEMS.register("black_dragon_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> WHITE_DRAGON_ELYTRA = ITEMS.register("white_dragon_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> STEAM_ELYTRA = ITEMS.register("steam_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> LEAF_ELYTRA = ITEMS.register("leaf_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> FAIRY_ELYTRA = ITEMS.register("fairy_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> PARROT_ELYTRA = ITEMS.register("parrot_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> OWL_ELYTRA = ITEMS.register("owl_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> RIVER_ELYTRA = ITEMS.register("river_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> LIGHT_ELYTRA = ITEMS.register("light_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> FIRE_ELYTRA = ITEMS.register("fire_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> WESTERN_ELYTRA = ITEMS.register("western_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> RAINBOW_ELYTRA = ITEMS.register("rainbow_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
    public static final RegistryObject<Item> FLOWERING_ELYTRA = ITEMS.register("flowering_elytra", () -> new CurioElytraItem(new Properties().stacksTo(1).durability(432)));
}
