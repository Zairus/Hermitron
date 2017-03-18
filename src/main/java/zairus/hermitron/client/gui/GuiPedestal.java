package zairus.hermitron.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.HTConstants;
import zairus.hermitron.Hermitron;
import zairus.hermitron.inventory.HTContainerBase;
import zairus.hermitron.tileentity.TileEntityHermitronPedestal;
import zairus.hermitron.util.network.PedestalPacket;

@SideOnly(Side.CLIENT)
public class GuiPedestal extends GuiContainer
{
	public static final ResourceLocation GUI_BACKGROUND = new ResourceLocation(HTConstants.MODID, "textures/gui/container/hermitron_pedestal.png");
	
	private IInventory inventory;
	
	private GuiCompleteButton completeButton;
	
	public GuiPedestal(IInventory playerInv, IInventory inventorySlots, EntityPlayer player)
	{
		super(new HTContainerBase(playerInv, inventorySlots, player, 3, 3));
		this.inventory = inventorySlots;
	}
	
	@Override
	public void initGui()
	{
		this.buttonList.add(completeButton = new GuiCompleteButton(0, 10, 10, 52, 11, ""));
		
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled)
		{
			switch(button.id)
			{
			case 0:
				break;
			default:
				break;
			}
		}
		
		updateButtons();
		syncTE();
	}
	
	private void syncTE()
	{
		TileEntityHermitronPedestal pedestal = (TileEntityHermitronPedestal)this.inventory;
		
		Hermitron.packetPipeline.sendToServer(new PedestalPacket(pedestal.getPos().getX(), pedestal.getPos().getY(), pedestal.getPos().getZ()));
	}
	
	private void updateButtons()
	{
		;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		int left = (this.width - this.xSize) / 2;
		int top = (this.height - this.ySize) / 2;
		
		if (this.inventory instanceof TileEntityHermitronPedestal)
		{
			TileEntityHermitronPedestal pedestal = (TileEntityHermitronPedestal)this.inventory;
			this.completeButton.visible = pedestal.isSet();
		}
		
		setButtonPositions(left, top);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	private void setButtonPositions(int left, int top)
	{
		this.completeButton.setScreenPos(left + 62, top + 70);
		this.completeButton.displayString = "Complete Set";
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(((TileEntityHermitronPedestal)inventory).getGUIDisplayName(), 40, 1, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GUI_BACKGROUND);
		this.ySize = 170;
		int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize - 4);
	}
	
	static class GuiCompleteButton extends GuiButton
	{
		public GuiCompleteButton(int buttonId, int x, int y, int width, int height, String buttonText)
		{
			super(buttonId, x, y, width, height, buttonText);
		}
		
		@Override
		public void drawButton(Minecraft minecraft, int mouseX, int mouseY)
		{
			if (this.visible)
			{
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				minecraft.getTextureManager().bindTexture(GuiPedestal.GUI_BACKGROUND);
				
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 166, 52, 11);
			}
		}
		
		public void setScreenPos(int x, int y)
		{
			this.xPosition = x;
			this.yPosition = y;
		}
	}
}
