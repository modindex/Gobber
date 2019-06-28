package com.kwpugh.gobber2.lists;

import net.minecraft.item.Food;

public class FoodList
{
	public static Food gooFood = (new Food.Builder()).hunger(7).saturation(0.7F).setAlwaysEdible().build();
	public static Food gooeyApple = (new Food.Builder()).hunger(8).saturation(0.8F).setAlwaysEdible().build();
	public static Food gooeyBread = (new Food.Builder()).hunger(8).saturation(0.8F).setAlwaysEdible().build();
	public static Food gooeyBeef = (new Food.Builder()).hunger(9).saturation(0.9F).meat().setAlwaysEdible().build();
	public static Food gooeyBeefstew = (new Food.Builder()).hunger(10).saturation(1.0F).setAlwaysEdible().build();
	
	public static Food gooFood_nether = (new Food.Builder()).hunger(9).saturation(0.9F).setAlwaysEdible().build();
	public static Food gooeyApple_nether = (new Food.Builder()).hunger(10).saturation(1.0F).setAlwaysEdible().build();
	public static Food gooeyBreadN_nether = (new Food.Builder()).hunger(10).saturation(1.0F).setAlwaysEdible().build();
	public static Food gooeyBeef_nether = (new Food.Builder()).hunger(12).saturation(1.2F).meat().setAlwaysEdible().build();
	public static Food gooeyBeefstew_nether = (new Food.Builder()).hunger(14).saturation(1.5F).setAlwaysEdible().build();
}
