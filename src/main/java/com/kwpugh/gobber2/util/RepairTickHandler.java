package com.kwpugh.gobber2.util;

import com.kwpugh.gobber2.lists.ItemList;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
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
	
//	@SubscribeEvent
//	public void lifeMend(LivingUpdateEvent e) {
//		if (e.getEntity().world.isRemote) return;
//		for (EntityEquipmentSlot slot : slots) {
//			ItemStack stack = e.getEntityLiving().getItemStackFromSlot(slot);
//			if (!stack.isEmpty() && stack.isItemDamaged()) {
//				int level = EnchantmentHelper.getEnchantmentLevel(ApotheosisObjects.LIFE_MENDING, stack);
//				if (level > 0 && e.getEntityLiving().world.rand.nextInt(10) == 0) {
//					int i = Math.min(level, stack.getItemDamage());
//					e.getEntityLiving().attackEntityFrom(CORRUPTED, i * 0.7F);
//					stack.setItemDamage(stack.getItemDamage() - i);
//					return;
//				}
//			}
//		}
//	}
	
	
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		PlayerEntity player = event.player;
		IItemHandler inv = (IItemHandler) player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		for (int i = 0; i < inv.getSlots(); i++)
		{
			ItemStack target = inv.getStackInSlot(i);

			if (target.getItem() == ItemList.gobber2_ring)
			{
				time--;
				if (time <= 0)
				{
					time = DELAY;
					repair(inv);
				}
			}
		}			
	}
	
	@SubscribeEvent
	public void repair(LivingUpdateEvent event)
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