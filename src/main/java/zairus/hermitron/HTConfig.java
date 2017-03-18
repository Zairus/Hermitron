package zairus.hermitron;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class HTConfig
{
	public static Configuration configuration;
	
	public static boolean output_generation_log = true;
	public static int hermitron_generation_rarity = 130;
	
	public static void init(File cFile)
	{
		configuration = new Configuration(cFile);
		
		configuration.load();
		
		output_generation_log = configuration.getBoolean("output_generation_log", "GENERAL_CONFIGURATION", output_generation_log, "Sets wether output world generation to game log or not.");
		
		hermitron_generation_rarity = configuration.getInt("hermitron_generation_rarity", "WORLD_GENERATION", hermitron_generation_rarity, 1, 250, "The lower the value, the more common Hermitrons spawn.");
		
		configuration.save();
	}
}
