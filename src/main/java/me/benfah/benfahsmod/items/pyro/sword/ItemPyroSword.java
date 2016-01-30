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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.IItemRenderer;
import me.benfah.benfahsmod.Reference;
import cofh.api.energy.IEnergyContainerItem;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPyroSword extends ItemSword{
	

	private IIcon sword;
	private IIcon overlay;
	private IIcon fire;

	protected int maxExtract = 50000 * 50;
	protected int maxReceive = 50000;

	protected int capacity = 3200000;
	
	
	public ItemPyroSword(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("pyro_sword");
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
	public int getRenderPasses(int metadata) {
		return 3;
	}
	
	@Override
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
	
	@Override
	public void registerIcons(IIconRegister i) {
		
		this.sword = i.registerIcon(Reference.MOD_ID + ":pyro_sword");	
		this.overlay = i.registerIcon(Reference.MOD_ID + ":" + "overlay_upgrade1");
		this.fire = i.registerIcon(Reference.MOD_ID + ":" + "fire_animation");
		textures.put("overlay_upgrade1", overlay);
		
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass)
    {
		Collection<AttributeModifier> col = stack.getAttributeModifiers().get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName());
		AttributeModifier modifier = col.iterator().next();
		
		if(pass == 0)
		{
			
			return sword;
			
		}
		else
		if(pass == 1 && modifier.getAmount() >= 14D)
		{
			
			return overlay;

		}
		if(pass == 2)
		{
		
			return fire;
			
			
			
		}
		
		return sword;
    }
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase attacker, EntityLivingBase target) {
		System.out.println("test");
		return false;
		
		
		
	}
	
	
	@Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer entityplayer, Entity entity)
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
        			return true;
				}
				else

		return false;
    }





	





	

	






}
