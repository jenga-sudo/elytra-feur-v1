package com.yourname.feurshadowelytra;

import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;

public class WingElytraItem extends ElytraItem {
    public WingElytraItem() {
        super(new Item.Properties()
                .stacksTo(1)
                .durability(432)
        );
    }
}