package me.benfah.benfahsmod.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import me.benfah.benfahsmod.init.BenfahsItems;
import me.benfah.benfahsmod.items.pyro.axe.ItemPyroAxe;
import me.benfah.benfahsmod.items.pyro.axe.ItemPyroAxeElectrolyzed;
import me.benfah.benfahsmod.items.pyro.pick.ItemPyroPickaxe;
import me.benfah.benfahsmod.items.pyro.pick.ItemPyroPickaxeElectrolyzed;
import me.benfah.benfahsmod.items.pyro.sword.ItemPyroSword;
import me.benfah.benfahsmod.items.pyro.sword.ItemPyroSwordElectrolyzed;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BenfahEventHandler {

	
	
	
	
	
	@SubscribeEvent
	public void tooltip(ItemTooltipEvent e)
	{
		if(e.itemStack.getItem() instanceof ItemPyroPickaxe || e.itemStack.getItem() instanceof ItemPyroPickaxeElectrolyzed)
		{
			e.toolTip.add("A fast pickaxe, if you upgrade it with an anvil");
			e.toolTip.add("and an Orb of Sharpness.");
			e.toolTip.add(EnumChatFormatting.GRAY + "Press" + EnumChatFormatting.ITALIC + EnumChatFormatting.YELLOW + " LSHIFT " + EnumChatFormatting.GRAY + "for more information.");
			if(GuiScreen.isShiftKeyDown())
			{
				e.toolTip.remove(2);
				e.toolTip.remove(4);	
				e.toolTip.add(writeOnTooltip("Tier", EnumChatFormatting.GOLD, "1"));
				e.toolTip.add(writeOnTooltip("Speed", EnumChatFormatting.GREEN, e.itemStack.stackTagCompound == null ? "1.0" : e.itemStack.stackTagCompound.getInteger("miningspeed")) + ".0");
				if(e.itemStack.getItem() instanceof ItemPyroPickaxeElectrolyzed)
				{
					e.toolTip.add(writeOnTooltip("Energy", EnumChatFormatting.AQUA, e.itemStack.stackTagCompound == null ? "0/3200000 RF" : e.itemStack.stackTagCompound.getInteger("Energy") + "/3200000 RF"));
				}	
			}
			else
			e.toolTip.remove(2);
		}
		if(e.itemStack.getItem() instanceof ItemPyroSword || e.itemStack.getItem() instanceof ItemPyroSwordElectrolyzed)
		{
			e.toolTip.add("Just a sword, but a pyromatic one!");
			e.toolTip.add("Put it in an anvil with an Orb of Sharpness.");
			e.toolTip.add("");
			e.toolTip.add(EnumChatFormatting.GRAY + "Press" + EnumChatFormatting.ITALIC + EnumChatFormatting.YELLOW + " LSHIFT " + EnumChatFormatting.GRAY + "for more information.");
			if(GuiScreen.isShiftKeyDown())
			{
				e.toolTip.remove(2);
			e.toolTip.add(writeOnTooltip("Tier", EnumChatFormatting.GOLD, "1"));
			e.toolTip.remove(5);
			e.toolTip.add(writeOnTooltip("Range", EnumChatFormatting.GREEN, "1x1x1"));
			if(e.itemStack.getItem() instanceof ItemPyroSwordElectrolyzed)
			e.toolTip.add(writeOnTooltip("Energy", EnumChatFormatting.AQUA, e.itemStack.stackTagCompound == null ? "0/3200000 RF" : e.itemStack.stackTagCompound.getInteger("Energy") + "/3200000 RF"));
		Collection<AttributeModifier> col = e.itemStack.getAttributeModifiers().get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName());
		AttributeModifier modifier = col.iterator().next();
		if(modifier.getAmount() >= 14D)
		{
			e.toolTip.remove(5);
			e.toolTip.remove(5);
			e.toolTip.add("");
			e.toolTip.add(writeOnTooltip("Tier", EnumChatFormatting.GOLD, "2"));
			e.toolTip.remove(4);
			e.toolTip.add(writeOnTooltip("Range", EnumChatFormatting.GREEN, "3x1x3"));
			if(e.itemStack.getItem() instanceof ItemPyroSwordElectrolyzed)
			{
			e.toolTip.remove(4);
			e.toolTip.add(writeOnTooltip("Energy", EnumChatFormatting.AQUA, e.itemStack.stackTagCompound == null ? "0/3200000 RF" : e.itemStack.stackTagCompound.getInteger("Energy") + "/3200000 RF"));
			}
		}
		e.toolTip.add(writeOnTooltip("Attack Damage", EnumChatFormatting.RED, modifier.getAmount()));
			}
			else
				e.toolTip.remove(2);
		}
		if(e.itemStack.getItem() instanceof ItemPyroAxe)
		{
			e.toolTip.add("Chop trees faster with the Pyromatic Axe!");
			e.toolTip.add("(If you upgrade it)");
			e.toolTip.add("");
			e.toolTip.add(EnumChatFormatting.GRAY + "Press" + EnumChatFormatting.ITALIC + EnumChatFormatting.YELLOW + " LSHIFT " + EnumChatFormatting.GRAY + "for more information.");
				if(GuiScreen.isShiftKeyDown())
				{
					e.toolTip.remove(2);
				e.toolTip.add(writeOnTooltip("Tier", EnumChatFormatting.GOLD, "1"));
				e.toolTip.remove(5);
				e.toolTip.add(writeOnTooltip("Range", EnumChatFormatting.GREEN, "1x1x1"));
				e.toolTip.add(writeOnTooltip("Speed", EnumChatFormatting.RED, e.itemStack.stackTagCompound != null ? e.itemStack.stackTagCompound.getInteger("miningspeed") + ".0" : "1.0") );
				if(e.itemStack.getItem() instanceof ItemPyroAxeElectrolyzed)
				{
					e.toolTip.add(writeOnTooltip("Energy", EnumChatFormatting.AQUA, e.itemStack.stackTagCompound == null ? "0/3200000 RF" : e.itemStack.stackTagCompound.getInteger("Energy") + "/3200000 RF"));
				}
			}
			else
				e.toolTip.remove(2);
		}
	}
	
	public static String writeOnTooltip(String type, EnumChatFormatting color, Object o)
	{
		String res = color + "" + EnumChatFormatting.UNDERLINE + type + ":" + EnumChatFormatting.RESET + " " + EnumChatFormatting.GRAY + EnumChatFormatting.BOLD.toString() + o;
		
		
		return res;
		
		
		
	}
	
	@SubscribeEvent
	public void deathEvent(LivingDeathEvent e)
	{


		if(e.entityLiving.isBurning() && !e.entityLiving.worldObj.isRemote)
		{
			
			Random ran = new Random();
			
			float f = ran.nextFloat();
			
			
			
			System.out.println(f);
			
			if(f <= 0.1)
			{
				
				EntityItem ei = new EntityItem(e.entity.worldObj, e.entityLiving.lastTickPosX, e.entityLiving.lastTickPosY, e.entityLiving.lastTickPosZ, new ItemStack(BenfahsItems.pyro_gem));
				ei.fireResistance = 9999;
				ei.setFire(0);
				e.entityLiving.worldObj.spawnEntityInWorld(ei);

			}
			if(f >= 0.1)
			{
			}
			
		}
		
	}
	
	
}
