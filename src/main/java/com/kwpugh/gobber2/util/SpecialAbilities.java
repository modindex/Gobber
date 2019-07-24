package com.kwpugh.gobber2.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class SpecialAbilities
{	
	//Set player health to max on tick update
	public static void giveHealthEffect(World world, PlayerEntity player, ItemStack itemstack)
	{
    	player.setHealth(20);
		return;
	}
	
	//Increases the player's food level to max on tick update, based on inputs
	public static void giveRegenffect(World world, PlayerEntity player, ItemStack itemstack, int newfoodlevel, float newsatlevel)
	{
		player.getFoodStats().addStats(newfoodlevel, newsatlevel);
    	return;
	}
		
	//Set player saturation level to max on tick update
	public static void giveSaturationEffect(World world, PlayerEntity player, ItemStack itemstack)
	{
		player.getFoodStats().setFoodSaturationLevel(7.0F);
    	return;
	}
		
	//Set player yellow hearts to max on tick update
	public static void giveExtraHearts(World world, LivingEntity player, ItemStack itemstack)
	{
		player.setAbsorptionAmount(20);
    	return;
	}

	//Set player yellow hearts to none on tick update
	public static void giveNoExtraHearts(World world, PlayerEntity player, ItemStack itemstack)
	{
		player.setAbsorptionAmount(0);
    	return;
	}
	
	//	//Set player oxygen to max on tick update
	public static void giveBreathing(World world, PlayerEntity player, ItemStack itemstack)
	{
		player.setAir(300);
    	return;
	}
	
	//Gives player Conduit Effect
	public static void giveConduitEffect(World world, PlayerEntity player, ItemStack itemstack)
	{
		player.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 260, 0, false, false));
	}
}
