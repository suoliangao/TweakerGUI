package suoliangao.tweakergui.gui.textfield;

import java.util.Arrays;
import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;

public class NumberTextField extends GuiTextField {

	public NumberTextField(int componentId, FontRenderer fontrendererObj, int x, int y, int par5Width, int par6Height) {
		super(componentId, fontrendererObj, x, y, par5Width, par6Height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean textboxKeyTyped(char typedChar, int keyCode) {
		// TODO Auto-generated method stub
		List<Character> numbers = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
		if (!numbers.contains(typedChar) && keyCode != 14 && keyCode != 203 && keyCode != 205)
			return false;
		return super.textboxKeyTyped(typedChar, keyCode);
	}

}
