package org.nationsatwar.toychest;

import java.util.logging.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.nationsatwar.toychest.proxy.CommonProxy;

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
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		
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