package suoliangao.tweakergui.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotCanHide extends Slot {

	private boolean isHidden = false;
	
	public SlotCanHide(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return !isHidden;
	}
	
	public void hide () {
		isHidden = true;
	}
	
	public void show () {
		isHidden = false;
	}
}
