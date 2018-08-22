package suoliangao.tweakergui.inventory.minecraft;

import net.minecraft.item.ItemStack;
import suoliangao.tweakergui.inventory.RecipeMakerInventory;
import suoliangao.tweakergui.recipe.minecraft.FurnaceRecipe;

public class FurnaceInventory extends RecipeMakerInventory {
	
	public FurnaceInventory () {
		this.recipe = new FurnaceRecipe ();
		setTitle ("recipe_maker.furnace");
	}
	
	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO Auto-generated method stub
		return recipe.getStack(index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		recipe.setStack(index, stack);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
