package com.kwpugh.gobber2.util;

import com.kwpugh.gobber2.lists.ItemList;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class RepairTickHandler
{
static int DELAY;
	
	Item repairGring;
	static int time;
	
	public RepairTickHandler(Item item, int delay)
	{
		repairGring = item;
		DELAY = delay;
		time = DELAY;
	}
/*	
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		PlayerEntity player = event.player;
		IItemHandler inv = (IItemHandler) player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		for (int i = 0; i < inv.getSlots(); i++)
		{
			ItemStack target = inv.getStackInSlot(i);

			if (target.getItem() == ItemList.gobber2_ring_repair)
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
	
	private static void repair(PlayerEntity player)
	{
		IItemHandler inv = (IItemHandler) player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		for (int i = 0; i < inv.getSlots(); i++)
		{
			ItemStack target = inv.getStackInSlot(i);
			if (!target.isEmpty() && target.getItem().isRepairable())
			{
				if (!(player.isSwingInProgress && target == player.getItemStackFromSlot(EquipmentSlotType.MAINHAND)))
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
*/
}