package com.kwpugh.gobber2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kwpugh.gobber2.items.armor.ItemCustomArmor;
import com.kwpugh.gobber2.items.armor.ItemCustomArmorNether;
import com.kwpugh.gobber2.items.food.ItemCustomFoodBeefstew;
import com.kwpugh.gobber2.items.food.ItemCustomFoodBeefstewNether;
import com.kwpugh.gobber2.items.fuels.ItemCustomFuel;
import com.kwpugh.gobber2.items.rings.ItemCustomRing;
import com.kwpugh.gobber2.items.rings.ItemCustomRingAcceleration;
import com.kwpugh.gobber2.items.rings.ItemCustomRingAttraction;
import com.kwpugh.gobber2.items.rings.ItemCustomRingCuring;
import com.kwpugh.gobber2.items.rings.ItemCustomRingDismissal;
import com.kwpugh.gobber2.items.rings.ItemCustomRingEnderchest;
import com.kwpugh.gobber2.items.rings.ItemCustomRingLeaping;
import com.kwpugh.gobber2.items.rings.ItemCustomRingLumberjack;
import com.kwpugh.gobber2.items.rings.ItemCustomRingMiner;
import com.kwpugh.gobber2.items.rings.ItemCustomRingPhoenix;
import com.kwpugh.gobber2.items.rings.ItemCustomRingSwiftness;
import com.kwpugh.gobber2.items.rings.ItemCustomRingTraveler;
import com.kwpugh.gobber2.items.rings.ItemCustomRingVision;
import com.kwpugh.gobber2.items.staffs.ItemCustomStaffClearing;
import com.kwpugh.gobber2.items.staffs.ItemCustomStaffSniper;
import com.kwpugh.gobber2.items.staffs.ItemCustomStaffStars;
import com.kwpugh.gobber2.items.tools.ItemCustomAxe;
import com.kwpugh.gobber2.items.tools.ItemCustomAxeNether;
import com.kwpugh.gobber2.items.tools.ItemCustomHammer;
import com.kwpugh.gobber2.items.tools.ItemCustomHammerNether;
import com.kwpugh.gobber2.items.tools.ItemCustomHoe;
import com.kwpugh.gobber2.items.tools.ItemCustomHoeNether;
import com.kwpugh.gobber2.items.tools.ItemCustomPaxel;
import com.kwpugh.gobber2.items.tools.ItemCustomPaxelNether;
import com.kwpugh.gobber2.items.tools.ItemCustomPaxelStars;
import com.kwpugh.gobber2.items.tools.ItemCustomPickaxe;
import com.kwpugh.gobber2.items.tools.ItemCustomPickaxeNether;
import com.kwpugh.gobber2.items.tools.ItemCustomShovel;
import com.kwpugh.gobber2.items.tools.ItemCustomShovelNether;
import com.kwpugh.gobber2.items.tools.ItemCustomSword;
import com.kwpugh.gobber2.items.tools.ItemCustomSwordNether;
import com.kwpugh.gobber2.items.tools.ItemCustomSwordSniper;
import com.kwpugh.gobber2.items.tools.ItemCustomSwordTraveler;
import com.kwpugh.gobber2.lists.ArmourMaterialList;
import com.kwpugh.gobber2.lists.ArmourMaterialNetherList;
import com.kwpugh.gobber2.lists.BlockList;
import com.kwpugh.gobber2.lists.FoodList;
import com.kwpugh.gobber2.lists.ItemList;
import com.kwpugh.gobber2.lists.ToolMaterialList;
import com.kwpugh.gobber2.util.Gobber2_Group;
import com.kwpugh.gobber2.util.GobberConfig;
import com.kwpugh.gobber2.world.OreGenerator;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
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
		
		GobberConfig.loadConfig(GobberConfig.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("gobber-oregen.toml"));
		 
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void modSetup(final FMLCommonSetupEvent event)
	{
		OreGenerator.setupOregen();
		OreGenerator.setupNetherOregen();
		
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
				//Novelty Blocks
				ItemList.gobber2_lucky_block = new BlockItem(BlockList.gobber2_lucky_block, new Item.Properties().group(gobber2)).setRegistryName(BlockList.gobber2_lucky_block.getRegistryName()),
				
				
				
				//Ores & Materials
				ItemList.gobber2_ore = new BlockItem(BlockList.gobber2_ore, new Item.Properties().group(gobber2)).setRegistryName(BlockList.gobber2_ore.getRegistryName()),
				ItemList.gobber2_ore_nether = new BlockItem(BlockList.gobber2_ore_nether, new Item.Properties().group(gobber2)).setRegistryName(BlockList.gobber2_ore_nether.getRegistryName()),
				ItemList.gobber2_ore_end = new BlockItem(BlockList.gobber2_ore_end, new Item.Properties().group(gobber2)).setRegistryName(BlockList.gobber2_ore_end.getRegistryName()),
				
				ItemList.gobber2_globette = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_globette")),
				ItemList.gobber2_globette_nether = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_globette_nether")),
						
				ItemList.gobber2_glob = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_glob")),
				ItemList.gobber2_glob_nether = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_glob_nether")),
				
				ItemList.gobber2_ingot = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_ingot")),
				ItemList.gobber2_ingot_nether = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_ingot_nether")),

				ItemList.gobber2_block = new BlockItem(BlockList.gobber2_block, new Item.Properties().group(gobber2)).setRegistryName(BlockList.gobber2_block.getRegistryName()),
				ItemList.gobber2_block_nether = new BlockItem(BlockList.gobber2_block_nether, new Item.Properties().group(gobber2)).setRegistryName(BlockList.gobber2_block_nether.getRegistryName()),
				
				ItemList.gobber2_rod = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_rod")),		
				ItemList.gobber2_rod_nether = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_rod_nether")),
				
				ItemList.gobber2_medallion = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_medallion")),
				ItemList.gobber2_medallion_nether = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_medallion_nether")),
						
				ItemList.gobber2_foo = new ItemCustomFuel(new Item.Properties().group(gobber2), "gobber2_foo", 64000),
				ItemList.gobber2_foo_nether = new ItemCustomFuel(new Item.Properties().group(gobber2), "gobber2_foo_nether", 96000),
				
				
				
				//Foods
				ItemList.gobber2_goo = new Item(new Item.Properties().food(FoodList.gooFood).group(gobber2)).setRegistryName(location("gobber2_goo")),
				ItemList.gobber2_gooey_apple = new Item(new Item.Properties().food(FoodList.gooeyApple).group(gobber2)).setRegistryName(location("gobber2_gooey_apple")),
				ItemList.gobber2_gooey_bread = new Item(new Item.Properties().food(FoodList.gooeyBread).group(gobber2)).setRegistryName(location("gobber2_gooey_bread")),
				ItemList.gobber2_gooey_beef = new Item(new Item.Properties().food(FoodList.gooeyBeef).group(gobber2)).setRegistryName(location("gobber2_gooey_beef")),
				ItemList.gobber2_gooey_beefstew = new ItemCustomFoodBeefstew(new Item.Properties().maxStackSize(1).food(FoodList.gooeyBeef).group(gobber2)).setRegistryName(location("gobber2_gooey_beefstew")),
				
				ItemList.gobber2_goo_nether = new Item(new Item.Properties().food(FoodList.gooFood).group(gobber2)).setRegistryName(location("gobber2_goo_nether")),
				ItemList.gobber2_gooey_apple_nether = new Item(new Item.Properties().food(FoodList.gooeyApple).group(gobber2)).setRegistryName(location("gobber2_gooey_apple_nether")),
				ItemList.gobber2_gooey_bread_nether = new Item(new Item.Properties().food(FoodList.gooeyBread).group(gobber2)).setRegistryName(location("gobber2_gooey_bread_nether")),
				ItemList.gobber2_gooey_beef_nether = new Item(new Item.Properties().food(FoodList.gooeyBeef).group(gobber2)).setRegistryName(location("gobber2_gooey_beef_nether")),
				ItemList.gobber2_gooey_beefstew_nether = new ItemCustomFoodBeefstewNether(new Item.Properties().maxStackSize(1).food(FoodList.gooeyBeef).group(gobber2)).setRegistryName(location("gobber2_gooey_beefstew_nether")),

				ItemList.gobber2_armor_repair = new Item(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_armor_repair")),
				
				
				
				//Gobber 
				ItemList.gobber2_helmet = new ItemCustomArmor(ArmourMaterialList.gobber2, EquipmentSlotType.HEAD, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_helmet")),
				ItemList.gobber2_chestplate = new ItemCustomArmor(ArmourMaterialList.gobber2, EquipmentSlotType.CHEST, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_chestplate")),
				ItemList.gobber2_leggings = new ItemCustomArmor(ArmourMaterialList.gobber2, EquipmentSlotType.LEGS, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_leggings")),
				ItemList.gobber2_boots = new ItemCustomArmor(ArmourMaterialList.gobber2, EquipmentSlotType.FEET, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_boots")),
				
				ItemList.gobber2_helmet_nether = new ItemCustomArmorNether(ArmourMaterialList.gobber2_nether, EquipmentSlotType.HEAD, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_helmet_nether")),
				ItemList.gobber2_chestplate_nether = new ItemCustomArmorNether(ArmourMaterialList.gobber2_nether, EquipmentSlotType.CHEST, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_chestplate_nether")),
				ItemList.gobber2_leggings_nether = new ItemCustomArmorNether(ArmourMaterialList.gobber2_nether, EquipmentSlotType.LEGS, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_leggings_nether")),
				ItemList.gobber2_boots_nether = new ItemCustomArmorNether(ArmourMaterialList.gobber2_nether, EquipmentSlotType.FEET, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_boots_nether")),
				
				
				
				//Tools & Weapons
				ItemList.gobber2_sword = new ItemCustomSword(ToolMaterialList.gobber2, 4, 4.0f, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_sword")),
				ItemList.gobber2_pickaxe = new ItemCustomPickaxe(ToolMaterialList.gobber2, -14, 4.0f, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_pickaxe")),
				ItemList.gobber2_hammer = new ItemCustomHammer(ToolMaterialList.gobber2, -14, 4.0f, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_hammer")),
				ItemList.gobber2_paxel = new ItemCustomPaxel(-14, 4.0f, ToolMaterialList.gobber2, null, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_paxel")),
				ItemList.gobber2_shovel = new ItemCustomShovel(ToolMaterialList.gobber2, -14.0f, 4.0f, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_shovel")),
				ItemList.gobber2_axe = new ItemCustomAxe(ToolMaterialList.gobber2, -14.0f, 4.0f, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_axe")),
				ItemList.gobber2_hoe = new ItemCustomHoe(ToolMaterialList.gobber2, 4.0f, 0, new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_hoe")),
				
				ItemList.gobber2_sword_nether = new ItemCustomSwordNether(ToolMaterialList.gobber2_nether, 4, 4.0f, new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_sword_nether")),
				ItemList.gobber2_sword_sniper = new ItemCustomSwordSniper(ToolMaterialList.gobber2_nether, 6, 4.0f, new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_sword_sniper")),
				ItemList.gobber2_sword_traveler = new ItemCustomSwordTraveler(ToolMaterialList.gobber2_nether, 6, 4.0f, new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_sword_traveler")),
				ItemList.gobber2_pickaxe_nether = new ItemCustomPickaxeNether(ToolMaterialList.gobber2_nether, -14, 4.0f, new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_pickaxe_nether")),
				ItemList.gobber2_hammer_nether = new ItemCustomHammerNether(ToolMaterialList.gobber2_nether, -14, 4.0f, new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_hammer_nether")),
				ItemList.gobber2_paxel_nether = new ItemCustomPaxelNether(-14, 4.0f, ToolMaterialList.gobber2_nether, null, new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_paxel_nether")),
				ItemList.gobber2_paxel_stars = new ItemCustomPaxelStars(-14, 4.0f, ToolMaterialList.gobber2_nether, null, new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_paxel_stars")),
				ItemList.gobber2_shovel_nether = new ItemCustomShovelNether(ToolMaterialList.gobber2_nether, -14.0f, 4.0f, new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_shovel_nether")),
				ItemList.gobber2_axe_nether = new ItemCustomAxeNether(ToolMaterialList.gobber2_nether, -14.0f, 4.0f, new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_axe_nether")),
				ItemList.gobber2_hoe_nether = new ItemCustomHoeNether(ToolMaterialList.gobber2_nether, 4.0f, 0, new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_hoe_nether")),
			
				
				
				//Gobber Rings
				ItemList.gobber2_ring = new ItemCustomRing(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_ring")),
				
				ItemList.gobber2_ring_attraction = new ItemCustomRingAttraction(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_attraction")),
				ItemList.gobber2_ring_miner = new ItemCustomRingMiner(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_miner")),
				ItemList.gobber2_ring_lumberjack = new ItemCustomRingLumberjack(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_lumberjack")),
				ItemList.gobber2_ring_acceleration = new ItemCustomRingAcceleration(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_acceleration")),				
				ItemList.gobber2_ring_leaping = new ItemCustomRingLeaping(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_leaping")),
				ItemList.gobber2_ring_dismissal = new ItemCustomRingDismissal(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_dismissal")),
				//ItemList.gobber2_ring_enderchest = new ItemCustomRingEnderchest(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_enderchest")),

				ItemList.gobber2_ring_nether = new ItemCustomRing(new Item.Properties().group(gobber2)).setRegistryName(location("gobber2_ring_nether")),
				ItemList.gobber2_ring_curing = new ItemCustomRingCuring(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_curing")),
				ItemList.gobber2_ring_traveler = new ItemCustomRingTraveler(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_traveler")),
				ItemList.gobber2_ring_swiftness = new ItemCustomRingSwiftness(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_swiftness")),
				ItemList.gobber2_ring_vision = new ItemCustomRingVision(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_vision")),
				ItemList.gobber2_ring_phoenix = new ItemCustomRingPhoenix(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_ring_phoenix")),
				
				
				
				//Staffs
				ItemList.gobber2_staff_clearing = new ItemCustomStaffClearing(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_staff_clearing")),
				ItemList.gobber2_staff_stars = new ItemCustomStaffStars(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_staff_stars")),
				ItemList.gobber2_staff_sniper = new ItemCustomStaffSniper(new Item.Properties().maxStackSize(1).group(gobber2)).setRegistryName(location("gobber2_staff_sniper"))
			);
			logger.info("Items registered.");
		}
	
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockList.gobber2_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(15).sound(SoundType.METAL)).setRegistryName(location("gobber2_ore")),
				BlockList.gobber2_ore_nether = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(15).sound(SoundType.METAL)).setRegistryName(location("gobber2_ore_nether")),
				BlockList.gobber2_ore_end = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(15).sound(SoundType.METAL)).setRegistryName(location("gobber2_ore_end")),
				BlockList.gobber2_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(15).sound(SoundType.METAL)).setRegistryName(location("gobber2_block")),
				BlockList.gobber2_block_nether = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(15).sound(SoundType.METAL)).setRegistryName(location("gobber2_block_nether")),
				BlockList.gobber2_lucky_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(15).sound(SoundType.METAL)).setRegistryName(location("gobber2_lucky_block"))
			);
			logger.info("Blocks registered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}	
	}
}



