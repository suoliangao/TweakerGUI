package suoliangao.tweakergui.gui.minecraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import suoliangao.tweakergui.gui.ContainerRecipeMaker;
import suoliangao.tweakergui.gui.slot.SlotCanHide;
import suoliangao.tweakergui.gui.slot.SlotMark;
import suoliangao.tweakergui.inventory.*;
import suoliangao.tweakergui.inventory.minecraft.CraftingTableInventory;

public class ContainerCraftingTable extends ContainerRecipeMaker {
	
	public ContainerCraftingTable (InventoryPlayer inventory) {
		super (inventory);
		this.recipeMakerInventory = new CraftingTableInventory();
		
		for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                this.addSlotToContainer(new SlotMark(recipeMakerInventory, j + i * 3, 30 + j * 18, 17 + i * 18, false));
            }
        }
		this.addSlotToContainer(new SlotMark(recipeMakerInventory, 9, 124, 35, true));
		this.addPlayerInventorySlots();
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		// TODO Auto-generated method stub
		System.out.println("transferStackInSlot(" + playerIn.getName() + ", " + index + ")");
		return ItemStack.EMPTY;
	}
}

class MySlot extends Slot {

	public int slotIndex;
	
	public MySlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		slotIndex = index;
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public boolean canTakeStack(EntityPlayer player) {
		System.out.println("Issued canTakeStack");
		isItemValid(ItemStack.EMPTY);
		return false;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		System.out.println("Issued isItemValid");
		ItemStack s = stack.copy();
		if(stack.isEmpty())
			inventory.decrStackSize(slotIndex, inventory.getStackInSlot(slotIndex).getCount());
		else
			inventory.setInventorySlotContents(this.slotIndex, s);
		onSlotChanged();
		return false;
	}
	
	
}