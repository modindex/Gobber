package com.kwpugh.gobber2.items.armor;

import com.kwpugh.gobber2.lists.ItemList;
import com.kwpugh.gobber2.util.SpecialAbilities;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCustomArmorNether extends ArmorItem
{
	public ItemCustomArmorNether(IArmorMaterial materialIn, EquipmentSlotType slots, Properties builder)
	{
		super(materialIn, slots, builder);
	}
	
	@Override
	public void onArmorTick(final ItemStack stack, final World world, final PlayerEntity player)
	{
		ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
	    ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);	
	 
	    //Full Set
	    if(!world.isRemote)
	    {
	    	if(head != null && head.getItem() == ItemList.gobber2_helmet_nether && 
	    			chest != null && chest.getItem() == ItemList.gobber2_chestplate_nether && 
	    			legs != null && legs.getItem() == ItemList.gobber2_leggings_nether && 
	    			feet != null && feet.getItem() == ItemList.gobber2_boots_nether)
	    	{
	    		//something here
	    	}	
	    }
	    
	    //Helmet
	    if(head.getItem() == ItemList.gobber2_helmet_nether)
		{
			SpecialAbilities.giveExtraHearts(world, player, stack);
			int newfoodlevel = 1;
			float newsatlevel = 0.05F;
			SpecialAbilities.giveRegenffect(world, player, stack, newfoodlevel, newsatlevel);			
		}
		else
		{
			SpecialAbilities.giveNoExtraHearts(world, player, stack);
		}
	    
	    //Chestplate
	    if(chest.getItem() == ItemList.gobber2_chestplate_nether)
		{
	 		if(player.isInWater())
	 		{
	 			SpecialAbilities.giveConduitEffect(world, player, chest);
	 		}
	 		
	 		SpecialAbilities.giveFireProtection(world, player, chest);
	 		player.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(40.0D); 
		 }		
	    
	    //Leggings
	    if(legs.getItem() == ItemList.gobber2_leggings_nether)
		{
			player.fallDistance = 0.0F;
		}
		else
		{
			player.fallDistance = 1.0F;
		}		
	    
	    //Boots
	    if(feet.getItem() == ItemList.gobber2_boots_nether)
		{
			player.stepHeight = 3.0F;
			
			if(!player.onGround)
			{
				//player.jumpMovementFactor += 0.09F;
			}
	    }
		else
	    {
			player.stepHeight = 0.0F;
	    }
	}
		
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.gobber2_armor_repair;
	}
}
