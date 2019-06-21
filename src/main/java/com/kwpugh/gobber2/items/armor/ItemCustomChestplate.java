package com.kwpugh.gobber2.items.armor;

import com.kwpugh.gobber2.lists.ItemList;
import com.kwpugh.gobber2.util.SpecialAbilities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCustomChestplate extends ArmorItem
{
	
	public ItemCustomChestplate(IArmorMaterial materialIn, EquipmentSlotType slots, Properties builder)
	{
		super(materialIn, slots, builder);
	}

	public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
	{
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);

			 if(chest.getItem() == ItemList.gobber2_chestplate)
			 {
			 		if(player.isInWater())
			 		{
			 			SpecialAbilities.giveConduitEffect(world, player, chest);
			 		}
			 		
			 		SpecialAbilities.giveFireProtection(world, player, chest);
			 		player.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(40.0D); 
			 }			 	 
		 
	}
}
