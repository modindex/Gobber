package com.kwpugh.gobber2.items.rings;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ItemCustomRingAirwalking extends Item
{


	public ItemCustomRingAirwalking(Properties properties)
	{
		super(properties);
	}

	public void inventoryTick(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected)
	{
		LivingEntity player = (PlayerEntity)entity;
		ItemStack equipped = player.getHeldItemMainhand();

		
		if (!world.isRemote)
		{	
			if(stack == equipped)
			{
				player.setNoGravity(true);
				//((EntityPlayer) player).addExperienceLevel(-1);
			}
			else
			{
				player.setNoGravity(false);
			}
		}
	}
	
//	int currentDim;
//	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
//	{
//		ItemStack stack = player.getHeldItem(hand);
//
//        ItemStack equippedMain = player.getHeldItemMainhand();
//    	
//        if(equippedMain == stack)   //Only works in the main hand
//        {
//			if (!world.isRemote)
//			{
//				 if(!world.isRemote || !(currentDim == 1))
//				    {
//				    	player.changeDimension(DimensionType.THE_END);  //Switch to The End
//				    	currentDim = 1;	
//				    }
//			}
//        }
//        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
//	}
	
	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.BLUE + "Provides the ability to walk on air"));
		list.add(new StringTextComponent(TextFormatting.GREEN + "Works while in player mainhand"));
	}
}
