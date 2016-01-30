package me.benfah.benfahsmod.items;

import io.netty.buffer.Unpooled;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.benfah.benfahsmod.BenfahTab;
import me.benfah.benfahsmod.BenfahsMod;
import me.benfah.benfahsmod.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemTest extends Item{
    public static Item instance;
	private float weaponDamage;
	private HashMap<String, IIcon> textures = new HashMap<String, IIcon>();
	public ItemTest() {
		this.setCreativeTab(BenfahsMod.tabBenfah);
		this.setUnlocalizedName("test_item2");
		this.setTextureName(Reference.MOD_ID + ":test_item2");
	}
	
	
  
   
	@SideOnly(Side.CLIENT)
	@Override
    public void registerIcons(IIconRegister iconReg)
    {
		
			
			IIcon tex = iconReg.registerIcon("benfahsmod:coord_cache");
			textures.put("overlay_upgrade1", tex);
    }
	
	@Override
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
	
	
	
	
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(ItemStack stack, int pass)
    {
		IIcon i = itemIcon;
		if(pass == 0) {
			if(stack.stackTagCompound == null) {
				return itemIcon;
			}
			i = (IIcon) textures.get(stack.stackTagCompound.getString("icon").toLowerCase());
			if(i == null) {
				i = itemIcon;
			}
		}
		else {
			if(stack.stackTagCompound == null) {
				return (IIcon) textures.get("overlay_upgrade1");
			}
			i = (IIcon) textures.get("overlay_"+stack.stackTagCompound.getString("icon").toLowerCase());
			if(i == null) {
				i = (IIcon) textures.get("overlay_upgrade1");
			}
		}
		return i;
    }
	
	@Override
	public int getMaxDamage(ItemStack stack)
    {
		float base = 1;
		if(stack.stackTagCompound != null) {
			base = (stack.stackTagCompound.getInteger("material") / 2);
			if(base == 2) {
				base += 5;
			}
			else {
				base += 7.5;
			}		
		}
		return (int) (Math.pow(2, base)-1);
    }



	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		par1ItemStack.getTagCompound().setString("icon", " overlay_upgrade1");
		
		
		
        return false;
    }
 
	
     
	
    
	
	
	

	

    

	
	
	@Override
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
    	
    }
    
	
    

  
    
   


}