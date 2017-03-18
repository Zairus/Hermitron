package zairus.hermitron.item;

import net.minecraft.item.Item;
import zairus.hermitron.Hermitron;

public class ItemBase extends Item
{
	protected String itemName = "";
	
	public ItemBase()
	{
		this.setCreativeTab(Hermitron.creativeTab);
	}
	
	protected ItemBase setItemName(String name)
	{
		this.itemName = name;
		
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		
		return this;
	}
	
	protected String getItemName()
	{
		return this.itemName;
	}
	
	protected void register()
	{
		Hermitron.proxy.registerItem(this, this.itemName, 0, true);
	}
}
