package suoliangao.tweakergui;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import suoliangao.tweakergui.gui.GuiHandler;
import net.minecraft.client.gui.inventory.GuiFurnace;

@EventBusSubscriber
public class RecipeMaker extends Item {
	
	public RecipeMaker () {
		setRegistryName("recipe_maker");
		setUnlocalizedName("recipe_maker");
		setCreativeTab(CreativeTabs.TOOLS);
	}
	
	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
		// TODO Auto-generated method stub
		if(!world.isRemote && player.isSneaking()) {
			if(world.getBlockState(pos).getBlock().equals(Blocks.CRAFTING_TABLE))
				player.openGui(TweakerGUI.instance, GuiHandler.CRAFTING_TABLE, world, pos.getX(), pos.getY(), pos.getZ());
			else {
				String msg = I18n.format("msg.open_recipemakergui_fail");
				player.sendMessage(new TextComponentString(msg));
			}
		}
		return super.onItemUseFirst(player, world, pos, side, hitX, hitY, hitZ, hand);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		// TODO Auto-generated method stub
		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
	
	
}
