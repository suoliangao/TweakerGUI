package suoliangao.tweakergui.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class StackWrapper {
	
	public static final StackWrapper EMPTY = new StackWrapper (ItemStack.EMPTY);
	private ItemStack stack;
	//attributes
	private boolean ignoreMeta;
	private boolean useNbt;
	private int transformDamage;
	private ItemStack returnItem;
	private boolean useOreDictionary;
	private String oreDictionaryName;
	
	
	public StackWrapper (ItemStack stack) {
		this.stack = stack.copy();
	}
	
	//getter
	public ItemStack getStack () {
		return stack;
	}
	
	//setter
	public void setStack (ItemStack stack) {
		this.stack = stack.copy();
	}
	
	public String toString () {
		return toString (false);
	}
	
	public String toString (boolean withCount) {
		if (stack.isEmpty())
			return "null";
		String str = "";
		String itemModid = stack.getItem().getCreatorModId(stack);
		String itemName = stack.getItem().getRegistryName().toString();
		Integer meta = stack.getMetadata();
		str = String.format("<%s:%s>", itemName, meta.toString());
		if (withCount)
			str = str + "*" + stack.getCount();
		return str;
	}
}
