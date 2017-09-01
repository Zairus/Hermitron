package zairus.hermitron.plugins.jei;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import zairus.hermitron.HTConstants;

public class HTRecipeCategory extends BlankRecipeCategory<IRecipeWrapper>
{
	public static final String CATEGORY_ID = "hermitron";
	
	private final IDrawable background;
	private final String name;
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(HTConstants.MODID, "textures/gui/hermitron_crafting.png");
	
	public HTRecipeCategory(IGuiHelper helper, String recipeId)
	{
		this.background = helper.createDrawable(TEXTURE, 0, 0, 125, 125);
		this.name = I18n.format("hermitron.jei.recipe." + recipeId);
	}
	
	@Override
	public String getUid()
	{
		return CATEGORY_ID;
	}
	
	@Override
	public String getTitle()
	{
		return this.name;
	}
	
	@Override
	public IDrawable getBackground()
	{
		return this.background;
	}
	
	@Override
	public void drawExtras(Minecraft minecraft)
	{
	}
	
	@Override
	public void drawAnimations(Minecraft minecraft)
	{
	}
	
	@Override
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients)
	{
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		
		stacks.init(1, true, 28, 35);
		stacks.init(2, true, 45, 35);
		stacks.init(3, true, 63, 35);
		
		stacks.init(4, true, 28, 52);
		stacks.init(5, true, 45, 52);
		stacks.init(6, true, 63, 52);
		
		stacks.init(7, true, 28, 69);
		stacks.init(8, true, 45, 69);
		stacks.init(9, true, 63, 69);
		
		stacks.init(10, false, 90, 52);
		
		stacks.set(1, ingredients.getInputs(ItemStack.class).get(0));
		stacks.set(2, ingredients.getInputs(ItemStack.class).get(1));
		stacks.set(3, ingredients.getInputs(ItemStack.class).get(2));
		
		stacks.set(4, ingredients.getInputs(ItemStack.class).get(3));
		stacks.set(5, ingredients.getInputs(ItemStack.class).get(4));
		stacks.set(6, ingredients.getInputs(ItemStack.class).get(5));
		
		stacks.set(7, ingredients.getInputs(ItemStack.class).get(6));
		stacks.set(8, ingredients.getInputs(ItemStack.class).get(7));
		stacks.set(9, ingredients.getInputs(ItemStack.class).get(8));
		
		stacks.set(10, ingredients.getOutputs(ItemStack.class).get(0));
		
		recipeLayout.getItemStacks().init(0, true, 0, 0);
	}
}
