package com.kwpugh.gobber2.seeds;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.BlockNamedItem;

public class ItemCustomSeed extends BlockNamedItem
{

	public ItemCustomSeed(String name, Block crop, Properties builder)
	{
        super(crop, builder);

        this.setRegistryName("gobber2:gobber2_seed");       
    }
	
    public List<ModelResourceLocation> getVariants() {
        return Lists.newArrayList(new ModelResourceLocation("gobber2:gobber2_seed", "inventory"));
    }
}
