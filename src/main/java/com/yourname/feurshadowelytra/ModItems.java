package com.yourname.feurshadowelytra;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> REGISTER =
            DeferredRegister.create(ForgeRegistries.ITEMS, FeurShadowElytra.MODID);

    private static Item.Properties props() { return new Item.Properties().stacksTo(1).durability(432); }

    public static final RegistryObject<Item> PRINCESS     = REGISTER.register("princess",     () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> PHOENIX      = REGISTER.register("phoenix",      () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> ANGEL        = REGISTER.register("angel",        () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> BLACK_DRAGON = REGISTER.register("black_dragon", () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> WHITE_DRAGON = REGISTER.register("white_dragon", () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> STEAM        = REGISTER.register("steam",        () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> LEAF         = REGISTER.register("leaf",         () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> FAIRY        = REGISTER.register("fairy",        () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> PARROT       = REGISTER.register("parrot",       () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> OWL          = REGISTER.register("owl",          () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> RIVER        = REGISTER.register("river",        () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> LIGHT        = REGISTER.register("light",        () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> FIRE         = REGISTER.register("fire",         () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> WESTERN      = REGISTER.register("western",      () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> RAINBOW      = REGISTER.register("rainbow",      () -> new WingElytraItem(props()));
    public static final RegistryObject<Item> FLOWERING    = REGISTER.register("flowering",    () -> new WingElytraItem(props()));
}
