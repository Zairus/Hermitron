package zairus.hermitron.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelHermitronCase extends ModelBase
{
	public ModelRenderer chestLid;
	public ModelRenderer chestBelow;
	
	public ModelHermitronCase()
	{
		this.chestLid = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		this.chestLid.addBox(-8.0F, -5.0F, -8.0F, 16, 5, 16, 0.0F);
		this.chestLid.rotationPointX = 0.0F;
		this.chestLid.rotationPointY = 5.0F;
		this.chestLid.rotationPointZ = 0.0F;
		this.chestBelow = (new ModelRenderer(this, 0, 21)).setTextureSize(64, 64);
		this.chestBelow.addBox(-1.0F, -1.0F, -1.0F, 16, 11, 16, 0.0F);
		this.chestBelow.rotationPointX = 1.0F;
		this.chestBelow.rotationPointY = 6.0F;
		this.chestBelow.rotationPointZ = 1.0F;
	}
	
	public void renderAll()
	{
		this.chestLid.render(0.0625F);
		this.chestBelow.render(0.0625F);
	}
}
