package com.kwpugh.gobber2.items.tools;

import java.util.List;

import com.kwpugh.gobber2.lists.ItemList;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemCustomSwordTraveler extends SwordItem
{
	public ItemCustomSwordTraveler(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) 
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand)
	{
		ActionResult<ItemStack> result = super.onItemRightClick(world, entity, hand);
		ItemStack itemstack = result.getResult();
	
        ItemStack equippedMain = entity.getHeldItemMainhand();
 
    	Vec3d look = entity.getLookVec().normalize();
		double lookX = look.x;
		double lookY = look.y;
		double lookZ = look.z;
		
		//Get some vertical height to start
		if(entity.onGround && !entity.isSneaking())	
		{
			entity.setMotion(lookX * 0.0, lookY * 7.0, lookZ * 0.0);
		}
        
		//Once aloft, provide some horizontal movement
		if(!entity.onGround)
		{	
			entity.addVelocity(lookX * 0.7, lookY * 0.7, lookZ * 0.7);
		}
		return result;		 
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment)
    {
        return true;
    }
    
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.gobber2_ingot_nether;
	}
	
    @Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent("Right-click to jump"));
	} 
}