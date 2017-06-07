package zairus.hermitron.command.server;

import org.apache.commons.lang3.math.NumberUtils;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import zairus.hermitron.biome.decorate.WorldGenDecorationBase.GenerationType;
import zairus.hermitron.Hermitron;
import zairus.hermitron.biome.decorate.WorldGenHermitronCase;

public class CommandGenerate extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "hermitron_generate";
	}
	
	@Override
	public String getCommandUsage(ICommandSender sender)
	{
		return "hermitron_generate <x> <y> <z>";
	}
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if (sender instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)sender;
			
			int x = (int)player.posX;
			int y = (int)player.posY;
			int z = (int)player.posZ;
			
			if (args.length > 0)
				x = ((NumberUtils.isNumber(args[0])) ? Integer.valueOf(args[0]) : x);
			
			if (args.length > 1)
				y = ((NumberUtils.isNumber(args[1])) ? Integer.valueOf(args[1]) : y);
			
			if (args.length > 2)
				z = ((NumberUtils.isNumber(args[2])) ? Integer.valueOf(args[2]) : z);
			
			BlockPos pos = new BlockPos(x, y, z);
			
			Hermitron.logger.info("p:" + pos);
			
			WorldGenHermitronCase h = new WorldGenHermitronCase(GenerationType.ANYWHERE);
			h.setRarity(1);
			
			h.generate(player.worldObj, player.worldObj.rand, pos);
		}
	}
}
