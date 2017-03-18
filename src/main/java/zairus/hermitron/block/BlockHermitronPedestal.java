package zairus.hermitron.block;

import javax.annotation.Nullable;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import zairus.hermitron.Hermitron;
import zairus.hermitron.client.renderer.ISpecialRendered;
import zairus.hermitron.client.renderer.tileentity.TileEntityHermitronPedestalRenderer;
import zairus.hermitron.handlers.GuiHandler;
import zairus.hermitron.stats.HTStatList;
import zairus.hermitron.tileentity.HTTileEntityBase;
import zairus.hermitron.tileentity.TileEntityHermitronPedestal;

public class BlockHermitronPedestal extends BlockContainer implements ISpecialRendered, IBlockBase
{
	private String blockName = "";
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	protected static final AxisAlignedBB NOT_CONNECTED_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	
	public BlockHermitronPedestal()
	{
		super(Material.CIRCUITS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setCreativeTab(Hermitron.creativeTab);
		this.setHardness(1.5F);
		this.setSoundType(SoundType.METAL);
		this.setHarvestLevel("pickaxe", 0);
	}
	
	@Override
	public BlockHermitronPedestal setBlockName(String name)
	{
		this.blockName = name;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		return this;
	}
	
	@Override
	public String getBlockName()
	{
		return this.blockName;
	}
	
	@Override
	public void register()
	{
		HTBlocks.registerBlock(this, this.blockName, TileEntityHermitronPedestal.class, "tileEntityHermitronPedestal", true);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		else
		{
			TileEntity te = world.getTileEntity(pos);
			
			if (te != null && te instanceof TileEntityHermitronPedestal)
			{
				player.openGui(Hermitron.instance, GuiHandler.GUI_HERMITRON_PEDESTAL, world, pos.getX(), pos.getY(), pos.getZ());
				player.addStat(HTStatList.HERMITRON_PEDESTAL_ACCESSED);
			}
			
			return true;
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		TileEntityHermitronPedestal p = new TileEntityHermitronPedestal();
		p.setCustomName("Hermitron Pedestal");
		return p;
	}
	
	@Override
	public Object getTESR()
	{
		return new TileEntityHermitronPedestalRenderer();
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return NOT_CONNECTED_AABB;
	}
	
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3).getOpposite();
		state = state.withProperty(FACING, enumfacing);
		worldIn.setBlockState(pos, state, 3);
		
		TileEntity tileentity = worldIn.getTileEntity(pos);
		
		if (tileentity instanceof TileEntityHermitronPedestal)
		{
			if (stack.hasDisplayName())
			{
				((TileEntityHermitronPedestal)tileentity).setCustomName(stack.getDisplayName());
			}
			
			if (stack.hasTagCompound())
			{
				if (stack.getTagCompound().hasKey("chestContents"))
				{
					NBTTagCompound tag = stack.getTagCompound().getCompoundTag("chestContents");
					((TileEntityHermitronPedestal)tileentity).readFromNBT(tag);
					tileentity.setPos(pos);
				}
			}
		}
	}
	
	public IBlockState correctFacing(World worldIn, BlockPos pos, IBlockState state)
	{
		EnumFacing enumfacing = null;
		
		for (EnumFacing enumfacing1 : EnumFacing.Plane.HORIZONTAL)
		{
			IBlockState iblockstate = worldIn.getBlockState(pos.offset(enumfacing1));
			
			if (iblockstate.getBlock() == this)
			{
				return state;
			}
			
			if (iblockstate.isFullBlock())
			{
				if (enumfacing != null)
				{
					enumfacing = null;
					break;
				}
				
				enumfacing = enumfacing1;
			}
		}
		
		if (enumfacing != null)
		{
			return state.withProperty(FACING, enumfacing.getOpposite());
		}
		else
		{
			EnumFacing enumfacing2 = (EnumFacing)state.getValue(FACING);
			
			if (worldIn.getBlockState(pos.offset(enumfacing2)).isFullBlock())
			{
				enumfacing2 = enumfacing2.getOpposite();
			}
			
			if (worldIn.getBlockState(pos.offset(enumfacing2)).isFullBlock())
			{
				enumfacing2 = enumfacing2.rotateY();
			}
			
			if (worldIn.getBlockState(pos.offset(enumfacing2)).isFullBlock())
			{
				enumfacing2 = enumfacing2.getOpposite();
			}
			
			return state.withProperty(FACING, enumfacing2);
		}
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		TileEntity tileentity = worldIn.getTileEntity(pos);
		
		if (tileentity instanceof IInventory)
			worldIn.updateComparatorOutputLevel(pos, this);
		
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, @Nullable ItemStack stack)
	{
		Item item = this.getItemDropped(state, world.rand, 0);
		ItemStack itemStack = new ItemStack(item, 1, this.damageDropped(state));
		
		if (te instanceof HTTileEntityBase)
		{
			if (!((HTTileEntityBase)te).isEmpty())
			{
				NBTTagCompound tag = new NBTTagCompound();
				tag = ((HTTileEntityBase)te).writeToNBT(tag);
				itemStack.setTagCompound(new NBTTagCompound());
				itemStack.getTagCompound().setTag("chestContents", tag);
			}
		}
		
		spawnAsEntity(world, pos, itemStack);
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
		
		if (!(tileentity instanceof TileEntityHermitronPedestal))
		{
			return null;
		}
		else
		{
			ILockableContainer ilockablecontainer = (TileEntityHermitronPedestal)tileentity;
			
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
			
			if (tileentity instanceof TileEntityHermitronPedestal)
			{
				i = ((TileEntityHermitronPedestal)tileentity).playersUsing;
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
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		EnumFacing enumfacing = EnumFacing.getFront(meta);
		
		if (enumfacing.getAxis() == EnumFacing.Axis.Y)
		{
			enumfacing = EnumFacing.NORTH;
		}
		
		return this.getDefaultState().withProperty(FACING, enumfacing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	{
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}
}
