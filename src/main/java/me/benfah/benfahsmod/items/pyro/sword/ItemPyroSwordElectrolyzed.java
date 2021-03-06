package me.benfah.benfahsmod.items.pyro.sword;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;













import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.IItemRenderer;
import me.benfah.benfahsmod.Reference;
import me.benfah.benfahsmod.util.NBTHelper;
import cofh.api.energy.IEnergyContainerItem;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPyroSwordElectrolyzed extends ItemPyroSword implements IEnergyContainerItem{
	

	

	protected int maxExtract = 50000 * 50;
	protected int maxReceive = 50000;

	protected int capacity = 4000000;
	
	
	public ItemPyroSwordElectrolyzed(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("pyro_sword_electrolyzed");
		//this.setTextureName(Reference.MOD_ID + ":pyro_sword");
	}

	
	
	
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
	
	}

	 
	
	
	private HashMap<String, IIcon> textures = new HashMap<String, IIcon>();
	
	
	


	
		
		
	
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
	public boolean hitEntity(ItemStack stack, EntityLivingBase attacker, EntityLivingBase target) {
		System.out.println("test");
		return false;
		
		
		
	}
	
	
	@Override
    public boolean onLeftClickEntity (ItemStack stack, EntityPlayer entityplayer, Entity entity)
    {
		
		
		
			if(NBTHelper.getInteger("Energy", stack) >= 400)
			{
				
				Collection<AttributeModifier> col = stack.getAttributeModifiers().get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName());
				AttributeModifier modifier = col.iterator().next();
		
				if(modifier.getAmount() >= 14)
				{
			entity.setFire(20);
        AxisAlignedBB box = AxisAlignedBB.getBoundingBox(entity.posX, entity.posY, entity.posZ, entity.posX + 1.0D, entity.posY + 1.0D, entity.posZ + 1.0D).expand(1.0D, 1.0D, 1.0D);
        List list = entityplayer.worldObj.getEntitiesWithinAABBExcludingEntity(entityplayer, box);
        			for (Object o : list)
        			{
            ((Entity)o).attackEntityFrom(DamageSource.magic, (float) ((float) modifier.getAmount()*1.5/list.size()));
            
            double d = ((Entity)o).posX - entityplayer.posX;
			double d1;
							for(d1 = ((Entity)o).posZ - entityplayer.posZ; d * d + d1 * d1 < 0.0001D; d1 = (Math.random() - Math.random()) * 0.01D)
							{
								d = (Math.random() - Math.random()) * 0.01D;
							}
		
			((Entity)o).isAirBorne = true;
			float f = MathHelper.sqrt_double(d * d + d1 * d1);
			float f1 = 0.4F;
			((Entity)o).motionX /= 2D;
			((Entity)o).motionY /= 2D;
			((Entity)o).motionZ /= 2D;
			((Entity)o).motionX += (d / (double)f) * (double)f1 * 2;
			((Entity)o).motionY += 0.40000000596046448D;
			((Entity)o).motionZ += (d1 / (double)f) * (double)f1 * 2;
								if(((Entity)o).motionY > 0.40000000596046448D)
								{
									((Entity)o).motionY = 0.40000000596046448D;
								}
        			}
					NBTHelper.setInteger("Energy",stack, NBTHelper.getInteger("Energy", stack)-400*list.size());
        			return true;
				}
				else
					NBTHelper.setInteger("Energy",stack, NBTHelper.getInteger("Energy", stack)-400);

			}
			else
				return true;
		
		
		return false;
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
	
	@Override
	public void registerIcons(IIconRegister i) {
		super.registerIcons(i);
		sword = i.registerIcon(Reference.MOD_ID + ":electrolyzed_pyro_sword");
		
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
