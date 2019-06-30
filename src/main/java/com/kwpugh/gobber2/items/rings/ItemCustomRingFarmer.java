package com.kwpugh.gobber2.items.rings;

import java.util.List;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CactusBlock;
import net.minecraft.block.CocoaBlock;
import net.minecraft.block.CoralBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemCustomRingFarmer extends Item
{

	public ItemCustomRingFarmer(Properties properties)
	{
		super(properties);
	}

	public void inventoryTick(ItemStack stack, World world, Entity entity, int par4, boolean par5)
    {
        
    	if(!(entity instanceof PlayerEntity) || world.isRemote)
        {
            return;
        }

    	PlayerEntity player = (PlayerEntity)entity;
        ItemStack equipped = player.getHeldItemMainhand();
        
        if(stack == equipped)
        {
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
                        
                        BlockPos tagetPos = new BlockPos(theX, theY, theZ);
                        
                        BlockState blockstate = world.getBlockState(tagetPos);

                        //Determine if the blocks that implement IGrowable
                        if (blockstate.getBlock() instanceof IGrowable)
                        {
                        	IGrowable igrowable = (IGrowable)blockstate.getBlock();
                            
                        	//Exclude these ones
                            if((igrowable == Blocks.GRASS_BLOCK) ||
                            		(igrowable == Blocks.TALL_GRASS) ||
                            		(igrowable == Blocks.GRASS) ||
                            		(igrowable == Blocks.SUNFLOWER) || 
                            		(igrowable == Blocks.LILAC) || 
                            		(igrowable == Blocks.ROSE_BUSH) || 
                            		(igrowable == Blocks.PEONY) || 
                            		(igrowable == Blocks.SEAGRASS) ||
                            		(igrowable == Blocks.TALL_SEAGRASS))
                            {
                            	continue;
                            }
                            if (igrowable.canGrow(world, tagetPos, blockstate, world.isRemote))
                            {
                                {
                                	if (!world.isRemote)
                                    {
                                		igrowable.grow(world, world.rand, tagetPos, blockstate);
                                    }
                                }
                            } 
                        }
                        	
                        //Determine if the blocks that use the tick() method
                        if ((blockstate.getBlock() instanceof BambooBlock) || 
                        		(blockstate.getBlock() instanceof NetherWartBlock) ||
                        		(blockstate.getBlock() instanceof CoralBlock) ||
                        		(blockstate.getBlock() instanceof CocoaBlock) || 
                        		(blockstate.getBlock() instanceof SugarCaneBlock) ||
                        		(blockstate.getBlock() instanceof CactusBlock))
                        {
                        	if (!world.isRemote)
                    		{
                    			blockstate.tick(world, tagetPos, world.rand);                                                                
                    		}
                        }

                    }
                }
            }
       }
    }
	
    @Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent("Works on most crops, plants, and trees"));
		list.add(new StringTextComponent("Range: 14 blocks"));
		list.add(new StringTextComponent("Still a bit of a WIP"));
	}  
}