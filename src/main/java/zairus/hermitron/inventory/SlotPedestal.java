package zairus.hermitron.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import zairus.hermitron.item.ItemHermitron;
import zairus.hermitron.item.ItemHermitronSet;

public class SlotPedestal extends Slot
{
	public SlotPedestal(IInventory inventory, int index, int xPosition, int yPosition)
	{
		super(inventory, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return (stack.getItem() instanceof ItemHermitron) || (stack.getItem() instanceof ItemHermitronSet);
	}
	
	@Override
	public int getSlotStackLimit()
	{
		return 1;
	}
}
