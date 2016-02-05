package me.benfah.benfahsmod.items.pyro.wand;

import java.util.Set;

import com.google.common.collect.Sets;

import me.benfah.benfahsmod.Reference;
import me.benfah.benfahsmod.init.BenfahsItems;
import me.benfah.benfahsmod.util.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.ForgeHooks;

public class ItemPyroTool extends ItemTool{
	
	public IIcon tool;
	
	
    public static final Set BLOCKS = Sets.newHashSet(new Block[] {Blocks.obsidian, Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail, Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});
    
	
	public ItemPyroTool(ToolMaterial p_i45333_2_) {
		super(3.0F, p_i45333_2_, BLOCKS);
		setUnlocalizedName("pyro_tool");
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta) {
		
        return NBTHelper.getFloat("miningspeed", stack) != 0.0F ? NBTHelper.getFloat("miningspeed", stack) : 1.0F;
        
		
         
    }
	@Override
	public boolean func_150897_b(Block p_150897_1_)
    {
        return p_150897_1_ == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (p_150897_1_ != Blocks.diamond_block && p_150897_1_ != Blocks.diamond_ore ? (p_150897_1_ != Blocks.emerald_ore && p_150897_1_ != Blocks.emerald_block ? (p_150897_1_ != Blocks.gold_block && p_150897_1_ != Blocks.gold_ore ? (p_150897_1_ != Blocks.iron_block && p_150897_1_ != Blocks.iron_ore ? (p_150897_1_ != Blocks.lapis_block && p_150897_1_ != Blocks.lapis_ore ? (p_150897_1_ != Blocks.redstone_ore && p_150897_1_ != Blocks.lit_redstone_ore ? (p_150897_1_.getMaterial() == Material.rock ? true : (p_150897_1_.getMaterial() == Material.iron ? true : p_150897_1_.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {
		if(pass == 0)
		{
			
			return tool;
			
		}
		
		return tool;

	}
	@Override
	public void registerIcons(IIconRegister i) {
		tool = i.registerIcon(Reference.MOD_ID + ":pyro_wand");
	}
	
	@Override
	public int getHarvestLevel(ItemStack stack, String toolClass) {
		return 3;
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
