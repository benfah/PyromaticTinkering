package me.benfah.benfahsmod.items.pyro.shovel;

import me.benfah.benfahsmod.util.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.ForgeHooks;

public class ItemPyroShovel extends ItemSpade
{

	public ItemPyroShovel(ToolMaterial p_i45353_1_) {
		super(p_i45353_1_);
	}
	
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta)
	{
		if(ForgeHooks.isToolEffective(stack, block, meta))
		{
			return NBTHelper.getFloat("miningspeed", stack) + 1;
		}
		return 1.0F;
		
		
	}


	
	@Override
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
	
	@Override
	public void registerIcons(IIconRegister p_94581_1_) {
	}
	
	@Override
	public int getRenderPasses(int metadata) {
		return 2;
	}
}
