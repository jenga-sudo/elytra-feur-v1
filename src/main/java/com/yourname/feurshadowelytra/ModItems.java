package com.yourname.feurshadowelytra;

import com.yourname.feurshadowelytra.item.CurioElytraItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FeurShadowElytra.MODID);

    public static final RegistryObject<Item> PRINCESS_ELYTRA = ITEMS.register("princess_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "princess"));
    public static final RegistryObject<Item> PHOENIX_ELYTRA = ITEMS.register("phoenix_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "phoenix"));
    public static final RegistryObject<Item> ANGEL_ELYTRA = ITEMS.register("angel_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "angel"));
    public static final RegistryObject<Item> BLACK_DRAGON_ELYTRA = ITEMS.register("black_dragon_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "black_dragon"));
    public static final RegistryObject<Item> WHITE_DRAGON_ELYTRA = ITEMS.register("white_dragon_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "white_dragon"));
    public static final RegistryObject<Item> STEAM_ELYTRA = ITEMS.register("steam_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "steam"));
    public static final RegistryObject<Item> LEAF_ELYTRA = ITEMS.register("leaf_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "leaf"));
    public static final RegistryObject<Item> FAIRY_ELYTRA = ITEMS.register("fairy_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "fairy"));
    public static final RegistryObject<Item> PARROT_ELYTRA = ITEMS.register("parrot_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "parrot"));
    public static final RegistryObject<Item> OWL_ELYTRA = ITEMS.register("owl_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "owl"));
    public static final RegistryObject<Item> RIVER_ELYTRA = ITEMS.register("river_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "river"));
    public static final RegistryObject<Item> LIGHT_ELYTRA = ITEMS.register("light_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "light"));
    public static final RegistryObject<Item> FIRE_ELYTRA = ITEMS.register("fire_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "fire"));
    public static final RegistryObject<Item> WESTERN_ELYTRA = ITEMS.register("western_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "western"));
    public static final RegistryObject<Item> RAINBOW_ELYTRA = ITEMS.register("rainbow_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "rainbow"));
    public static final RegistryObject<Item> FLOWERING_ELYTRA = ITEMS.register("flowering_elytra", () -> new CurioElytraItem(new Item.Properties().stacksTo(1).durability(432), "flowering"));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}