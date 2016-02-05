package me.benfah.benfahsmod.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import me.benfah.benfahsmod.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class PyroBar {

	
	
	
	
	@SubscribeEvent
	public void onRenderGameOverlay(RenderGameOverlayEvent e)
	{
		if(!e.isCancelable() && e.type == ElementType.EXPERIENCE)
		{
			Minecraft mc = Minecraft.getMinecraft();
			
			if(!mc.thePlayer.capabilities.isCreativeMode)
			{
				int posX = e.resolution.getScaledWidth() / 2 + 10;
				int posZ = e.resolution.getScaledHeight() - 48;

				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/pyrobar.png"));
				
				mc.ingameGUI.drawTexturedModalRect(posX, posZ, 0, 0, 81, 8);
				mc.ingameGUI.drawTexturedModalRect(posX+1, posZ+1, 0, 0, 50 , 6);

			}
		}
		
		
	}
	
}
