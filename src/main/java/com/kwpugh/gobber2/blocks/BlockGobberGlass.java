package com.kwpugh.gobber2.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockGobberGlass extends GlassBlock
{

	public BlockGobberGlass(Properties properties)
	{
		super(properties);
	}

/*
    public static AxisAlignedBB GLOBGLASS_COLLISION_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.9375D, 0.9375D);
    
    
    public void addCollisionBoxToList(BlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState)
    {
	        if (!(entity instanceof PlayerEntity))
	        {
	       		super.addCollisionBoxToList(state, world, pos, entityBox, collidingBoxes, entity, isActualState);
	        }
	        
	        if(entity instanceof PlayerEntity && entity.isSneaking())
	        {
	        	super.addCollisionBoxToList(state, world, pos, entityBox, collidingBoxes, entity, isActualState);
			}
	        
	        if(entity instanceof SpiderEntity)
	        {
	        	((SpiderEntity) entity).setBesideClimbableBlock(false);
	        }
	        
	        if(entity instanceof IMob || entity instanceof WitherEntity)
	        {
	        	this.blockHardness(24F);
	        	this.blockResistance(2000F);
	        }
    }

    //Wither proof glass
	public boolean canEntityDestroy(BlockState state, BlockPos world, BlockPos pos, Entity entity)
	{
		return !(entity instanceof WitherEntity) && !(entity instanceof WitherSkullEntity);
	}

	
	public void onBlockExploded(World world, BlockPos pos, Explosion explosion)
	{
	
	}
	
	public int quantityDropped(Random random)
	{
	    return 1;
	}
	   
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player)
	{
		super.onBlockHarvested(worldIn, pos, state, player);
	}
	
    public AxisAlignedBB getCollisionBoundingBox(BlockState blockState, BlockPos worldIn, BlockPos pos)
    {
        return GLOBGLASS_COLLISION_AABB;
    }
	
    public void onEntityCollision(World worldIn, BlockPos pos, BlockState state, Entity entity)
    {
    	if(!(entity instanceof PlayerEntity) || !(entity instanceof WitherEntity))
        {
        	//Stub from previous          entity.attackEntityFrom(DamageSource.CACTUS, 7.0F);
        }
    }
*/
}
