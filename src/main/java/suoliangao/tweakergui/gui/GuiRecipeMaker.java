package suoliangao.tweakergui.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import suoliangao.tweakergui.gui.minecraft.ContainerCraftingTable;

public abstract class GuiRecipeMaker extends GuiContainer{

	public static final int BTN_SWITCH_MODE = 0;
	public static final int BTN_SWITCH_COMMAND = 1;
	public static final int BTN_GENERATE = 2;
	
	protected ContainerRecipeMaker container;
	
	protected GuiButton btnSwitchMode;
	protected GuiButton btnSwitchCommand;
	protected GuiButton btnGenerate;
	
	protected RecipeEditMode editMode = RecipeEditMode.Basic;
	protected String commandName = "NO COMMAND!";
	
	public GuiRecipeMaker(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		container = (ContainerRecipeMaker) inventorySlotsIn;
		// TODO Auto-generated constructor stub
	}
	
	public void switchMode (RecipeEditMode mode) {
		switch (mode) {
		case Basic:
			btnSwitchMode.displayString = I18n.format("btn.basic_mode");
			break;
		case Advanced:
			btnSwitchMode.displayString = I18n.format("btn.advanced_mode");
			break;
		}
		container.switchMode(mode);
		editMode = mode;
	}

	public RecipeEditMode getEditMode () {
		return editMode;
	}
	
	public ContainerRecipeMaker getContainer () {
		return container;
	}
	
	public void RenderSlotFrame (Slot slot) {
		this.drawHorizontalLine(slot.xPos - 2, slot.xPos + 17, slot.yPos - 2, 0xFFFF3333);
		this.drawHorizontalLine(slot.xPos - 2, slot.xPos + 17, slot.yPos + 17, 0xFFFF3333);
		this.drawVerticalLine(slot.xPos - 2, slot.yPos - 2, slot.yPos + 17, 0xFFFF3333);
		this.drawVerticalLine(slot.xPos + 17, slot.yPos - 2, slot.yPos + 17, 0xFFFF3333);
	}
	
	protected void addDefaultButtons () {
		String str = "btn.generate";
		int btnStartX = this.width / 2 - this.getXSize() / 2;
		int btnStartY = this.height / 2 + this.getYSize() / 2;
		btnSwitchMode = new GuiButton(BTN_SWITCH_MODE, btnStartX + 1 * this.getXSize() / 2, this.height / 2 - 23, this.getXSize() / 2 - 6, 20, I18n.format("btn.basic_mode"));
		btnSwitchCommand = new GuiButton(BTN_SWITCH_COMMAND, btnStartX + 0 * this.getXSize() / 2, btnStartY + 3, this.getXSize() / 2, 20, getContainer().getRecipeMakerInventory().getRecipe().nextCommand());
		btnGenerate = new GuiButton(BTN_GENERATE, btnStartX + this.getXSize() / 2, btnStartY + 3, this.getXSize() / 2, 20, I18n.format(str));
		this.addButton(btnSwitchMode);
		this.addButton(btnSwitchCommand);
		this.addButton(btnGenerate);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		// TODO Auto-generated method stub
		switch(button.id) {
		case BTN_SWITCH_MODE: //Edit Mode
			switch (editMode) {
			case Basic:
				switchMode(RecipeEditMode.Advanced);
				break;
			case Advanced:
				switchMode(RecipeEditMode.Basic);
				break;
			}
			break;
		case BTN_SWITCH_COMMAND:
			button.displayString = getContainer().getRecipeMakerInventory().getRecipe().nextCommand();
			break;
		case BTN_GENERATE:
			String command = getContainer().getRecipeMakerInventory().getRecipe().getScript();
			if (command == null) {
				this.getContainer().player.sendMessage(new TextComponentString(I18n.format("msg.generate_fail")));
			} else {
				Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
				Transferable text = new StringSelection(command);
				cb.setContents(text, null);
				this.getContainer().player.sendMessage(new TextComponentString(I18n.format("msg.generate_success")));
			}
			break;
					
		}
	}
}
