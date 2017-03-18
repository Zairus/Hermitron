package zairus.hermitron.stats;

import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.text.TextComponentTranslation;

public class HTStatList
{
	public static final String HERMITRON_CASE_OPENED_KEY = "stat.hermitronCaseOpened";
	public static final String HERMITRON_PEDESTAL_ACCCESSED_KEY = "stat.hermitronPedestalAccessed";
	public static final String HERMITRON_SCOREBOARD_ACCCESSED_KEY = "stat.hermitronScoreboardAccessed";
	public static final String HERMITRON_SETS_KEY = "stat.hermitronSets";
	
	public static final StatBase HERMITRON_CASE_OPENED = (new StatBasic(HERMITRON_CASE_OPENED_KEY, new TextComponentTranslation(HERMITRON_CASE_OPENED_KEY, new Object[0])).registerStat());
	public static final StatBase HERMITRON_PEDESTAL_ACCESSED = (new StatBasic(HERMITRON_PEDESTAL_ACCCESSED_KEY, new TextComponentTranslation(HERMITRON_PEDESTAL_ACCCESSED_KEY, new Object[0]))).registerStat();
	public static final StatBase HERMITRON_SCOREBOARD_ACCESSED = (new StatBasic(HERMITRON_SCOREBOARD_ACCCESSED_KEY, new TextComponentTranslation(HERMITRON_SCOREBOARD_ACCCESSED_KEY, new Object[0]))).registerStat();
	public static final StatBase HERMITRON_SETS = (new StatBasic(HERMITRON_SETS_KEY, new TextComponentTranslation(HERMITRON_SETS_KEY, new Object[0])).registerStat());
}
