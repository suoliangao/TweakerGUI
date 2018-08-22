package suoliangao.tweakergui.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import suoliangao.tweakergui.item.StackWrapper;

public class GuiAdvancedItemSetting extends GuiScreen {
	
	StackWrapper stackWrapper = StackWrapper.EMPTY;
	
	private int x, y, width, height;
	
	public GuiAdvancedItemSetting (RenderItem itemRender, FontRenderer fontRenderer, int x, int y, int width, int height) {
		this.itemRender = itemRender;
		this.fontRenderer = fontRenderer;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		// TODO Auto-generated method stub
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	public void drawAdvancedItemSetting (StackWrapper stackWrapperIn) {
		ItemStack stack = stackWrapperIn.getStack().copy();
		stack.setCount(1);
        RenderHelper.enableGUIStandardItemLighting();
		this.itemRender.renderItemAndEffectIntoGUI (stack, x + 5, y + 5);
		String str = I18n.format("txt.unfinished_function");
		this.fontRenderer.drawString(str, (width - x) / 2 - this.fontRenderer.getStringWidth(str) / 2, height / 4 * 3, 0xFFFF3333);
	}
	
}
