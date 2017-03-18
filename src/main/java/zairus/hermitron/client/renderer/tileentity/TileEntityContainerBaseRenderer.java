package zairus.hermitron.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.block.BlockHermitronCase;
import zairus.hermitron.client.model.ModelHermitronCase;
import zairus.hermitron.tileentity.HTTileEntityBase;
import zairus.hermitron.tileentity.TileEntityHermitronCase;

@SideOnly(Side.CLIENT)
public class TileEntityContainerBaseRenderer extends TileEntitySpecialRenderer<HTTileEntityBase>
{
	private final ModelHermitronCase simpleChest = new ModelHermitronCase();
	
	public TileEntityContainerBaseRenderer()
	{
		;
	}
	
	public void renderTileEntityAt(HTTileEntityBase te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		GlStateManager.enableDepth();
		GlStateManager.depthFunc(515);
		GlStateManager.depthMask(true);
		int i;
		
		if (te == null)
			te = new TileEntityHermitronCase();
		
		if (te.hasWorldObj())
		{
			Block block = te.getBlockType();
			i = te.getBlockMetadata();
			
			if (block instanceof BlockHermitronCase && i == 0)
			{
				i = te.getBlockMetadata();
			}
		}
		else
		{
			i = 0;
		}
		
		ModelHermitronCase modelchest;
		
		modelchest = this.simpleChest;
		
		if (destroyStage >= 0)
		{
			this.bindTexture(DESTROY_STAGES[destroyStage]);
			GlStateManager.matrixMode(5890);
			GlStateManager.pushMatrix();
			GlStateManager.scale(4.0F, 4.0F, 1.0F);
			GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
			GlStateManager.matrixMode(5888);
		}
		else
		{
			this.bindTexture(te.getTextures());
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
		
		modelchest.chestBelow.render(0.0625F);
		
		GlStateManager.translate(0.5F, 0.0F, 0.5F);
		GlStateManager.translate(0.0F, -(te.prevOpenPhase + (te.openPhase - te.prevOpenPhase) * partialTicks) * 0.5F, 0.0F);
		GlStateManager.rotate(270.0F * (te.prevOpenPhase + (te.openPhase - te.prevOpenPhase) * partialTicks), 0.0F, 1.0F, 0.0F);
		
		modelchest.chestLid.render(0.0625F);
		
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
