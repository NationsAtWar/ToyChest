package org.nationsatwar.toychest;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * The Tag parent class.
 * <p>
 * Custom item modification plugin for Minecraft
 * 
 * @author Aculem
 */
public final class ToyChest extends JavaPlugin {
	
	private static final Logger log = Logger.getLogger("Minecraft");

	/**
	 * Initializes the plugin on server startup.
	 */
	public void onEnable() {
    	
    	log("ToyChest has been enabled.");
	}

	/**
	 * Handles the plugin on server stop.
	 */
	public void onDisable() {
		
		log("ToyChest has been disabled.");
	}

	/**
	 * Plugin logger handler. Useful for debugging.
	 * 
	 * @param logMessage  Message to send to the console.
	 */
	public static void log(String logMessage) {
		
		log.info("ToyChest: " + logMessage);
	}
}