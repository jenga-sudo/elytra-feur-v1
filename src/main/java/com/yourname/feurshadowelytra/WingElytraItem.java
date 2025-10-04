package com.yourname.feurshadowelytra;

import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;

public class WingElytraItem extends ElytraItem {
    public WingElytraItem(Properties props) { super(props); }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return super.isValidRepairItem(toRepair, repair);
    }
}
