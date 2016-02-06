package me.benfah.benfahsmod;

import java.util.List;

import me.benfah.benfahsmod.handler.SwordUpgrades;
import me.benfah.benfahsmod.init.BenfahsItems;
import me.benfah.benfahsmod.util.NBTHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;

public class BenfahTab extends CreativeTabs{

	public BenfahTab(String label) {
		super(label);
		this.setBackgroundImageName("benfah.png");
		
		
	}

	@Override
	public Item getTabIconItem() {
		return BenfahsItems.pyro_sword;
	}

	@Override
	public void displayAllReleventItems(List items)
	{
		super.displayAllReleventItems(items);
		ItemStack pickaxe = new ItemStack(BenfahsItems.pyro_pickaxe);
		ItemStack axe = new ItemStack(BenfahsItems.pyro_axe);
		ItemStack sword = new ItemStack(BenfahsItems.pyro_sword);
		ItemStack tool = new ItemStack(BenfahsItems.pyro_tool);
		
		ItemStack pickaxe_e = new ItemStack(BenfahsItems.pyro_pickaxe_electrolyzed);
		ItemStack axe_e = new ItemStack(BenfahsItems.pyro_axe_electrolyzed);
		ItemStack sword_e = new ItemStack(BenfahsItems.pyro_sword_electrolyzed);
		ItemStack tool_e = new ItemStack(BenfahsItems.pyro_tool_electrolyzed);

		
		NBTTagCompound com = new NBTTagCompound();
		
		com.setInteger("Energy", Reference.CAPACITY_PYRO);
		
		pickaxe_e.setTagCompound(com);
		axe_e.setTagCompound(com);
		sword_e.setTagCompound(com);
		tool_e.setTagCompound(com);
		
		items.add(pickaxe);
		items.add(axe);
		items.add(sword);
		items.add(tool);

		
		items.add(pickaxe_e);
		items.add(axe_e);
		items.add(sword_e);
		items.add(tool_e);

		

	}
	
}
