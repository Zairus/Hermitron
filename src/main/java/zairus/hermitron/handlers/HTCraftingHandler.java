package zairus.hermitron.handlers;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import zairus.hermitron.block.HTBlocks;
import zairus.hermitron.item.ItemHermitron.Rarity;
import zairus.hermitron.item.ItemHermitron.Version;

public class HTCraftingHandler
{
	public static void addRecipes()
	{
		for (Version v : Version.values())
		{
			for (Rarity r : Rarity.values())
			{
				String oreName = "itemHermitron" + v.getName() + r.getName();
				
				if (OreDictionary.doesOreNameExist(oreName))
				{
					Object[] ingredients = new Object[] { "qqq", " h ", "lll", 'q', Blocks.QUARTZ_BLOCK, 'h', oreName, 'l', Blocks.LAPIS_BLOCK };
					ShapedOreRecipe recipe = new ShapedOreRecipe(new ItemStack(HTBlocks.HERMITRON_PEDESTAL), ingredients);
					GameRegistry.addRecipe(recipe);
					
					ingredients = new Object[] { "   ", " h ", "lll", 'h', oreName, 'l', Blocks.LAPIS_BLOCK };
					recipe = new ShapedOreRecipe(new ItemStack(HTBlocks.HERMITRON_SCOREBOARD), ingredients);
					GameRegistry.addRecipe(recipe);
				}
			}
		}
	}
}
