package me.benfah.benfahsmod.items.pyro.pick;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import me.benfah.benfahsmod.Reference;
import me.benfah.benfahsmod.util.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.EnumHelper;

public class ItemPyroPickaxe extends ItemPickaxe{
	
	
	private IIcon pickaxe;
	private IIcon overlay;
	
	public ItemPyroPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		
		this.setUnlocalizedName("pyro_pickaxe");
		
	}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta) {
		
		if (ForgeHooks.isToolEffective(stack, block, meta) == true)
        {
			return NBTHelper.getFloat("miningspeed", stack) +1F;
        }
		return 1.0F;
	}
	
	
	
	private HashMap<String, IIcon> textures = new HashMap<String, IIcon>();
	
	
	
	

	@Override
	public IIcon getIcon(ItemStack stack, int pass)
    {
		
		
			if(pass == 0)
			{
				
				return pickaxe;
				
			}
			else
			
		return pickaxe;
    }
		
	@Override
	public int getRenderPasses(int metadata) {
		return 3;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.rare;
	}
	
	
	@Override
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
	
	@Override
	public void registerIcons(IIconRegister i) {
		
		this.pickaxe = i.registerIcon(Reference.MOD_ID + ":pyro_pickaxe");	
		this.overlay = i.registerIcon(Reference.MOD_ID + ":" + "overlay_upgrade1");
		textures.put("overlay_upgrade1", overlay);
		
	}
}
