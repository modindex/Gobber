package com.kwpugh.gobber2.items.rings;

import java.util.List;

import com.kwpugh.gobber2.util.RayTraceUtil;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemCustomRingEnderman extends Item
{

	public ItemCustomRingEnderman(Properties properties)
	{
		super(properties);
	}

/*
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
    {
        ItemStack stack = player.getHeldItem(hand);
        
        ItemStack equippedMain = player.getHeldItemMainhand();
        
        if(equippedMain == stack)   //Only works in the main hand
        {
	        if(!world.isRemote)
	        {
	        	RayTraceResult pos = RayTraceUtil.getMovingObjectPosWithReachDistance(world, player, 100);
	            if(pos != null && (pos.getType() == RayTraceResult.Type.BLOCK || player.rotationPitch >= -5))
	            {
	                int side = pos.sideHit.ordinal();
	                if(side != -1)
	                {
	                    double x = pos.hitVec.x-(side == 4 ? 0.5 : 0)+(side == 5 ? 0.5 : 0);
	                    double y = pos.hitVec.y-(side == 0 ? 2.0 : 0)+(side == 1 ? 0.5 : 0);
	                    double z = pos.hitVec.z-(side == 2 ? 0.5 : 0)+(side == 3 ? 0.5 : 0);
	                    int baseUse = 200;
	                    int use = baseUse+(int)(baseUse*pos.hitVec.distanceTo(new Vec3d(player.posX, player.posY+(player.getEyeHeight()-player.getEyeHeight()), player.posZ)));
	
	                    ((ServerPlayerEntity)player).connection.setPlayerLocation(x, y, z, player.rotationYaw, player.rotationPitch);
	                    player.stopRiding();
	                    world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
	
	                    return ActionResult.newResult(ActionResultType.SUCCESS, stack);
	                }
	            }
	        }
        }
        player.swingArm(hand);
        return ActionResult.newResult(ActionResultType.FAIL, stack);
    }
*/
	
    @Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent("Teleports the player to the spot they are looking"));
		list.add(new StringTextComponent("Right-click to use"));
	}   
}
