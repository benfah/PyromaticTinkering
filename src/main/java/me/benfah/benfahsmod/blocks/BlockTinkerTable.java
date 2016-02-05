package me.benfah.benfahsmod.blocks;

import java.util.ArrayList;

import com.jcraft.jorbis.Block;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import me.benfah.benfahsmod.BenfahsMod;
import me.benfah.benfahsmod.Reference;
import me.benfah.benfahsmod.blocks.tileentity.TileEntityTinkerTable;
import me.benfah.benfahsmod.init.BenfahsItems;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTinkerTable extends BlockContainer{

	public BlockTinkerTable(Material mat) {
		super(mat);
		this.setBlockTextureName(Reference.MOD_ID + ":tinkerTable_p");
		this.setBlockName("tinker_table");
	}
	BlockFurnace bf;
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityTinkerTable();
	}
	
	 @Override
     public int getRenderType() {
             return -1;
     }
	
	 @Override
	public boolean onBlockActivated(World w, int x, int y, int z,
			EntityPlayer ep, int side, float hit, float p_149727_8_, float p_149727_9_) {
		if(!ep.isSneaking())
		{
			if(!w.isRemote)
			{
			FMLNetworkHandler.openGui(ep, BenfahsMod.instance, BenfahsMod.tableID, w, x, y, z);
			
			
			
			
			
			}
			
			
			
			
			
			
			return true;
		
		
		
		
		}
		return false;
	}
	 
	 @Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		
		return super.getDrops(world, x, y, z, metadata, fortune);
	}
	 @Override
     public boolean isOpaqueCube() {
             return false;
     }
	 
	 @Override
	 public boolean renderAsNormalBlock() {
         return false;
	 }
 
}
