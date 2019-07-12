package com.kwpugh.gobber2.items.armor;

import java.util.List;

import com.kwpugh.gobber2.lists.ItemList;
import com.kwpugh.gobber2.util.SpecialAbilities;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemCustomArmorEnd extends ArmorItem
{
	public ItemCustomArmorEnd(IArmorMaterial materialIn, EquipmentSlotType slots, Properties builder)
	{
		super(materialIn, slots, builder);
	}
	
	@Override
	public void onArmorTick(final ItemStack stack, final World world, final PlayerEntity player)
	{
		ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
	    ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);	
	 
	    setDamage(head, 0);
	    setDamage(chest, 0);
	    setDamage(legs, 0);
	    setDamage(feet, 0);
	    
	    //Full Set
    	if(head.getItem() == ItemList.gobber2_helmet_end && 
    			chest.getItem() == ItemList.gobber2_chestplate_end && 
    			legs.getItem() == ItemList.gobber2_leggings_end && 
    			feet.getItem() == ItemList.gobber2_boots_end)
    	{
			((LivingEntity) player).removePotionEffect(Effect.get(2));  //Slowness
			((LivingEntity) player).removePotionEffect(Effect.get(4));  //Mining Fatigue
			((LivingEntity) player).removePotionEffect(Effect.get(7));  //Instant Damage
			((LivingEntity) player).removePotionEffect(Effect.get(9));  //Nausea
			((LivingEntity) player).removePotionEffect(Effect.get(15)); //Blindness
			((LivingEntity) player).removePotionEffect(Effect.get(17)); //Hunger
			((LivingEntity) player).removePotionEffect(Effect.get(19)); //Poison
			((LivingEntity) player).removePotionEffect(Effect.get(20)); //Wither
			
			int currentDim = player.dimension.getId();
		
			if(currentDim == 1) 
	    	{
	       		player.abilities.allowFlying = true;
	    	}
	       	else
	       	{
	       		player.abilities.allowFlying = false;
	       		player.abilities.isFlying = false;
	       	}
    	}	

	    //Helmet
	    if(head.getItem() == ItemList.gobber2_helmet_end)
		{
			SpecialAbilities.giveExtraHearts(world, player, stack);
			int newfoodlevel = 1;
			float newsatlevel = 0.10F;
			SpecialAbilities.giveRegenffect(world, player, stack, newfoodlevel, newsatlevel);			
		}
		else
		{
			SpecialAbilities.giveNoExtraHearts(world, player, stack);
		}
	    
	    //Chestplate
	    if(chest.getItem() == ItemList.gobber2_chestplate_end)
		{
	 		if(player.isInWater())
	 		{
	 			SpecialAbilities.giveConduitEffect(world, player, chest);
	 		}
	 		
			if(player.isBurning() || player.isInLava())
			{
				SpecialAbilities.giveHealthEffect(world, player, stack);
				player.extinguish();			
			}
	 		player.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(40.0D); 
		 }		
	    
	    //Leggings
	    if(legs.getItem() == ItemList.gobber2_leggings_end)
		{
			player.fallDistance = 0.0F;
		}
		else
		{
			player.fallDistance = 1.0F;
		}		
	    
	    //Boots
	    if(feet.getItem() == ItemList.gobber2_boots_end)
		{
			player.stepHeight = 3.0F;
	    }
		else
	    {
			player.stepHeight = 1.0F;
	    }		
	}
		
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.gobber2_armor_repair;
	}
    
    @Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.AQUA + "Repair with Armor Plate"));
		list.add(new StringTextComponent(TextFormatting.LIGHT_PURPLE + "Helmet: Rapid auto-feeding with saturation and aborption hearts"));
		list.add(new StringTextComponent(TextFormatting.LIGHT_PURPLE + "Chestplate: Conduit Power in water, fire protection, and knockback resistance"));
		list.add(new StringTextComponent(TextFormatting.LIGHT_PURPLE + "Leggings: No fall damage"));
		list.add(new StringTextComponent(TextFormatting.LIGHT_PURPLE + "Boots: Three block step assist"));
		list.add(new StringTextComponent(TextFormatting.GOLD + "Full suit bonus: Negative effect protection and flight only in the End"));
	}
}