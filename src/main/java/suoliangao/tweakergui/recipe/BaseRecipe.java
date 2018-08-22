package suoliangao.tweakergui.recipe;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import suoliangao.tweakergui.item.StackWrapper;

public abstract class BaseRecipe {
	
	protected List<String> commands = new ArrayList<String> ();
	
	protected int cmdIndex = -1;
	
	public String nextCommand () {
		if (commands.isEmpty())
			return "NO COMMAND!";
		cmdIndex ++;
		cmdIndex %= commands.size();
		return commands.get(cmdIndex);
	}
	
	public String getCommand () {
		if (commands.isEmpty())
			return "NO COMMAND!";
		return commands.get(cmdIndex);
	}
	
	public abstract ItemStack getStack (int index);
	public abstract void setStack (int index, ItemStack stack);
	public abstract StackWrapper getStackWrapper(int index);
	protected abstract boolean velidateRecipe ();
	public abstract String getScript ();
}
