package zairus.hermitron.item;

import net.minecraft.util.ResourceLocation;
import zairus.hermitron.HTConstants;
import zairus.hermitron.item.ItemHermitron.Version;

public class ItemHermitronSet extends ItemBase
{
	public ResourceLocation textures = null;
	
	private Version version;
	private int tribe;
	
	public ItemHermitronSet()
	{
		super();
	}
	
	public ItemHermitronSet setVersion(Version v)
	{
		this.version = v;
		return this;
	}
	
	public Version getVersion()
	{
		return this.version;
	}
	
	public ItemHermitronSet setTribe(int t)
	{
		this.tribe = t;
		return this;
	}
	
	public int getTribe()
	{
		return this.tribe;
	}
	
	@Override
	protected ItemBase setItemName(String name)
	{
		this.textures = new ResourceLocation(HTConstants.MODID, "textures/items/hermitron/" + name + ".png");
		return super.setItemName(name);
	}
	
	@Override
	protected void register()
	{
		super.register();
		HTItems.hermitron_complete_sets.add(this);
	}
}
