package com.kwpugh.gobber2.items.tools;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ToolItem;

public class ItemCustomPaxel extends ToolItem
{

	protected ItemCustomPaxel(float attackDamageIn, float attackSpeedIn, IItemTier tier, Set<Block> effectiveBlocksIn,
			Properties builder)
	{
		super(attackDamageIn, attackSpeedIn, tier, effectiveBlocksIn, builder);
	}
	
	

}
