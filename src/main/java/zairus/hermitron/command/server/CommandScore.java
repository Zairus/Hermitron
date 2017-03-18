package zairus.hermitron.command.server;

import java.util.Map;
import java.util.Set;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import zairus.hermitron.data.HTDataManager;

public class CommandScore extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "hermitron_score";
	}
	
	@Override
	public String getCommandUsage(ICommandSender sender)
	{
		return "";
	}
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if (sender instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)sender;
			Map<String, Integer> score = HTDataManager.get(player.worldObj).playerScore;
			Set<String> keys = score.keySet();
			
			for (String p : keys)
			{
				TextComponentString msg = new TextComponentString(p + "'s Hermitron score is: " + score.get(p));
				sender.addChatMessage(msg);
				server.addChatMessage(msg);
			}
		}
	}
}
