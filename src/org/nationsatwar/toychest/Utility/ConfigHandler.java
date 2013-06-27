package org.nationsatwar.toychest.Utility;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.nationsatwar.toychest.Toy;
import org.nationsatwar.toychest.ToyChest;

public final class ConfigHandler {
	
	// Toy Settings
	private static final String itemType = "Item Type";
	private static final String enabled = "Enabled";
	
	// Toy Properties
	private static final String itemDamage = "Item.Damage";
	
	// File Paths
	private static final String toyChestPath = "plugins/ToyChest/";
	private static final String toyChestExtension = ".yml";
	
	// Miscellaneous Strings
	private static final String lineBreak = "\r\n";

	/**
	 * Creates all the default Toy Chest Files
	 */
	public static void createDefaultToyChestFiles() {
		
		// Create necessary folders
		File toyChestDirectory = new File(toyChestPath);
		
		if (!toyChestDirectory.exists())
			toyChestDirectory.mkdir();
		
		// Create default Toy Chest Files
		createToyChestFile("IRON_SWORD");
		createToyChestFile("DIAMOND_SWORD");
	}
	
	/**
	 * Reloads all the toys into the plugin
	 */
	public static void reloadToys(ToyChest plugin) {
		
		plugin.manager.emptyToychest();
		
		// Cycle through Toychest directory
		File toyChestDirectory = new File(toyChestPath);
		
		for (File toychestFile : toyChestDirectory.listFiles()) {
			
			if (toychestFile.isFile()) {
				
				FileConfiguration toychestConfig = YamlConfiguration.loadConfiguration(toychestFile);
				
				// If file is valid, create Toy
				if (toychestConfig.contains(itemType) && toychestConfig.getBoolean(enabled)) {
					
					String toyName = toychestConfig.getString(itemType);
					Toy toy = new Toy(toyName);
					
					// Set all properties here
					toy.setDamage(toychestConfig.getInt(itemDamage));
					
					plugin.manager.addToy(toy);
				}
			}
		}
		
		ToyChest.log(plugin.manager.toychest.toString());
	}
	
	/**
	 * Gets the full Toy Chest path
	 */
	public static String getFullToyChestPath(String itemName) {
		
		return toyChestPath + itemName + toyChestExtension;
	}
	
	/**
	 * Creates a ToyChest File
	 * 
	 * @param itemName  The name of the ToyChest file to create
	 */
	private static void createToyChestFile(String itemName) {
		
	    File toyChestFile = new File(getFullToyChestPath(itemName));
		
	    FileConfiguration toyChestConfig = YamlConfiguration.loadConfiguration(toyChestFile);
	    FileConfigurationOptions toyChestConfigOptions = toyChestConfig.options();

	    // Creates default config parameters on creation
	    toyChestConfig.addDefault(itemType, itemName);
	    toyChestConfig.addDefault(enabled, false);

	    toyChestConfig.addDefault(itemDamage, 5);
	    
	    toyChestConfigOptions.copyDefaults(true);
	    
	    // Add header to config file
	    String header = "Toy Chest Config File" + lineBreak;
	    toyChestConfigOptions.header(header);
	    toyChestConfigOptions.copyHeader(true);
	    
	    // Save the file
	    try { toyChestConfig.save(toyChestFile); }
	    catch (IOException e) { ToyChest.log("Error saving config file: " + e.getMessage()); }
	}
}