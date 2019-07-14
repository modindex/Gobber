package com.kwpugh.gobber2.items.rings;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SilverfishBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemCustomRingMiner extends Item
{

	public ItemCustomRingMiner(Properties properties)
	{
		super(properties);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
	{
		ItemStack stack = player.getHeldItem(hand);

        ItemStack equippedMain = player.getHeldItemMainhand();
    	
        if(equippedMain == stack)   //Only works in the main hand
        {
        	 if(!world.isRemote)
			{
				Block block;
				List<BlockPos> poslist = new ArrayList<BlockPos>();

				for (int x = -5; x <= 5; x++)
				{
					for (int y = 0; y <= 4; y++)
					{
						for (int z = -5; z <= 5; z++)
						{
							BlockPos pos = player.getPosition().add(x, y, z);
							block = world.getBlockState(pos).getBlock();
							
							BlockState state = world.getBlockState(pos);
		        
						    boolean witherImmune = BlockTags.WITHER_IMMUNE.contains(state.getBlock());
							
							if ((block instanceof OreBlock)  ||
								(witherImmune)   ||
								(block instanceof SilverfishBlock) ||
								(block instanceof TorchBlock)   ||
								(block instanceof ContainerBlock))
							{
								continue;
							}
							else
							{
								poslist.add(player.getPosition().add(x, y, z));
							}
						}
					}	
				}

				if(!player.isSneaking())
				{
					if (!poslist.isEmpty())
					{
						for (int i = 0; i <= poslist.size() - 1; i++)
						{
							BlockPos targetpos = poslist.get(i);
							block = world.getBlockState(targetpos).getBlock();
							
							world.destroyBlock(targetpos, true);
						}				
					}
				}
				
				
				if(player.isSneaking())
				{
					if (!poslist.isEmpty())
					{
						for (int i = 0; i <= poslist.size() - 1; i++)
						{
							BlockPos targetpos = poslist.get(i);
							block = world.getBlockState(targetpos).getBlock();
							
							world.removeBlock(targetpos, true);
						}				
					}
				}
				
			}
        }
        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
	}
	
    @Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.BLUE + "Breaks common vanilla blocks around the player"));
		list.add(new StringTextComponent(TextFormatting.GREEN + "Area of effect: 11x5x11"));
		list.add(new StringTextComponent(TextFormatting.GREEN + "Right-click to break blocks"));
		list.add(new StringTextComponent(TextFormatting.LIGHT_PURPLE + "Sneak right-click to remove blocks"));
	} 
}
