package me.benfah.benfahsmod.init;

import java.util.Set;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.benfah.benfahsmod.BenfahsMod;
import me.benfah.benfahsmod.Reference;
import me.benfah.benfahsmod.items.ItemPyroGem;
import me.benfah.benfahsmod.items.ItemUpgrade;
import me.benfah.benfahsmod.items.pyro.axe.ItemPyroAxe;
import me.benfah.benfahsmod.items.pyro.axe.ItemPyroAxeElectrolyzed;
import me.benfah.benfahsmod.items.pyro.pick.ItemPyroPickaxe;
import me.benfah.benfahsmod.items.pyro.pick.ItemPyroPickaxeElectrolyzed;
import me.benfah.benfahsmod.items.pyro.sword.ItemPyroSword;
import me.benfah.benfahsmod.items.pyro.sword.ItemPyroSwordElectrolyzed;
import me.benfah.benfahsmod.items.pyro.wand.ItemPyroWand;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.util.EnumHelper;

public class BenfahsItems {

	
	public static Item pyro_sword;
	public static Item pyro_sword_electrolyzed;
		
	public static Item pyro_pickaxe;
	public static Item pyro_pickaxe_electrolyzed;

	public static Item pyro_gem;
	public static Item sword_upgrade;

	public static Item pyro_axe;
	public static Item pyro_axe_electrolyzed;
	
	public static Item pyro_wand;
	
	public static ToolMaterial pyro_toolmaterial = new EnumHelper().addToolMaterial("pyro_toolmaterial", 0, 2000, 10, 0, 0);
	
	
	public static void init()
	{
		pyro_gem = new ItemPyroGem().setUnlocalizedName("pyro_gem").setCreativeTab(BenfahsMod.tabBenfah);
		pyro_sword = new ItemPyroSword(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		pyro_sword_electrolyzed = new ItemPyroSwordElectrolyzed(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		sword_upgrade = new ItemUpgrade();
		pyro_pickaxe = new ItemPyroPickaxe(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		pyro_pickaxe_electrolyzed = new ItemPyroPickaxeElectrolyzed(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		pyro_axe = new ItemPyroAxe(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		pyro_axe_electrolyzed = new ItemPyroAxeElectrolyzed(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		pyro_wand = new ItemPyroWand(pyro_toolmaterial);
		
		
	}
	
	
	public static void register()
	{
		GameRegistry.registerItem(pyro_wand, pyro_wand.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pyro_pickaxe, pyro_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pyro_sword_electrolyzed, pyro_sword_electrolyzed.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pyro_sword, pyro_sword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(sword_upgrade, sword_upgrade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pyro_gem, pyro_gem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pyro_pickaxe_electrolyzed, pyro_pickaxe_electrolyzed.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pyro_axe, pyro_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pyro_axe_electrolyzed, pyro_axe_electrolyzed.getUnlocalizedName().substring(5));

	}
	
	

	
}
