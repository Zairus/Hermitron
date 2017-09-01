package zairus.hermitron.handlers;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import zairus.hermitron.block.HTBlocks;
import zairus.hermitron.item.HTItems;
import zairus.hermitron.item.ItemHermitron;

public class PedestalRecipe implements IHTRecipe
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
	
	@Override
	public List<List<ItemStack>> getCrafting()
	{
		List<ItemStack> craftingOption;
		List<List<ItemStack>> options = new ArrayList<List<ItemStack>>();
		
		craftingOption = new ArrayList<ItemStack>();
		craftingOption.add(new ItemStack(Blocks.QUARTZ_BLOCK));
		
		options.add(craftingOption);
		options.add(craftingOption);
		options.add(craftingOption);
		
		craftingOption = new ArrayList<ItemStack>();
		for (List<ItemHermitron> hermitronList : HTItems.hermitron_sets.values())
		{
			for (ItemHermitron hermitron : hermitronList)
			{
				craftingOption.add(new ItemStack(hermitron));
			}
		}
		
		options.add(new ArrayList<ItemStack>());
		options.add(craftingOption);
		options.add(new ArrayList<ItemStack>());
		
		craftingOption = new ArrayList<ItemStack>();
		craftingOption.add(new ItemStack(Blocks.LAPIS_BLOCK));
		
		options.add(craftingOption);
		options.add(craftingOption);
		options.add(craftingOption);
		
		return options;
	}
}