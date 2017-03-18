package zairus.hermitron.biome.decorate;

import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import zairus.hermitron.HTConfig;
import zairus.hermitron.Hermitron;

public abstract class WorldGenDecorationBase extends WorldGenerator
{
	private final GenerationType generationType;
	
	protected int rarity = 3;
	
	public WorldGenDecorationBase()
	{
		this(GenerationType.FINDGROUND);
	}
	
	public WorldGenDecorationBase(GenerationType t)
	{
		this.generationType = t;
	}
	
	public WorldGenDecorationBase setRarity(int r)
	{
		this.rarity = r;
		return this;
	}
	
	public abstract List<Biome> getAllowedBiomes();
	protected abstract boolean doGenerate(World world, Random rand, BlockPos pos);
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		switch (generationType)
		{
		case FINDGROUND:
			pos = findGround(world, pos);
			break;
		default:
			pos = new BlockPos(pos.getX(), rand.nextInt(255), pos.getZ());
			break;
		}
		
		boolean generated = doGenerate(world, rand, pos);
		
		if (generated && HTConfig.output_generation_log)
			Hermitron.logger.info("generated: [" + this.getClass().getName() + "]" + pos);
		
		return generated;
	}
	
	public BlockPos findGround(World world, BlockPos pos)
	{
		BlockPos groundPos = new BlockPos(pos.getX(), 255, pos.getZ());
		
		do {
			if (!world.isAirBlock(groundPos))
				break;
			
			groundPos = groundPos.down();
		} while (groundPos.getY() > 0);
		
		return groundPos;
	}
	
	public boolean setBlockInWorld(World world, BlockPos pos, IBlockState state)
	{
		if (!world.isBlockLoaded(pos))
			return false;
		
		world.setBlockState(pos, state);
		
		return true;
	}
	
	public BlockPos findBlockInArea(World world, BlockPos center, int areaExpand, int height, IBlockState match, boolean surface)
	{
		BlockPos pos = null;
		
		state_search:
		for (int x = -areaExpand; x <= areaExpand; ++x)
		{
			for (int z = -areaExpand; z <= areaExpand; ++z)
			{
				for (int y = height; y >= (surface ? 0 : -height); --y)
				{
					if (world.isBlockLoaded(center.add(x, y, z)) && world.getBlockState(center.add(x, y, z)) == match)
					{
						pos = center.add(x, y, z);
						break state_search;
					}
				}
			}
		}
		
		return pos;
	}
	
	public enum GenerationType
	{
		FINDGROUND,
		ANYWHERE;
	}
}
