package com.kwpugh.gobber2.util;

import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
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
		player.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 260, 0, true, true));
	}
	
	//Set player step height to 3 blocks
	public static void giveHighStepping(PlayerEntity player, boolean highstep)
	{
		if(highstep)
		{
			player.stepHeight = 3.0F;
		}
		else
		{
			player.stepHeight = 0.0F;
		}   	
	}
	
	//Set player as invulnerable
	public static void giveInvulnerable(World world, PlayerEntity player, ItemStack itemstack)
	{
		player.setInvulnerable(true);
    	return;
	}	
	
	//Set player as vulnerable
	public static void giveVulnerable(World world, PlayerEntity player, ItemStack itemstack)
	{
		player.setInvulnerable(false);
    	return;
	}

	//Gives player protection until they start on fire
	public static void giveFireProtection(World world, PlayerEntity player, ItemStack itemstack)
	{
		if(player.isBurning() || player.isInLava())
		{
			player.hurtTime = 0;
			player.setInvulnerable(true);
		}
		else
		{
			player.setInvulnerable(false);
		}	
	}
	
	
	
	
	
}
