package suoliangao.tweakergui.recipe.minecraft;

import net.minecraft.item.ItemStack;
import suoliangao.tweakergui.item.StackWrapper;
import suoliangao.tweakergui.recipe.BaseRecipe;

public class FurnaceRecipe extends BaseRecipe {

	public static final int ADD = 0;
	public static final int REMOVE = 1;
	public static final int SET_FUEL = 2;
	
	protected StackWrapper input;
	protected StackWrapper fuel;
	protected StackWrapper output;
	protected int fuelBurningTime = 1600;
	protected int xp = 0;
	
	public FurnaceRecipe () {
		input = fuel = output = StackWrapper.EMPTY;
		this.commands.add("addRecipe");
		this.commands.add("remove");
		this.commands.add("setFuel");
	}

	@Override
	public ItemStack getStack(int index) {
		// TODO Auto-generated method stub
		switch (index) {
		case 0:
			return input.getStack();
		case 1:
			return fuel.getStack();
		case 2:
			return output.getStack();
		default:
			return ItemStack.EMPTY;
		}
	}

	@Override
	public void setStack(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		switch (index) {
		case 0:
			input = new StackWrapper(stack);
			break;
		case 1:
			fuel = new StackWrapper(stack);
			break;
		case 2:
			output = new StackWrapper(stack);
			break;
		}
	}
	
	public StackWrapper getStackWrapper (int index) {
		switch (index) {
		case 0:
			return input;
		case 1:
			return fuel;
		case 2:
			return output;
		default:
			return StackWrapper.EMPTY;
		}
	}
	
	public int getBurningTime () {
		return fuelBurningTime;
	}
	
	public void setBurningTime (int time) {
		this.fuelBurningTime = time;
	}
	
	public int getXp () {
		return xp;
	}
	
	public void setXp (int xp) {
		this.xp = xp;
	}
	
	@Override
	protected boolean velidateRecipe() {
		// TODO Auto-generated method stub
		switch (cmdIndex) {
		case ADD:
			return !input.getStack().isEmpty() && !output.getStack().isEmpty();
		case REMOVE:
			return !output.getStack().isEmpty();
		case SET_FUEL:
			return !fuel.getStack().isEmpty() && fuelBurningTime != 0;
		}
		return false;
	}

	@Override
	public String getScript() {
		// TODO Auto-generated method stub
		if (!velidateRecipe ())
			return null;
		String str = "";
		switch (cmdIndex) {
		case ADD:
			str = output.toString(true) + ", " + input.toString();
			if (xp != 0)
				str = str + ", " + xp;
			return String.format("furnace.addRecipe(%s);", str);
		case REMOVE:
			str = output.toString();
			if (!input.getStack().isEmpty())
				str = str + ", " + input.toString();
			return String.format("furnace.remove(%s);", str);
		case SET_FUEL:
			str = fuel.toString() + ", " + fuelBurningTime;
			return String.format("furnace.setFuel(%s);", str);
		}
		return null;
	}
}
