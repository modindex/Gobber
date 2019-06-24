package com.kwpugh.gobber2.items.armor;

import com.kwpugh.gobber2.lists.ItemList;

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
	 
	    if(!world.isRemote)
	    {
	    	if(head != null && head.getItem() == ItemList.gobber2_helmet_nether && 
	    			chest != null && chest.getItem() == ItemList.gobber2_chestplate_nether && 
	    			legs != null && legs.getItem() == ItemList.gobber2_leggings_nether && 
	    			feet != null && feet.getItem() == ItemList.gobber2_boots_nether)
	    	{
	    		
	    	}	
	    }
	}
}
