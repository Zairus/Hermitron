package zairus.hermitron.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import zairus.hermitron.HTConstants;
import zairus.hermitron.Hermitron;
import zairus.hermitron.handlers.GuiHandler;

public class ItemHermitron extends ItemBase
{
	private Version version;
	private int tribe;
	private Rarity rarity;
	
	public ResourceLocation textures = null;
	
	public ItemHermitron()
	{
		super();
	}
	
	public ItemHermitron setVersion(Version v)
	{
		this.version = v;
		return this;
	}
	
	public Version getVersion()
	{
		return this.version;
	}
	
	public ItemHermitron setTribe(int t)
	{
		this.tribe = t;
		return this;
	}
	
	public int getTribe()
	{
		return this.tribe;
	}
	
	public ItemHermitron setRarity(Rarity r)
	{
		this.rarity = r;
		return this;
	}
	
	public Rarity getRarity()
	{
		return this.rarity;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
	{
		player.openGui(Hermitron.instance, GuiHandler.GUI_HERMITRON_INFO, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, itemStack);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	{
		tooltip.add("Version: " + this.version.getName());
		tooltip.add("Tribe: " + this.tribe);
		tooltip.add("Rarity: " + this.rarity.getName());
	}
	
	@Override
	protected void register()
	{
		super.register();
		HTItems.hermitron_sets.get(this.version).add(this);
		OreDictionary.registerOre("itemHermitron" + this.version.getName() + this.rarity.getName(), this);
	}
	
	@Override
	protected ItemBase setItemName(String name)
	{
		this.textures = new ResourceLocation(HTConstants.MODID, "textures/items/hermitron/" + name + ".png");
		return super.setItemName(name);
	}
	
	public static enum Rarity
	{
		COMMON("Common", 1),
		UNCOMMON("Uncommon", 3),
		RARE("Rare", 8),
		MYTHIC("Mythic", 40);
		
		private final String name;
		private final int rarityFactor;
		
		private Rarity(String name, int factor)
		{
			this.name = name;
			this.rarityFactor = factor;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public int getRarityFactor()
		{
			return this.rarityFactor;
		}
	}
	
	public static enum Version
	{
		ALPHA("Alpha"),
		BETA("Beta"),
		GAMA("Gama");
		
		private final String name;
		
		private Version(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return this.name;
		}
	}
}
