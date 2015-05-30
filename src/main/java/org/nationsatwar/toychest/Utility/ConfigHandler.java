package org.nationsatwar.toychest.Utility;

import java.io.File;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import org.nationsatwar.toychest.Toy;
import org.nationsatwar.toychest.ToyChest;

public final class ConfigHandler {
	
	// Toy Settings
	private static final String itemType = "Item Type";
	private static final String enabled = "Enabled";
	
	// Toy Properties
	private static final String itemDamage = "Item.Damage";
	
	// Custom Properties
	private static final String attackRange = "attackRange";
	private static final String attackWidth = "attackWidth";
	private static final String attackHeight = "attackHeight";
	
	// File Paths
	private static final String toyChestPath = "plugins/ToyChest/";
	private static final String toyChestExtension = ".yml";
	
	// Miscellaneous Strings
	private static final String generalCategory = Configuration.CATEGORY_GENERAL;
	private static final String customCategory = "Custom";
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
		
		plugin.log(toyChestDirectory.getAbsolutePath());
		
		for (File toychestFile : toyChestDirectory.listFiles()) {
			
			if (toychestFile.isFile()) {
				
				Configuration toychestConfig = new Configuration(toychestFile);
				
				toychestConfig.load();
				
                Property itemTypeProp = toychestConfig.get(generalCategory, itemType, "null");
                Property enabledProp = toychestConfig.get(generalCategory, enabled, "null");

				// If file is valid, create Toy
				if (toychestConfig.hasKey(generalCategory, itemType) &&
						enabledProp.getBoolean(false)) {
					
					Toy toy = new Toy(itemTypeProp.getString());
					
					toychestConfig.addCustomCategoryComment("Custom", "Custom Category");
					
	                Property itemDamageProp = toychestConfig.get(generalCategory, itemDamage, 0);
	                ConfigCategory customCategory = toychestConfig.getCategory("Custom");
					
					// Set toy properties here
					toy.setDamage(itemDamageProp.getInt());
					
					// Set custom properties here
					for (String key : customCategory.getValues().keySet())
						toy.addCustomValue(key, customCategory.get(key));
					
					plugin.manager.addToy(toy);
					
					plugin.log("Range: " + toy.getCustomValue("attackRange"));
				}
				
				toychestConfig.save();
			}
		}
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
		
	    File toychestFile = new File(getFullToyChestPath(itemName));
		
		Configuration toychestConfig = new Configuration(toychestFile);
		
		toychestConfig.load();

	    // Creates default config parameters on creation
		toychestConfig.get(generalCategory, itemType, itemName);
		toychestConfig.get(generalCategory, enabled, false);

		toychestConfig.get(generalCategory, itemDamage, 5);

		toychestConfig.get(customCategory, attackRange, 3);
		toychestConfig.get(customCategory, attackWidth, 3);
		toychestConfig.get(customCategory, attackHeight, 3);
	    
	    toychestConfig.save();
	}
}