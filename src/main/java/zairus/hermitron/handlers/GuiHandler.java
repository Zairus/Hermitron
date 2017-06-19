package zairus.hermitron.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import zairus.hermitron.client.gui.GuiChestStandard;
import zairus.hermitron.client.gui.GuiInfo;
import zairus.hermitron.client.gui.GuiPedestal;
import zairus.hermitron.client.gui.GuiScoreboard;
import zairus.hermitron.data.HTDataManager;
import zairus.hermitron.inventory.HTContainerBase;
import zairus.hermitron.inventory.HTContainerInfo;
import zairus.hermitron.item.ItemHermitron;
import zairus.hermitron.tileentity.TileEntityHermitronCase;
import zairus.hermitron.tileentity.TileEntityHermitronPedestal;
import zairus.hermitron.tileentity.TileEntityHermitronScoreboard;

public class GuiHandler implements IGuiHandler
{
	public static final int GUI_HERMITRON_CASE = 0;
	public static final int GUI_HERMITRON_PEDESTAL = 1;
	public static final int GUI_HERMITRON_INFO = 2;
	public static final int GUI_HERMITRON_SCORE = 3;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity;
		
		switch (ID)
		{
		case GUI_HERMITRON_CASE:
			tileEntity = world.getTileEntity(new BlockPos(x, y, z));
			if (tileEntity instanceof TileEntityHermitronCase)
			{
				return new HTContainerBase(player.inventory, (TileEntityHermitronCase)tileEntity, player);
			}
			break;
		case GUI_HERMITRON_PEDESTAL:
			tileEntity = world.getTileEntity(new BlockPos(x, y, z));
			if (tileEntity instanceof TileEntityHermitronPedestal)
			{
				return new HTContainerBase(player.inventory, (TileEntityHermitronPedestal)tileEntity, player, 3, 3);
			}
			break;
		case GUI_HERMITRON_INFO:
			ItemStack stack = (player.getHeldItemMainhand() != null)? player.getHeldItemMainhand() : player.getHeldItemOffhand();
			if (stack != null && stack.getItem() instanceof ItemHermitron)
			{
				return new HTContainerInfo((ItemHermitron)stack.getItem(), player, HTDataManager.get(world).playerScore);
			}
			break;
		case GUI_HERMITRON_SCORE:
			tileEntity = world.getTileEntity(new BlockPos(x, y, z));
			if (tileEntity instanceof TileEntityHermitronScoreboard)
			{
				return new HTContainerBase(player.inventory, (TileEntityHermitronScoreboard)tileEntity, player, 0, 0);
			}
			break;
		}
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity;
		
		switch (ID)
		{
		case GUI_HERMITRON_CASE:
			tileEntity = world.getTileEntity(new BlockPos(x, y, z));
			if (tileEntity instanceof TileEntityHermitronCase)
			{
				return new GuiChestStandard(player.inventory, (TileEntityHermitronCase)tileEntity, player);
			}
			break;
		case GUI_HERMITRON_PEDESTAL:
			tileEntity = world.getTileEntity(new BlockPos(x, y, z));
			if (tileEntity instanceof TileEntityHermitronPedestal)
			{
				return new GuiPedestal(player.inventory, (TileEntityHermitronPedestal)tileEntity, player);
			}
			break;
		case GUI_HERMITRON_INFO:
			ItemStack stack = (player.getHeldItemMainhand() != null)? player.getHeldItemMainhand() : player.getHeldItemOffhand();
			if (stack != null && stack.getItem() instanceof ItemHermitron)
			{
				return new GuiInfo((ItemHermitron)stack.getItem(), player, HTDataManager.get(world).playerScore);
			}
			break;
		case GUI_HERMITRON_SCORE:
			tileEntity = world.getTileEntity(new BlockPos(x, y, z));
			if (tileEntity instanceof TileEntityHermitronScoreboard)
			{
				return new GuiScoreboard(player, (TileEntityHermitronScoreboard)tileEntity);
			}
			break;
		}
		
		return null;
	}
}
