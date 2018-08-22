package suoliangao.tweakergui.recipe.minecraft;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import suoliangao.tweakergui.item.StackWrapper;
import suoliangao.tweakergui.recipe.BaseRecipe;

public class CraftingTableRecipe extends BaseRecipe {

	public static final int ADD_SHAPED = 0;
	public static final int ADD_SHAPELESS = 1;
	public static final int REMOVE_SHAPED = 2;
	public static final int REMOVE_SHAPELESS = 3;
	
	private List<StackWrapper> inputs;
	private StackWrapper output;
	
	public CraftingTableRecipe () {
		inputs = NonNullList.<StackWrapper>withSize(9, StackWrapper.EMPTY);
		output = StackWrapper.EMPTY;
		commands.add("addShaped");
		commands.add("addShapeless");
		commands.add("removeShaped");
		commands.add("removeShapeless");
	}
	
	public ItemStack getStack (int index) {
		if (index >= 0 && index < 9)
			return this.inputs.get(index).getStack();
		if (index == 9)
			return this.output.getStack();
		return ItemStack.EMPTY;
	}
	
	public void setStack (int index, ItemStack stack) {
		if (index >= 0 && index < 9)
			this.inputs.set(index, new StackWrapper (stack));
		else if (index == 9)
			this.output.setStack(stack);
	}
	
	public StackWrapper getStackWrapper (int index) {
		if (index >= 0 && index < 9)
			return this.inputs.get(index);
		if (index == 9)
			return this.output;
		return StackWrapper.EMPTY;
	}
	
	@Override
	protected boolean velidateRecipe() {
		// TODO Auto-generated method stub
		boolean velidate = true;
		int i;
		switch (cmdIndex) {
		case ADD_SHAPED:
			i = 0;
			for (StackWrapper sw : inputs) {
				if (sw.getStack().isEmpty())
					i++;
			}
			if (i > 8)
				return false;
			return !output.getStack().isEmpty();
		case ADD_SHAPELESS:
			i = 0;
			for (StackWrapper sw : inputs) {
				if (sw.getStack().isEmpty())
					i++;
			}
			if (i > 8)
				return false;
			return !output.getStack().isEmpty();
		case REMOVE_SHAPED:
			return !output.getStack().isEmpty();
		case REMOVE_SHAPELESS:
			return !output.getStack().isEmpty();
		}
		return velidate;
	}

	@Override
	public String getScript() {
		// TODO Auto-generated method stub
		if (!velidateRecipe ())
			return null;
		String str = "";
		switch (cmdIndex) {
		case ADD_SHAPED:
			System.out.println("Making String");
			str = output.toString(true) + ", \n"
					+ "[[" + inputs.get(0).toString() + ", " + inputs.get(1).toString() + ", " + inputs.get(2).toString() + "]\n"
					+ "[" +  inputs.get(3).toString() + ", " + inputs.get(4).toString() + ", " + inputs.get(5).toString() + "]\n"
					+ "[" + inputs.get(6).toString() + ", " + inputs.get(7).toString() + ", " + inputs.get(8).toString() + "]]";
			return String.format("recipes.addShaped(\"%s\", %s);", "auto_gen_" + str.hashCode(), str);
		case ADD_SHAPELESS:
			List<String> in = new ArrayList<String>();
			for (StackWrapper sw : inputs) {
				if (!sw.getStack().isEmpty())
					in.add(sw.toString());
			}
			str = output.toString(true);
			str = str + ", [";
			for (int i = 0; i < in.size(); i++) {
				str = str + in.get(i);
				if (i < in.size() - 1)
					str = str + ", ";
			}
			str = str + "]";
			return String.format("recipes.addShapeless(\"%s\", %s);", "auto_gen_" + str.hashCode(), str);
		case REMOVE_SHAPED:
			str = output.toString();
			if (!inputs.isEmpty())
				str = str + ", \n"
					+ "[[" + inputs.get(0).toString() + ", " + inputs.get(1).toString() + ", " + inputs.get(2).toString() + "]\n"
					+ "[" +  inputs.get(3).toString() + ", " + inputs.get(4).toString() + ", " + inputs.get(5).toString() + "]\n"
					+ "[" + inputs.get(6).toString() + ", " + inputs.get(7).toString() + ", " + inputs.get(8).toString() + "]]";
			return String.format("recipes.removeShaped(%s);", str);
		case REMOVE_SHAPELESS:
			str = output.toString();
			if (!inputs.isEmpty()) {
				List<String> strs = new ArrayList<String>();
				for (StackWrapper sw : inputs) {
					if (!sw.getStack().isEmpty())
						strs.add(sw.toString());
				}
				str = str + ", [";
				for (int i = 0; i < strs.size(); i++) {
					str = str + strs.get(i);
					if (i < strs.size() - 1)
						str = str + ", ";
				}
				str = str + "]";
			}
			return String.format("recipes.removeShapeless(%s);", str);
		}
		return null;
	}

}
