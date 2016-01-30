package me.benfah.benfahsmod.handler;

import me.benfah.benfahsmod.init.BenfahsItems;
import me.benfah.benfahsmod.items.pyro.sword.ItemPyroSword;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.Collection;
import java.util.UUID;

import com.google.common.collect.Multimap;

public class SwordUpgrades {
	public final static UUID MODIFIER_UUID = UUID.fromString("294093da-54f0-4c1b-9dbb-13b77534a84c");

	
	public static ItemStack upgradeSword(ItemSword item, AttributeModifier oldAtMo, float damage, int upgradeStackSize) {
		
		
		ItemStack istack = new ItemStack(item);
		
		
		
		
		AttributeModifier attackModifier = new AttributeModifier(MODIFIER_UUID, "Weapon Upgrade", (2*upgradeStackSize) + oldAtMo.getAmount(), 0);
		
		NBTTagCompound modifierNBT = writeAM(SharedMonsterAttributes.attackDamage, attackModifier);
		
		
		NBTTagCompound stackTagCompound = new NBTTagCompound();
		NBTTagList list = new NBTTagList();
		list.appendTag(modifierNBT);
		stackTagCompound.setTag("AttributeModifiers", list);

		
		ItemStack stack = new ItemStack(item);
		
		stack.setTagCompound(stackTagCompound);
		
		Collection<AttributeModifier> col = stack.getAttributeModifiers().get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName());
		AttributeModifier modifier = col.iterator().next();
		
		
		return stack;
		
	}

	private static NBTTagCompound writeAM(IAttribute attribute, AttributeModifier modifier) {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setString("AttributeName", attribute.getAttributeUnlocalizedName());
		nbttagcompound.setString("Name", modifier.getName());
		nbttagcompound.setDouble("Amount", modifier.getAmount());
		nbttagcompound.setInteger("Operation", modifier.getOperation());
		nbttagcompound.setLong("UUIDMost", modifier.getID().getMostSignificantBits());
		nbttagcompound.setLong("UUIDLeast", modifier.getID().getLeastSignificantBits());
		return nbttagcompound;
	}
}