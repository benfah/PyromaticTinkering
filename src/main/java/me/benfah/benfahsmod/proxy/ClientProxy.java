package me.benfah.benfahsmod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import me.benfah.benfahsmod.blocks.tileentity.TileEntityTinkerTable;
import me.benfah.benfahsmod.init.BenfahsItems;
import me.benfah.benfahsmod.renderer.BlockTinkerTableRenderer;
import me.benfah.benfahsmod.renderer.ItemBlockTinkerTableRenderer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{

	
	
	
	
	@Override
	public void registerRenders()
	{
		
		
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTinkerTable.class, new BlockTinkerTableRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BenfahsItems.tinker_table),new ItemBlockTinkerTableRenderer());
	}
	
	
	
}
