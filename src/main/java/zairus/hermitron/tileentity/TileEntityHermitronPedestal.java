package zairus.hermitron.tileentity;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.Hermitron;
import zairus.hermitron.data.HTDataManager;
import zairus.hermitron.inventory.SlotPedestal;
import zairus.hermitron.item.HTItems;
import zairus.hermitron.item.ItemHermitron;
import zairus.hermitron.item.ItemHermitron.Version;
import zairus.hermitron.item.ItemHermitronSet;
import zairus.hermitron.sound.HTSoundEvents;
import zairus.hermitron.stats.HTAchievementList;
import zairus.hermitron.stats.HTStatList;
import zairus.hermitron.util.network.PedestalCompletePacket;

public class TileEntityHermitronPedestal extends HTTileEntityBase
{
	private ItemStack[] chestContents = new ItemStack[9];
	private int controlTicks = 0;
	
	public TileEntityHermitronPedestal()
	{
		;
	}
	
	public String getGUIDisplayName()
	{
		return this.hasCustomName()? this.customName : "Hermitron Pedestal";
	}
	
	@Override
	public Slot getSlot(IInventory inv, int index, int x, int y)
	{
		return new SlotPedestal(inv, index, x, y);
	}
	
	@Override
	public ItemStack[] getChestContents()
	{
		return this.chestContents;
	}
	
	@Override
	public void setChestContents(ItemStack[] contents)
	{
		this.chestContents = contents;
	}
	
	@Override
	public int getSlotXOffset()
	{
		return 62;
	}
	
	@Override
	public int getSlotYOffset()
	{
		return 12;
	}
	
	@Override
	public String getDefaultName()
	{
		return this.defaultName;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ResourceLocation getTextures()
	{
		return null;
	}
	
	@Override
	@Nullable
	public SoundEvent getOpenSound()
	{
		return null;
	}
	
	@Override
	@Nullable
	public SoundEvent getCloseSound()
	{
		return null;
	}
	
	@Override
	@Nullable
	public SoundEvent getItemPlaceSound()
	{
		return HTSoundEvents.CARD_HANDLE;
	}
	
	@Override
	public int getInventoryStackLimit()
	{
		return 1;
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		return (stack.getItem() instanceof ItemHermitron) || (stack.getItem() instanceof ItemHermitronSet);
	}
	
	@Override
	public void update()
	{
		super.update();
		
		++controlTicks;
		
		if (controlTicks >= 1000000)
			controlTicks = 0;
		
		if (controlTicks % 100 == 50)
		{
			IBlockState state = this.worldObj.getBlockState(this.getPos());
			this.worldObj.notifyBlockUpdate(this.getPos(), state, state, 3);
		}
	}
	
	public void completeSet(EntityPlayer player)
	{
		if (isSet())
		{
			ItemStack stack = this.getStackInSlot(0);
			
			if (stack == null)
			{
				return;
			}
			
			ItemHermitron itemHermitron = (ItemHermitron)stack.getItem();
			
			Version version = itemHermitron.getVersion();
			int tribe = itemHermitron.getTribe();
			ItemHermitronSet set = null;
			
			for (ItemHermitronSet complete_set : HTItems.hermitron_complete_sets)
			{
				if (complete_set.getVersion() == version && complete_set.getTribe() == tribe)
				{
					set = complete_set;
					break;
				}
			}
			
			if (set != null)
			{
				this.clear();
				this.setInventorySlotContents(4, new ItemStack(set));
				
				String playerName = player.getDisplayNameString();
				
				Object o = HTDataManager.get(getWorld()).playerScore.get(playerName);
				int score = (o == null)? 0 : (int)o;
				score += 5;
				
				HTDataManager.get(getWorld()).playerScore.put(playerName, score);
				HTDataManager.get(getWorld()).markDirty();
				
				Hermitron.packetPipeline.sendToAll(new PedestalCompletePacket(score));
				
				player.addStat(HTStatList.HERMITRON_SETS);
				player.addStat(HTStatList.HERMITRON_SCORE, 5);
				player.addStat(HTAchievementList.HERMITRON_COLLECTOR);
			}
		}
	}
	
	public boolean isSet()
	{
		boolean set = true;
		
		ItemHermitron.Version version = null;
		int tribe = -1;
		ItemStack stack;
		
		int commonCount = 0;
		int uncommonCount = 0;
		int rareCount = 0;
		int mythicCount = 0;
		
		for (int i = 0; i < 9; ++i)
		{
			stack = this.getStackInSlot(i);
			
			if (stack == null)
				return false;
			
			if (!(stack.getItem() instanceof ItemHermitron))
				return false;
			
			ItemHermitron itemHermitron = (ItemHermitron)stack.getItem();
			
			if (version == null)
				version = itemHermitron.getVersion();
			
			if (tribe == -1)
				tribe = itemHermitron.getTribe();
			
			if (version != itemHermitron.getVersion())
				return false;
			
			if (tribe != itemHermitron.getTribe())
				return false;
			
			if (itemHermitron.getRarity() == ItemHermitron.Rarity.COMMON)
				++commonCount;
			
			if (itemHermitron.getRarity() == ItemHermitron.Rarity.UNCOMMON)
				++uncommonCount;
			
			if (itemHermitron.getRarity() == ItemHermitron.Rarity.RARE)
				++rareCount;
			
			if (itemHermitron.getRarity() == ItemHermitron.Rarity.MYTHIC)
				++mythicCount;
		}
		
		if (commonCount != 3)
			return false;
		
		if (uncommonCount != 3)
			return false;
		
		if (rareCount != 2)
			return false;
		
		if (mythicCount != 1)
			return false;
		
		return set;
	}
}
