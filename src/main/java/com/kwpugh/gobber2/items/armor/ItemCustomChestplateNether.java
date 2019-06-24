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

public class ItemCustomChestplateNether extends ArmorItem
{
	
	public ItemCustomChestplateNether(IArmorMaterial materialIn, EquipmentSlotType slots, Properties builder)
	{
		super(materialIn, slots, builder);
	}

	public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
	{
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);

			 if(chest.getItem() == ItemList.gobber2_chestplate_nether)
			 {
			 		if(player.isInWater())
			 		{
			 			SpecialAbilities.giveConduitEffect(world, player, chest);
			 		}
			 		
			 		SpecialAbilities.giveFireProtection(world, player, chest);
			 		player.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(40.0D); 
			 }			 	 	 
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.gobber2_armor_repair;
	}
}
