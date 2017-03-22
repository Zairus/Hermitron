package zairus.hermitron.biome.decorate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import zairus.hermitron.block.HTBlocks;
import zairus.hermitron.item.ItemHermitron.Version;
import zairus.hermitron.tileentity.TileEntityHermitronCase;

public class WorldGenHermitronCase extends WorldGenDecorationBase
{
	public WorldGenHermitronCase(GenerationType t)
	{
		super(t);
	}
	
	@Override
	public List<Biome>getAllowedBiomes()
	{
		List<Biome> biomes = new ArrayList<Biome>();
		
		for (Biome biome : Biome.REGISTRY)
		{
			biomes.add(biome);
		}
		
		return biomes;
	}
	
	@Override
	protected boolean doGenerate(World world, Random rand, BlockPos pos)
	{
		if (!(rand.nextInt(rarity) == 0))
			return false;
		
		int cx = pos.getX();
		int cz = pos.getZ();

		cx = cx - (MathHelper.floor_float((float)cx / 16.0F) * 16);
		cz = cz - (MathHelper.floor_float((float)cz / 16.0F) * 16);
		
		if (cx < 2)
			pos = pos.add(3, 0, 0);
		
		if (cx > 13)
			pos = pos.add(-3, 0, 0);
		
		if (cz < 2)
			pos = pos.add(0, 0, 3);
		
		if (cz > 13)
			pos = pos.add(0, 0, -3);
		
		while(pos.getY() > 6)
		{
			if (world.isAirBlock(pos) && !world.isAirBlock(pos.down()))
				break;
			
			pos = pos.down();
		}
		
		if (!world.isAirBlock(pos) && !world.isAirBlock(pos.up()) || pos.getY() <= 6)
			return false;
		
		if (world.getBlockState(pos.down()).getBlock() == Blocks.WATER)
			return false;
		
		Version v = Version.values()[rand.nextInt(Version.values().length -1)];
		Block caseBlock = (v == Version.ALPHA) ? HTBlocks.HERMITRON_CASE : (v == Version.BETA)? HTBlocks.HERMITRON_CASE_BETA : HTBlocks.HERMITRON_CASE_GAMMA;
		IBlockState glass_casing = Blocks.STAINED_GLASS.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.values()[rand.nextInt(EnumDyeColor.values().length)]);
		IBlockState hcase = caseBlock.getDefaultState();
		
		for (int x = -1; x <= 1; ++x)
		{
			for (int z = -1; z <= 1; ++z)
			{
				for (int y = 2; y >= 0; --y)
				{
					if (x == 0 && z == 0 && y == 1)
					{
						this.setBlockInWorld(world, pos.add(x, y, z), hcase);
						TileEntity te = world.getTileEntity(pos.add(x, y, z));
						if (te != null && te instanceof TileEntityHermitronCase)
						{
							TileEntityHermitronCase tecase = (TileEntityHermitronCase)te;
							tecase.setVersion(v);
							tecase.setLoot(rand);
						}
					}
					else
					{
						this.setBlockInWorld(world, pos.add(x, y, z), glass_casing);
					}
				}
			}
		}
		
		return true;
	}
}
