package me.benfah.benfahsmod.container;

import me.benfah.benfahsmod.blocks.tileentity.TileEntityTinkerTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerTinkerTable extends Container{
	
	
	public ContainerTinkerTable(InventoryPlayer inventory, TileEntityTinkerTable tileentity)
	{
	
	
	
	}
	
	
	
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return false;
	}

}
