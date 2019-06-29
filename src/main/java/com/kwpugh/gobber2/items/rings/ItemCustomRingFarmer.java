package com.kwpugh.gobber2.items.rings;


import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class ItemCustomRingFarmer extends Item
{

	public ItemCustomRingFarmer(Properties properties)
	{
		super(properties);
	}

	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
    {
        
    	if(!(entity instanceof PlayerEntity) || world.isRemote)
        {
            return;
        }

    	PlayerEntity player = (PlayerEntity)entity;
        ItemStack equipped = player.getHeldItemMainhand();
        
        if(stack == equipped)
        {
        	List<BlockPos> blocks = new ArrayList<BlockPos>();

            int range = 7;
            for(int x = -range; x < range+1; x++)
            {
                for(int z = -range; z < range+1; z++)
                {
                    for(int y = -range; y < range+1; y++)
                    {
                        int theX = MathHelper.floor(player.posX+x);
                        int theY = MathHelper.floor(player.posY+y);
                        int theZ = MathHelper.floor(player.posZ+z);
                        BlockPos posInQuestion = new BlockPos(theX, theY, theZ);
                        Block theBlock = world.getBlockState(posInQuestion).getBlock();
                        if((theBlock instanceof IGrowable || theBlock instanceof IPlantable))
                        {
                            blocks.add(posInQuestion);
                        }
                    }
                }
            }

            if(!blocks.isEmpty())
            {
                BlockPos pos = blocks.get(world.rand.nextInt(blocks.size()));
                BlockState state = world.getBlockState(pos);
                Block block = state.getBlock();
            }
       }
    }
}