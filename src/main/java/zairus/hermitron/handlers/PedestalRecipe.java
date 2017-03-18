package zairus.hermitron.handlers;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import zairus.hermitron.block.HTBlocks;
import zairus.hermitron.item.ItemHermitron;

public class PedestalRecipe implements IRecipe
{
	private ItemStack pedestal = new ItemStack(HTBlocks.HERMITRON_PEDESTAL);
	
	@Override
	public boolean matches(InventoryCrafting inv, World world)
	{
		boolean m = true;
		
		for (int i = 0; i < 3; ++i)
		{
			if (!checkSlotForItem(inv, i, Blocks.LAPIS_BLOCK))
				return false;
		}
		
		if (inv.getStackInSlot(4) == null)
			return false;
		
		if (!(inv.getStackInSlot(4).getItem() instanceof ItemHermitron))
			return false;
		
		for (int i = 6; i < 9; ++i)
		{
			if (!checkSlotForItem(inv, i, Blocks.QUARTZ_BLOCK))
				return false;
		}
		
		return m;
	}
	
	private boolean checkSlotForItem(InventoryCrafting inv, int slot, Item item)
	{
		return (inv.getStackInSlot(slot) == null)? false : (inv.getStackInSlot(slot).getItem() == item);
	}
	
	private boolean checkSlotForItem(InventoryCrafting inv, int slot, Block block)
	{
		return checkSlotForItem(inv, slot, Item.getItemFromBlock(block));
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv)
	{
		return this.pedestal.copy();
	}
	
	@Override
	public int getRecipeSize()
	{
		return 10;
	}
	
	@Override
	public ItemStack getRecipeOutput()
	{
		return this.pedestal;
	}
	
	@Override
	public ItemStack[] getRemainingItems(InventoryCrafting inv)
	{
		ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];
		
		for (int i = 0; i < aitemstack.length; ++i)
		{
			ItemStack itemstack = inv.getStackInSlot(i);
			aitemstack[i] = net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack);
		}
		
		return aitemstack;
	}
}