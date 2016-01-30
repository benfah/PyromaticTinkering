package me.benfah.benfahsmod.items.pyro.axe;

import scala.reflect.internal.Trees.Super;
import me.benfah.benfahsmod.BenfahsMod;
import me.benfah.benfahsmod.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

public class ItemPyroAxe extends ItemAxe{

	public ItemPyroAxe(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);
		this.setUnlocalizedName("pyro_axe");
		this.setTextureName(Reference.MOD_ID + ":pyro_axe");
	}

	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta)
	{
		
		if(ForgeHooks.isToolEffective(stack,block, meta))
		{
		return stack.stackTagCompound != null ? stack.stackTagCompound.getInteger("miningspeed") : efficiencyOnProperMaterial / 8;
		}
		else
		return 1.0F;
		
	}
	
	
	
}
