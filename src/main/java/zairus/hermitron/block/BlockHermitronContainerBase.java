package zairus.hermitron.block;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.tileentity.HTTileEntityBase;
import zairus.hermitron.tileentity.TileEntityHermitronCase;
import zairus.hermitron.tileentity.TileEntityHermitronScoreboard;

public class BlockHermitronContainerBase extends BlockContainer
{
	protected BlockHermitronContainerBase(Material material)
	{
		super(material);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return null;
	}
	
	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
	{
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		TileEntity tileentity = world.getTileEntity(pos);
		
		if (tileentity != null && tileentity instanceof IInventory)
			world.updateComparatorOutputLevel(pos, this);
		
		if (tileentity != null && tileentity instanceof HTTileEntityBase /*&& !((HTTileEntityBase)tileentity).isEmpty()*/)
		{
			dropWithContents(world, state, pos, tileentity);
		}
		
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player)
	{
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, @Nullable ItemStack stack)
	{
	}
	
	private void dropWithContents(World world, IBlockState state, BlockPos pos, @Nullable TileEntity te)
	{
		Item item = this.getItemDropped(state, world.rand, 0);
		ItemStack itemStack = new ItemStack(item, 1, this.damageDropped(state));
		
		if (te != null && te instanceof HTTileEntityBase)
		{
			if (!((HTTileEntityBase)te).isEmpty())
			{
				NBTTagCompound tag = new NBTTagCompound();
				tag = ((HTTileEntityBase)te).writeToNBT(tag);
				
				itemStack.setTagCompound(new NBTTagCompound());
				itemStack.getTagCompound().setTag("chestContents", tag);
				
				if (tag.hasKey("CustomName"))
					itemStack.setStackDisplayName(tag.getString("CustomName"));
			}
		}
		
		spawnAsEntity(world, pos, itemStack);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
	{
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("chestContents"))
		{
			NBTTagCompound tag = stack.getTagCompound().getCompoundTag("chestContents");
			
			if (tag.hasKey("Items", 9))
			{
				NBTTagList nbttaglist = tag.getTagList("Items", 10);
				
				ItemStack itemStack;
				
				int itemCount = nbttaglist.tagCount();
				if (itemCount > 8)
					itemCount = 8;
				
				for (int i = 0; i < itemCount; ++i)
				{
					NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
					itemStack = ItemStack.loadItemStackFromNBT(nbttagcompound);
					if (itemStack != null)
					{
						tooltip.add(String.format("%s x%d", new Object[] { itemStack.getDisplayName(), Integer.valueOf(itemStack.stackSize) }));
					}
				}
				
				if (nbttaglist.tagCount() > 8)
					tooltip.add("...");
			}
		}
	}
	
	@Nullable
	public ILockableContainer getLockableContainer(World world, BlockPos pos)
	{
		return this.getContainer(world, pos, false);
	}
	
	@Nullable
	public ILockableContainer getContainer(World world, BlockPos pos, boolean flag)
	{
		TileEntity tileentity = world.getTileEntity(pos);
		
		if (!(tileentity instanceof TileEntityHermitronCase))
		{
			return null;
		}
		else
		{
			ILockableContainer ilockablecontainer = (HTTileEntityBase)tileentity;
			
			if (this.isBlocked(world, pos))
			{
				return null;
			}
			else
			{
				return ilockablecontainer;
			}
		}
	}
	
	@Override
	public boolean canProvidePower(IBlockState state)
	{
		return true;
	}
	
	@Override
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		if (!blockState.canProvidePower())
		{
			return 0;
		}
		else
		{
			int i = 0;
			TileEntity tileentity = blockAccess.getTileEntity(pos);
			
			if (tileentity instanceof TileEntityHermitronScoreboard)
			{
				i = ((TileEntityHermitronScoreboard)tileentity).playersUsing;
			}
			
			return MathHelper.clamp_int(i, 0, 15);
		}
	}
	
	@Override
	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return side == EnumFacing.UP ? blockState.getWeakPower(blockAccess, pos, side) : 0;
	}
	
	private boolean isBlocked(World worldIn, BlockPos pos)
	{
		return this.isBelowSolidBlock(worldIn, pos);
	}
	
	private boolean isBelowSolidBlock(World worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos.up()).isSideSolid(worldIn, pos.up(), EnumFacing.DOWN);
	}
	
	@Override
	public boolean hasComparatorInputOverride(IBlockState state)
	{
		return true;
	}
	
	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
	{
		return Container.calcRedstoneFromInventory(this.getLockableContainer(worldIn, pos));
	}
}
