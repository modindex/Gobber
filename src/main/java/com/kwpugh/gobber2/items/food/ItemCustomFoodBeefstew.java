package com.kwpugh.gobber2.items.food;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class ItemCustomFoodBeefstew extends Item
{

	public ItemCustomFoodBeefstew(Properties properties)
	{
		super(properties);
	}
	
	protected void onFoodEaten(ItemStack stack, World world, PlayerEntity player)
	{
		if (!player.inventory.addItemStackToInventory(new ItemStack(Items.BOWL)))
		{
			player.dropItem(new ItemStack(Items.BOWL), false);
		}	
	}
}
