package zairus.hermitron.client.gui;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.HTConstants;
import zairus.hermitron.tileentity.TileEntityHermitronScoreboard;

@SideOnly(Side.CLIENT)
public class GuiScoreboard extends GuiScreen
{
	private final ResourceLocation GUI_BACKGROUND = new ResourceLocation(HTConstants.MODID, "textures/gui/container/hermitron_info.png");
	
	private EntityPlayer player;
	private TileEntityHermitronScoreboard scoreboard;
	
	private int page = 1;
	
	private GuiScoreButton nextPage;
	private GuiScoreButton prevPage;
	
	public GuiScoreboard(EntityPlayer player, TileEntityHermitronScoreboard scoreboard)
	{
		this.player = player;
		this.scoreboard = scoreboard;
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		this.mc.getConnection().sendPacket(new CPacketClientStatus(CPacketClientStatus.State.REQUEST_STATS));
		
		this.buttonList.add(nextPage = new GuiScoreButton(0, 10, 10, 20, 20, ""));
		this.buttonList.add(prevPage = new GuiScoreButton(1, 10, 10, 20, 20, ""));
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
	{
		if (keyCode == 1 || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
		{
			this.mc.thePlayer.closeScreen();
		}
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
			switch(button.id)
			{
			case 0:
				this.page++;
				break;
			case 1:
				if (this.page > 1)
					this.page--;
				break;
			}
		}
	}
	
	private void setButtonPositions(int left, int top)
	{
		this.nextPage.setScreenPos(left + 145, top + 20);
		this.nextPage.width = 25;
		this.nextPage.height = 10;
		
		this.prevPage.setScreenPos(left + 115, top + 20);
		this.prevPage.width = 25;
		this.prevPage.height = 10;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		int xSize = 176;
		int ySize = 170;
		int i = (this.width - xSize) / 2;
        int j = (this.height - ySize) / 2;
        
        setButtonPositions(i, j);
        
        RenderHelper.disableStandardItemLighting();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GUI_BACKGROUND);
		
		this.drawTexturedModalRect(i, j, 0, 0, xSize, ySize - 4);
		
		int playerScore = 0;
		
		if (this.scoreboard != null && this.scoreboard.getScore() != null)
		{
			this.fontRendererObj.drawString("Next", i + 145, j + 20, 4210752);
			this.fontRendererObj.drawString("Prev", i + 115, j + 20, 4210752);
			
			Map<String, Integer> scoreCopy = new HashMap<String, Integer>(this.scoreboard.getScore());
			
			scoreCopy = sortByValue(scoreCopy);
			
			playerScore = scoreCopy.getOrDefault(player.getDisplayNameString(), 0);
			
			int regs_page = 13;
			int reg = 0;
			int line = 0;
			for (String p : scoreCopy.keySet())
			{
				++reg;
				if (reg > (regs_page * (page - 1)) && reg < (regs_page * page))
				{
					this.fontRendererObj.drawString(((line == 0 && page == 1)? TextFormatting.BLUE : "") + p + "", i + 10, j + (10 * line) + 30, 4210752);
					this.fontRendererObj.drawString(((line == 0 && page == 1)? TextFormatting.BLUE : "") + "" + scoreCopy.get(p), i + 130, j + (10 * line) + 30, 4210752);
					++line;
				}
			}
		}
		else
		{
			this.fontRendererObj.drawString(TextFormatting.DARK_BLUE + "Nope, there's nothing here", i + 10, j + 40, 4210752);
		}
		
		this.fontRendererObj.drawString(player.getDisplayNameString() + "'s Score: " + playerScore, i + 10, j + 10, 4210752);
	}
	
	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap)
	{
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
		{
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
			{
				return (o1.getValue()).compareTo(o2.getValue()) * -1;
			}
		});
		
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		
		for (Map.Entry<String, Integer> entry : list)
		{
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedMap;
	}
	
	public class GuiScoreButton extends GuiButton
	{
		public GuiScoreButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText)
		{
			super(buttonId, x, y, widthIn, heightIn, buttonText);
		}
		
		@Override
		public void drawButton(Minecraft minecraft, int mouseX, int mouseY)
		{
			if (this.visible)
			{
			}
		}
		
		public void setScreenPos(int x, int y)
		{
			this.xPosition = x;
			this.yPosition = y;
		}
	}
}
