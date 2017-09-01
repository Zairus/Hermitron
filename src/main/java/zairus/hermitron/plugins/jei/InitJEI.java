package zairus.hermitron.plugins.jei;

import java.util.ArrayList;
import java.util.List;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import zairus.hermitron.handlers.PedestalRecipe;
import zairus.hermitron.handlers.ScoreboardRecipe;

@JEIPlugin
public class InitJEI extends BlankModPlugin
{
	@Override
	public void register(IModRegistry registry)
	{
		IJeiHelpers helpers = registry.getJeiHelpers();
		IGuiHelper guiHelper = helpers.getGuiHelper();
		
		registry.addRecipeCategories(new HTRecipeCategory(guiHelper, "station"));
		registry.addRecipeHandlers(new HTRecipeHandler());
		
		List<HTRecipeWrapper> recipes = new ArrayList<HTRecipeWrapper>();
		
		recipes.add(new HTRecipeWrapper(new PedestalRecipe()));
		recipes.add(new HTRecipeWrapper(new ScoreboardRecipe()));
		
		registry.addRecipes(recipes);
		
		//registry.addRecipeCategoryCraftingItem(new ItemStack(HTItems.A0C_DIOTREE), "hermitron.diotree");
	}
}
