package org.nationsatwar.toychest.Utility;

import org.bukkit.Bukkit;
import org.nationsatwar.toychest.Toy;
import org.nationsatwar.toychest.ToyChest;

public class ToyChestHook {
	
	private static ToyChest plugin = (ToyChest) Bukkit.getPluginManager().getPlugin("ToyChest");
	
	public static Toy retrieveToy(String toyName) {
		
		Toy toy = plugin.manager.getToy(toyName);
		
		return toy;
	}
}