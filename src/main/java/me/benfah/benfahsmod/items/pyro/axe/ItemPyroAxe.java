package me.benfah.benfahsmod.items.pyro.axe;

import scala.reflect.internal.Trees.Super;

import java.util.Set;

import com.google.common.collect.Sets;

import me.benfah.benfahsmod.BenfahsMod;
import me.benfah.benfahsmod.Reference;
import me.benfah.benfahsmod.util.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

public class ItemPyroAxe extends ItemAxe{

	
	private static final Set field_150915_c = Sets.newHashSet(new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});
	
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
		return NBTHelper.getInteger("miningspeed", stack) + 1;
		}
		return 1.0F;
		
	}
	
	
	
}
