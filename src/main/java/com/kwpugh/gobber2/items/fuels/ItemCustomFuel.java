package com.kwpugh.gobber2.items.fuels;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCustomFuel extends Item
{	
	private int burnTime;
	
	public ItemCustomFuel(Properties p_i48487_1_, String name, int burnTime)
	{
	    super(p_i48487_1_);
	    this.setRegistryName(name);
	    this.burnTime = burnTime;
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack)
	{
	    return this.burnTime;
	}
}