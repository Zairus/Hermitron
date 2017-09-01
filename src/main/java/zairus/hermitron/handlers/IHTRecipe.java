package zairus.hermitron.handlers;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public interface IHTRecipe extends IRecipe
{
	public List<List<ItemStack>> getCrafting();
}
