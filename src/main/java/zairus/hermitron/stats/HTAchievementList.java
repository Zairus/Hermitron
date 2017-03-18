package zairus.hermitron.stats;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import zairus.hermitron.HTConstants;
import zairus.hermitron.item.HTItems;

public class HTAchievementList
{
	public static final Achievement HERMITRON_GO = new Achievement(HTConstants.MODID + ":" + "achievement.hermitron_go", "hermitron_go", 0, 0, HTItems.A0_COMPLETED_SET, (Achievement)null).initIndependentStat().registerStat();
	public static final Achievement HERMITRON_COLLECTOR = new Achievement(HTConstants.MODID + ":" + "achievement.hermitron_collector", "hermitron_collector", 0, 0, HTItems.A0_COMPLETED_SET, (Achievement)null).initIndependentStat().registerStat();
	public static final Achievement HERMITRON_MASTER = new Achievement(HTConstants.MODID + ":" + "achievement.hermitron_master", "hermitron_master", 0, 0, HTItems.A0_COMPLETED_SET, (Achievement)null).initIndependentStat().registerStat();
	public static final Achievement FREAKING_NERD = new Achievement(HTConstants.MODID + ":" + "achievement.freaking_nerd", "freaking_nerd", 0, 0, HTItems.A0_COMPLETED_SET, (Achievement)null).initIndependentStat().registerStat();
	
	public static final AchievementPage HT_ACHIEVEMENT_PAGE1 = new AchievementPage("Hermitron GO", HERMITRON_GO);
	
	public static void initPages()
	{
		AchievementPage.registerAchievementPage(HT_ACHIEVEMENT_PAGE1);
	}
}
