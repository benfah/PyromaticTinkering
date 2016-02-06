package me.benfah.benfahsmod.items.pyro.wand;

import cofh.api.energy.IEnergyContainerItem;
import me.benfah.benfahsmod.Reference;
import me.benfah.benfahsmod.util.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeHooks;

public class ItemPyroToolElectrolyzed extends ItemPyroTool implements IEnergyContainerItem{

	public ItemPyroToolElectrolyzed(ToolMaterial p_i45333_2_) {
		super(p_i45333_2_);
		this.setUnlocalizedName("pyro_tool_electrolyzed");
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
	public float getDigSpeed(ItemStack stack, Block block, int meta) {
		
		
		
		if(NBTHelper.getInteger("Energy", stack) >= 400)
		{

			return super.getDigSpeed(stack, block, meta);
		}
		
		return 1F;
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
	
	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return true;
	}
	
	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		return 1D - ((double)getEnergyStored(stack) / (double)getMaxEnergyStored(stack));
	}
	
	
	
}
