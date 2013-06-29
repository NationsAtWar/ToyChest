package org.nationsatwar.toychest;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;
import java.util.logging.Logger;

import org.nationsatwar.toychest.Utility.CommandParser;
import org.nationsatwar.toychest.Utility.ConfigHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * The ToyChest parent class.
 * <p>
 * Custom item modification plugin for Minecraft
 * 
 * @author Aculem
 */
@Mod(modid="nationsToyChest", name="ToyChest", version="0.1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ToyChest {
	
	// The instance of your mod that Forge uses.
	@Instance("nationsToyChest")
	public static ToyChest instance;
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="org.nationsatwar.toychest.client.ClientProxy",
            serverSide="org.nationsatwar.toychest.CommonProxy")
	public static CommonProxy proxy;
	
	private static final Logger log = Logger.getLogger("Minecraft");
	
	// Custom variables go here
	public final CommandParser commandParser = new CommandParser(this);
	
	public final ToyChestManager manager = new ToyChestManager();
    	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
		// Stub Method
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		
		proxy.registerRenderers();

		// Creates all the default Toy Chest Items packaged with the plugin
		ConfigHandler.createDefaultToyChestFiles();
		ConfigHandler.reloadToys(this);
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		
		// Stub Method
	}
	
	@ServerStarting
	public void serverLoad(FMLServerStartingEvent event) {
		
		event.registerServerCommand(commandParser);
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