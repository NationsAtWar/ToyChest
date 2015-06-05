package org.nationsatwar.toychest.items;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToyEntity extends EntityItem {
	
	public boolean keepSpawned = true;
	public float brightnessLevel = 10;

	public ToyEntity(World worldIn, double posX, double posY, double posZ, ItemStack itemStack) {
		
		super(worldIn, posX, posY, posZ, itemStack);
		this.setPickupDelay(10000);
	}
	
	@Override
	public float getBrightness(float someValue) {

		Toy toy = (Toy) this.getEntityItem().getItem();
		
		brightnessLevel = 1000;
		System.out.println("Wh231aat");
		
		if (toy.revertColor)
			return brightnessLevel;
		else
			return brightnessLevel;
	}
	
	@Override
	public void onUpdate() {
		
		super.onUpdate();
		
		Toy toy = (Toy) this.getEntityItem().getItem();
		if (toy.revertColor)
			toy.color = 0xAAAAAA;
		else
			toy.revertColor = true;
		
		
	}
	
	public boolean interact(EntityPlayer player) {

		System.out.println("Hey what");
		return true;
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer entityIn) {
		
		return;
	}
	
	@Override
	public boolean interactFirst(EntityPlayer playerIn) {
		
		System.out.println("Hey what");
		return true;
	}
}