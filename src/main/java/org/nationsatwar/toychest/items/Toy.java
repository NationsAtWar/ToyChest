package org.nationsatwar.toychest.items;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.nationsatwar.toychest.ToyChest;

public class Toy extends Item {
	
	private String name;
	public int color = 0x999999FF;
	public boolean revertColor = true;
	
	public Toy(String name) {
		
		this.name = name;
		setUnlocalizedName(name);
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(64);
	}
	
	public void setColor(int color) {
		
		this.color = color;
		revertColor = false;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		
	}
	
	@Override
	public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining) {
		
		return null;
	}
	
	@Override
	public int getColorFromItemStack(ItemStack stack, int renderPass) {
		
		return color;
	}
	
	public static void register(Toy item) {

		GameRegistry.registerItem(item, item.name);
		ToyChest.proxy.registerRender(item);
	}
	
	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) {
		
		return 2147483647;
	}
}