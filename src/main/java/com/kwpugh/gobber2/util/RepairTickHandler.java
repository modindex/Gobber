package com.kwpugh.gobber2.util;

import com.kwpugh.gobber2.Gobber2;
import com.kwpugh.gobber2.lists.ItemList;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.items.IItemHandler;

@EventBusSubscriber(modid = Gobber2.modid, bus = EventBusSubscriber.Bus.FORGE )
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
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		ServerPlayerEntity player=(ServerPlayerEntity) event.player;
		//IItemHandler inv = (IItemHandler) player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		Iterable<ItemStack> inv = player.getEquipmentAndArmor();
		for (int i = 0; i < ((IItemHandler) inv).getSlots(); i++)
		{
			ItemStack target = ((IItemHandler) inv).getStackInSlot(i);

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
	
	private void repair(PlayerEntity player)
	{
		//IItemHandler inv = (IItemHandler) player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		Iterable<ItemStack> inv = player.getEquipmentAndArmor();
		for (int i = 0; i < ((IItemHandler) inv).getSlots(); i++)
		{
			ItemStack target = ((IItemHandler) inv).getStackInSlot(i);
			if (!target.isEmpty() && target.getItem().isRepairable(target))
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
}

