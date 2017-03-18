package zairus.hermitron.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.HTConstants;
import zairus.hermitron.inventory.HTContainerBase;
import zairus.hermitron.tileentity.TileEntityHermitronCase;

@SideOnly(Side.CLIENT)
public class GuiChestStandard extends GuiContainer
{
	private static final ResourceLocation GUI_BACKGROUND = new ResourceLocation(HTConstants.MODID, "textures/gui/container/hermitron_case.png");
	
	private IInventory inventory;
	
	public GuiChestStandard(IInventory playerInv, IInventory inventorySlots, EntityPlayer player)
	{
		super(new HTContainerBase(playerInv, inventorySlots, player));
		this.inventory = inventorySlots;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(((TileEntityHermitronCase)inventory).getGUIDisplayName(), 7, 4, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GUI_BACKGROUND);
		this.ySize = 170;
		int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}
}
