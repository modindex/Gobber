package com.kwpugh.gobber2.blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockGobberGlass extends GlassBlock
{

	public BlockGobberGlass(Properties properties)
	{
		super(properties);
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader world, List<ITextComponent> tooltip, ITooltipFlag flag)
	{
		super.addInformation(stack, world, tooltip, flag);				
		tooltip.add(new StringTextComponent(TextFormatting.BLUE + "A very sturdy glass block"));
		tooltip.add(new StringTextComponent(TextFormatting.GREEN + "Drops the block when broken"));
	}
	
	public VoxelShape getCollisionShape(IBlockReader worldIn, BlockPos pos)
	{
	      return VoxelShapes.empty();
	   }
	

	
	
	
	public void preventNonPlayers(IBlockReader world, BlockPos pos, BlockState state, LivingEntity entity)
	{
		if(entity instanceof PlayerEntity)
		{
			state.getCollisionShape(world, pos);
			
		}
	}


}
