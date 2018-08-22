package suoliangao.tweakergui.gui.minecraft;

import net.minecraft.entity.player.InventoryPlayer;
import suoliangao.tweakergui.gui.ContainerRecipeMaker;
import suoliangao.tweakergui.gui.slot.SlotMark;
import suoliangao.tweakergui.inventory.minecraft.FurnaceInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;

public class ContainerFurnace extends ContainerRecipeMaker {

	
	
	public ContainerFurnace(InventoryPlayer inventory) {
		super(inventory);
		// TODO Auto-generated constructor stub
		this.recipeMakerInventory = new FurnaceInventory();
		this.addSlotToContainer(new SlotMark(recipeMakerInventory, 0, 56, 17));
	    this.addSlotToContainer(new SlotMark(recipeMakerInventory, 1, 56, 53));
	    this.addSlotToContainer(new SlotMark(recipeMakerInventory, 2, 116, 35, true));
	    
		this.addPlayerInventorySlots();
	}

}
