package zairus.hermitron.tileentity;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.data.HTDataManager;
import zairus.hermitron.item.ItemHermitron;
import zairus.hermitron.item.ItemHermitronSet;

public class TileEntityHermitronScoreboard extends HTTileEntityBase
{
	private ItemStack[] chestContents = new ItemStack[9];
	private int controlTicks = 0;
	
	Map<String, Integer> score;
	
	public TileEntityHermitronScoreboard()
	{
		;
	}
	
	public String getGUIDisplayName()
	{
		return this.hasCustomName()? this.customName : "Hermitron Scoreboard";
	}
	
	@Override
	public Slot getSlot(IInventory inv, int index, int x, int y)
	{
		return new Slot(inv, index, x, y);
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
		return null;
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
		
		if (controlTicks % 100 == 50 && !(this.worldObj.isRemote))
		{
			this.score = HTDataManager.get(this.worldObj).playerScore;
			updateMe();
		}
	}
	
	public Map<String, Integer> getScore()
	{
		return this.score;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		return super.writeToNBT(compound);
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		NBTTagCompound syncData = new NBTTagCompound();
		writeSyncableDataToNBT(syncData);
		return new SPacketUpdateTileEntity(this.getPos(), 1, syncData);
	}
	
	@Override
	public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt)
	{
		readSyncableDataFromNBT(pkt.getNbtCompound());
	}
	
	protected void writeSyncableDataToNBT(NBTTagCompound syncData)
	{
		if (score == null)
			return;
		
		NBTTagCompound scoreData = new NBTTagCompound();
		
		for (String k : score.keySet())
		{
			scoreData.setInteger(k, score.get(k));
		}
		
		syncData.setTag("hermitronScore", scoreData);
	}
	
	protected void readSyncableDataFromNBT(NBTTagCompound syncData)
	{
		if (syncData.hasKey("hermitronScore"))
		{
			NBTTagCompound scoreData = syncData.getCompoundTag("hermitronScore");
			
			for (String k : scoreData.getKeySet())
			{
				if (score == null)
					score = new HashMap<String, Integer>();
				
				if (scoreData.hasKey(k))
					score.put(k, scoreData.getInteger(k));
			}
		}
	}
	
	private void updateMe()
	{
		this.markDirty();
		
		IBlockState state = this.worldObj.getBlockState(getPos());
		this.worldObj.notifyBlockUpdate(getPos(), state, state, 0);
	}
}
