package suoliangao.tweakergui.item;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

@EventBusSubscriber
public class ItemLoader {
	
	public static RecipeMaker recipeCreator = new RecipeMaker();
	
	static ItemStack stack = new ItemStack(recipeCreator, 1);
	
	
	@SubscribeEvent
	public static void onRegistryItem (RegistryEvent.Register<Item> event) {
		event.getRegistry().register(recipeCreator);
	}
	
	@SubscribeEvent
	public static void onModelRegister (ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(recipeCreator, 0, new ModelResourceLocation(recipeCreator.getRegistryName(), "inventory"));
	}
	
	
}
