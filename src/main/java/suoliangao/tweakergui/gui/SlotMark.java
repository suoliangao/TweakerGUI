package suoliangao.tweakergui.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import suoliangao.tweakergui.inventory.RecipeMakerInventory;
import suoliangao.tweakergui.util.StackUtil;

public class SlotMark extends Slot {

	private int slotIndex;
	private boolean stackable;
	private RecipeEditMode editMode = RecipeEditMode.Basic;
	
	public SlotMark(RecipeMakerInventory inventoryIn, int index, int xPosition, int yPosition, boolean stackable) {
		super(inventoryIn, index, xPosition, yPosition);
		slotIndex = index;
		this.stackable = stackable;
	}
	
	public SlotMark(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		slotIndex = index;
		this.stackable = false;
	}
	
	@Override
	public void putStack(ItemStack stack) {
		if (editMode == RecipeEditMode.Basic) {
			if(!stackable)
				stack.setCount(1);
			inventory.setInventorySlotContents(slotIndex, stack);
		}
	}
	
	public void switchMode (RecipeEditMode mode) {
		editMode = mode;
	}
}
