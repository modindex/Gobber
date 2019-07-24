package com.kwpugh.gobber2.util;

import javax.annotation.Nonnull;

import com.kwpugh.gobber2.Gobber2;
import com.kwpugh.gobber2.lists.ItemList;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Inspired and adapted from Sinhika's code in NetherRocks
 * 
 */

@EventBusSubscriber(modid = Gobber2.modid, bus = EventBusSubscriber.Bus.FORGE )
public final class ModEventSubscriber
{	
    @SubscribeEvent(receiveCanceled = true, priority= EventPriority.HIGHEST)
    public static void onLivingHurtEvent(LivingAttackEvent event)
    {
        if (event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            if ((event.getSource() == DamageSource.FALL) &&
                ArmorUtil.isPlayerGotFallProtection(player))
            {
                if (event.isCancelable()) event.setCanceled(true);
            } 
            
            if (((event.getSource() == DamageSource.IN_FIRE) ||
            		(event.getSource() == DamageSource.ON_FIRE) || 
            		(event.getSource() == DamageSource.LAVA)) && 
            		ArmorUtil.isPlayerGotFireProtection(player))
            {
                if (event.isCancelable()) event.setCanceled(true);
            } 
        } 
    }
    
//    @SubscribeEvent(receiveCanceled = true, priority= EventPriority.HIGHEST)
//    public void onPlayerTickEvent(@Nonnull TickEvent.PlayerTickEvent event)
//    {
//        PlayerEntity player = event.player;
//        
//        if (player == null) return;
//        
//        ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
//		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
//		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
//	    ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);	
//	    
//	    //Full Set
//    	if(head.getItem() == ItemList.gobber2_helmet_end && 
//    			chest.getItem() == ItemList.gobber2_chestplate_end &&
//    			legs.getItem() == ItemList.gobber2_leggings_end && 
//    			feet.getItem() == ItemList.gobber2_boots_end)
//    	{	
//			int currentDim = player.dimension.getId();
//		
//			if(currentDim == 1) 
//	    	{
//	       		player.abilities.allowFlying = true;
//	    	}
//	       	else
//	       	{
//	       		player.abilities.allowFlying = false;
//	       		player.abilities.isFlying = false;
//	       	}
//    	}	
//    }
} 