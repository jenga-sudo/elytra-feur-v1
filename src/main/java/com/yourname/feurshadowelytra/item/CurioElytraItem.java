package com.yourname.feurshadowelytra.item;

import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CurioElytraItem extends ElytraItem implements ICurioItem {

    public CurioElytraItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public boolean canEquip(ItemStack stack, LivingEntity entity) {
        return true;
    }
}