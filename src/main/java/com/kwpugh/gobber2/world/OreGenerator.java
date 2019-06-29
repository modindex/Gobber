package com.kwpugh.gobber2.world;

import com.kwpugh.gobber2.lists.BlockList;

import static net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType.NATURAL_STONE;
import static net.minecraft.world.gen.placement.Placement.COUNT_RANGE;

import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
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
 
            if(WorldgenConfig.GOBBER2_LUCKY_BLOCK_GENERATION.get())
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(NATURAL_STONE, BlockList.gobber2_lucky_block.getDefaultState(), WorldgenConfig.GOBBER2_LUCKY_BLOCK_SIZE.get().intValue()), COUNT_RANGE, new CountRangeConfig(WorldgenConfig.GOBBER2_LUCKY_BLOCK_CHANCE.get(), WorldgenConfig.GOBBER2_LUCKY_BLOCK_MIN_HEIGHT.get(), WorldgenConfig.GOBBER2_LUCKY_BLOCK_MIN_HEIGHT.get(), WorldgenConfig.GOBBER2_LUCKY_BLOCK_MAX_HEIGHT.get())));
        }
    }
    
    public static void setupNetherOregen()
    {
        if(WorldgenConfig.GOBBER2_ORE_NETHER_GENERATION.get())
           Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockList.gobber2_ore_nether.getDefaultState(), WorldgenConfig.GOBBER2_ORE_NETHER_SIZE.get().intValue()), COUNT_RANGE, new CountRangeConfig(WorldgenConfig.GOBBER2_ORE_NETHER_CHANCE.get(), WorldgenConfig.GOBBER2_ORE_NETHER_MIN_HEIGHT.get(), WorldgenConfig.GOBBER2_ORE_NETHER_MIN_HEIGHT.get(), WorldgenConfig.GOBBER2_ORE_NETHER_MAX_HEIGHT.get())));   
    }
    
    public static void setupEndOregen()
    {
        if(WorldgenConfig.GOBBER2_ORE_END_GENERATION.get())
           Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.gobber2_ore_end.getDefaultState(), WorldgenConfig.GOBBER2_ORE_END_SIZE.get().intValue()), COUNT_RANGE, new CountRangeConfig(WorldgenConfig.GOBBER2_ORE_END_CHANCE.get(), WorldgenConfig.GOBBER2_ORE_END_MIN_HEIGHT.get(), WorldgenConfig.GOBBER2_ORE_END_MIN_HEIGHT.get(), WorldgenConfig.GOBBER2_ORE_END_MAX_HEIGHT.get())));   
    }
}