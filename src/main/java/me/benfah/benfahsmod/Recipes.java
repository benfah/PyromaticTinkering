package me.benfah.benfahsmod;

import cpw.mods.fml.common.registry.GameRegistry;
import me.benfah.benfahsmod.blocks.tileentity.TileEntityTinkerTable;
import me.benfah.benfahsmod.init.BenfahsItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipes {

	
	
	public Recipes()
	{
		
		
	}
	
	
	public static void init()
	{
		ItemStack obsidian = new ItemStack(Blocks.obsidian);
		ItemStack redstone = new ItemStack(Items.redstone);
		ItemStack glass = new ItemStack(Blocks.glass_pane);
		ItemStack netherstar = new ItemStack(Items.nether_star);
		
		ItemStack pyro_sword = new ItemStack(BenfahsItems.pyro_sword);
		ItemStack pyro_sword_electrolyzed = new ItemStack(BenfahsItems.pyro_sword_electrolyzed);
		
		ItemStack pyro_tool = new ItemStack(BenfahsItems.pyro_tool);
		ItemStack pyro_tool_electrolyzed = new ItemStack(BenfahsItems.pyro_tool_electrolyzed);

		
		ItemStack pyro_pick = new ItemStack(BenfahsItems.pyro_pickaxe);
		ItemStack pyro_pick_electrolyzed = new ItemStack(BenfahsItems.pyro_pickaxe_electrolyzed);

		ItemStack pyro_axe = new ItemStack(BenfahsItems.pyro_axe);
		ItemStack pyro_axe_electrolyzed = new ItemStack(BenfahsItems.pyro_axe_electrolyzed);

		

		ItemStack pyro_gem = new ItemStack(new BenfahsItems().pyro_gem);
		ItemStack blaze_rod = new ItemStack(Items.blaze_rod);
		ItemStack slime_ball = new ItemStack(Items.slime_ball);
		ItemStack gold = new ItemStack(Items.gold_ingot);
		ItemStack sharp_orb = new ItemStack(BenfahsItems.sword_upgrade);
		
		
		GameRegistry.addRecipe(sharp_orb, "GPG", "PSP", "GPG", 'G', gold, 'P', pyro_gem, 'S', slime_ball);
		
		GameRegistry.addRecipe(pyro_sword, " G "," G ", " R ", 'G', pyro_gem, 'R', blaze_rod);
		GameRegistry.addRecipe(pyro_sword_electrolyzed, "RGR", "GEG", "COC", 'R', redstone, 'G', pyro_gem, 'E', pyro_sword, 'O', sharp_orb, 'C', new ItemStack(Items.diamond));

		
		GameRegistry.addRecipe(pyro_pick, "GGG"," R ", " R ", 'G', pyro_gem, 'R', blaze_rod);
		GameRegistry.addRecipe(pyro_pick_electrolyzed, "RGR", "GEG", "COC", 'R', redstone, 'G', pyro_gem, 'E', pyro_pick, 'O', sharp_orb, 'C', new ItemStack(Items.diamond));
		
		GameRegistry.addRecipe(pyro_axe, "GG ","GR ", " R ", 'G', pyro_gem, 'R', blaze_rod);
		GameRegistry.addRecipe(pyro_axe_electrolyzed, "RGR", "GEG", "COC", 'R', redstone, 'G', pyro_gem, 'E', pyro_pick, 'O', sharp_orb, 'C', new ItemStack(Items.diamond));

		GameRegistry.addRecipe(pyro_tool, "GDG","AGP", "RSR", 'G', pyro_gem, 'R', redstone, 'D', new ItemStack(Items.diamond), 'A', pyro_axe, 'P', pyro_pick, 'S', pyro_sword);
		GameRegistry.addRecipe(pyro_axe_electrolyzed, "RGR", "GEG", "COC", 'R', redstone, 'G', pyro_gem, 'E', pyro_pick, 'O', sharp_orb, 'C', new ItemStack(Items.diamond));


		
		
		
	}
}
