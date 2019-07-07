package com.kwpugh.gobber2.lists;

import com.kwpugh.gobber2.Gobber2;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmourMaterialList implements IArmorMaterial
{
	//Armor order: helmet, leggings, chestplate, boots
	gobber2("gobber2", 2000, new int[] {6, 8, 10, 6}, 30, ItemList.gobber2_ingot, "entity.ender_dragon.growl", 2.0f),
	gobber2_nether("gobber2_nether", 4000, new int[] {8, 10, 12, 8}, 30, ItemList.gobber2_ingot_nether, "entity.ender_dragon.growl", 2.0f),
	gobber2_end("gobber2_end", 8000, new int[] {10, 12, 14, 10}, 30, ItemList.gobber2_ingot_end, "entity.ender_dragon.growl", 2.0f);
	
	private static final int[] max_damage_array = new int[]{16, 20, 24, 16};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	private ArmourMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness) 
	{
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) 
	{
		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) 
	{
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public String getName() 
	{
		return Gobber2.modid + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}
}
