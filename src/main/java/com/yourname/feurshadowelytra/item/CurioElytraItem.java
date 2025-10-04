package com.yourname.feurshadowelytra.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CurioElytraItem extends ElytraItem implements ICurioItem {
    
    private final String textureName;
    
    public CurioElytraItem(Properties properties, String textureName) {
        super(properties);
        this.textureName = textureName;
    }
    
    public String getTextureName() {
        return textureName;
    }
    
    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }
    
    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return true;
    }
    
    @Override
    public boolean canUnequip(SlotContext slotContext, ItemStack stack) {
        return true;
    }
    
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        // Elytra tick logic is handled by vanilla in LivingEntity
    }
    
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, 
                                                                         ResourceLocation id, 
                                                                         ItemStack stack) {
        return HashMultimap.create();
    }
    
    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return false;
    }
}
