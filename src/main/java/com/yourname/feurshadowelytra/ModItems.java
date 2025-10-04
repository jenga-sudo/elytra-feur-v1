package com.yourname.feurshadowelytra;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, FeurShadowElytra.MODID);

    public static final RegistryObject<Item> PRINCESS = REGISTER.register("princess_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> PHOENIX = REGISTER.register("phoenix_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> ANGEL = REGISTER.register("angel_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> BLACK_DRAGON = REGISTER.register("black_dragon_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> WHITE_DRAGON = REGISTER.register("white_dragon_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> STEAM = REGISTER.register("steam_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> LEAF = REGISTER.register("leaf_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> FAIRY = REGISTER.register("fairy_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> PARROT = REGISTER.register("parrot_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> OWL = REGISTER.register("owl_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> RIVER = REGISTER.register("river_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> LIGHT = REGISTER.register("light_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> FIRE = REGISTER.register("fire_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> WESTERN = REGISTER.register("western_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> RAINBOW = REGISTER.register("rainbow_wings_chestplate", WingElytraItem::new);
    public static final RegistryObject<Item> FLOWERING = REGISTER.register("flowering_wings_chestplate", WingElytraItem::new);
}