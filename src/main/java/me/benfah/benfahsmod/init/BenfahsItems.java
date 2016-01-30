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
import me.benfah.benfahsmod.items.ItemTest;
import me.benfah.benfahsmod.items.pyro.axe.ItemPyroAxe;
import me.benfah.benfahsmod.items.pyro.axe.ItemPyroAxeElectrolyzed;
import me.benfah.benfahsmod.items.pyro.pick.ItemPyroPickaxe;
import me.benfah.benfahsmod.items.pyro.pick.ItemPyroPickaxeElectrolyzed;
import me.benfah.benfahsmod.items.pyro.sword.ItemPyroSword;
import me.benfah.benfahsmod.items.pyro.sword.ItemPyroSwordElectrolyzed;
import me.benfah.benfahsmod.items.pyro.wand.ItemPyroWand;
import me.benfah.benfahsmod.items.tut.ItemTutPickaxe;
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
	
	public static Set blockWandSet;
	
	public static Item pyro_pickaxe;
	public static Item pyro_pickaxe_electrolyzed;

	public static Item pyro_gem;
	public static Item sword_upgrade;

	public static Item pyro_axe;
	public static Item pyro_axe_electrolyzed;
	
	public static Item pyro_wand;
	
	public static ToolMaterial pyro_toolmaterial = new EnumHelper().addToolMaterial("pyro_toolmaterial", 0, 2000, 40, 0, 0);
	
	public static Item tut_pickaxe;
	
	public static void init()
	{
		blockWandSet = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin}, new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});
		pyro_gem = new ItemPyroGem().setUnlocalizedName("pyro_gem").setCreativeTab(BenfahsMod.tabBenfah);
		pyro_sword = new ItemPyroSword(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		pyro_sword_electrolyzed = new ItemPyroSwordElectrolyzed(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		sword_upgrade = new ItemUpgrade();
		pyro_pickaxe = new ItemPyroPickaxe(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		pyro_pickaxe_electrolyzed = new ItemPyroPickaxeElectrolyzed(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		pyro_axe = new ItemPyroAxe(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		pyro_axe_electrolyzed = new ItemPyroAxeElectrolyzed(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		tut_pickaxe = new ItemTutPickaxe(pyro_toolmaterial).setCreativeTab(BenfahsMod.tabBenfah);
		pyro_wand = new ItemPyroWand(0F, pyro_toolmaterial, blockWandSet);
		
		
	}
	
	
	public static void register()
	{
		GameRegistry.registerItem(tut_pickaxe, tut_pickaxe.getUnlocalizedName().substring(5));
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
