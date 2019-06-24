package com.kwpugh.gobber2.items.armor;

import com.kwpugh.gobber2.lists.ItemList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCustomLeggingsNether extends ArmorItem
{
	public ItemCustomLeggingsNether(IArmorMaterial materialIn, EquipmentSlotType slots, Properties builder)
	{
		super(materialIn, slots, builder);
	}

	public void onArmorTick(final ItemStack stack, final World world, final PlayerEntity player)
	{
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
		
		if(legs.getItem() == ItemList.gobber2_leggings_nether)
		{
			player.fallDistance = 0.0F;
		}
		else
		{
			player.fallDistance = 1.0F;
		}			
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.gobber2_armor_repair;
	}
}