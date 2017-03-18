package zairus.hermitron.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelHermitronScoreboard extends ModelBase
{
	public ModelRenderer h0;
	public ModelRenderer h1;
	public ModelRenderer h2;
	public ModelRenderer h3;
	public ModelRenderer h4;
	public ModelRenderer h5;
	public ModelRenderer h6;
	
	public ModelRenderer table_top;
	
	public ModelHermitronScoreboard()
	{
		this.table_top = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		this.table_top.addBox(0.0F, 1.0F, 0.0F, 16, 1, 16, 0.0F);
		
		h0 = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		h0.addBox(0.0F, 2.0F, 12.0F, 2, 2, 2, 0.0F);
		h1 = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		h1.addBox(0.0F, 2.0F, 10.0F, 2, 14, 2, 0.0F);
		h2 = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		h2.addBox(0.0F, 8.0F, 6.0F, 2, 2, 4, 0.0F);
		h3 = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		h3.addBox(0.0F, 2.0F, 4.0F, 2, 14, 2, 0.0F);
		h4 = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		h4.addBox(0.0F, 14.0F, 2.0F, 2, 2, 2, 0.0F);
		h5 = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		h5.addBox(0.0F, 4.0F, 2.0F, 2, 2, 2, 0.0F);
		h6 = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		h6.addBox(0.0F, 4.0F, 6.0F, 2, 2, 2, 0.0F);
	}
	
	public void renderTable()
	{
		this.table_top = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		this.table_top.addBox(0.0F, 15.0F, 0.0F, 16, 1, 16, 0.0F);
		
		this.table_top.render(0.0625F);
	}
	
	public void renderH()
	{
		GlStateManager.translate(0.5F, -0.06F, 0.0F);
		renderSide();
	}
	
	private void renderSide()
	{
		this.h0.render(0.0625F);
		this.h1.render(0.0625F);
		this.h2.render(0.0625F);
		this.h3.render(0.0625F);
		this.h4.render(0.0625F);
		this.h5.render(0.0625F);
		this.h6.render(0.0625F);
	}
}
