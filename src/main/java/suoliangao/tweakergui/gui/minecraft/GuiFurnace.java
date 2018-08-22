package suoliangao.tweakergui.gui.minecraft;

import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import suoliangao.tweakergui.gui.GuiRecipeMaker;
import suoliangao.tweakergui.gui.textfield.NumberTextField;
import suoliangao.tweakergui.item.StackWrapper;
import suoliangao.tweakergui.recipe.minecraft.FurnaceRecipe;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCommandBlock;

public class GuiFurnace extends GuiRecipeMaker {

	private GuiTextField txtBurningTime;
	private GuiTextField txtXp;
	
	String str = "1600";
	
	public GuiFurnace(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initGui() {
		// TODO Auto-generated method stub
		super.initGui();
		this.txtBurningTime = new NumberTextField(0, this.fontRenderer, 10, 56, 40, 12);
        this.txtBurningTime.setMaxStringLength(10);
        this.txtBurningTime.setText(((FurnaceRecipe)this.getContainer().getRecipeMakerInventory().getRecipe()).getBurningTime() + "");
        this.txtXp = new NumberTextField(1, this.fontRenderer, 115, 15, 40, 12);
        this.txtXp.setMaxStringLength(10);
        this.txtXp.setText(((FurnaceRecipe)this.getContainer().getRecipeMakerInventory().getRecipe()).getXp() + "");
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		GlStateManager.color(1, 1, 1);
		ResourceLocation texture = new ResourceLocation("minecraft:textures/gui/container/furnace.png");
		mc.getTextureManager().bindTexture(texture);
		drawDefaultBackground();
		int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
		drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		String str = I18n.format("txt.fuel_burning_time");
		this.fontRenderer.drawString(str, 10, 72, 0x404040);
		this.txtBurningTime.drawTextBox();
		str = I18n.format("txt.furnace_xp");
		this.fontRenderer.drawString(str, 115 - this.fontRenderer.getStringWidth(str) - 3, 16, 0x404040);
		this.txtXp.drawTextBox();
		
		this.fontRenderer.drawString(this.getContainer().getRecipeMakerInventory().getTitle(), 6, 6, 4210752);
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

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		// TODO Auto-generated method stub
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		// TODO Auto-generated method stub
		super.mouseClicked(mouseX, mouseY, mouseButton);
		this.txtBurningTime.mouseClicked(mouseX - this.getGuiLeft(), mouseY - this.getGuiTop(), mouseButton);
		this.txtXp.mouseClicked(mouseX - this.getGuiLeft(), mouseY - this.getGuiTop(), mouseButton);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		// TODO Auto-generated method stub
		super.keyTyped(typedChar, keyCode);
		System.out.println(typedChar + " : " + keyCode);
		if (txtBurningTime.textboxKeyTyped(typedChar, keyCode)) {
			if (txtBurningTime.getText().isEmpty())
				txtBurningTime.setText("0");
			((FurnaceRecipe)this.getContainer().getRecipeMakerInventory().getRecipe()).setBurningTime(Integer.parseInt(txtBurningTime.getText()));
		}
		if (txtXp.textboxKeyTyped(typedChar, keyCode)) {
			if (txtXp.getText().isEmpty())
				txtXp.setText("0");
			((FurnaceRecipe)this.getContainer().getRecipeMakerInventory().getRecipe()).setXp(Integer.parseInt(txtXp.getText()));
		}
	}
}
