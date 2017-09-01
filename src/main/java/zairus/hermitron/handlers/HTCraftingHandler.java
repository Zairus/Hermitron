package zairus.hermitron.handlers;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;

public class HTCraftingHandler
{
	public static void addRecipes()
	{
		IRecipe hermitronPedestal = new PedestalRecipe();
		IRecipe hermitronScoreboard = new ScoreboardRecipe();
		
		RecipeSorter.register("Hermitron_Pedestal", PedestalRecipe.class, Category.SHAPED, "");
		RecipeSorter.register("Hermitron_Scoreboard", ScoreboardRecipe.class, Category.SHAPED, "");
		
		GameRegistry.addRecipe(hermitronPedestal);
		GameRegistry.addRecipe(hermitronScoreboard);
	}
}
