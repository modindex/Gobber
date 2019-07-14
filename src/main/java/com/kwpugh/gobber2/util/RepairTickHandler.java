package com.kwpugh.gobber2.util;

import com.kwpugh.gobber2.lists.ItemList;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class RepairTickHandler
{
	int DELAY;
	
	Item repairGring;
	
	int time;
	
	public RepairTickHandler(Item item, int delay)
	{
		repairGring = item;
		DELAY = delay;
		time = DELAY;
	}
	
	@SubscribeEvent
	public void TickEvent(TickEvent.PlayerTickEvent event)
	{
		PlayerEntity player = event.player;
		
		IItemHandler inv = (IItemHandler) player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		for (int i = 0; i < ((IItemHandler) inv).getSlots(); i++)
		{
			ItemStack target = ((IItemHandler) inv).getStackInSlot(i);

			if (target.getItem() == ItemList.gobber2_ring)
			{
				time--;
				if (time <= 0)
				{
					time = DELAY;
					repair(player);
				}
			}
		}			
	}
	
	private void repair(PlayerEntity player)
	{
		IItemHandler inv = (IItemHandler) player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		for (int i = 0; i < ((IItemHandler) inv).getSlots(); i++)
		{
			ItemStack target = ((IItemHandler) inv).getStackInSlot(i);
			if (!target.isEmpty() && target.getItem().isRepairable(target))
			{
				if (target.isDamaged())
				{
					target.setDamage(target.getDamage() - 1);
					return; 
				}
			}
		}
	}
}