package suoliangao.tweakergui.gui.minecraft;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.BossInfo.Color;
import net.minecraftforge.fml.client.config.GuiCheckBox;
import suoliangao.tweakergui.gui.GuiAdvancedItemSetting;
import suoliangao.tweakergui.gui.GuiRecipeMaker;
import suoliangao.tweakergui.gui.RecipeEditMode;
import suoliangao.tweakergui.item.StackWrapper;

public class GuiCraftingTable extends GuiRecipeMaker{
	

	
	public GuiCraftingTable(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		GlStateManager.color(1, 1, 1);
		ResourceLocation texture = new ResourceLocation("minecraft:textures/gui/container/crafting_table.png");
		mc.getTextureManager().bindTexture(texture);
		drawDefaultBackground();
		int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
		drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(this.getContainer().getRecipeMakerInventory().getTitle(), 6, 6, 4210752);
		//drawRect(guiLeft + 3, guiTop + getYSize () / 2 + 3, guiLeft + getXSize() - 3, guiTop + getYSize() - 6, 0xFFC6C6C6);
		switch (getEditMode()) {
		case Basic:
			break;
		case Advanced:
			drawRect(3, getYSize () / 2, getXSize() - 3, getYSize() - 6, 0xFFC6C6C6);
			if(getContainer().getSelectedSlot() != null) {
				this.RenderSlotFrame(getContainer().getSelectedSlot());
				StackWrapper stackWrapper = getContainer().getSelectedSlot().getStackWrapper();
				advancedItemSetting.drawAdvancedItemSetting(stackWrapper);
			}
			break;
		}
	}

	
}
