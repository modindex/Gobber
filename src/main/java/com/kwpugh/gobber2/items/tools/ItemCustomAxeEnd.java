package com.kwpugh.gobber2.items.tools;

import com.kwpugh.gobber2.lists.ItemList;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemCustomAxeEnd extends AxeItem
{
	public ItemCustomAxeEnd(IItemTier tier, float attackDamage, float attackSpeedIn, Properties builder) 
	{
		super(tier, attackDamage, attackSpeedIn, builder);
	}
	
	@Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
		stack.setDamage(0);  //no damage
        
        return true;
    }

    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving)
    {
        if (!worldIn.isRemote && (double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.setDamage(0);
        }
        return true;
    }
    
	@Override
	public int getBurnTime(ItemStack itemStack)
	{
		return 400;
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}
    
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.gobber2_ingot_end;
	}
}
