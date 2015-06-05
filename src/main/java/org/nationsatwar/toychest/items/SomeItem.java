package org.nationsatwar.toychest.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class SomeItem extends Toy {

	public SomeItem(String name) {
		
		super(name);
        this.maxStackSize = 16;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		if (!worldIn.isRemote)
			return false;
		
		return true;
	}
}