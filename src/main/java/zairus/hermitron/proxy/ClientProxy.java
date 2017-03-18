package zairus.hermitron.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zairus.hermitron.HTConstants;
import zairus.hermitron.block.HTBlocks;
import zairus.hermitron.client.renderer.ISpecialRendered;
import zairus.hermitron.client.renderer.tileentity.TileEntityHermitronPedestalRenderer;
import zairus.hermitron.client.renderer.tileentity.TileEntityHermitronScoreboardRenderer;
import zairus.hermitron.tileentity.TileEntityHermitronPedestal;
import zairus.hermitron.tileentity.TileEntityHermitronScoreboard;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
		
		//Regisgter entity renderer
	}
	
	@Override
	public void init(FMLInitializationEvent e)
	{
		super.init(e);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
		//Blocks init client
	}
	
	@Override
	public void registerBlock(Block block, String name, boolean model)
	{
		super.registerBlock(block, name, model);
		
		if (model)
			registerModel(Item.getItemFromBlock(block), 0, name);
	}
	
	@Override
	public void registerBlock(Block block, String name, boolean model, boolean item)
	{
		super.registerBlock(block, name, model, item);
	}
	
	@Override
	public void registerItem(Item item, String name, int meta, boolean model)
	{
		super.registerItem(item, name, meta, model);
		
		if (model && item != null)
		{
			registerModel(item, meta, name);
		}
	}
	
	public void registerModel(Item item, int meta, String name)
	{
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation(HTConstants.MODID + ":" + name, "inventory");
		
		renderItem.getItemModelMesher().register(item, meta, modelResourceLocation);
		
		if (meta == 0)
			ModelBakery.registerItemVariants(item, new ResourceLocation(HTConstants.MODID, name));
	}
	
	@Override
	public void registerBlock(Block block, String name, Class<? extends TileEntity> clazz, String tileEntityId, boolean model)
	{
		super.registerBlock(block, name, clazz, tileEntityId, model);
		
		if (block instanceof ISpecialRendered)
		{
			Object tesrObj = ((ISpecialRendered)block).getTESR();
			if (tesrObj instanceof TileEntitySpecialRenderer)
			{
				@SuppressWarnings("unchecked")
				TileEntitySpecialRenderer<TileEntity> tesr = (TileEntitySpecialRenderer<TileEntity>)tesrObj;
				
				ClientRegistry.bindTileEntitySpecialRenderer(clazz, tesr);
			}
		}
		
		if (model)
			registerModel(Item.getItemFromBlock(block), 0, name);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void initBuiltinShapes()
	{
		MinecraftForge.EVENT_BUS.register(this);
		
		BlockModelShapes shapes = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes();
		
		TileEntityRendererDispatcher.instance.mapSpecialRenderers.put(TileEntityHermitronScoreboard.class, new TileEntityHermitronScoreboardRenderer());
		TileEntityRendererDispatcher.instance.mapSpecialRenderers.put(TileEntityHermitronPedestal.class, new TileEntityHermitronPedestalRenderer());
		
		ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(HTBlocks.HERMITRON_SCOREBOARD), 0, TileEntityHermitronScoreboard.class);
		ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(HTBlocks.HERMITRON_PEDESTAL), 0, TileEntityHermitronPedestal.class);
		
		shapes.registerBuiltInBlocks(new Block[] { HTBlocks.HERMITRON_SCOREBOARD, HTBlocks.HERMITRON_PEDESTAL });
	}
}
