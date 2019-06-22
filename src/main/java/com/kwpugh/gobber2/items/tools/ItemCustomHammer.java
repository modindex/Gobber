package com.kwpugh.gobber2.items.tools;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemCustomHammer extends PickaxeItem
{

	protected ItemCustomHammer(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
	

	/*
	private int mineRadius = 1, mineDepth = 0;

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving)
    {
        if(!world.isRemote)
	    {
	    	if (entityLiving instanceof PlayerEntity)
	        {
	    		PlayerEntity player = (PlayerEntity) entityLiving;
	            RayTraceResult result = hitResult(world, player, false);
	            Direction sideHit = result.sideHit;
	
	            int xDist, yDist, zDist;
	            yDist = xDist = zDist = mineRadius;
	
	            switch (sideHit)
	            {
	                case UP:
	                case DOWN: yDist = mineDepth; break;
	                case NORTH:
	                case SOUTH: zDist = mineDepth; break;
	                case EAST:
	                case WEST: xDist = mineDepth; break;
	            }
	
	                for (int x = pos.getX() - xDist; x <= pos.getX() + xDist; x++)
	                {
	                    for (int y = pos.getY() - yDist; y <= pos.getY() + yDist; y++)
	                    {
	                        for (int z = pos.getZ() - zDist; z <= pos.getZ() + zDist; z++)
	                        {
	                            BlockPos targetPos = new BlockPos(x, y, z);
	                            BlockState targetBlock = world.getBlockState(targetPos);
	                            if (canHarvestBlock(targetBlock))
	                            {
	                                if ((stack.getMaxDamage() - stack.getDamage()) >= 1 && targetBlock.getBlock() != Blocks.BEDROCK)
	                                {
	                                	
	                                    if (targetBlock.getBlock().getExpDrop(targetBlock, world, targetPos, 0) > 0)
	                                    {
	                                        if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops"))
	                                        {
	                                            world.spawnEntity(new EntityXPOrb(world, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, world.getBlockState(pos).getBlock().getExpDrop(targetBlock, world, targetPos, 0, z)));
	                                        }
	                                    }
	                                    
	                                    world.destroyBlock(new BlockPos(x, y, z), true);
	                                }
	                                stack.setDamage(1);
	                            }
	                        }
	                    }
	                }
	                stack.setDamage(1);
	            }
	    } 
        return false;
    }
    */

}
