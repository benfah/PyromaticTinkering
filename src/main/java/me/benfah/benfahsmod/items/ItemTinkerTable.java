package me.benfah.benfahsmod.items;

import me.benfah.benfahsmod.BenfahsMod;
import me.benfah.benfahsmod.init.BenfahsItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTinkerTable extends Item{

	public ItemTinkerTable() {
		this.setUnlocalizedName("tinker_table_item");
		this.setCreativeTab(BenfahsMod.tabBenfah);
		
	}
	
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World w, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		if(par7 != 1)
		{
			
			return false;
			
			
		}else
		{
			if(player.canPlayerEdit(x, y, z, par7, stack) && player.canPlayerEdit(x, y+1, z, par7, stack))
			{
				w.setBlock(x, y+1, z, BenfahsItems.tinker_table);
				w.playSoundEffect(x, y, z, "dig.stone", 0.5F, 0.9F);
				--stack.stackSize;
				return true;
			}else
				return false;
			
			
		}
	
	
	
	
	
	
	
	
	}
}
