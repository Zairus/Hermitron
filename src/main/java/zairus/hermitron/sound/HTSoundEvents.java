package zairus.hermitron.sound;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zairus.hermitron.HTConstants;

public class HTSoundEvents
{
	public static SoundEvent HERMITRON_CASE_OPEN;
	public static SoundEvent HERMITRON_CASE_CLOSE;
	public static SoundEvent CARD_HANDLE;
	public static SoundEvent SET_COMPLETE;
	
	public static SoundEvent registerSound(ResourceLocation location)
	{
		SoundEvent sound = new SoundEvent(location).setRegistryName(location);
		GameRegistry.register(sound);
		return sound;
	}
	
	private static SoundEvent registerSound(String location)
	{
		return registerSound(new ResourceLocation(HTConstants.MODID, location));
	}
	
	public static void register()
	{
		HERMITRON_CASE_OPEN = registerSound("hermitron_case_open");
		HERMITRON_CASE_CLOSE = registerSound("hermitron_case_close");
		CARD_HANDLE = registerSound("card_handle");
		SET_COMPLETE = registerSound("set_complete");
	}
}
