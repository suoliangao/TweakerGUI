package suoliangao.tweakergui.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import suoliangao.tweakergui.TweakerGUI;

import suoliangao.tweakergui.gui.minecraft.*;

public class GuiHandler implements IGuiHandler {
	
	//minecraft
	public static final int CRAFTING_TABLE = 0;
	public static final int FURNACE = 1;
	
	public GuiHandler () {
		NetworkRegistry.INSTANCE.registerGuiHandler(TweakerGUI.instance, this);
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		switch (ID) {
		case CRAFTING_TABLE:
			return new ContainerCraftingTable(player.inventory);
		case FURNACE:
			return new ContainerFurnace(player.inventory);
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		switch (ID) {
		case CRAFTING_TABLE:
			return new GuiCraftingTable(new ContainerCraftingTable(player.inventory));
		case FURNACE:
			return new GuiFurnace(new ContainerFurnace(player.inventory));
		default:
			return null;
		}
	}

}
