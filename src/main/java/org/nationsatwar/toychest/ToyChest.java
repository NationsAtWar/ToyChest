package org.nationsatwar.toychest;

import java.util.logging.Logger;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import org.nationsatwar.toychest.Utility.CommandParser;
import org.nationsatwar.toychest.Utility.ConfigHandler;

/**
 * The ToyChest parent class.
 * <p>
 * Custom item modification plugin for Minecraft
 * 
 * @author Aculem
 */
@Mod(modid = ToyChest.MODID, 
	name = ToyChest.MODNAME, 
	version = ToyChest.MODVER)
public class ToyChest {

    @Instance(ToyChest.MODID)
    public static ToyChest instance;

	@SidedProxy(clientSide = ToyChest.CLIENT_PROXY_CLASS, serverSide = ToyChest.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final String MODID = "toychest";
	public static final String MODNAME = "ToyChest";
	public static final String MODVER = "0.0.1";

	public static final String CLIENT_PROXY_CLASS = "org.nationsatwar.superhero.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "org.nationsatwar.superhero.proxy.CommonProxy";
	
	private static final Logger log = Logger.getLogger("Minecraft");
	
	// Custom variables go here
	public final CommandParser commandParser = new CommandParser(this);
	
	public final ToyChestManager manager = new ToyChestManager();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		proxy.registerRenderers();

		// Creates all the default Toy Chest Items packaged with the plugin
		if (isServer()) {
			
			ConfigHandler.createDefaultToyChestFiles();
			ConfigHandler.reloadToys(this);
		}
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		
	}
	
	/**
	 * Returns true if the script is currently handling server code
	 * 
	 * @return True is server, false otherwise
	 */
	public static boolean isServer() {
		
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		
		if (side == Side.SERVER)
			return true;
		else if (side == Side.CLIENT)
			return false;
		else
			log("Something horrible has happened...");
		
		return false;
	}
	
	/**
	 * Plugin logger handler. Useful for debugging.
	 * 
	 * @param logMessage  Message to send to the console.
	 */
	public static void log(String logMessage) {

		log.info("ToyChest: " + logMessage);
		System.out.println("ToyChest: " + logMessage);
	}
}