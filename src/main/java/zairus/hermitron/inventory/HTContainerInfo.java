package zairus.hermitron.inventory;

import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import zairus.hermitron.item.ItemHermitron;

public class HTContainerInfo extends Container
{
	@SuppressWarnings("unused")
	private ItemHermitron itemHermitron;
	@SuppressWarnings("unused")
	private EntityPlayer player;
	private Map<String, Integer> score;
	
	public HTContainerInfo()
	{
		;
	}
	
	public HTContainerInfo(ItemHermitron itemHermitron, EntityPlayer player, Map<String, Integer> score)
	{
		this.itemHermitron = itemHermitron;
		this.player = player;
		this.score = score;
	}
	
	public Map<String, Integer> getScoreData()
	{
		return this.score;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
}
