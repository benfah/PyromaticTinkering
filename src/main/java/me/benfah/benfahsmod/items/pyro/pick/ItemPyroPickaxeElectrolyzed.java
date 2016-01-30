package me.benfah.benfahsmod.items.pyro.pick;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import cofh.api.energy.IEnergyContainerItem;
import me.benfah.benfahsmod.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.EnumHelper;

public class ItemPyroPickaxeElectrolyzed extends ItemPyroPickaxe implements IEnergyContainerItem{

	
	protected int maxExtract = 50000 * 50;
	protected int maxReceive = 50000;

	protected int capacity = 4000000;
	
	
	public ItemPyroPickaxeElectrolyzed(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setUnlocalizedName("pyro_pickaxe_electrolyzed");

	}
	
	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return !(getEnergyStored(stack) == getMaxEnergyStored(stack));
	}
	
	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		return 1D - ((double)getEnergyStored(stack) / (double)getMaxEnergyStored(stack));
	}

	@Override
	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {

		if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
			return 0;
		}
		int energy = container.stackTagCompound.getInteger("Energy");
		int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));

		if (!simulate) {
			energy -= energyExtracted;
			container.stackTagCompound.setInteger("Energy", energy);
		}
		return energyExtracted;
	}





	@Override
	public int getEnergyStored(ItemStack container) {
		if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
			return 0;
		}
		return container.stackTagCompound.getInteger("Energy");
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta) {
		System.out.println(stack.stackTagCompound.getInteger("Energy"));
		if(stack.stackTagCompound.getInteger("Energy") >= 400)
		{
			System.out.println("NHOOHOHOOHO");

			return super.getDigSpeed(stack, block, meta);
		}
		else
		return 1.0F;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x,
			int y, int z, EntityLivingBase blockbreaker) {
		
		
		if(stack.stackTagCompound.getInteger("Energy") >= 400)
		{
			
			stack.stackTagCompound.setInteger("Energy", stack.stackTagCompound.getInteger("Energy") - 400);
			
			
			
		}
		
		
		return super.onBlockDestroyed(stack, world, block, x, y, z, blockbreaker);
	}


	@Override
	public int getMaxEnergyStored(ItemStack arg0) {
		
		return capacity;
	}





	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {

		if (container.stackTagCompound == null) {
			container.stackTagCompound = new NBTTagCompound();
		}
		int energy = container.stackTagCompound.getInteger("Energy");
		int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));

		if (!simulate) {
			energy += energyReceived;
			container.stackTagCompound.setInteger("Energy", energy);
		}
		return energyReceived;
	}
	
}
