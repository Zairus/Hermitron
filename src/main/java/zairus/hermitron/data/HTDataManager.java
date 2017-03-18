package zairus.hermitron.data;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;
import zairus.hermitron.HTConstants;

public class HTDataManager extends WorldSavedData
{
	private static final String ID = HTConstants.MODID + "_score";
	
	public Map<String, Integer> playerScore = new HashMap<String, Integer>();
	
	public HTDataManager()
	{
		super(ID);
	}
	
	public HTDataManager(String name)
	{
		super(name);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		for (String playerName : nbt.getKeySet())
		{
			playerScore.put(playerName, nbt.getInteger(playerName));
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		for (String playerName : playerScore.keySet())
		{
			compound.setInteger(playerName, playerScore.get(playerName));
		}
		
		return compound;
	}
	
	public static HTDataManager get(World world)
	{
		MapStorage storage = world.getMapStorage();
		HTDataManager instance = (HTDataManager) storage.getOrLoadData(HTDataManager.class, ID);
		
		if (instance == null)
		{
			instance = new HTDataManager();
			storage.setData(ID, instance);
		}
		
		return instance;
	}
}
