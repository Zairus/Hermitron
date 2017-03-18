package zairus.hermitron.util.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import zairus.hermitron.tileentity.TileEntityHermitronPedestal;

public class PedestalPacket extends AbstractPacket
{
	private int x;
	private int y;
	private int z;
	
	public PedestalPacket()
	{
		;
	}
	
	public PedestalPacket(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
	}
	
	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
	}
	
	@Override
	public void handleClientSide(EntityPlayer player)
	{
	}
	
	@Override
	public void handleServerSide(EntityPlayer player)
	{
		TileEntity tileEntity = player.worldObj.getTileEntity(new BlockPos(x, y, z));
		
		if (tileEntity instanceof TileEntityHermitronPedestal)
		{
			TileEntityHermitronPedestal pedestal = ((TileEntityHermitronPedestal)tileEntity);
			pedestal.completeSet(player);
		}
	}
}
