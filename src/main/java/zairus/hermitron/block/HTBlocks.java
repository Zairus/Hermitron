package zairus.hermitron.block;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.Hermitron;
import zairus.hermitron.item.ItemHermitron.Version;

public class HTBlocks
{
	public static final Block HERMITRON_CASE;
	public static final Block HERMITRON_CASE_BETA;
	public static final Block HERMITRON_CASE_GAMMA;
	public static final Block HERMITRON_PEDESTAL;
	public static final Block HERMITRON_SCOREBOARD;
	
	static
	{
		HERMITRON_CASE = new BlockHermitronCase(Version.ALPHA).setBlockName("hermitron_case");
		HERMITRON_CASE_BETA = new BlockHermitronCase(Version.BETA).setBlockName("hermitron_case_beta");
		HERMITRON_CASE_GAMMA = new BlockHermitronCase(Version.GAMA).setBlockName("hermitron_case_gamma");
		HERMITRON_PEDESTAL = new BlockHermitronPedestal().setBlockName("hermitron_pedestal");
		HERMITRON_SCOREBOARD = new BlockHermitronScoreboard().setBlockName("hermitron_scoreboard");
	}
	
	public static void register()
	{
		((IBlockBase)HERMITRON_CASE).register();
		((IBlockBase)HERMITRON_CASE_BETA).register();
		((IBlockBase)HERMITRON_CASE_GAMMA).register();
		((IBlockBase)HERMITRON_PEDESTAL).register();
		((IBlockBase)HERMITRON_SCOREBOARD).register();
	}
	
	protected static void registerBlock(Block block, String name, Class<? extends TileEntity> teClazz, String id, boolean model)
	{
		Hermitron.proxy.registerBlock(block, name, teClazz, id, model);
	}
	
	@SuppressWarnings("unused")
	private static void registerBlock(Block block, String name)
	{
		Hermitron.proxy.registerBlock(block, name, true);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initClient()
	{
		;
	}
}
