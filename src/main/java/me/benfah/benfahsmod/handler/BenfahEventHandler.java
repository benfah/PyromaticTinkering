package me.benfah.benfahsmod.handler;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import me.benfah.benfahsmod.init.BenfahsItems;
import me.benfah.benfahsmod.items.pyro.axe.ItemPyroAxe;
import me.benfah.benfahsmod.items.pyro.axe.ItemPyroAxeElectrolyzed;
import me.benfah.benfahsmod.items.pyro.pick.ItemPyroPickaxe;
import me.benfah.benfahsmod.items.pyro.pick.ItemPyroPickaxeElectrolyzed;
import me.benfah.benfahsmod.items.pyro.sword.ItemPyroSword;
import me.benfah.benfahsmod.items.pyro.sword.ItemPyroSwordElectrolyzed;
import me.benfah.benfahsmod.items.pyro.wand.ItemPyroTool;
import me.benfah.benfahsmod.items.pyro.wand.ItemPyroToolElectrolyzed;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class BenfahEventHandler {

	
	
	String l1_s_l;
	String l2_s_l;
	
	String l1_t_l;
	String l2_t_l;

	String l1_p_l;
	String l2_p_l;
	
	String l1_a_l;
	String l2_a_l;


	
	@SubscribeEvent
	public void tooltip(ItemTooltipEvent e)
	{
		translateAllLocalized();
		if(e.itemStack.getItem() instanceof ItemPyroTool)
		{
			shift(e.toolTip);

			
			e.toolTip.add(l1_t_l);
			e.toolTip.add(l2_t_l);

			
			addLSHIFT(e.toolTip);
			if(GuiScreen.isShiftKeyDown())
			{
				shift(e.toolTip);
				e.toolTip.add(writeOnTooltip("Tier", EnumChatFormatting.GOLD, "1"));
				e.toolTip.add(writeOnTooltip("Speed", EnumChatFormatting.GREEN, e.itemStack.stackTagCompound == null ? "1.0" : e.itemStack.stackTagCompound.getInteger("miningspeed")) + ".0");
				if(e.itemStack.getItem() instanceof ItemPyroToolElectrolyzed)
				{
					addEnergy(e.toolTip, e.itemStack);
				}	
			}
		}
		if(e.itemStack.getItem() instanceof ItemPyroPickaxe || e.itemStack.getItem() instanceof ItemPyroPickaxeElectrolyzed)
		{
			shift(e.toolTip);

			e.toolTip.add(l1_p_l);
			e.toolTip.add(l2_p_l);
			addLSHIFT(e.toolTip);
			if(GuiScreen.isShiftKeyDown())
			{
				shift(e.toolTip);

				e.toolTip.add(writeOnTooltip("Tier", EnumChatFormatting.GOLD, "1"));
				e.toolTip.add(writeOnTooltip("Speed", EnumChatFormatting.GREEN, e.itemStack.stackTagCompound == null ? "1.0" : e.itemStack.stackTagCompound.getInteger("miningspeed")) + ".0");
				if(e.itemStack.getItem() instanceof ItemPyroPickaxeElectrolyzed)
				{
					addEnergy(e.toolTip, e.itemStack);
				}	
			}
		}
		if(e.itemStack.getItem() instanceof ItemPyroSword || e.itemStack.getItem() instanceof ItemPyroSwordElectrolyzed)
		{
			shift(e.toolTip);

			
			e.toolTip.add(l1_s_l);
			e.toolTip.add(l2_s_l);
			addLSHIFT(e.toolTip);
			if(GuiScreen.isShiftKeyDown())
			{
			shift(e.toolTip);

			
			if(e.itemStack.getItem() instanceof ItemPyroSwordElectrolyzed)
			addEnergy(e.toolTip, e.itemStack);
		
			
		Collection<AttributeModifier> col = e.itemStack.getAttributeModifiers().get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName());
		AttributeModifier modifier = col.iterator().next();
		if(modifier.getAmount() >= 14D)
		{
			e.toolTip.add(writeOnTooltip("Tier", EnumChatFormatting.GOLD, "2"));
			e.toolTip.add(writeOnTooltip("Range", EnumChatFormatting.GREEN, "3x1x3"));
			if(e.itemStack.getItem() instanceof ItemPyroSwordElectrolyzed)
			{
			addEnergy(e.toolTip, e.itemStack);
			}
		}
		else
		{
			e.toolTip.add(writeOnTooltip("Tier", EnumChatFormatting.GOLD, "1"));
			e.toolTip.add(writeOnTooltip("Range", EnumChatFormatting.GREEN, "1x1x1"));
			
		}
		e.toolTip.add(writeOnTooltip("Attack Damage", EnumChatFormatting.RED, modifier.getAmount()));
			}
		}
		if(e.itemStack.getItem() instanceof ItemPyroAxe)
		{
			shift(e.toolTip);
			e.toolTip.add(l1_a_l);
			e.toolTip.add(l2_a_l);
			addLSHIFT(e.toolTip);
				if(GuiScreen.isShiftKeyDown())
				{
					shift(e.toolTip);

					
				e.toolTip.add(writeOnTooltip("Tier", EnumChatFormatting.GOLD, "1"));
				e.toolTip.add(writeOnTooltip("Speed", EnumChatFormatting.GREEN, e.itemStack.stackTagCompound != null ? e.itemStack.stackTagCompound.getInteger("miningspeed") + ".0" : "1.0") );
				if(e.itemStack.getItem() instanceof ItemPyroAxeElectrolyzed)
				{
					addEnergy(e.toolTip, e.itemStack);
				}
			}
			
		}
	}
	
	public static String writeOnTooltip(String type, EnumChatFormatting color, Object o)
	{
		String res = color + type + ":" + EnumChatFormatting.RESET + " " + EnumChatFormatting.GRAY + o;
		
		
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
	
	public void translateAllLocalized()
	{
		l1_s_l = StatCollector.translateToLocal("item.pyro_sword_detailed_line1.name");
		l2_s_l = StatCollector.translateToLocal("item.pyro_sword_detailed_line2.name");

		l1_t_l = StatCollector.translateToLocal("item.pyro_tool_detailed_line1.name");
		l2_t_l = StatCollector.translateToLocal("item.pyro_tool_detailed_line2.name");

		l1_p_l = StatCollector.translateToLocal("item.pyro_pickaxe_detailed_line1.name");
		l2_p_l = StatCollector.translateToLocal("item.pyro_pickaxe_detailed_line2.name");

		l1_a_l = StatCollector.translateToLocal("item.pyro_axe_detailed_line1.name");
		l2_a_l = StatCollector.translateToLocal("item.pyro_axe_detailed_line2.name");

		
	}
	public void shift(List<String> toolT)
	{
		
		
		String s1 = toolT.get(0);
		toolT.clear();
		toolT.add(s1);
		
	}
	public void addEnergy(List<String> toolT, ItemStack stack)
	{
		toolT.add(writeOnTooltip("Energy", EnumChatFormatting.AQUA, stack.stackTagCompound == null ? "0/3200000 RF" : stack.stackTagCompound.getInteger("Energy") + "/3200000 RF"));
		
	}
	public void addLSHIFT(List<String> toolT)
	{
		toolT.add(EnumChatFormatting.GRAY + "Press" + EnumChatFormatting.ITALIC + EnumChatFormatting.YELLOW + " LSHIFT " + EnumChatFormatting.GRAY + "for more information.");

		
	}
}
