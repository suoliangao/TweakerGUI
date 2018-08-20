package suoliangao.tweakergui.util;

import net.minecraft.item.ItemStack;

public class StackUtil {
	
	/**
	 * 
	 * @param stack1
	 * @param stack2
	 * @return returns true if 
	 */
	public static boolean isStackItemEqual (ItemStack stack1, ItemStack stack2) {
		return stack1.getItem().getRegistryName().equals(stack2.getItem().getRegistryName());
	}
	
	public static boolean isStackEqual (ItemStack stackIn1, ItemStack stackIn2, boolean ignoreCount, boolean ignoreMeta, boolean ignoreNBT) {
		ItemStack stack1 = stackIn1.copy(), stack2 = stackIn2.copy();
		if (ignoreCount) {
			stack1.setCount(1);
			stack2.setCount(1);
		}
		if (!isStackItemEqual(stack1, stack2))
			return false;
		if (!ignoreMeta && stack1.getMetadata() != stack2.getMetadata())
			return false;
		if (!ignoreNBT && !stack1.serializeNBT().equals(stack2.serializeNBT()))
			return false;
		return true;
	}
	
	public static boolean canMerge (ItemStack stack1, ItemStack stack2) {
		return isStackEqual (stack1, stack2, true, false, false);
	}
}
