package me.benfah.benfahsmod;

import me.benfah.benfahsmod.handler.BenfahEventHandler;
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
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "")
public class BenfahsMod {
	
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	
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
		ItemStack obsidian = new ItemStack(Blocks.obsidian);
		ItemStack redstone = new ItemStack(Items.redstone);
		ItemStack glass = new ItemStack(Blocks.glass_pane);
		ItemStack netherstar = new ItemStack(Items.nether_star);
		ItemStack pyro_sword = new ItemStack(new BenfahsItems().pyro_sword);
		ItemStack pyro_sword_electrolyzed = new ItemStack(new BenfahsItems().pyro_sword_electrolyzed);

		ItemStack pyro_gem = new ItemStack(new BenfahsItems().pyro_gem);
		ItemStack blaze_rod = new ItemStack(Items.blaze_rod);
		ItemStack slime_ball = new ItemStack(Items.slime_ball);
		ItemStack gold = new ItemStack(Items.gold_ingot);
		ItemStack sharp_orb = new ItemStack(BenfahsItems.sword_upgrade);
		
		
		GameRegistry.addRecipe(sharp_orb, "GPG", "PSP", "GPG", 'G', gold, 'P', pyro_gem, 'S', slime_ball);
		GameRegistry.addRecipe(pyro_sword, " G "," G ", " R ", 'G', pyro_gem, 'R', blaze_rod);
		proxy.registerRenders();
		
		
			GameRegistry.addRecipe(pyro_sword_electrolyzed, "RGR", "GEG", "COC", 'R', redstone, 'G', pyro_gem, 'E', pyro_sword, 'O', sharp_orb, 'C', new ItemStack(Items.diamond));
			
		
	}
	
	@EventHandler
	public void postInit(FMLInitializationEvent e)
	{

	}
}

