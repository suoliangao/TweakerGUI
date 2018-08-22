package suoliangao.tweakergui;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import suoliangao.tweakergui.gui.GuiHandler;

/**
 * This mod provide a in-game GUI system to help modpack makers to easily modify their zenscript recipes.
 * @author Suoliangao
 * 
 */
@Mod(modid = TweakerGUI.MOD_ID, name = TweakerGUI.MOD_NAME, version = TweakerGUI.VERSION)
public class TweakerGUI {
	
	public static TweakerGUI instance;
	
	public static final String MOD_ID = "tweakergui";
	public static final String MOD_NAME = "Tweaker GUI";
	public static final String VERSION = "0.2-alpha";
	
	@EventHandler
	public void preInit (FMLPreInitializationEvent event) {
		instance = this;
	}
	
	@EventHandler
	public void init (FMLInitializationEvent event) {
		new GuiHandler ();
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent event) {
		
	}
}
