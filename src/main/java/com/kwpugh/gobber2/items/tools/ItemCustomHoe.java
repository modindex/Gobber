package com.kwpugh.gobber2.items.tools;

import com.kwpugh.gobber2.lists.ItemList;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class ItemCustomHoe extends HoeItem
{
	public ItemCustomHoe(IItemTier tier, float attackDamage, float attackSpeedIn, Properties builder) 
	{
		super(tier, attackDamage, builder);
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack)
	{
		return 400;
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}
    
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.gobber2_ingot;
	}
}
