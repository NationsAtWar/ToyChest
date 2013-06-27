package org.nationsatwar.toychest.Utility;

import org.bukkit.Bukkit;
import org.nationsatwar.toychest.Toy;
import org.nationsatwar.toychest.ToyChest;

public class ToyChestHook {
	
	private static ToyChest plugin = (ToyChest) Bukkit.getPluginManager().getPlugin("ToyChest");
	
	public static boolean toyExists(String toyName) {
		
		Toy toy = plugin.manager.getToy(toyName);
		
		if (toy != null)
			return true;
		else
			return false;
	}
	
	public static int getDamage(String toyName) {
		
		Toy toy = plugin.manager.getToy(toyName);
		
		if (toy != null)
			return toy.getDamage();
		else
			return 0;
	}
	
	public static Object getCustomValue(String toyName, String customValue) {
		
		Toy toy = plugin.manager.getToy(toyName);
		
		if (toy != null)
			return toy.getCustomValue(customValue);
		else
			return null;
	}
}