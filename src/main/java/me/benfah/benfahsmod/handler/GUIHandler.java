package me.benfah.benfahsmod.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import me.benfah.benfahsmod.BenfahsMod;
import me.benfah.benfahsmod.blocks.tileentity.TileEntityTinkerTable;
import me.benfah.benfahsmod.container.ContainerTinkerTable;
import me.benfah.benfahsmod.gui.GuiTinkerTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GUIHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null)
		{
			switch(ID)
			{
			case BenfahsMod.tableID:
				if(entity instanceof TileEntityTinkerTable)
				{
					return new ContainerTinkerTable(player.inventory, (TileEntityTinkerTable) entity);
				}
				return null;
			
			
			
			
			
			
			}
			
			
			
			
		}
		return null;	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null)
		{
			switch(ID)
			{
			case BenfahsMod.tableID:
				if(entity instanceof TileEntityTinkerTable)
				{
					return new GuiTinkerTable(player.inventory, (TileEntityTinkerTable) entity);
				}
				return null;
			
			
			
			
			
			
			}
			
			
			
			
		}
		return null;
	}

}
