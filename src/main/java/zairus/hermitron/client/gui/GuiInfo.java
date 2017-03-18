package zairus.hermitron.client.gui;

import java.io.IOException;
import java.util.Map;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.HTConstants;
import zairus.hermitron.inventory.HTContainerInfo;
import zairus.hermitron.item.ItemHermitron;

@SideOnly(Side.CLIENT)
public class GuiInfo extends GuiContainer
{
	private final ResourceLocation GUI_BACKGROUND = new ResourceLocation(HTConstants.MODID, "textures/gui/container/hermitron_info.png");
	
	private ItemHermitron itemHermitron = null;
	@SuppressWarnings("unused")
	private EntityPlayer player;
	@SuppressWarnings("unused")
	private Map<String, Integer> hScore;
	
	public GuiInfo(ItemHermitron h, EntityPlayer p, Map<String, Integer> hScore)
	{
		super(new HTContainerInfo(h, p, hScore));
		
		this.itemHermitron = h;
		this.player = p;
		this.hScore = hScore;
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		this.mc.getConnection().sendPacket(new CPacketClientStatus(CPacketClientStatus.State.REQUEST_STATS));
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
	
	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled)
		{
			;
		}
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		int xSize = 176;
		int ySize = 170;
		int i = (this.width - xSize) / 2;
        int j = (this.height - ySize) / 2;
        
		if (this.itemHermitron != null)
			drawItemStack(new ItemStack(itemHermitron), i + 10, j + 10, "");
		
		RenderHelper.disableStandardItemLighting();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GUI_BACKGROUND);
		
        this.drawTexturedModalRect(i, j, 0, 0, xSize, ySize - 4);
        
		//TEXT
        if (itemHermitron != null)
        {
        	this.fontRendererObj.drawString(itemHermitron.getItemStackDisplayName(new ItemStack(itemHermitron)), i + 30, j + 10, 4210752);
        	this.fontRendererObj.drawString("Version: " + itemHermitron.getVersion().getName(), i + 30, j + 20, 4210752);
        	this.fontRendererObj.drawString("Tribe: " + itemHermitron.getTribe(), i + 30, j + 30, 4210752);
        	this.fontRendererObj.drawString("Rarity: " + itemHermitron.getRarity().getName(), i + 30, j + 40, 4210752);
        }
        //this.fontRendererObj.drawString(">ed: --" + ((EntityPlayerSP)player).getStatFileWriter().readStat(HTStatList.HERMITRON_CASE_OPENED), i + 30, j + 50, 4210752);
        
        /*
        if (player != null)
        {
        	Set<String> pScore = ((HTContainerInfo)this.inventorySlots).getScoreData().keySet();
        	
        	for (String pName : pScore)
        	{
        		this.fontRendererObj.drawString("N: " + pName, i + 30, j + 60, 4210752);
        	}
        	this.fontRendererObj.drawString(">ed: --", i + 30, j + 50, 4210752);
        }
        else
        {
        	this.fontRendererObj.drawString("Na: ", i + 30, j + 60, 4210752);
        }
        */
		RenderHelper.enableGUIStandardItemLighting();
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
	{
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	private void drawItemStack(ItemStack stack, int x, int y, String altText)
	{
		GlStateManager.translate(0.0F, 0.0F, 32.0F);
		this.zLevel = 200.0F;
		this.itemRender.zLevel = 200.0F;
		net.minecraft.client.gui.FontRenderer font = null;
		if (stack != null) font = stack.getItem().getFontRenderer(stack);
		if (font == null) font = fontRendererObj;
		this.itemRender.renderItemAndEffectIntoGUI(stack, x, y);
		this.itemRender.renderItemOverlayIntoGUI(font, stack, x, y - 8, altText);
		this.zLevel = 0.0F;
		this.itemRender.zLevel = 0.0F;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		;
	}
}
