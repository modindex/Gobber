package com.kwpugh.gobber2.items.staffs;

import java.util.List;

import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemCustomStaffStars extends Item
{

	public ItemCustomStaffStars(Properties properties)
	{
		super(properties);
	}


    @Override
    public ActionResultType onItemUse(ItemUseContext iuc)
    {    	
    	BlockPos torchPos;
    	BlockPos pos = iuc.getPos();
		if(iuc.getWorld().getBlockState(pos).getBlock() == Blocks.TORCH
				|| iuc.getWorld().getBlockState(pos).getBlock() == Blocks.WALL_TORCH)
		{
			return ActionResultType.FAIL;
		}
    	
    	Boolean isWallTorch = false;
    	switch(iuc.getFace())
    	{
    	case DOWN:
    		return ActionResultType.FAIL;
    	case UP:
    		torchPos = new BlockPos(pos.getX(), pos.getY() +1, pos.getZ());
    		break;
    	case NORTH:
    		torchPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() -1);
    		isWallTorch = true;
    		break;
    	case SOUTH:
    		torchPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() +1);
    		isWallTorch = true;
    		break;
    	case WEST:
    		torchPos = new BlockPos(pos.getX() -1, pos.getY(), pos.getZ());
    		isWallTorch = true;
    		break;
    	case EAST:
    		torchPos = new BlockPos(pos.getX() +1, pos.getY(), pos.getZ());
    		isWallTorch = true;
    		break;
    	default:
    		return ActionResultType.FAIL;
    	}
    	
    	if(iuc.getWorld().getBlockState(torchPos).getBlock() == Blocks.AIR)
    	{
    		if (isWallTorch)
    		{
    			iuc.getWorld().setBlockState(torchPos, Blocks.WALL_TORCH.getDefaultState());
    		}
    		else
    		{
    			iuc.getWorld().setBlockState(torchPos, Blocks.TORCH.getDefaultState());
    		}
    		return ActionResultType.SUCCESS;
    	}
    	return ActionResultType.FAIL;
    }
    
    @Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent("Places regular torches"));
		list.add(new StringTextComponent("Right-click in player main hand"));
		list.add(new StringTextComponent("Torch supply: Unlimited"));
	} 
}
