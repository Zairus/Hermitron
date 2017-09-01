package zairus.hermitron.plugins.jei;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class HTRecipeHandler implements IRecipeHandler<HTRecipeWrapper>
{
	@Override
	public Class<HTRecipeWrapper> getRecipeClass()
	{
		return HTRecipeWrapper.class;
	}
	
	@Override
	public String getRecipeCategoryUid()
	{
		return HTRecipeCategory.CATEGORY_ID;
	}
	
	@Override
	public String getRecipeCategoryUid(HTRecipeWrapper recipe)
	{
		return getRecipeCategoryUid();
	}
	
	@Override
	public IRecipeWrapper getRecipeWrapper(HTRecipeWrapper recipe)
	{
		return recipe;
	}
	
	@Override
	public boolean isRecipeValid(HTRecipeWrapper recipe)
	{
		return true;
	}
}
