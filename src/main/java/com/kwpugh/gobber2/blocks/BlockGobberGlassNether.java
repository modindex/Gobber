package com.kwpugh.gobber2.blocks;

import java.util.List;

import net.minecraft.block.GlassBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class BlockGobberGlassNether extends GlassBlock
{

	public BlockGobberGlassNether(Properties properties)
	{
		super(properties);
	}

	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.BLUE + "A very sturdy glass block"));
		list.add(new StringTextComponent(TextFormatting.GREEN + "Drops the block when broken"));
	}  
}
