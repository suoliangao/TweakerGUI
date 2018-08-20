package suoliangao.tweakergui.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import suoliangao.tweakergui.inventory.RecipeMakerInventory;
import suoliangao.tweakergui.util.StackUtil;

public abstract class ContainerRecipeMaker extends Container {
	
	protected EntityPlayer player;
	protected RecipeMakerInventory recipeMakerInventory;
	private RecipeEditMode editMode = RecipeEditMode.Basic;
	private SlotMark selectedSlot;
	
	public ContainerRecipeMaker (InventoryPlayer inventory) {
		this.player = inventory.player;
	}
	
	public RecipeMakerInventory getRecipeMakerInventory () {
		return recipeMakerInventory;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
		// TODO Auto-generated method stub
		if(slotId != -999 && slotId != -1 && getSlot(slotId) instanceof SlotMark) {
			switch (editMode) {
			case Basic:
				return onClickBasicMode(slotId, dragType, clickTypeIn, player);
			case Advanced:
				return onClickAdvancedMode(slotId, dragType, clickTypeIn, player);
			}
		}
		return super.slotClick(slotId, dragType, clickTypeIn, player);
	}

	public void switchMode (RecipeEditMode mode) {
		switch (mode) {
		case Basic:
			for (Slot s : inventorySlots) {
				if (s instanceof SlotCanHide)
					((SlotCanHide)s).show();
				if (s instanceof SlotMark)
					((SlotMark)s).switchMode(mode);
			}
			break;
		case Advanced:
			for (Slot s : inventorySlots) {
				if (s instanceof SlotCanHide)
					((SlotCanHide)s).hide();
				if (s instanceof SlotMark)
					((SlotMark)s).switchMode(mode);
			}
			break;
		}
		editMode = mode;
	}
	
	/**
	 * Get the slot selected in the GUI page.
	 */
	public SlotMark getSelectedSlot () {
		return selectedSlot;
	}
	//private methods
	/**
	 * This method contains the click behavior when click the Mark Slot in Basic edit mode.
	 */
	private ItemStack onClickBasicMode (int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
		ItemStack mouseStack = player.inventory.getItemStack().copy();
		if (clickTypeIn == ClickType.PICKUP) {
			if (StackUtil.canMerge(mouseStack, getSlot(slotId).getStack())) {
				Slot slot = getSlot(slotId);
				ItemStack slotStack = slot.getStack().copy();
				int count = slotStack.getCount();
				if (dragType == 0) {
					slotStack.setCount(count + 1);
					if (count < slotStack.getMaxStackSize() - 1)
						slot.putStack(slotStack);
				}
				if (dragType == 1) {
					if (count > 1)
						getSlot(slotId).getStack().setCount(getSlot(slotId).getStack().getCount() - 1);
					else
						slot.putStack(ItemStack.EMPTY);
				}
			} else {
				getSlot(slotId).putStack(mouseStack);
			}
		}
		return ItemStack.EMPTY;
	}
	/**
	 * This method contains the click behavior when click the Mark Slot in Advanced edit mode.
	 */
	private ItemStack onClickAdvancedMode (int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
		selectedSlot = (SlotMark) getSlot(slotId);
		return ItemStack.EMPTY;
	}
}
