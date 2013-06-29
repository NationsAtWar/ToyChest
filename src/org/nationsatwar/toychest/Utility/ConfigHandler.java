package org.nationsatwar.toychest.Utility;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

import org.nationsatwar.toychest.Toy;
import org.nationsatwar.toychest.ToyChest;

public final class ConfigHandler {
	
	// Toy Settings
	private static final String itemType = "Item Type";
	private static final String enabled = "Enabled";
	
	// Toy Properties
	private static final String itemDamage = "Item.Damage";
	
	// Custom Properties
	private static final String customRange = "Custom.Range";
	private static final String customWidth = "Custom.Width";
	private static final String customHeight = "Custom.Height";
	
	// File Paths
	private static final String toyChestPath = "plugins/ToyChest/";
	private static final String toyChestExtension = ".yml";
	
	// Miscellaneous Strings
	private static final String generalCategory = Configuration.CATEGORY_GENERAL;
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
		
		plugin.log(toyChestPath);
		plugin.log(toyChestDirectory.getPath());
		plugin.log(toyChestDirectory.getAbsolutePath());
		try {
			plugin.log(toyChestDirectory.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (File toychestFile : toyChestDirectory.listFiles()) {
			
			if (toychestFile.isFile()) {
				
				Configuration toychestConfig = new Configuration(toychestFile);
				
                Property itemTypeProp = toychestConfig.get(generalCategory, itemType, "null");
                Property enabledProp = toychestConfig.get(generalCategory, enabled, "null");
                
                itemTypeProp.comment = "Placeholder blah blah blah";

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
				}
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

	    // Creates default config parameters on creation
		toychestConfig.get(generalCategory, itemType, itemName);
		toychestConfig.get(generalCategory, enabled, false);

		toychestConfig.get(generalCategory, itemDamage, 5);

		toychestConfig.get(generalCategory, customRange, 3);
		toychestConfig.get(generalCategory, customWidth, 3);
		toychestConfig.get(generalCategory, customHeight, 3);
	    
	    // Add header to config file
	    String header = "Toy Chest Config File" + lineBreak;
	    
	    toychestConfig.save();
	}
}