package me.benfah.benfahsmod.handler;

import java.util.Collection;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import me.benfah.benfahsmod.init.BenfahsItems;
import me.benfah.benfahsmod.items.ItemUpgrade;
import me.benfah.benfahsmod.items.pyro.axe.ItemPyroAxe;
import me.benfah.benfahsmod.items.pyro.pick.ItemPyroPickaxe;
import me.benfah.benfahsmod.items.pyro.sword.ItemPyroSword;
import me.benfah.benfahsmod.items.pyro.sword.ItemPyroSwordElectrolyzed;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.AnvilUpdateEvent;

public class RecipeManager {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	  @SubscribeEvent
	  public void handleAnvilEvent(AnvilUpdateEvent evt) {
	    if(evt.left == null || evt.right == null) {
	        return;
  	    }
	    
	    if(evt.left.getItem() instanceof ItemPyroSword || evt.left.getItem() instanceof ItemPyroSwordElectrolyzed && evt.right.getItem() instanceof ItemUpgrade)
	    {
	    	
	    	
	    	handleUpgrade(evt);
	    }
	    
	    if(evt.left.getItem() instanceof ItemPyroPickaxe && evt.right.getItem() instanceof ItemUpgrade)
	    {
	    	
	    	handlePickaxeUpgrade(evt);
	    	
	    	
	    	
	    }
	    if(evt.left.getItem() instanceof ItemPyroAxe)
	    {
	    	
	    	
	    	
	    	handleAxeUpgrade(evt);
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
	}
	
	
	private void handleAxeUpgrade(AnvilUpdateEvent evt)
	{
		
		
		
		ItemStack axe = evt.left.copy();
	 	
		
		
		System.out.println("hi");

        
        
		
		
		NBTTagCompound tagCompound = (NBTTagCompound) (axe.stackTagCompound == null ? new NBTTagCompound() : axe.stackTagCompound.copy());
		
		
		tagCompound.setInteger("miningspeed", tagCompound.hasKey("miningspeed") ? tagCompound.getInteger("miningspeed") + (5 * evt.right.stackSize) : 1 + 5);
		
		axe.setTagCompound(tagCompound);
		
        evt.output = axe;
        
        evt.cost = 3;
        return;
		
		
		
		
		
		
		
		
		
	}
	
	private void handleUpgrade(AnvilUpdateEvent evt) {
	    
		
		
		
		Collection<AttributeModifier> col = evt.left.getAttributeModifiers().get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName());
		AttributeModifier modifier = col.iterator().next();
		
		 ItemStack res = SwordUpgrades.upgradeSword((ItemSword) evt.left.getItem(), modifier, 2, evt.right.stackSize);
	
		 
		
		
		
			System.out.println("hi");

	        
	        
		 
			
			NBTTagCompound tagCompound = res.getTagCompound();
			if(evt.left.getItem() instanceof ItemPyroSwordElectrolyzed)
			tagCompound.setInteger("Energy", evt.left.stackTagCompound == null ? 0 : evt.left.stackTagCompound.getInteger("Energy"));
			
			tagCompound.setString("icon", "overlay_upgrade1");
			
			res.setTagCompound(tagCompound);

	        evt.output = res;
	        
	        evt.cost = 3;
	        return;
	      
	    
	  }
	
	private void handlePickaxeUpgrade(AnvilUpdateEvent evt)
	{
	
		 	ItemStack pick = evt.left.copy();
		 	
		
		
			System.out.println("hi");

	        
	        
			
			
			NBTTagCompound tagCompound = (NBTTagCompound) (pick.stackTagCompound == null ? new NBTTagCompound() : pick.stackTagCompound.copy());
			
			
			tagCompound.setInteger("miningspeed", tagCompound.hasKey("miningspeed") ? tagCompound.getInteger("miningspeed") + (5 * evt.right.stackSize) : 1 + 5);
			
			pick.setTagCompound(tagCompound);
			
	        evt.output = pick;
	        
	        evt.cost = 3;
	        return;
	}
	
	
}
