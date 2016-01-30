package me.benfah.benfahsmod;

import java.util.List;

import me.benfah.benfahsmod.handler.SwordUpgrades;
import me.benfah.benfahsmod.init.BenfahsItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

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
	}
	
}
