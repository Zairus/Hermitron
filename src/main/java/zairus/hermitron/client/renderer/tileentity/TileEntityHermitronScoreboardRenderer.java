package zairus.hermitron.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.HTConstants;
import zairus.hermitron.block.BlockHermitronScoreboard;
import zairus.hermitron.client.model.ModelHermitronScoreboard;
import zairus.hermitron.tileentity.TileEntityHermitronScoreboard;

@SideOnly(Side.CLIENT)
public class TileEntityHermitronScoreboardRenderer extends TileEntitySpecialRenderer<TileEntityHermitronScoreboard>
{
	private final ModelHermitronScoreboard pedestal = new ModelHermitronScoreboard();
	
	private final ResourceLocation TEXTURE_ORANGE = new ResourceLocation(HTConstants.MODID, "textures/entity/pedestal_orange.png");
	private final ResourceLocation TEXTURE_BLUE = new ResourceLocation(HTConstants.MODID, "textures/entity/pedestal_blue.png");
	
	public TileEntityHermitronScoreboardRenderer()
	{
		this.setRendererDispatcher(TileEntityRendererDispatcher.instance);
	}
	
	public void renderTileEntityAt(TileEntityHermitronScoreboard te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		GlStateManager.enableDepth();
		GlStateManager.depthFunc(515);
		GlStateManager.depthMask(true);
		int i;
		
		if (te == null)
		{
			te = new TileEntityHermitronScoreboard();
		}
		
		if (te.hasWorldObj())
		{
			Block block = te.getBlockType();
			i = te.getBlockMetadata();
			
			if (block instanceof BlockHermitronScoreboard && i == 0)
			{
				i = te.getBlockMetadata();
			}
		}
		else
		{
			i = 0;
		}
		
		ModelHermitronScoreboard p;
		
		p  = this.pedestal;
		
		if (destroyStage >= 0)
		{
			this.bindTexture(DESTROY_STAGES[destroyStage]);
			GlStateManager.matrixMode(5890);
			GlStateManager.pushMatrix();
			GlStateManager.scale(4.0F, 4.0F, 1.0F);
			GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
			GlStateManager.matrixMode(5888);
		}
		
		GlStateManager.pushMatrix();
		GlStateManager.enableRescaleNormal();
		
		if (destroyStage < 0)
		{
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		}
		
		GlStateManager.translate((float)x, (float)y + 1.0F, (float)z + 1.0F);
		GlStateManager.scale(1.0F, -1.0F, -1.0F);
		GlStateManager.translate(0.5F, 0.5F, 0.5F);
		int j = 0;
		
		if (i == 2)
		{
			j = 180;
		}
		
		if (i == 3)
		{
			j = 0;
		}
		
		if (i == 4)
		{
			j = 90;
		}
		
		if (i == 5)
		{
			j = -90;
		}
		
		GlStateManager.rotate((float)j, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(-0.5F, -0.5F, -0.5F);
		
		if (this.rendererDispatcher == null)
			return;
		
		this.bindTexture(TEXTURE_BLUE);
		p.renderTable();
		this.bindTexture(TEXTURE_ORANGE);
		p.renderH();
		
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		
		if (destroyStage >= 0)
		{
			GlStateManager.matrixMode(5890);
			GlStateManager.popMatrix();
			GlStateManager.matrixMode(5888);
		}
	}
}
