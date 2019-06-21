package com.kwpugh.gobber2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kwpugh.gobber2.items.armor.ItemCustomBoots;
import com.kwpugh.gobber2.items.armor.ItemCustomChestplate;
import com.kwpugh.gobber2.items.armor.ItemCustomHelmet;
import com.kwpugh.gobber2.items.armor.ItemCustomLeggings;
import com.kwpugh.gobber2.items.food.ItemCustomFoodBeefstew;
import com.kwpugh.gobber2.items.fuels.ItemCustomFuel;
import com.kwpugh.gobber2.items.rings.ItemCustomRing;
import com.kwpugh.gobber2.items.rings.ItemCustomRingAcceleration;
import com.kwpugh.gobber2.items.rings.ItemCustomRingAttraction;
import com.kwpugh.gobber2.items.rings.ItemCustomRingCuring;
import com.kwpugh.gobber2.items.rings.ItemCustomRingLeaping;
import com.kwpugh.gobber2.items.rings.ItemCustomRingLumberjack;
import com.kwpugh.gobber2.items.rings.ItemCustomRingMiner;
import com.kwpugh.gobber2.items.rings.ItemCustomRingTraveler;
import com.kwpugh.gobber2.items.staffs.ItemCustomStaffClearing;
import com.kwpugh.gobber2.items.staffs.ItemCustomStaffSniper;
import com.kwpugh.gobber2.items.staffs.ItemCustomStaffStars;
import com.kwpugh.gobber2.items.tools.ItemCustomAxe;
import com.kwpugh.gobber2.items.tools.ItemCustomPickaxe;
import com.kwpugh.gobber2.items.tools.ItemCustomShovel;
import com.kwpugh.gobber2.items.tools.ItemCustomSword;
import com.kwpugh.gobber2.lists.ArmourMaterialList;
import com.kwpugh.gobber2.lists.BlockList;
import com.kwpugh.gobber2.lists.FoodList;
import com.kwpugh.gobber2.lists.ItemList;
import com.kwpugh.gobber2.lists.ToolMaterialList;
import com.kwpugh.gobber2.util.Gobber2_Group;
import com.kwpugh.gobber2.util.GobberConfig;
import com.kwpugh.gobber2.world.feature.OreGenerator;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("gobber2")
public class Gobber2 
{
	public static Gobber2 instance;
	public static final String modid = "gobber2";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup gobber2 = new Gobber2_Group();
	
	public Gobber2() 
	{
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, GobberConfig.SERVER_CONFIG);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::modSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
		
		GobberConfig.loadConfig(GobberConfig.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("gobber-server.toml"));
		 
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void modSetup(final FMLCommonSetupEvent event)
	{
		OreGenerator.setupOregen();
		
		logger.info("Gobber mod setup completed");
	}
	
	private void clientSetup(final FMLClientSetupEvent event)
	{
		logger.info("Gobber client setup completed");
	}
	
	private void serverSetup(final FMLDedicatedServerSetupEvent event)
	{
		logger.info("Gobber server setup completed");
	}
	
	public static Food gooFood = (new Food.Builder()).hunger(4).saturation(0.6F).build();
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
				ItemList.gobber2_ore = new BlockItem(BlockList.gobber2_ore, new Item.Properties().group(gobber2)).setRegistryName(BlockList.gobber2_ore.getRegistryName()),
				ItemList.gobber2_ore_nether = new BlockItem(BlockList.gobber2_ore_nether, new Item.Properties().group(gobber2)).setRegistryName(BlockList.gobber2_ore_nether.getRegistryName()),
				ItemList.gobber2_ore_end = new BlockItem(BlockList.gobber2_ore_end, new Item.Properties().group(gobber2)).setRegistryName(BlockList.gobber2_ore_end.getRegistryName()),
				
				ItemList.gobber2_globette = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_globette")),
				ItemList.gobber2_glob = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_glob")),
						
				ItemList.gobber2_ingot = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_ingot")),
				ItemList.gobber2_block = new BlockItem(BlockList.gobber2_block, new Item.Properties().group(gobber2)).setRegistryName(BlockList.gobber2_block.getRegistryName()),
						
				ItemList.gobber2_rod = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_rod")),
				
				ItemList.gobber2_foo = new ItemCustomFuel(new Item.Properties().group(gobber2), "gobber2_foo", 64000),
				
				ItemList.gobber2_helmet = new ItemCustomHelmet(ArmourMaterialList.gobber2, EquipmentSlotType.HEAD, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_helmet")),
				ItemList.gobber2_chestplate = new ItemCustomChestplate(ArmourMaterialList.gobber2, EquipmentSlotType.CHEST, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_chestplate")),
				ItemList.gobber2_leggings = new ItemCustomLeggings(ArmourMaterialList.gobber2, EquipmentSlotType.LEGS, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_leggings")),
				ItemList.gobber2_boots = new ItemCustomBoots(ArmourMaterialList.gobber2, EquipmentSlotType.FEET, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_boots")),
				
				ItemList.gobber2_sword = new ItemCustomSword(ToolMaterialList.gobber2, 4, 6.0f, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_sword")),
				ItemList.gobber2_pickaxe = new ItemCustomPickaxe(ToolMaterialList.gobber2, -14, 6.0f, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_pickaxe")),
				ItemList.gobber2_shovel = new ItemCustomShovel(ToolMaterialList.gobber2, -14.0f, 6.0f, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_shovel")),
				ItemList.gobber2_axe = new ItemCustomAxe(ToolMaterialList.gobber2, -14.0f, 6.0f, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_axe")),
				ItemList.gobber2_hoe = new HoeItem(ToolMaterialList.gobber2, 6.0f, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_hoe")),
						
				ItemList.gobber2_ring = new ItemCustomRing(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_ring")),
				ItemList.gobber2_ring_miner = new ItemCustomRingMiner(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_miner")),
				ItemList.gobber2_ring_lumberjack = new ItemCustomRingLumberjack(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_lumberjack")),
				ItemList.gobber2_ring_acceleration = new ItemCustomRingAcceleration(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_acceleration")),
				ItemList.gobber2_ring_attraction = new ItemCustomRingAttraction(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_attraction")),
				ItemList.gobber2_ring_curing = new ItemCustomRingCuring(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_curing")),
				ItemList.gobber2_ring_traveler = new ItemCustomRingTraveler(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_traveler")),
				ItemList.gobber2_ring_leaping = new ItemCustomRingLeaping(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_leaping")),
				
				ItemList.gobber2_staff_sniper = new ItemCustomStaffSniper(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_staff_sniper")),
				ItemList.gobber2_staff_clearing = new ItemCustomStaffClearing(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_staff_clearing")),
				ItemList.gobber2_staff_stars = new ItemCustomStaffStars(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_staff_stars"))
			);
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerFoods(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
				ItemList.gobber2_goo = new Item(new Item.Properties().food(FoodList.gooFood).group(gobber2)).setRegistryName(location("gobber2_goo")),
				ItemList.gobber2_gooey_apple = new Item(new Item.Properties().food(FoodList.gooeyApple).group(gobber2)).setRegistryName(location("gobber2_gooey_apple")),
				ItemList.gobber2_gooey_bread = new Item(new Item.Properties().food(FoodList.gooeyBread).group(gobber2)).setRegistryName(location("gobber2_gooey_bread")),
				ItemList.gobber2_gooey_beef = new Item(new Item.Properties().food(FoodList.gooeyBeef).group(gobber2)).setRegistryName(location("gobber2_gooey_beef")),
				ItemList.gobber2_gooey_beefstew = new ItemCustomFoodBeefstew(new Item.Properties().maxStackSize(1).food(FoodList.gooeyBeef).group(gobber2)).setRegistryName(location("gobber2_gooey_beefstew"))
			);
			logger.info("Foods registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockList.gobber2_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(15).sound(SoundType.METAL)).setRegistryName(location("gobber2_ore")),
				BlockList.gobber2_ore_nether = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(15).sound(SoundType.METAL)).setRegistryName(location("gobber2_ore_nether")),
				BlockList.gobber2_ore_end = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(15).sound(SoundType.METAL)).setRegistryName(location("gobber2_ore_end")),
				BlockList.gobber2_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(15).sound(SoundType.METAL)).setRegistryName(location("gobber2_block"))
			);
			logger.info("Blocks registered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}	
	}
}



