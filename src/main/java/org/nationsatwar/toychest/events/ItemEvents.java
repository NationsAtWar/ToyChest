package org.nationsatwar.toychest.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemEvents {
	
	@SubscribeEvent
	public void onItemSpawnEvent(EntityJoinWorldEvent event) {
		
		if (!(event.entity instanceof EntityItem))
			return;
		
		EntityItem entityItem = (EntityItem) event.entity;
		
		// Bug Prevention
		if (entityItem.getDataWatcher().getWatchableObjectItemStack(10) == null)
			return;
	}
	
	@SubscribeEvent
	public void onItemSpawnEvent(ItemEvent event) {
		
		return;
	}
}