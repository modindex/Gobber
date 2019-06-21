package com.kwpugh.gobber2.world.feature;

import com.kwpugh.gobber2.lists.BlockList;

import static net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType.NATURAL_STONE;
import static net.minecraft.world.gen.placement.Placement.COUNT_RANGE;

import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGenerator
{
    public static void setupOregen()
    {
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            if(WorldgenConfig.GOBBER2_ORE_GENERATION.get())
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(NATURAL_STONE, BlockList.gobber2_ore.getDefaultState(), WorldgenConfig.GOBBER2_ORE_SIZE.get().intValue()), COUNT_RANGE, new CountRangeConfig(WorldgenConfig.GOBBER2_ORE_CHANCE.get(), WorldgenConfig.GOBBER2_ORE_MIN_HEIGHT.get(), WorldgenConfig.GOBBER2_ORE_MIN_HEIGHT.get(), WorldgenConfig.GOBBER2_ORE_MAX_HEIGHT.get())));
        }
    }
}