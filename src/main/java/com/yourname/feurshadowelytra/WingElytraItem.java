package com.yourname.feurshadowelytra;

import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class WingElytraItem extends ElytraItem {
    public WingElytraItem(Item.Properties props) { super(props); }
    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repair) { return super.isValidRepairItem(stack, repair); }
}
