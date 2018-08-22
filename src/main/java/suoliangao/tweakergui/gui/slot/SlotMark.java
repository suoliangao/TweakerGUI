package suoliangao.tweakergui.gui.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import suoliangao.tweakergui.gui.RecipeEditMode;
import suoliangao.tweakergui.inventory.RecipeMakerInventory;
import suoliangao.tweakergui.item.StackWrapper;
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

	public StackWrapper getStackWrapper() {
		// TODO Auto-generated method stub
		return ((RecipeMakerInventory)this.inventory).getStackWrapper (slotIndex);
	}
}
