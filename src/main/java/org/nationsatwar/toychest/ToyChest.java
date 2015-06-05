package org.nationsatwar.toychest;

import java.util.logging.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.nationsatwar.toychest.events.ItemEvents;
import org.nationsatwar.toychest.items.SomeItem;
import org.nationsatwar.toychest.items.Toy;
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

	public static final String CLIENT_PROXY_CLASS = "org.nationsatwar.toychest.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "org.nationsatwar.toychest.proxy.CommonProxy";
	
	private static final Logger log = Logger.getLogger("Minecraft");
	
	ItemEvents itemEventHandler = new ItemEvents();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		MinecraftForge.EVENT_BUS.register(itemEventHandler);
		FMLCommonHandler.instance().bus().register(itemEventHandler);
		
		proxy.registerEvents();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		Toy.register(new SomeItem("test"));
		Toy.register(new SomeItem("test2"));
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