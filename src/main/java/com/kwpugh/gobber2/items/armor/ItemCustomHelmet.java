package com.kwpugh.gobber2.items.armor;

import com.kwpugh.gobber2.lists.ItemList;
import com.kwpugh.gobber2.util.SpecialAbilities;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCustomHelmet extends ArmorItem
{
	public ItemCustomHelmet(IArmorMaterial materialIn, EquipmentSlotType slots, Properties builder)
	{
		super(materialIn, slots, builder);
	}

	public void onArmorTick(final ItemStack stack, final World world, final PlayerEntity player)
	{	
		ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		
		if(helmet.getItem() == ItemList.gobber2_helmet)
		{
			int newfoodlevel = 1;
			float newsatlevel = 0.0F;
			SpecialAbilities.giveRegenffect(world, player, stack, newfoodlevel, newsatlevel);			
		}
		else
		{
			
		}
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.gobber2_armor_repair;
	}
}
