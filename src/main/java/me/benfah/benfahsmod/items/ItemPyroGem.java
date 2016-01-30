package me.benfah.benfahsmod.items;

import com.sun.org.apache.xml.internal.security.encryption.Reference;
import me.benfah.benfahsmod.BenfahsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemPyroGem extends Item{

	public ItemPyroGem() {
		
		
		this.setUnlocalizedName("pyro_gem");
		this.setCreativeTab(BenfahsMod.tabBenfah);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setTextureName(me.benfah.benfahsmod.Reference.MOD_ID + ":pyro_gem");
	}
	
	
	
	
	
}
