package suoliangao.tweakergui.recipe;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import suoliangao.tweakergui.util.StackWarpper;

public abstract class BaseRecipe {
	
	protected List<String> commands = new ArrayList<String> ();
	protected List<StackWarpper> inputs;
	protected List<StackWarpper> outputs;
	
	protected int cmdIndex = -1;
	
	public List<StackWarpper> getInputs () {
		return inputs;
	}
	
	public List<StackWarpper> getOutputs () {
		return outputs;
	}
	
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
	protected abstract boolean velidateRecipe ();
	public abstract String getScript ();
	public abstract ItemStack getStack (int index);
	public abstract void setStack (int index, ItemStack stack);
	
	
}
