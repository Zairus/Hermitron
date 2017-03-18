package zairus.hermitron.util.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentString;
import zairus.hermitron.sound.HTSoundEvents;

public class PedestalCompletePacket extends AbstractPacket
{
	private int score;
	
	public PedestalCompletePacket()
	{
		;
	}
	
	public PedestalCompletePacket(int score)
	{
		this.score = score;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		buffer.writeInt(score);
	}
	
	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		score = buffer.readInt();
	}
	
	@Override
	public void handleClientSide(EntityPlayer player)
	{
		if (player == null || player.worldObj == null)
			return;
		
		player.addChatMessage(new TextComponentString(player.getDisplayNameString() + " now has " + score + " Hermitron points."));
		player.worldObj.playSound(player, player.getPosition(), HTSoundEvents.SET_COMPLETE, SoundCategory.BLOCKS, 1.0F, 1.0F);
	}
	
	@Override
	public void handleServerSide(EntityPlayer player)
	{
		player.worldObj.getMinecraftServer().addChatMessage(new TextComponentString(player.getDisplayNameString() + " now has " + score + " Hermitron points."));
		player.worldObj.playSound(player, player.getPosition(), HTSoundEvents.SET_COMPLETE, SoundCategory.BLOCKS, 1.0F, 1.0F);
	}
}
