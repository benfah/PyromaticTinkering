package me.benfah.benfahsmod.items.pyro.axe;

import cofh.api.energy.IEnergyContainerItem;
import scala.reflect.internal.Trees.Super;
import me.benfah.benfahsmod.BenfahsMod;
import me.benfah.benfahsmod.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ItemPyroAxeElectrolyzed extends ItemPyroAxe implements IEnergyContainerItem{

	
	
	
	protected int maxExtract = 50000 * 50;
	protected int maxReceive = 50000;

	protected int capacity = 4000000;
	
	
	public ItemPyroAxeElectrolyzed(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);
		this.setUnlocalizedName("pyro_axe_electrolyzed");
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
	public float getDigSpeed(ItemStack stack, Block block, int meta) {
		
		
		if(stack.stackTagCompound != null)
		{
		if(stack.stackTagCompound.getInteger("Energy") >= 400)
		{
			System.out.println("DAKNFEIG?)V");

			return super.getDigSpeed(stack, block, meta);
		}
		}
		return 1.0F;
	}
	

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x,
			int y, int z, EntityLivingBase blockbreaker) {
		
		if(stack.stackTagCompound != null)
		if(stack.stackTagCompound.getInteger("Energy") >= 400)
		{
			
			stack.stackTagCompound.setInteger("Energy", stack.stackTagCompound.getInteger("Energy") - 400);
			
			
			
		}
		
		
		return super.onBlockDestroyed(stack, world, block, x, y, z, blockbreaker);
	}
	@Override
	public int getEnergyStored(ItemStack container) {
		if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
			return 0;
		}
		return container.stackTagCompound.getInteger("Energy");
	}

	



	@Override
	public int getMaxEnergyStored(ItemStack arg0) {
		
		return capacity;
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