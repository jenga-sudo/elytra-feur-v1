package com.yourname.feurshadowelytra.item;

import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.type.capability.SlotContext;
import net.minecraft.nbt.CompoundTag;

public class CurioElytraItem extends ElytraItem implements ICurioItem {

    public CurioElytraItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public boolean canEquip(ItemStack stack, SlotContext slotContext) {
        // Curios Elytra 슬롯에 착용 가능
        return true;
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
        // Elytra 효과가 Curios 슬롯에서도 동작하도록(필요시 추가)
        // 기본 ElytraItem이 자동 처리하지만, 확장 필요시 구현
    }
}