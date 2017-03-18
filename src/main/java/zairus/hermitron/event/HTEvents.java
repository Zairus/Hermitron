package zairus.hermitron.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zairus.hermitron.HTConfig;
import zairus.hermitron.biome.decorate.WorldGenDecorationBase;
import zairus.hermitron.biome.decorate.WorldGenDecorationBase.GenerationType;
import zairus.hermitron.biome.decorate.WorldGenHermitronCase;

public class HTEvents
{
	private static List<WorldGenDecorationBase> decorations;
	
	static
	{
		decorations = new ArrayList<WorldGenDecorationBase>();
		
		decorations.add(new WorldGenHermitronCase(GenerationType.ANYWHERE).setRarity(HTConfig.hermitron_generation_rarity));
	}
	
	@SubscribeEvent
	public void BiomeDecorate(DecorateBiomeEvent.Post event)
	{
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		Random rand = event.getRand();
		Biome biome = world.getBiomeForCoordsBody(pos);
		
		for (WorldGenDecorationBase decoration : decorations)
		{
			if (decoration.getAllowedBiomes().contains(biome))
			{
				decoration.generate(world, rand, pos);
			}
		}
	}
}
