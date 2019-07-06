package com.kwpugh.gobber2.seeds;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.BlockNamedItem;

public class ItemCustomSeedNether extends BlockNamedItem
{
	public ItemCustomSeedNether(String name, Block crop, Properties builder)
	{
        super(crop, builder);

        this.setRegistryName("gobber2:gobber2_seed_nether");       
    }
	
    public List<ModelResourceLocation> getVariants() {
        return Lists.newArrayList(new ModelResourceLocation("gobber2:gobber2_seed_nether", "inventory"));
    }
}
