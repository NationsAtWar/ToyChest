package org.nationsatwar.toychest.Utility;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.nationsatwar.toychest.ToyChest;

public final class ConfigHandler {

	public static final String itemType = "Item Type";
	
	private static final String toyChestPath = "plugins/ToyChest/";
	private static final String toyChestExtension = ".yml";
	
	private static final String lineBreak = "\r\n";

	/**
	 * Creates all the default Toy Chest Files
	 */
	public static void createDefaultSumoFiles() {
		
		// Create necessary folders
		File sumoDirectory = new File(toyChestPath);
		
		if (!sumoDirectory.exists())
			sumoDirectory.mkdir();
		
		// Create default Toy Chest Files
		createToyChestFile("IRON_SWORD");
		createToyChestFile("DIAMOND_SWORD");
	}

	/**
	 * Gets the full Toy Chest path
	 */
	public static String getFullToyChestPath(String sumoName) {
		
		return toyChestPath + sumoName + toyChestExtension;
	}

	/**
	 * Creates a ToyChest File
	 * 
	 * @param itemName  The name of the ToyChest file to create
	 */
	private static void createToyChestFile(String itemName) {
		
		String fullSumoPath = toyChestPath + itemName + toyChestExtension;
	    File sumoFile = new File(fullSumoPath);
		
	    FileConfiguration toyChestConfig = YamlConfiguration.loadConfiguration(sumoFile);
	    FileConfigurationOptions toyChestConfigOptions = toyChestConfig.options();

	    // Creates default config parameters on creation
	    toyChestConfig.addDefault(itemType, itemName);
	    
	    toyChestConfigOptions.copyDefaults(true);
	    
	    // Add header to config file
	    String header = "Toy Chest Config File" + lineBreak;
	    toyChestConfigOptions.header(header);
	    toyChestConfigOptions.copyHeader(true);
	    
	    // Save the file
	    try { toyChestConfig.save(sumoFile); }
	    catch (IOException e) { ToyChest.log("Error saving config file: " + e.getMessage()); }
	}
}