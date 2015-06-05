package org.nationsatwar.toychest.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import org.nationsatwar.palette.PlayerUtil;
import org.nationsatwar.toychest.items.Toy;
import org.nationsatwar.toychest.items.ToyEntity;

public class ItemEvents {
	
	@SubscribeEvent
	public void onItemSpawnEvent(EntityJoinWorldEvent event) {
		
		if (!(event.entity instanceof EntityItem))
			return;
		
		EntityItem entityItem = (EntityItem) event.entity;
		
		// Bug Prevention
		if (entityItem.getDataWatcher().getWatchableObjectItemStack(10) == null)
			return;
		
		if (entityItem instanceof ToyEntity) {
			
			System.out.println("Whaaat");
			return;
		}
		
		if (entityItem.getEntityItem().getItem() != null && entityItem.getEntityItem().getItem() instanceof Toy) {

			entityItem.setDead();
			ToyEntity newEntity = new ToyEntity(entityItem.worldObj, 
					entityItem.posX, entityItem.posY, entityItem.posZ, 
					entityItem.getEntityItem());
			entityItem.worldObj.spawnEntityInWorld(newEntity);
		}
	}
	
	@SubscribeEvent
    public void onEntityItemObserve(PlayerTickEvent event) {
		
    	EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
    	EntityItem playerLookItem = PlayerUtil.findPlayerLookEntityItem(player);
    	
    	if (playerLookItem == null)
    		return;
    	
    	if (playerLookItem.getEntityItem().getItem() instanceof Toy) {
    		
    		Toy toy = (Toy) playerLookItem.getEntityItem().getItem();
    		toy.setColor(0xFFFFFFFF);
    	}
	}
}