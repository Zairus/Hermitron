package zairus.hermitron.plugins.jei;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.item.ItemStack;
import zairus.hermitron.handlers.IHTRecipe;

public class HTRecipeWrapper extends BlankRecipeWrapper
{
	public IHTRecipe recipe;
	
	public HTRecipeWrapper(IHTRecipe recipe)
	{
		this.recipe = recipe;
	}
	
	@Override
	public void getIngredients(IIngredients ingredients)
	{
		ingredients.setInputLists(ItemStack.class, this.recipe.getCrafting());
		
		ingredients.setOutput(ItemStack.class, recipe.getRecipeOutput());
	}
}
