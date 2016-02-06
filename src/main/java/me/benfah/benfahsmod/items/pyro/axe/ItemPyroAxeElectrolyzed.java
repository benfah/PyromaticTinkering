package me.benfah.benfahsmod.items.pyro.axe;

import cofh.api.energy.IEnergyContainerItem;
import me.benfah.benfahsmod.Reference;
import me.benfah.benfahsmod.util.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemPyroAxeElectrolyzed extends ItemPyroAxe implements IEnergyContainerItem{

	
	
	
	protected int maxExtract = 50000 * 50;
	protected int maxReceive = 50000;

	protected int capacity = 4000000;
	
	
	public ItemPyroAxeElectrolyzed(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);
		this.setUnlocalizedName("pyro_axe_electrolyzed");
	}
	
	
	
	

	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta) {
		
		
		
		if(NBTHelper.getInteger("Energy", stack) >= 400)
		{
			System.out.println("DAKNFEIG?)V");

			return super.getDigSpeed(stack, block, meta);
		}
		
		return 0.5F;
	}
	

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x,
			int y, int z, EntityLivingBase blockbreaker) {
		
		
		if(NBTHelper.getInteger("Energy", stack) >= 400)
		{
			
			stack.stackTagCompound.setInteger("Energy", stack.stackTagCompound.getInteger("Energy") - 400);
			
			
			
		}
		
		
		return super.onBlockDestroyed(stack, world, block, x, y, z, blockbreaker);
	}
	

	



	

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return true;
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
		int energyExtracted = Math.min(energy, Math.min(Reference.MAX_EXTRACT_PYRO, maxExtract));

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
	public int getMaxEnergyStored(ItemStack arg0) {
		
		return Reference.CAPACITY_PYRO;
		
	}

	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {

		if (container.stackTagCompound == null) {
			container.stackTagCompound = new NBTTagCompound();
		}
		int energy = container.stackTagCompound.getInteger("Energy");
		int energyReceived = Math.min(Reference.CAPACITY_PYRO - energy, Math.min(Reference.MAX_RECEIVE_PYRO, maxReceive));

		if (!simulate) {
			energy += energyReceived;
			container.stackTagCompound.setInteger("Energy", energy);
		}
		return energyReceived;
	}


	
	
}
