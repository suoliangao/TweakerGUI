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
import suoliangao.tweakergui.gui.SlotCanHide;
import suoliangao.tweakergui.gui.SlotMark;
import suoliangao.tweakergui.inventory.*;
import suoliangao.tweakergui.inventory.minecraft.InventoryCraftingTable;

public class ContainerCraftingTable extends ContainerRecipeMaker {
	
	public ContainerCraftingTable (InventoryPlayer inventory) {
		super (inventory);
		this.recipeMakerInventory = new InventoryCraftingTable();
		
		for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                this.addSlotToContainer(new SlotMark(recipeMakerInventory, j + i * 3, 30 + j * 18, 17 + i * 18, false));
            }
        }
		
		this.addSlotToContainer(new SlotMark(recipeMakerInventory, 9, 124, 35, true));

        for (int k = 0; k < 3; ++k)
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new SlotCanHide(inventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }

        for (int l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new SlotCanHide(inventory, l, 8 + l * 18, 142));
        }
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
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