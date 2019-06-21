package com.kwpugh.gobber2.items.rings;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemCustomRingChest extends Item
{

	public ItemCustomRingChest(Properties properties)
	{
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
	{
		ActionResult<ItemStack> result = super.onItemRightClick(world, player, hand);
		ItemStack itemstack = result.getResult();
	
        ItemStack equippedMain = player.getHeldItemMainhand();
        
		 if(equippedMain == itemstack)  //Only works while in the main hand
		 {   			
			 player.getInventoryEnderChest();		 
		
		 }	
		 return result;
	}
	
    @Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent("Provides access to the player Enderchest"));
		list.add(new StringTextComponent("Right-click to use"));
	}   
}
