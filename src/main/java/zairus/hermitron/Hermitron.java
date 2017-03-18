package zairus.hermitron;

import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import zairus.hermitron.block.HTBlocks;
import zairus.hermitron.command.server.CommandScore;
import zairus.hermitron.event.HTEvents;
import zairus.hermitron.handlers.GuiHandler;
import zairus.hermitron.handlers.HTCraftingHandler;
import zairus.hermitron.item.HTItems;
import zairus.hermitron.proxy.CommonProxy;
import zairus.hermitron.sound.HTSoundEvents;
import zairus.hermitron.stats.HTAchievementList;
import zairus.hermitron.util.network.PacketPipeline;

@Mod(modid = HTConstants.MODID, name = HTConstants.MODNAME, version = HTConstants.VERSION)
public class Hermitron
{
	@Mod.Instance(HTConstants.MODID)
	public static Hermitron instance;
	
	@SidedProxy(clientSide = HTConstants.CLIENT_PROXY, serverSide = HTConstants.COMMON_PROXY)
	public static CommonProxy proxy;
	
	public static PacketPipeline packetPipeline = new PacketPipeline();
	
	public static Logger logger;
	
	public static CreativeTabs creativeTab = new CreativeTabs("hermitron") {
		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(HTBlocks.HERMITRON_CASE);
		}
	};
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		HTConfig.init(event.getSuggestedConfigurationFile());
		
		Hermitron.proxy.preInit(event);
		
		HTSoundEvents.register();
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
		Hermitron.proxy.init(event);
		Hermitron.packetPipeline.initalise();
		
		HTItems.register();
		HTBlocks.register();
		
		Hermitron.proxy.initBuiltinShapes();
		
		HTCraftingHandler.addRecipes();
		
		HTEvents eventHandler = new HTEvents();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		MinecraftForge.TERRAIN_GEN_BUS.register(eventHandler);
		MinecraftForge.ORE_GEN_BUS.register(eventHandler);
		
		HTAchievementList.initPages();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Hermitron.instance, new GuiHandler());
    }
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		Hermitron.proxy.postInit(event);
	}
	
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandScore());
	}
}
