package org.nationsatwar.toychest.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.nationsatwar.toychest.ToyChest;

public class Toy extends Item {
	
	public static Toy instance;
	
	private String name;
	
	public Toy(String name) {
		
		this.name = name;
		
		setUnlocalizedName(name);
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(64);
		
		instance = this;
	}
	
	public static void register(Toy item, String modID) {

		GameRegistry.registerItem(item, item.name);
		ToyChest.proxy.registerRender(item, modID);
	}
}