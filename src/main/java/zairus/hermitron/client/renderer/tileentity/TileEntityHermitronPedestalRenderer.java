package zairus.hermitron.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.HTConstants;
import zairus.hermitron.block.BlockHermitronPedestal;
import zairus.hermitron.client.model.ModelHermitronPedestal;
import zairus.hermitron.item.ItemHermitron;
import zairus.hermitron.item.ItemHermitronSet;
import zairus.hermitron.tileentity.TileEntityHermitronPedestal;

@SideOnly(Side.CLIENT)
public class TileEntityHermitronPedestalRenderer extends TileEntitySpecialRenderer<TileEntityHermitronPedestal>
{
	private final ModelHermitronPedestal pedestal = new ModelHermitronPedestal();
	
	private final ResourceLocation TEXTURE_WHITE = new ResourceLocation(HTConstants.MODID, "textures/entity/pedestal_white.png");
	private final ResourceLocation TEXTURE_ORANGE = new ResourceLocation(HTConstants.MODID, "textures/entity/pedestal_orange.png");
	private final ResourceLocation TEXTURE_BLUE = new ResourceLocation(HTConstants.MODID, "textures/entity/pedestal_blue.png");
	
	public TileEntityHermitronPedestalRenderer()
	{
		this.setRendererDispatcher(TileEntityRendererDispatcher.instance);
	}
	
	public void renderTileEntityAt(TileEntityHermitronPedestal te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		GlStateManager.enableDepth();
		GlStateManager.depthFunc(515);
		GlStateManager.depthMask(true);
		int i;
		
		if (te == null)
		{
			te = new TileEntityHermitronPedestal();
		}
		
		if (te.hasWorldObj())
		{
			Block block = te.getBlockType();
			i = te.getBlockMetadata();
			
			if (block instanceof BlockHermitronPedestal && i == 0)
			{
				i = te.getBlockMetadata();
			}
		}
		else
		{
			i = 0;
		}
		
		ModelHermitronPedestal p;
		
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
			j = 0;
		}
		
		if (i == 3)
		{
			j = 180;
		}
		
		if (i == 4)
		{
			j = -90;
		}
		
		if (i == 5)
		{
			j = 90;
		}
		
		if (this.rendererDispatcher == null)
			return;
		
		GlStateManager.rotate((float)j, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(-0.5F, -0.5F, -0.5F);
		
		this.bindTexture(TEXTURE_BLUE);
		p.renderTable();
		this.bindTexture(TEXTURE_WHITE);
		p.renderBase();
		this.bindTexture(TEXTURE_ORANGE);
		p.renderH();
		
		p.scaleForItems();
		
		int slot = 0;
		
		renderHermitronSlot(te, slot, p);
		
		p.advanceRight();
		renderHermitronSlot(te, ++slot, p);
		
		p.advanceRight();
		renderHermitronSlot(te, ++slot, p);
		
		p.nextLine();
		renderHermitronSlot(te, ++slot, p);
		
		p.advanceRight();
		renderHermitronSlot(te, ++slot, p);
		
		p.advanceRight();
		renderHermitronSlot(te, ++slot, p);
		
		p.nextLine();
		renderHermitronSlot(te, ++slot, p);
		
		p.advanceRight();
		renderHermitronSlot(te, ++slot, p);
		
		p.advanceRight();
		renderHermitronSlot(te, ++slot, p);
		
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
	
	private void renderHermitronSlot(TileEntityHermitronPedestal te, int slot, ModelHermitronPedestal p)
	{
		ResourceLocation t = null;
		
		if (te.getStackInSlot(slot) != null)
		{
			if (te.getStackInSlot(slot).getItem() instanceof ItemHermitron)
			{
				t = ((ItemHermitron)te.getStackInSlot(slot).getItem()).textures;
			}
			else if (te.getStackInSlot(slot).getItem() instanceof ItemHermitronSet)
			{
				t = ((ItemHermitronSet)te.getStackInSlot(slot).getItem()).textures;
			}
			
			if (t != null)
			{
				this.bindTexture(t);
				p.renderItem();
			}
		}
	}
}
