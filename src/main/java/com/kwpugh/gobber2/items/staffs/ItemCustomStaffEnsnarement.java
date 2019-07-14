package com.kwpugh.gobber2.items.staffs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemCustomStaffEnsnarement extends Item
{


	public ItemCustomStaffEnsnarement(Properties properties)
	{
		super(properties);
	}
/*
	 public ActionResultType onItemUse(ItemUseContext context)
	 {
		 World world = context.getWorld();
		 BlockPos pos = context.getPos();
		 PlayerEntity player = context.getPlayer();
		 Hand hand = context.getHand();
		 Direction direction = context.getFace();
		 ItemStack stack= context.getPlayer().getHeldItemMainhand();
		 
		 if (player.getEntityWorld().isRemote)
	     {
			 return ActionResultType.FAIL;
	     }
		 
		 if (!containsEntity(stack))
	     {
			 return ActionResultType.FAIL;
	     }
		 
		 Entity entity = getEntityFromStack(stack, world, true);
		 BlockPos blockPos = pos.offset(direction);
		 entity.setPositionAndRotation(blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, 0, 0);
		 stack.setTag(new CompoundNBT());
		 player.setHeldItem(hand, stack);
		 world.addEntity(entity);
			
		 if (entity instanceof LivingEntity)
		 {
				
		 }

		 return ActionResultType.PASS;
	}
	


    @Override
    public boolean itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand)
    {
        if (target.getEntityWorld().isRemote)
    	{
    		return false;
    	}
        
        if (target instanceof PlayerEntity ||
        		!target.isNonBoss() ||
        		!target.isAlive())
        	return false;
        
        if (containsEntity(stack))
    	{
    		return false;
    	}
        
        String entityID = EntityType.getKey(target).toString();
        
        if (isBlacklisted(entityID))
        	{
        		return false;
        	}
        CompoundNBT nbt = new CompoundNBT();
        nbt.setString("entity", entityID);
        nbt.setInteger("id", EntityList.getID(target.getClass()));
        target.writeToNBT(nbt);
        stack.setTag(nbt);
        playerIn.swingArm(hand);
        playerIn.setHeldItem(hand, stack);
        target.remove();
        return true;
    }


    public boolean isBlacklisted(String entity)
    {
        return false;
    }

    public boolean containsEntity(ItemStack stack)
    {
        return !stack.isEmpty() && stack.hasTag() && stack.getTag().hasKey("entity");
    }
    
    
    
    
    
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flagIn)
    {
        super.addInformation(stack, world, list, flagIn);
        if (containsEntity(stack) && EntityList.getTranslationName(new ResourceLocation(getID(stack))) != null)
        {
            list.add(TextFormatting.RED + "Mob: " + new TextComponentTranslation(EntityList.getTranslationName(new ResourceLocation(getID(stack)))).getUnformattedComponentText());
            list.add(TextFormatting.RED + "Health: " + stack.getTagCompound().getDouble("Health"));
        }
        list.add(TextFormatting.GOLD + "Right-click to capture a mob");
    }

    public Entity getEntityFromStack(ItemStack stack, World world, boolean withInfo)
    {
        Entity entity = EntityList.createEntityByIDFromName(new ResourceLocation(stack.getTag().getString("entity")), world);
        
        if (withInfo)
    	{
    		entity.readFromNBT(stack.getTagCompound());
    	}
        return entity;
    }

    public String getID(ItemStack stack)
    {
        return stack.getTagCompound().getString("entity");
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        if (!containsEntity(stack))
            return new TextComponentTranslation(super.getUnlocalizedNameInefficiently(stack) + ".name").getUnformattedComponentText();
        return new TextComponentTranslation(super.getUnlocalizedNameInefficiently(stack) + ".name").getUnformattedComponentText() + " (" + EntityList.getTranslationName(new ResourceLocation(getID(stack))) + ")";
    }
*/  
}


