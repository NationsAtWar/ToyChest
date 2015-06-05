package org.nationsatwar.toychest.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import org.nationsatwar.toychest.ToyChest;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRender(Item item) {
		
		String itemName = item.getUnlocalizedName().substring(5);
		itemName = "test";
		
		ModelResourceLocation resourceLocation = new ModelResourceLocation(ToyChest.MODID + ":" + itemName, "inventory");
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, resourceLocation);
	}
	
	@Override
	public void registerEvents() {
		
		
	}
}