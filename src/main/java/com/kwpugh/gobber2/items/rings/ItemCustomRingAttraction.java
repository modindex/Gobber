package com.kwpugh.gobber2.items.rings;

import java.util.List;

import com.kwpugh.gobber2.util.EnableUtil;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemCustomRingAttraction extends Item
{

	public ItemCustomRingAttraction(Properties properties)
	{
		super(properties);
	}


	public void inventoryTick(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected)
	{		
		if(entity instanceof PlayerEntity && !world.isRemote && EnableUtil.isEnabled(stack))
		{
			PlayerEntity player = (PlayerEntity)entity;
			
			double x = player.posX;
			double y = player.posY + 1.5;
			double z = player.posZ;
				
			int range = 18;

			boolean isPulling;
			
			//Scan for and collect items
			List<ItemEntity> items = entity.world.getEntitiesWithinAABB(ItemEntity.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
				for(ItemEntity e: items)
				{
					if(!player.isSneaking())
					{
						isPulling = true;							
						double factor = 0.02;
						e.addVelocity((x - e.posX) * factor, (y - e.posY) * factor, (z - e.posZ) * factor);
					}
				}
				
				if(items.isEmpty())
				{
					isPulling = false;
				}
			
			//Scan for and collect XP Orbs
			List<ExperienceOrbEntity> xp = entity.world.getEntitiesWithinAABB(ExperienceOrbEntity.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
				for(ExperienceOrbEntity orb: xp)
				{
					if(!player.isSneaking())
					{
						isPulling = true;							
						double factor = 0.02;
						orb.addVelocity((x - orb.posX) * factor, (y - orb.posY) * factor, (z - orb.posZ) * factor);
                        player.onItemPickup(orb, 1);
                        player.giveExperiencePoints(orb.xpValue);
                        orb.remove();
					}
				}
				
				if(items.isEmpty())
				{
					isPulling = false;
				}
		}
	}
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
    {
		ItemStack stack = player.getHeldItem(hand);
		
        if(!world.isRemote && player.isSneaking())
        {
            EnableUtil.changeEnabled(player, hand);
            player.sendMessage(new StringTextComponent("Attraction ability active: " + EnableUtil.isEnabled(stack)));
            return new ActionResult<ItemStack>(ActionResultType.SUCCESS, player.getHeldItem(hand));
        }
        return super.onItemRightClick(world, player, hand);
    }
    
    @Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.BLUE + "Draws dropped items toward the player"));
		list.add(new StringTextComponent(TextFormatting.RED + "Attraction ability active: " + EnableUtil.isEnabled(stack)));
		list.add(new StringTextComponent(TextFormatting.GREEN + "Works while in player inventory"));
		list.add(new StringTextComponent(TextFormatting.GREEN + "Shift-click to toggle on/off"));
	}   

}
