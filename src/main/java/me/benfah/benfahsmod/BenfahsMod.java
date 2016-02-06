package me.benfah.benfahsmod;

import me.benfah.benfahsmod.blocks.tileentity.TileEntityTinkerTable;
import me.benfah.benfahsmod.handler.BenfahEventHandler;
import me.benfah.benfahsmod.handler.GUIHandler;
import me.benfah.benfahsmod.handler.RecipeManager;
import me.benfah.benfahsmod.init.BenfahsItems;
import me.benfah.benfahsmod.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "")
public class BenfahsMod {
	
	
	public static final int tableID = 0;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Instance(Reference.MOD_ID)
	public static BenfahsMod instance;
	
	
	public static final BenfahTab tabBenfah = new BenfahTab("tabBenfah");
	BenfahEventHandler handler = new BenfahEventHandler();
	
	
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{

		MinecraftForge.EVENT_BUS.register(handler);
		MinecraftForge.EVENT_BUS.register(new RecipeManager());

		FMLCommonHandler.instance().bus().register(new RecipeManager());
		BenfahsItems.init();
		BenfahsItems.register();
	
	
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
		proxy.registerRenders();
        GameRegistry.registerTileEntity(TileEntityTinkerTable.class, "tileEntityTinkerTable");

		Recipes.init();
	}
	
	@EventHandler
	public void postInit(FMLInitializationEvent e)
	{

	}
}

