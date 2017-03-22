package zairus.hermitron.block;

import javax.annotation.Nullable;

import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
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
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.Hermitron;
import zairus.hermitron.client.renderer.ISpecialRendered;
import zairus.hermitron.client.renderer.tileentity.TileEntityHermitronPedestalRenderer;
import zairus.hermitron.handlers.GuiHandler;
import zairus.hermitron.stats.HTStatList;
import zairus.hermitron.tileentity.TileEntityHermitronScoreboard;

public class BlockHermitronScoreboard extends BlockHermitronContainerBase implements ISpecialRendered, IBlockBase
{
	private String blockName = "";
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	protected static final AxisAlignedBB NOT_CONNECTED_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	
	public BlockHermitronScoreboard()
	{
		super(Material.GROUND);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setCreativeTab(Hermitron.creativeTab);
		this.setHardness(1.5F);
		this.setSoundType(SoundType.METAL);
		this.setHarvestLevel("pickaxe", 0);
	}
	
	@Override
	public BlockHermitronScoreboard setBlockName(String name)
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
		HTBlocks.registerBlock(this, this.blockName, TileEntityHermitronScoreboard.class, "tileEntityHermitronScoreboard", true);
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
			
			if (te != null && te instanceof TileEntityHermitronScoreboard)
			{
				player.openGui(Hermitron.instance, GuiHandler.GUI_HERMITRON_SCORE, world, pos.getX(), pos.getY(), pos.getZ());
				player.addStat(HTStatList.HERMITRON_SCOREBOARD_ACCESSED);
			}
			
			return true;
		}
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
		
		if (tileentity instanceof TileEntityHermitronScoreboard)
		{
			if (stack.hasDisplayName())
			{
				((TileEntityHermitronScoreboard)tileentity).setCustomName(stack.getDisplayName());
			}
			
			if (stack.hasTagCompound())
			{
				if (stack.getTagCompound().hasKey("chestContents"))
				{
					NBTTagCompound tag = stack.getTagCompound().getCompoundTag("chestContents");
					((TileEntityHermitronScoreboard)tileentity).readFromNBT(tag);
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
	
	@SideOnly(Side.CLIENT)
	public boolean addDestroyEffects(World world, BlockPos pos, net.minecraft.client.particle.ParticleManager manager)
	{
		manager.addBlockDestroyEffects(pos, Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN));
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		TileEntityHermitronScoreboard p = new TileEntityHermitronScoreboard();
		p.setCustomName("Hermitron Scoreboard");
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
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		return true;
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
