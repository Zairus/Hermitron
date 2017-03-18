package zairus.hermitron.inventory;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import zairus.hermitron.block.BlockHermitronCase;

public class SlotHermitronCase extends Slot
{
	public SlotHermitronCase(IInventory inventory, int index, int xPosition, int yPosition)
	{
		super(inventory, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return !(Block.getBlockFromItem(stack.getItem()) instanceof BlockHermitronCase);
	}
}
