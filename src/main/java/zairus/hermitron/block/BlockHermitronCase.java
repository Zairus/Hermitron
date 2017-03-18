package zairus.hermitron.block;

import javax.annotation.Nullable;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.Hermitron;
import zairus.hermitron.client.renderer.ISpecialRendered;
import zairus.hermitron.client.renderer.tileentity.TileEntityContainerBaseRenderer;
import zairus.hermitron.handlers.GuiHandler;
import zairus.hermitron.stats.HTAchievementList;
import zairus.hermitron.stats.HTStatList;
import zairus.hermitron.tileentity.HTTileEntityBase;
import zairus.hermitron.tileentity.TileEntityHermitronCase;

public class BlockHermitronCase extends BlockContainer implements ISpecialRendered, IBlockBase
{
	private String blockName = "";
	
	protected static final AxisAlignedBB NOT_CONNECTED_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	
	public BlockHermitronCase()
	{
		super(Material.CIRCUITS);
		this.setDefaultState(this.blockState.getBaseState());
		this.setCreativeTab(Hermitron.creativeTab);
		this.setHardness(1.5F);
		this.setSoundType(SoundType.METAL);
		this.setHarvestLevel("pickaxe", 0);
	}
	
	@Override
	public BlockHermitronCase setBlockName(String name)
	{
		this.blockName = name;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
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
		HTBlocks.registerBlock(this, this.blockName, TileEntityHermitronCase.class, "tileEntityHermitornCase", true);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean addDestroyEffects(World world, BlockPos pos, net.minecraft.client.particle.ParticleManager manager)
	{
		return false;
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
			
			if (te != null && te instanceof TileEntityHermitronCase)
			{
				player.openGui(Hermitron.instance, GuiHandler.GUI_HERMITRON_CASE, world, pos.getX(), pos.getY(), pos.getZ());
				player.addStat(HTStatList.HERMITRON_CASE_OPENED);
				player.addStat(HTAchievementList.HERMITRON_GO);
			}
			
			return true;
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		TileEntityHermitronCase hc = new TileEntityHermitronCase();
		hc.setCustomName("Hermitron Case");
		return hc;
	}
	
	@Override
	public Object getTESR()
	{
		return new TileEntityContainerBaseRenderer();
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
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		worldIn.setBlockState(pos, state, 3);
		
		TileEntity tileentity = worldIn.getTileEntity(pos);
		
		if (tileentity instanceof TileEntityHermitronCase)
		{
			if (stack.hasDisplayName())
			{
				((TileEntityHermitronCase)tileentity).setCustomName(stack.getDisplayName());
			}
			
			if (stack.hasTagCompound())
			{
				if (stack.getTagCompound().hasKey("chestContents"))
				{
					NBTTagCompound tag = stack.getTagCompound().getCompoundTag("chestContents");
					((TileEntityHermitronCase)tileentity).readFromNBT(tag);
					tileentity.setPos(pos);
				}
			}
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
		
		if (!(tileentity instanceof TileEntityHermitronCase))
		{
			return null;
		}
		else
		{
			ILockableContainer ilockablecontainer = (TileEntityHermitronCase)tileentity;
			
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
			
			if (tileentity instanceof TileEntityHermitronCase)
			{
				i = ((TileEntityHermitronCase)tileentity).playersUsing;
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
		return this.getDefaultState();
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return 0;
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { });
	}
}
