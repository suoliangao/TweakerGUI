package suoliangao.tweakergui.inventory.minecraft;

import net.minecraft.item.ItemStack;
import suoliangao.tweakergui.inventory.RecipeMakerInventory;
import suoliangao.tweakergui.recipe.BaseRecipe;
import suoliangao.tweakergui.recipe.minecraft.CraftingTableRecipe;

public class InventoryCraftingTable extends RecipeMakerInventory {
	
	public InventoryCraftingTable () {
		this.recipe = new CraftingTableRecipe ();
		setTitle ("recipe_maker.crafting_table");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO Auto-generated method stub
		return recipe.getStack(index);
	}
	
	
	
}
