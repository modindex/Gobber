package com.kwpugh.gobber2.items.armor;

import com.kwpugh.gobber2.lists.ItemList;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCustomBoots extends ArmorItem
{
	public ItemCustomBoots(IArmorMaterial materialIn, EquipmentSlotType slots, Properties builder)
	{
		super(materialIn, slots, builder);
	}
	
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
	{	
		ItemStack boots = player.getItemStackFromSlot(EquipmentSlotType.FEET);

		if(boots.getItem() == ItemList.gobber2_boots)
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
}
