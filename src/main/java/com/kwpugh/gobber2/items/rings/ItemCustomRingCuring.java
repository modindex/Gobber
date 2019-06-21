package com.kwpugh.gobber2.items.rings;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemCustomRingCuring extends Item
{

	public ItemCustomRingCuring(Properties properties)
	{
		super(properties);
	}

	public void inventoryTick(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected)
	{		
		if(entity instanceof PlayerEntity)
		{	
				((LivingEntity) entity).removePotionEffect(Effect.get(2));  //Slowness
				((LivingEntity) entity).removePotionEffect(Effect.get(4));  //Mining Fatigue
				((LivingEntity) entity).removePotionEffect(Effect.get(7));  //Instant Damage
				((LivingEntity) entity).removePotionEffect(Effect.get(9));  //Nausea
				((LivingEntity) entity).removePotionEffect(Effect.get(15)); //Blindness
				((LivingEntity) entity).removePotionEffect(Effect.get(17)); //Hunger
				((LivingEntity) entity).removePotionEffect(Effect.get(19)); //Poison
				((LivingEntity) entity).removePotionEffect(Effect.get(20)); //Wither
		}
	}
	
    @Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent("Provides curing of most negative potion effects"));
		list.add(new StringTextComponent("Works while in player inventory"));
	}  
}
