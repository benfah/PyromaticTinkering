package me.benfah.benfahsmod.renderer;

import me.benfah.benfahsmod.blocks.tileentity.TileEntityTinkerTable;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemBlockTinkerTableRenderer implements IItemRenderer{

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		
        new BlockTinkerTableRenderer().renderTileEntityAt(new TileEntityTinkerTable(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}
