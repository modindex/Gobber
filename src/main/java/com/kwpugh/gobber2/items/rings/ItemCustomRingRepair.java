package com.kwpugh.gobber2.items.rings;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ItemCustomRingRepair extends Item
{
	
	
	public ItemCustomRingRepair(Properties properties)
	{
		super(properties);
	}
	
	/*
	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected)
	{
		if(!world.isRemote && entity instanceof PlayerEntity)
		{		
					// Repair.
					if (repair((PlayerEntity) entity))
					{
						
					}
					else
					{
						//false
					}
				
		}			
	}
	
	private static boolean repair(PlayerEntity player)
	{
		IItemHandler inv = (IItemHandler) player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		
		boolean flag = false;
		
		// Scan the player's inventory.
		for (int i = 0; i < inv.getSlots(); i++)
		{
			ItemStack stack = inv.getStackInSlot(i);
			
			if (!stack.isEmpty() && stack.getItem().isRepairable())
			{
				// Repair.
				if (stack.isDamaged())
				{
					stack.setDamage(stack.getDamage() - 1);
					flag = true;
				}
				else
				{
					flag = false;
				}
			}
		}
		return flag;
	}
	*/
	
}	


	
