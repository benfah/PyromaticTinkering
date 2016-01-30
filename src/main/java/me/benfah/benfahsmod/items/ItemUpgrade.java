package me.benfah.benfahsmod.items;

import me.benfah.benfahsmod.BenfahsMod;
import me.benfah.benfahsmod.Reference;
import net.minecraft.item.Item;

public class ItemUpgrade extends Item
{
	
	public ItemUpgrade()
	{
		this.setCreativeTab(BenfahsMod.tabBenfah);
		this.setUnlocalizedName("pyro_upgrade");
		this.setTextureName(Reference.MOD_ID + ":sharpness_orb");
		
	}
	
	
	
	
}
