package org.nationsatwar.toychest.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRender(Item item, String modID) {
		
		String itemName = item.getUnlocalizedName().substring(5);
		
		ModelResourceLocation resourceLocation = new ModelResourceLocation(modID + ":" + itemName, "inventory");
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, resourceLocation);
	}
	
	@Override
	public void registerEvents() {
		
		
	}
}