package me.benfah.benfahsmod.gui;

import me.benfah.benfahsmod.blocks.BlockTinkerTable;
import me.benfah.benfahsmod.blocks.tileentity.TileEntityTinkerTable;
import me.benfah.benfahsmod.container.ContainerTinkerTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiTinkerTable extends GuiContainer{

	public TileEntityTinkerTable ttable;
	
	public GuiTinkerTable(InventoryPlayer inventoryPlayer, TileEntityTinkerTable entity) {
		super(new ContainerTinkerTable(inventoryPlayer, entity));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		
	}

}
