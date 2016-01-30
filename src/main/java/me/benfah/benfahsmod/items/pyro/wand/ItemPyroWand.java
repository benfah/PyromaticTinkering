package me.benfah.benfahsmod.items.pyro.wand;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.ForgeHooks;

public class ItemPyroWand extends ItemTool{
	
	public static Set test;
	
	public ItemPyroWand(float p_i45333_1_, ToolMaterial p_i45333_2_, Set p_i45333_3_) {
		super(p_i45333_1_, p_i45333_2_, p_i45333_3_);
		setUnlocalizedName("pyro_wand");
		 p_i45333_3_ = test;
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta) {

		if(test.contains(block))
		{
			System.out.println("test");


			if(stack.hasTagCompound())
			{
				if(stack.stackTagCompound.getFloat("miningspeed") != 0.0F)
				{
					
					return stack.stackTagCompound.getFloat("miningspeed");
					
				}
				
			}
			
			
			
			return efficiencyOnProperMaterial;
		}
		
		return 1.0F;
	}

	
	@Override
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
	
	@Override
	public int getRenderPasses(int metadata) {
		return 2;
	}
}