package me.benfah.benfahsmod.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper {

	
	public static float getFloat(String field,ItemStack stack)
	{
		if(stack.hasTagCompound())
		{
			return stack.stackTagCompound.getFloat(field);
		}
		return 0.0F;
	}
	
	public static double getDouble(String field,ItemStack stack)
	{
		if(stack.hasTagCompound())
		{
			return stack.stackTagCompound.getDouble(field);
		}
		return 0.0D;
	}
	
	public static boolean getBoolean(String field,ItemStack stack)
	{
		if(stack.hasTagCompound())
		{
			return stack.stackTagCompound.getBoolean(field);
		}
		return false;
	}
	
	
	public static int getInteger(String field,ItemStack stack)
	{
		if(stack.hasTagCompound())
		{
			return stack.stackTagCompound.getInteger(field);
		}
		return 0;
	}
	
	public static void setFloat(String field,ItemStack stack, float value)
	{
		if(stack.hasTagCompound())
		{
			stack.stackTagCompound.setFloat(field, value);
		}
	}
	
	public static void setDouble(String field,ItemStack stack, double value)
	{
		if(stack.hasTagCompound())
		{
			stack.stackTagCompound.setDouble(field, value);

		}
	}
	
	public static void setBoolean(String field,ItemStack stack, boolean value)
	{
		if(stack.hasTagCompound())
		{
			stack.stackTagCompound.setBoolean(field, value);
		}
	}
	
	
	public static void setInteger(String field,ItemStack stack, int value)
	{
		if(stack.hasTagCompound())
		{
			stack.stackTagCompound.setInteger(field, value);
		}
	}
	
	
	
}
