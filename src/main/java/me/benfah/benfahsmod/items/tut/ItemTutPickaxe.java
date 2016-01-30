package me.benfah.benfahsmod.items.tut;

import me.benfah.benfahsmod.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ItemTutPickaxe extends ItemPickaxe{
	
	IIcon pickaxe;
	IIcon overlay;
	
	
	public ItemTutPickaxe(ToolMaterial tm) {
		super(tm);
		setUnlocalizedName("tut_pickaxe");
	}
	
	
	
	@Override
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {
		if(pass == 0)
		{
			return pickaxe;
			
			
			
			
			
			
			
		}
		else
		{
		if(pass == 1 && stack.hasTagCompound())
		{
			if(stack.stackTagCompound.getBoolean("active") == true)
			{
				System.out.println("test");
				
			return overlay;
			
			}
			
			
			
		}
		}
		
			return pickaxe;
		
	}
	
	
	
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World w, EntityPlayer ep) {
		if(!w.isRemote)
		{
			if(stack.hasTagCompound())
			{
				stack.stackTagCompound.setBoolean("active", !stack.stackTagCompound.getBoolean("active"));
				stack.stackTagCompound.setFloat("miningspeed", Float.MAX_VALUE);
				
			}
			else
			{
				NBTTagCompound tc = new NBTTagCompound();
				tc.setFloat("miningspeed", 1.0F);
				tc.setBoolean("active", true);
				stack.setTagCompound(tc);
			}
		}
		
		return super.onItemRightClick(stack, w, ep);
	}
	
	
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta) {
		
		
			return stack.stackTagCompound.getFloat("miningspeed");
			
			
			
			
			
			
		
	}
	
	
	@Override
	public void registerIcons(IIconRegister i) {
		
		pickaxe = i.registerIcon(Reference.MOD_ID + ":tut_pickaxe");
		overlay = i.registerIcon(Reference.MOD_ID + ":tut_pickaxe_overlay");

	}
	
	@Override
	public int getRenderPasses(int metadata) {
		return 2;
	}
}
