package zairus.hermitron.handlers;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class HTCraftingHandler
{
	public static void addRecipes()
	{
		GameRegistry.addRecipe(new PedestalRecipe());
		GameRegistry.addRecipe(new ScoreboardRecipe());
	}
}
