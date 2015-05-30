package org.nationsatwar.toychest;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.nationsatwar.toychest.proxy.CommonProxy;
 
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
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		
	}
}