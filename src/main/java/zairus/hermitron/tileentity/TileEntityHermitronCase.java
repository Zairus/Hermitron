package zairus.hermitron.tileentity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.Nullable;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.hermitron.HTConstants;
import zairus.hermitron.inventory.SlotHermitronCase;
import zairus.hermitron.item.HTItems;
import zairus.hermitron.item.ItemHermitron;
import zairus.hermitron.item.ItemHermitron.Version;
import zairus.hermitron.sound.HTSoundEvents;

public class TileEntityHermitronCase extends HTTileEntityBase
{
	private static final ResourceLocation ALPHA_TEXTURES = new ResourceLocation(HTConstants.MODID, "textures/entity/hermitron_case.png");
	private static final ResourceLocation BETA_TEXTURES = new ResourceLocation(HTConstants.MODID, "textures/entity/hermitron_case_beta.png");
	private static final ResourceLocation GAMMA_TEXTURES = new ResourceLocation(HTConstants.MODID, "textures/entity/hermitron_case_gamma.png");
	
	private ItemStack[] chestContents = new ItemStack[27];
	private ItemHermitron.Version case_version;
	
	protected String defaultName = "hermitroncase";
	
	public TileEntityHermitronCase()
	{
		;
	}
	
	public String getGUIDisplayName()
	{
		return this.hasCustomName()? this.customName : "Hermitron Case";
	}
	
	public TileEntityHermitronCase setVersion(ItemHermitron.Version v)
	{
		this.case_version = v;
		return this;
	}
	
	public void setLoot(Random rand)
	{
		if (this.case_version == null)
			return;
		
		List<ItemHermitron> hermitrons_total = HTItems.hermitron_sets.get(this.case_version);
		List<ItemHermitron> hermitrons_collected = new ArrayList<ItemHermitron>();
		
		while(hermitrons_collected.size() < 5)
		{
			ItemHermitron cur_hermitron = hermitrons_total.get(rand.nextInt(hermitrons_total.size()));
			if (rand.nextInt(cur_hermitron.getRarity().getRarityFactor()) == 0)
				hermitrons_collected.add(cur_hermitron);
		}
		
		List<Integer> invSlots = IntStream.range(0, 27).boxed().collect(Collectors.toCollection(ArrayList::new));
		Collections.shuffle(invSlots);
		
		for (int i = 0; i < 5; ++i)
		{
			this.setInventorySlotContents(invSlots.get(i), new ItemStack(hermitrons_collected.get(i)));
		}
	}
	
	@Override
	public Slot getSlot(IInventory inv, int index, int x, int y)
	{
		return new SlotHermitronCase(inv, index, x, y);
	}
	
	@Override
	public ItemStack[] getChestContents()
	{
		return this.chestContents;
	}
	
	@Override
	public void setChestContents(ItemStack[] contents)
	{
		this.chestContents = contents;
	}
	
	@Override
	public int getSlotXOffset()
	{
		return 8;
	}
	
	@Override
	public int getSlotYOffset()
	{
		return 16;
	}
	
	@Override
	public String getDefaultName()
	{
		return this.defaultName;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ResourceLocation getTextures()
	{
		return (this.case_version == Version.ALPHA)? ALPHA_TEXTURES : (this.case_version == Version.BETA)? BETA_TEXTURES : GAMMA_TEXTURES;
	}
	
	@Override
	@Nullable
	public SoundEvent getOpenSound()
	{
		return HTSoundEvents.HERMITRON_CASE_OPEN;
	}
	
	@Override
	@Nullable
	public SoundEvent getCloseSound()
	{
		return HTSoundEvents.HERMITRON_CASE_CLOSE;
	}
	
	@Override
	@Nullable
	public SoundEvent getItemPlaceSound()
	{
		return null;
	}
}
