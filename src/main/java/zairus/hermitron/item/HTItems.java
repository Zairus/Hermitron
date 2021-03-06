package zairus.hermitron.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zairus.hermitron.item.ItemHermitron.Rarity;
import zairus.hermitron.item.ItemHermitron.Version;

public class HTItems
{
	public static final ItemBase A0C_DIOTREE;
	public static final ItemBase A0C_OAKAN;
	public static final ItemBase A0C_TAIGA;
	public static final ItemBase A0M_FERNOA;
	public static final ItemBase A0R_GRASSU;
	public static final ItemBase A0R_LILLY;
	public static final ItemBase A0U_CACTI;
	public static final ItemBase A0U_FOLIA;
	public static final ItemBase A0U_PRICLE;
	public static final ItemBase A0_COMPLETED_SET;
	public static final ItemBase A1C_AMY;
	public static final ItemBase A1C_CRYSTAL;
	public static final ItemBase A1C_FLUORA;
	public static final ItemBase A1M_DIANNA;
	public static final ItemBase A1R_RUBRA;
	public static final ItemBase A1R_SAPPHI;
	public static final ItemBase A1U_AQUA;
	public static final ItemBase A1U_EMMA;
	public static final ItemBase A1U_TORY;
	public static final ItemBase A1_COMPLETED_SET;
	public static final ItemBase A2C_CHORY;
	public static final ItemBase A2C_SPACEROCK;
	public static final ItemBase A2C_TELE;
	public static final ItemBase A2M_DRAGONBORNE;
	public static final ItemBase A2R_BOXES;
	public static final ItemBase A2R_ELYTRON;
	public static final ItemBase A2U_CRYSTAN;
	public static final ItemBase A2U_OPTICA;
	public static final ItemBase A2U_POPCHORN;
	public static final ItemBase A2_COMPLETED_SET;
	public static final ItemBase A3C_HELLROCK;
	public static final ItemBase A3C_INFERNO;
	public static final ItemBase A3C_PHOSPHOR;
	public static final ItemBase A3M_SIDERIS;
	public static final ItemBase A3R_CRACKLES;
	public static final ItemBase A3R_DEATHBONE;
	public static final ItemBase A3U_BURNS;
	public static final ItemBase A3U_MORB;
	public static final ItemBase A3U_QUZAT;
	public static final ItemBase A3_COMPLETED_SET;
	public static final ItemBase A4C_NEMES;
	public static final ItemBase A4C_SAM;
	public static final ItemBase A4C_SQUIDDLY;
	public static final ItemBase A4M_ENROTH;
	public static final ItemBase A4R_LANTAN;
	public static final ItemBase A4R_THORNE;
	public static final ItemBase A4U_CATCHER;
	public static final ItemBase A4U_PRISMARU;
	public static final ItemBase A4U_SCALES;
	public static final ItemBase A4_COMPLETED_SET;
	public static final ItemBase A5C_DAISY;
	public static final ItemBase A5C_LYON;
	public static final ItemBase A5C_POPPERS;
	public static final ItemBase A5M_ORCHALCUM;
	public static final ItemBase A5R_ALLIE;
	public static final ItemBase A5R_TULA;
	public static final ItemBase A5U_AZURI;
	public static final ItemBase A5U_RHODOS;
	public static final ItemBase A5U_SOL;
	public static final ItemBase A5_COMPLETED_SET;
	public static final ItemBase A6C_DRIPPLE;
	public static final ItemBase A6C_PUFF;
	public static final ItemBase A6C_WISPS;
	public static final ItemBase A6M_BOLT;
	public static final ItemBase A6R_ASTER;
	public static final ItemBase A6R_LUNA;
	public static final ItemBase A6U_HELIO;
	public static final ItemBase A6U_RAVEN;
	public static final ItemBase A6U_WHOOSH;
	public static final ItemBase A6_COMPLETED_SET;
	public static final ItemBase A7C_BREW;
	public static final ItemBase A7C_EXPER;
	public static final ItemBase A7C_HOPPS;
	public static final ItemBase A7R_PHEONIX;
	public static final ItemBase A7U_CARRI;
	public static final ItemBase A7R_DRACHIS;
	public static final ItemBase A7M_ERIS;
	public static final ItemBase A7U_SPECTRUM;
	public static final ItemBase A7U_TERRY;
	public static final ItemBase A7_COMPLETED_SET;
	public static final ItemBase A8C_RAWSHACH;
	public static final ItemBase A8C_ROASTER;
	public static final ItemBase A8C_SACCHAH;
	public static final ItemBase A8R_COOOKIEYS;
	public static final ItemBase A8M_LYRA;
	public static final ItemBase A8R_SHREW;
	public static final ItemBase A8U_DOH;
	public static final ItemBase A8U_GRILL;
	public static final ItemBase A8U_ROUTE;
	public static final ItemBase A8_COMPLETED_SET;
	public static final ItemBase A9C_SKELETON;
	public static final ItemBase A9C_SLIME;
	public static final ItemBase A9C_ZOMBIE;
	public static final ItemBase A9M_RENDOG;
	public static final ItemBase A9R_ENDERMAN;
	public static final ItemBase A9R_WITHERSKELETON;
	public static final ItemBase A9U_CREEPER;
	public static final ItemBase A9U_MAGMACUBE;
	public static final ItemBase A9U_SPIDER;
	public static final ItemBase A9_COMPLETED_SET;
	
	public static final ItemBase B0C_APHRODITE;
	public static final ItemBase B0C_HERMES;
	public static final ItemBase B0C_SOLIA;
	public static final ItemBase B0M_TERRA;
	public static final ItemBase B0R_ORANUS;
	public static final ItemBase B0R_POSEIDON;
	public static final ItemBase B0U_ARES;
	public static final ItemBase B0U_CRONOS;
	public static final ItemBase B0U_ZEUS;
	public static final ItemBase B0_COMPLETED_SET;
	public static final ItemBase B1C_BOWSON;
	public static final ItemBase B1C_BOZON;
	public static final ItemBase B1C_GLUON;
	public static final ItemBase B1M_HIGGS;
	public static final ItemBase B1R_MUON;
	public static final ItemBase B1R_PHOTON;
	public static final ItemBase B1U_ELECTRON;
	public static final ItemBase B1U_QUARK;
	public static final ItemBase B1U_TAU;
	public static final ItemBase B1_COMPLETED_SET;
	public static final ItemBase B2C_BRASSE;
	public static final ItemBase B2C_CUPER;
	public static final ItemBase B2C_FERRIS;
	public static final ItemBase B2M_MYTHRA;
	public static final ItemBase B2R_AURA;
	public static final ItemBase B2R_SILVA;
	public static final ItemBase B2U_BRAZEN;
	public static final ItemBase B2U_BUISNESS;
	public static final ItemBase B2U_STERLING;
	public static final ItemBase B2_COMPLETED_SET;
	public static final ItemBase B3C_CAPPE;
	public static final ItemBase B3C_FARMER;
	public static final ItemBase B3C_TROUSANTS;
	public static final ItemBase B3M_ISKALLIBUR;
	public static final ItemBase B3R_ARRY;
	public static final ItemBase B3R_RIPPER;
	public static final ItemBase B3U_ARCHAE;
	public static final ItemBase B3U_SHEEPISH;
	public static final ItemBase B3U_SPADEL;
	public static final ItemBase B3_COMPLETED_SET;
	public static final ItemBase B4C_PISTRON;
	public static final ItemBase B4C_REDDI;
	public static final ItemBase B4C_SPENCER;
	public static final ItemBase B4M_WATCHER;
	public static final ItemBase B4R_DETECTOS;
	public static final ItemBase B4R_RODGER;
	public static final ItemBase B4U_FUNNLES;
	public static final ItemBase B4U_PLATES;
	public static final ItemBase B4U_SHINER;
	public static final ItemBase B4_COMPLETED_SET;
	public static final ItemBase B5C_EMAP;
	public static final ItemBase B5C_MAPY;
	public static final ItemBase B5C_TEMPORALIS;
	public static final ItemBase B5M_AERODYNA;
	public static final ItemBase B5R_CRAFTMINE;
	public static final ItemBase B5R_RAILY;
	public static final ItemBase B5U_EQUESTRINE;
	public static final ItemBase B5U_MAGNETIS;
	public static final ItemBase B5U_SITFISH;
	public static final ItemBase B5_COMPLETED_SET;
	public static final ItemBase B6C_CALCIFLAME;
	public static final ItemBase B6C_CARBOFLAME;
	public static final ItemBase B6C_LITHIFLAME;
	public static final ItemBase B6M_CUPROFLAME;
	public static final ItemBase B6R_CESIFLAME;
	public static final ItemBase B6R_STRONTIFLAME;
	public static final ItemBase B6U_BARIFLAME;
	public static final ItemBase B6U_POTASSIFLAME;
	public static final ItemBase B6U_SODAFLAME;
	public static final ItemBase B6_COMPLETED_SET;
	public static final ItemBase B7C_CALCILIME;
	public static final ItemBase B7C_GRANITED;
	public static final ItemBase B7C_SANDE;
	public static final ItemBase B7M_OBSIDISHARD;
	public static final ItemBase B7R_BIRDPOOP;
	public static final ItemBase B7R_MAFIC;
	public static final ItemBase B7U_GNICEE;
	public static final ItemBase B7U_QUARTZOITEY;
	public static final ItemBase B7U_SHALEY;
	public static final ItemBase B7_COMPLETED_SET;
	public static final ItemBase B8C_GRAVELTY;
	public static final ItemBase B8C_SPAWNNEI;
	public static final ItemBase B8C_TORCHEROONI;
	public static final ItemBase B8M_MAGMALAVA;
	public static final ItemBase B8R_ARACHNE;
	public static final ItemBase B8R_SILFEESH;
	public static final ItemBase B8U_BSHROOM;
	public static final ItemBase B8U_INTERWEB;
	public static final ItemBase B8U_RSHROOM;
	public static final ItemBase B8_COMPLETED_SET;
	
	public static Map<Version, List<ItemHermitron>> hermitron_sets = new HashMap<Version, List<ItemHermitron>>();
	public static List<ItemHermitronSet> hermitron_complete_sets = new ArrayList<ItemHermitronSet>();
	
	static
	{
		hermitron_sets.put(Version.ALPHA, new ArrayList<ItemHermitron>());
		hermitron_sets.put(Version.BETA, new ArrayList<ItemHermitron>());
		hermitron_sets.put(Version.GAMA, new ArrayList<ItemHermitron>());
		
		A0C_DIOTREE = new ItemHermitron().setVersion(Version.ALPHA).setTribe(0).setRarity(Rarity.COMMON).setItemName("a0c_diotree");
		A0C_OAKAN = new ItemHermitron().setVersion(Version.ALPHA).setTribe(0).setRarity(Rarity.COMMON).setItemName("a0c_oakan");
		A0C_TAIGA = new ItemHermitron().setVersion(Version.ALPHA).setTribe(0).setRarity(Rarity.COMMON).setItemName("a0c_taiga");
		A0M_FERNOA = new ItemHermitron().setVersion(Version.ALPHA).setTribe(0).setRarity(Rarity.MYTHIC).setItemName("a0m_fernoa");
		A0R_GRASSU = new ItemHermitron().setVersion(Version.ALPHA).setTribe(0).setRarity(Rarity.RARE).setItemName("a0r_grassu");
		A0R_LILLY = new ItemHermitron().setVersion(Version.ALPHA).setTribe(0).setRarity(Rarity.RARE).setItemName("a0r_lilly");
		A0U_CACTI = new ItemHermitron().setVersion(Version.ALPHA).setTribe(0).setRarity(Rarity.UNCOMMON).setItemName("a0u_cacti");
		A0U_FOLIA = new ItemHermitron().setVersion(Version.ALPHA).setTribe(0).setRarity(Rarity.UNCOMMON).setItemName("a0u_folia");
		A0U_PRICLE = new ItemHermitron().setVersion(Version.ALPHA).setTribe(0).setRarity(Rarity.UNCOMMON).setItemName("a0u_pricle");
		A0_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.ALPHA).setTribe(0).setItemName("a0_completed_set");
		A1C_AMY = new ItemHermitron().setVersion(Version.ALPHA).setTribe(1).setRarity(Rarity.COMMON).setItemName("a1c_amy");
		A1C_CRYSTAL = new ItemHermitron().setVersion(Version.ALPHA).setTribe(1).setRarity(Rarity.COMMON).setItemName("a1c_crystal");
		A1C_FLUORA = new ItemHermitron().setVersion(Version.ALPHA).setTribe(1).setRarity(Rarity.COMMON).setItemName("a1c_fluora");
		A1M_DIANNA = new ItemHermitron().setVersion(Version.ALPHA).setTribe(1).setRarity(Rarity.MYTHIC).setItemName("a1m_dianna");
		A1R_RUBRA = new ItemHermitron().setVersion(Version.ALPHA).setTribe(1).setRarity(Rarity.RARE).setItemName("a1r_rubra");
		A1R_SAPPHI = new ItemHermitron().setVersion(Version.ALPHA).setTribe(1).setRarity(Rarity.RARE).setItemName("a1r_sapphi");
		A1U_AQUA = new ItemHermitron().setVersion(Version.ALPHA).setTribe(1).setRarity(Rarity.UNCOMMON).setItemName("a1u_aqua");
		A1U_EMMA = new ItemHermitron().setVersion(Version.ALPHA).setTribe(1).setRarity(Rarity.UNCOMMON).setItemName("a1u_emma");
		A1U_TORY = new ItemHermitron().setVersion(Version.ALPHA).setTribe(1).setRarity(Rarity.UNCOMMON).setItemName("a1u_tory");
		A1_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.ALPHA).setTribe(1).setItemName("a1_completed_set");
		A2C_CHORY = new ItemHermitron().setVersion(Version.ALPHA).setTribe(2).setRarity(Rarity.COMMON).setItemName("a2c_chory");
		A2C_SPACEROCK = new ItemHermitron().setVersion(Version.ALPHA).setTribe(2).setRarity(Rarity.COMMON).setItemName("a2c_spacerock");
		A2C_TELE = new ItemHermitron().setVersion(Version.ALPHA).setTribe(2).setRarity(Rarity.COMMON).setItemName("a2c_tele");
		A2M_DRAGONBORNE = new ItemHermitron().setVersion(Version.ALPHA).setTribe(2).setRarity(Rarity.MYTHIC).setItemName("a2m_dragonborne");
		A2R_BOXES = new ItemHermitron().setVersion(Version.ALPHA).setTribe(2).setRarity(Rarity.RARE).setItemName("a2r_boxes");
		A2R_ELYTRON = new ItemHermitron().setVersion(Version.ALPHA).setTribe(2).setRarity(Rarity.RARE).setItemName("a2r_elytron");
		A2U_CRYSTAN = new ItemHermitron().setVersion(Version.ALPHA).setTribe(2).setRarity(Rarity.UNCOMMON).setItemName("a2u_crystan");
		A2U_OPTICA = new ItemHermitron().setVersion(Version.ALPHA).setTribe(2).setRarity(Rarity.UNCOMMON).setItemName("a2u_optica");
		A2U_POPCHORN = new ItemHermitron().setVersion(Version.ALPHA).setTribe(2).setRarity(Rarity.UNCOMMON).setItemName("a2u_popchorn");
		A2_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.ALPHA).setTribe(2).setItemName("a2_completed_set");
		A3C_HELLROCK = new ItemHermitron().setVersion(Version.ALPHA).setTribe(3).setRarity(Rarity.COMMON).setItemName("a3c_hellrock");
		A3C_INFERNO = new ItemHermitron().setVersion(Version.ALPHA).setTribe(3).setRarity(Rarity.COMMON).setItemName("a3c_inferno");
		A3C_PHOSPHOR = new ItemHermitron().setVersion(Version.ALPHA).setTribe(3).setRarity(Rarity.COMMON).setItemName("a3c_phosphor");
		A3M_SIDERIS = new ItemHermitron().setVersion(Version.ALPHA).setTribe(3).setRarity(Rarity.MYTHIC).setItemName("a3m_sideris");
		A3R_CRACKLES = new ItemHermitron().setVersion(Version.ALPHA).setTribe(3).setRarity(Rarity.RARE).setItemName("a3r_crackles");
		A3R_DEATHBONE = new ItemHermitron().setVersion(Version.ALPHA).setTribe(3).setRarity(Rarity.RARE).setItemName("a3r_deathbone");
		A3U_BURNS = new ItemHermitron().setVersion(Version.ALPHA).setTribe(3).setRarity(Rarity.UNCOMMON).setItemName("a3u_burns");
		A3U_MORB = new ItemHermitron().setVersion(Version.ALPHA).setTribe(3).setRarity(Rarity.UNCOMMON).setItemName("a3u_morb");
		A3U_QUZAT = new ItemHermitron().setVersion(Version.ALPHA).setTribe(3).setRarity(Rarity.UNCOMMON).setItemName("a3u_quzat");
		A3_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.ALPHA).setTribe(3).setItemName("a3_completed_set");
		A4C_NEMES = new ItemHermitron().setVersion(Version.ALPHA).setTribe(4).setRarity(Rarity.COMMON).setItemName("a4c_nemes");
		A4C_SAM = new ItemHermitron().setVersion(Version.ALPHA).setTribe(4).setRarity(Rarity.COMMON).setItemName("a4c_sam");
		A4C_SQUIDDLY = new ItemHermitron().setVersion(Version.ALPHA).setTribe(4).setRarity(Rarity.COMMON).setItemName("a4c_squiddly");
		A4M_ENROTH = new ItemHermitron().setVersion(Version.ALPHA).setTribe(4).setRarity(Rarity.MYTHIC).setItemName("a4m_enroth");
		A4R_LANTAN = new ItemHermitron().setVersion(Version.ALPHA).setTribe(4).setRarity(Rarity.RARE).setItemName("a4r_lantan");
		A4R_THORNE = new ItemHermitron().setVersion(Version.ALPHA).setTribe(4).setRarity(Rarity.RARE).setItemName("a4r_thorne");
		A4U_CATCHER = new ItemHermitron().setVersion(Version.ALPHA).setTribe(4).setRarity(Rarity.UNCOMMON).setItemName("a4u_catcher");
		A4U_PRISMARU = new ItemHermitron().setVersion(Version.ALPHA).setTribe(4).setRarity(Rarity.UNCOMMON).setItemName("a4u_prismaru");
		A4U_SCALES = new ItemHermitron().setVersion(Version.ALPHA).setTribe(4).setRarity(Rarity.UNCOMMON).setItemName("a4u_scales");
		A4_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.ALPHA).setTribe(4).setItemName("a4_completed_set");
		A5C_DAISY = new ItemHermitron().setVersion(Version.ALPHA).setTribe(5).setRarity(Rarity.COMMON).setItemName("a5c_daisy");
		A5C_LYON = new ItemHermitron().setVersion(Version.ALPHA).setTribe(5).setRarity(Rarity.COMMON).setItemName("a5c_lyon");
		A5C_POPPERS = new ItemHermitron().setVersion(Version.ALPHA).setTribe(5).setRarity(Rarity.COMMON).setItemName("a5c_poppers");
		A5M_ORCHALCUM = new ItemHermitron().setVersion(Version.ALPHA).setTribe(5).setRarity(Rarity.MYTHIC).setItemName("a5m_orchalcum");
		A5R_ALLIE = new ItemHermitron().setVersion(Version.ALPHA).setTribe(5).setRarity(Rarity.RARE).setItemName("a5r_allie");
		A5R_TULA = new ItemHermitron().setVersion(Version.ALPHA).setTribe(5).setRarity(Rarity.RARE).setItemName("a5r_tula");
		A5U_AZURI = new ItemHermitron().setVersion(Version.ALPHA).setTribe(5).setRarity(Rarity.UNCOMMON).setItemName("a5u_azuri");
		A5U_RHODOS = new ItemHermitron().setVersion(Version.ALPHA).setTribe(5).setRarity(Rarity.UNCOMMON).setItemName("a5u_rhodos");
		A5U_SOL = new ItemHermitron().setVersion(Version.ALPHA).setTribe(5).setRarity(Rarity.UNCOMMON).setItemName("a5u_sol");
		A5_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.ALPHA).setTribe(5).setItemName("a5_completed_set");
		A6C_DRIPPLE = new ItemHermitron().setVersion(Version.ALPHA).setTribe(6).setRarity(Rarity.COMMON).setItemName("a6c_dripple");
		A6C_PUFF = new ItemHermitron().setVersion(Version.ALPHA).setTribe(6).setRarity(Rarity.COMMON).setItemName("a6c_puff");
		A6C_WISPS = new ItemHermitron().setVersion(Version.ALPHA).setTribe(6).setRarity(Rarity.COMMON).setItemName("a6c_wisps");
		A6M_BOLT = new ItemHermitron().setVersion(Version.ALPHA).setTribe(6).setRarity(Rarity.MYTHIC).setItemName("a6m_bolt");
		A6R_ASTER = new ItemHermitron().setVersion(Version.ALPHA).setTribe(6).setRarity(Rarity.RARE).setItemName("a6r_aster");
		A6R_LUNA = new ItemHermitron().setVersion(Version.ALPHA).setTribe(6).setRarity(Rarity.RARE).setItemName("a6r_luna");
		A6U_HELIO = new ItemHermitron().setVersion(Version.ALPHA).setTribe(6).setRarity(Rarity.UNCOMMON).setItemName("a6u_helio");
		A6U_RAVEN = new ItemHermitron().setVersion(Version.ALPHA).setTribe(6).setRarity(Rarity.UNCOMMON).setItemName("a6u_raven");
		A6U_WHOOSH = new ItemHermitron().setVersion(Version.ALPHA).setTribe(6).setRarity(Rarity.UNCOMMON).setItemName("a6u_whoosh");
		A6_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.ALPHA).setTribe(6).setItemName("a6_completed_set");
		A7C_BREW = new ItemHermitron().setVersion(Version.ALPHA).setTribe(7).setRarity(Rarity.COMMON).setItemName("a7c_brew");
		A7C_EXPER = new ItemHermitron().setVersion(Version.ALPHA).setTribe(7).setRarity(Rarity.COMMON).setItemName("a7c_exper");
		A7C_HOPPS = new ItemHermitron().setVersion(Version.ALPHA).setTribe(7).setRarity(Rarity.COMMON).setItemName("a7c_hopps");
		A7R_PHEONIX = new ItemHermitron().setVersion(Version.ALPHA).setTribe(7).setRarity(Rarity.RARE).setItemName("a7r_pheonix");
		A7U_CARRI = new ItemHermitron().setVersion(Version.ALPHA).setTribe(7).setRarity(Rarity.UNCOMMON).setItemName("a7u_carri");
		A7R_DRACHIS = new ItemHermitron().setVersion(Version.ALPHA).setTribe(7).setRarity(Rarity.RARE).setItemName("a7r_drachis");
		A7M_ERIS = new ItemHermitron().setVersion(Version.ALPHA).setTribe(7).setRarity(Rarity.MYTHIC).setItemName("a7m_eris");
		A7U_SPECTRUM = new ItemHermitron().setVersion(Version.ALPHA).setTribe(7).setRarity(Rarity.UNCOMMON).setItemName("a7u_spectrum");
		A7U_TERRY = new ItemHermitron().setVersion(Version.ALPHA).setTribe(7).setRarity(Rarity.UNCOMMON).setItemName("a7u_terry");
		A7_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.ALPHA).setTribe(7).setItemName("a7_completed_set");
		A8C_RAWSHACH = new ItemHermitron().setVersion(Version.ALPHA).setTribe(8).setRarity(Rarity.COMMON).setItemName("a8c_rawshach");
		A8C_ROASTER = new ItemHermitron().setVersion(Version.ALPHA).setTribe(8).setRarity(Rarity.COMMON).setItemName("a8c_roaster");
		A8C_SACCHAH = new ItemHermitron().setVersion(Version.ALPHA).setTribe(8).setRarity(Rarity.COMMON).setItemName("a8c_sacchah");
		A8R_COOOKIEYS = new ItemHermitron().setVersion(Version.ALPHA).setTribe(8).setRarity(Rarity.RARE).setItemName("a8r_coookieys");
		A8M_LYRA = new ItemHermitron().setVersion(Version.ALPHA).setTribe(8).setRarity(Rarity.MYTHIC).setItemName("a8m_lyra");
		A8R_SHREW = new ItemHermitron().setVersion(Version.ALPHA).setTribe(8).setRarity(Rarity.RARE).setItemName("a8r_shrew");
		A8U_DOH = new ItemHermitron().setVersion(Version.ALPHA).setTribe(8).setRarity(Rarity.UNCOMMON).setItemName("a8u_doh");
		A8U_GRILL = new ItemHermitron().setVersion(Version.ALPHA).setTribe(8).setRarity(Rarity.UNCOMMON).setItemName("a8u_grill");
		A8U_ROUTE = new ItemHermitron().setVersion(Version.ALPHA).setTribe(8).setRarity(Rarity.UNCOMMON).setItemName("a8u_route");
		A8_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.ALPHA).setTribe(8).setItemName("a8_completed_set");
		A9C_SKELETON = new ItemHermitron().setVersion(Version.ALPHA).setTribe(9).setRarity(Rarity.COMMON).setItemName("a9c_skeleton");
		A9C_SLIME = new ItemHermitron().setVersion(Version.ALPHA).setTribe(9).setRarity(Rarity.COMMON).setItemName("a9c_slime");
		A9C_ZOMBIE = new ItemHermitron().setVersion(Version.ALPHA).setTribe(9).setRarity(Rarity.COMMON).setItemName("a9c_zombie");
		A9M_RENDOG = new ItemHermitron().setVersion(Version.ALPHA).setTribe(9).setRarity(Rarity.MYTHIC).setItemName("a9m_rendog");
		A9R_ENDERMAN = new ItemHermitron().setVersion(Version.ALPHA).setTribe(9).setRarity(Rarity.RARE).setItemName("a9r_enderman");
		A9R_WITHERSKELETON = new ItemHermitron().setVersion(Version.ALPHA).setTribe(9).setRarity(Rarity.RARE).setItemName("a9r_witherskeleton");
		A9U_CREEPER = new ItemHermitron().setVersion(Version.ALPHA).setTribe(9).setRarity(Rarity.UNCOMMON).setItemName("a9u_creeper");
		A9U_MAGMACUBE = new ItemHermitron().setVersion(Version.ALPHA).setTribe(9).setRarity(Rarity.UNCOMMON).setItemName("a9u_magmacube");
		A9U_SPIDER = new ItemHermitron().setVersion(Version.ALPHA).setTribe(9).setRarity(Rarity.UNCOMMON).setItemName("a9u_spider");
		A9_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.ALPHA).setTribe(9).setItemName("a9_completed_set");
		
		B0C_APHRODITE = new ItemHermitron().setVersion(Version.BETA).setTribe(0).setRarity(Rarity.COMMON).setItemName("b0c_aphrodite");
		B0C_HERMES = new ItemHermitron().setVersion(Version.BETA).setTribe(0).setRarity(Rarity.COMMON).setItemName("b0c_hermes");
		B0C_SOLIA = new ItemHermitron().setVersion(Version.BETA).setTribe(0).setRarity(Rarity.COMMON).setItemName("b0c_solia");
		B0M_TERRA = new ItemHermitron().setVersion(Version.BETA).setTribe(0).setRarity(Rarity.MYTHIC).setItemName("b0m_terra");
		B0R_ORANUS = new ItemHermitron().setVersion(Version.BETA).setTribe(0).setRarity(Rarity.RARE).setItemName("b0r_oranus");
		B0R_POSEIDON = new ItemHermitron().setVersion(Version.BETA).setTribe(0).setRarity(Rarity.RARE).setItemName("b0r_poseidon");
		B0U_ARES = new ItemHermitron().setVersion(Version.BETA).setTribe(0).setRarity(Rarity.UNCOMMON).setItemName("b0u_ares");
		B0U_CRONOS = new ItemHermitron().setVersion(Version.BETA).setTribe(0).setRarity(Rarity.UNCOMMON).setItemName("b0u_cronos");
		B0U_ZEUS = new ItemHermitron().setVersion(Version.BETA).setTribe(0).setRarity(Rarity.UNCOMMON).setItemName("b0u_zeus");
		B0_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.BETA).setTribe(0).setItemName("b0_completed_set");
		B1C_BOWSON = new ItemHermitron().setVersion(Version.BETA).setTribe(1).setRarity(Rarity.COMMON).setItemName("b1c_bowson");
		B1C_BOZON = new ItemHermitron().setVersion(Version.BETA).setTribe(1).setRarity(Rarity.COMMON).setItemName("b1c_bozon");
		B1C_GLUON = new ItemHermitron().setVersion(Version.BETA).setTribe(1).setRarity(Rarity.COMMON).setItemName("b1c_gluon");
		B1M_HIGGS = new ItemHermitron().setVersion(Version.BETA).setTribe(1).setRarity(Rarity.MYTHIC).setItemName("b1m_higgs");
		B1R_MUON = new ItemHermitron().setVersion(Version.BETA).setTribe(1).setRarity(Rarity.RARE).setItemName("b1r_muon");
		B1R_PHOTON = new ItemHermitron().setVersion(Version.BETA).setTribe(1).setRarity(Rarity.RARE).setItemName("b1r_photon");
		B1U_ELECTRON = new ItemHermitron().setVersion(Version.BETA).setTribe(1).setRarity(Rarity.UNCOMMON).setItemName("b1u_electron");
		B1U_QUARK = new ItemHermitron().setVersion(Version.BETA).setTribe(1).setRarity(Rarity.UNCOMMON).setItemName("b1u_quark");
		B1U_TAU = new ItemHermitron().setVersion(Version.BETA).setTribe(1).setRarity(Rarity.UNCOMMON).setItemName("b1u_tau");
		B1_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.BETA).setTribe(1).setItemName("b1_completed_set");
		B2C_BRASSE = new ItemHermitron().setVersion(Version.BETA).setTribe(2).setRarity(Rarity.COMMON).setItemName("b2c_brasse");
		B2C_CUPER = new ItemHermitron().setVersion(Version.BETA).setTribe(2).setRarity(Rarity.COMMON).setItemName("b2c_cuper");
		B2C_FERRIS = new ItemHermitron().setVersion(Version.BETA).setTribe(2).setRarity(Rarity.COMMON).setItemName("b2c_ferris");
		B2M_MYTHRA = new ItemHermitron().setVersion(Version.BETA).setTribe(2).setRarity(Rarity.MYTHIC).setItemName("b2m_mythra");
		B2R_AURA = new ItemHermitron().setVersion(Version.BETA).setTribe(2).setRarity(Rarity.RARE).setItemName("b2r_aura");
		B2R_SILVA = new ItemHermitron().setVersion(Version.BETA).setTribe(2).setRarity(Rarity.RARE).setItemName("b2r_silva");
		B2U_BRAZEN = new ItemHermitron().setVersion(Version.BETA).setTribe(2).setRarity(Rarity.UNCOMMON).setItemName("b2u_brazen");
		B2U_BUISNESS = new ItemHermitron().setVersion(Version.BETA).setTribe(2).setRarity(Rarity.UNCOMMON).setItemName("b2u_buisness");
		B2U_STERLING = new ItemHermitron().setVersion(Version.BETA).setTribe(2).setRarity(Rarity.UNCOMMON).setItemName("b2u_sterling");
		B2_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.BETA).setTribe(2).setItemName("b2_completed_set");
		B3C_CAPPE = new ItemHermitron().setVersion(Version.BETA).setTribe(3).setRarity(Rarity.COMMON).setItemName("b3c_cappe");
		B3C_FARMER = new ItemHermitron().setVersion(Version.BETA).setTribe(3).setRarity(Rarity.COMMON).setItemName("b3c_farmer");
		B3C_TROUSANTS = new ItemHermitron().setVersion(Version.BETA).setTribe(3).setRarity(Rarity.COMMON).setItemName("b3c_trousants");
		B3M_ISKALLIBUR = new ItemHermitron().setVersion(Version.BETA).setTribe(3).setRarity(Rarity.MYTHIC).setItemName("b3m_iskallibur");
		B3R_ARRY = new ItemHermitron().setVersion(Version.BETA).setTribe(3).setRarity(Rarity.RARE).setItemName("b3r_arry");
		B3R_RIPPER = new ItemHermitron().setVersion(Version.BETA).setTribe(3).setRarity(Rarity.RARE).setItemName("b3r_ripper");
		B3U_ARCHAE = new ItemHermitron().setVersion(Version.BETA).setTribe(3).setRarity(Rarity.UNCOMMON).setItemName("b3u_archae");
		B3U_SHEEPISH = new ItemHermitron().setVersion(Version.BETA).setTribe(3).setRarity(Rarity.UNCOMMON).setItemName("b3u_sheepish");
		B3U_SPADEL = new ItemHermitron().setVersion(Version.BETA).setTribe(3).setRarity(Rarity.UNCOMMON).setItemName("b3u_spadel");
		B3_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.BETA).setTribe(3).setItemName("b3_completed_set");
		B4C_PISTRON = new ItemHermitron().setVersion(Version.BETA).setTribe(4).setRarity(Rarity.COMMON).setItemName("b4c_pistron");
		B4C_REDDI = new ItemHermitron().setVersion(Version.BETA).setTribe(4).setRarity(Rarity.COMMON).setItemName("b4c_reddi");
		B4C_SPENCER = new ItemHermitron().setVersion(Version.BETA).setTribe(4).setRarity(Rarity.COMMON).setItemName("b4c_spencer");
		B4M_WATCHER = new ItemHermitron().setVersion(Version.BETA).setTribe(4).setRarity(Rarity.MYTHIC).setItemName("b4m_watcher");
		B4R_DETECTOS = new ItemHermitron().setVersion(Version.BETA).setTribe(4).setRarity(Rarity.RARE).setItemName("b4r_detectos");
		B4R_RODGER = new ItemHermitron().setVersion(Version.BETA).setTribe(4).setRarity(Rarity.RARE).setItemName("b4r_rodger");
		B4U_FUNNLES = new ItemHermitron().setVersion(Version.BETA).setTribe(4).setRarity(Rarity.UNCOMMON).setItemName("b4u_funnles");
		B4U_PLATES = new ItemHermitron().setVersion(Version.BETA).setTribe(4).setRarity(Rarity.UNCOMMON).setItemName("b4u_plates");
		B4U_SHINER = new ItemHermitron().setVersion(Version.BETA).setTribe(4).setRarity(Rarity.UNCOMMON).setItemName("b4u_shiner");
		B4_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.BETA).setTribe(4).setItemName("b4_completed_set");
		B5C_EMAP = new ItemHermitron().setVersion(Version.BETA).setTribe(5).setRarity(Rarity.COMMON).setItemName("b5c_emap");
		B5C_MAPY = new ItemHermitron().setVersion(Version.BETA).setTribe(5).setRarity(Rarity.COMMON).setItemName("b5c_mapy");
		B5C_TEMPORALIS = new ItemHermitron().setVersion(Version.BETA).setTribe(5).setRarity(Rarity.COMMON).setItemName("b5c_temporalis");
		B5M_AERODYNA = new ItemHermitron().setVersion(Version.BETA).setTribe(5).setRarity(Rarity.MYTHIC).setItemName("b5m_aerodyna");
		B5R_CRAFTMINE = new ItemHermitron().setVersion(Version.BETA).setTribe(5).setRarity(Rarity.RARE).setItemName("b5r_craftmine");
		B5R_RAILY = new ItemHermitron().setVersion(Version.BETA).setTribe(5).setRarity(Rarity.RARE).setItemName("b5r_raily");
		B5U_EQUESTRINE = new ItemHermitron().setVersion(Version.BETA).setTribe(5).setRarity(Rarity.UNCOMMON).setItemName("b5u_equestrine");
		B5U_MAGNETIS = new ItemHermitron().setVersion(Version.BETA).setTribe(5).setRarity(Rarity.UNCOMMON).setItemName("b5u_magnetis");
		B5U_SITFISH = new ItemHermitron().setVersion(Version.BETA).setTribe(5).setRarity(Rarity.UNCOMMON).setItemName("b5u_sitfish");
		B5_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.BETA).setTribe(5).setItemName("b5_completed_set");
		B6C_CALCIFLAME = new ItemHermitron().setVersion(Version.BETA).setTribe(6).setRarity(Rarity.COMMON).setItemName("b6c_calciflame");
		B6C_CARBOFLAME = new ItemHermitron().setVersion(Version.BETA).setTribe(6).setRarity(Rarity.COMMON).setItemName("b6c_carboflame");
		B6C_LITHIFLAME = new ItemHermitron().setVersion(Version.BETA).setTribe(6).setRarity(Rarity.COMMON).setItemName("b6c_lithiflame");
		B6M_CUPROFLAME = new ItemHermitron().setVersion(Version.BETA).setTribe(6).setRarity(Rarity.MYTHIC).setItemName("b6m_cuproflame");
		B6R_CESIFLAME = new ItemHermitron().setVersion(Version.BETA).setTribe(6).setRarity(Rarity.RARE).setItemName("b6r_cesiflame");
		B6R_STRONTIFLAME = new ItemHermitron().setVersion(Version.BETA).setTribe(6).setRarity(Rarity.RARE).setItemName("b6r_strontiflame");
		B6U_BARIFLAME = new ItemHermitron().setVersion(Version.BETA).setTribe(6).setRarity(Rarity.UNCOMMON).setItemName("b6u_bariflame");
		B6U_POTASSIFLAME = new ItemHermitron().setVersion(Version.BETA).setTribe(6).setRarity(Rarity.UNCOMMON).setItemName("b6u_potassiflame");
		B6U_SODAFLAME = new ItemHermitron().setVersion(Version.BETA).setTribe(6).setRarity(Rarity.UNCOMMON).setItemName("b6u_sodaflame");
		B6_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.BETA).setTribe(6).setItemName("b6_completed_set");
		B7C_CALCILIME = new ItemHermitron().setVersion(Version.BETA).setTribe(7).setRarity(Rarity.COMMON).setItemName("b7c_calcilime");
		B7C_GRANITED = new ItemHermitron().setVersion(Version.BETA).setTribe(7).setRarity(Rarity.COMMON).setItemName("b7c_granited");
		B7C_SANDE = new ItemHermitron().setVersion(Version.BETA).setTribe(7).setRarity(Rarity.COMMON).setItemName("b7c_sande");
		B7M_OBSIDISHARD = new ItemHermitron().setVersion(Version.BETA).setTribe(7).setRarity(Rarity.MYTHIC).setItemName("b7m_obsidishard");
		B7R_BIRDPOOP = new ItemHermitron().setVersion(Version.BETA).setTribe(7).setRarity(Rarity.RARE).setItemName("b7r_birdpoop");
		B7R_MAFIC = new ItemHermitron().setVersion(Version.BETA).setTribe(7).setRarity(Rarity.RARE).setItemName("b7r_mafic");
		B7U_GNICEE = new ItemHermitron().setVersion(Version.BETA).setTribe(7).setRarity(Rarity.UNCOMMON).setItemName("b7u_gnicee");
		B7U_QUARTZOITEY = new ItemHermitron().setVersion(Version.BETA).setTribe(7).setRarity(Rarity.UNCOMMON).setItemName("b7u_quartzoitey");
		B7U_SHALEY = new ItemHermitron().setVersion(Version.BETA).setTribe(7).setRarity(Rarity.UNCOMMON).setItemName("b7u_shaley");
		B7_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.BETA).setTribe(7).setItemName("b7_completed_set");
		B8C_GRAVELTY = new ItemHermitron().setVersion(Version.BETA).setTribe(8).setRarity(Rarity.COMMON).setItemName("b8c_gravelty");
		B8C_SPAWNNEI = new ItemHermitron().setVersion(Version.BETA).setTribe(8).setRarity(Rarity.COMMON).setItemName("b8c_spawnnei");
		B8C_TORCHEROONI = new ItemHermitron().setVersion(Version.BETA).setTribe(8).setRarity(Rarity.COMMON).setItemName("b8c_torcherooni");
		B8M_MAGMALAVA = new ItemHermitron().setVersion(Version.BETA).setTribe(8).setRarity(Rarity.MYTHIC).setItemName("b8m_magmalava");
		B8R_ARACHNE = new ItemHermitron().setVersion(Version.BETA).setTribe(8).setRarity(Rarity.RARE).setItemName("b8r_arachne");
		B8R_SILFEESH = new ItemHermitron().setVersion(Version.BETA).setTribe(8).setRarity(Rarity.RARE).setItemName("b8r_silfeesh");
		B8U_BSHROOM = new ItemHermitron().setVersion(Version.BETA).setTribe(8).setRarity(Rarity.UNCOMMON).setItemName("b8u_bshroom");
		B8U_INTERWEB = new ItemHermitron().setVersion(Version.BETA).setTribe(8).setRarity(Rarity.UNCOMMON).setItemName("b8u_interweb");
		B8U_RSHROOM = new ItemHermitron().setVersion(Version.BETA).setTribe(8).setRarity(Rarity.UNCOMMON).setItemName("b8u_rshroom");
		B8_COMPLETED_SET = new ItemHermitronSet().setVersion(Version.BETA).setTribe(8).setItemName("b8_completed_set");
	}
	
	public static final void register()
	{
		A0C_DIOTREE.register();
		A0C_OAKAN.register();
		A0C_TAIGA.register();
		A0M_FERNOA.register();
		A0R_GRASSU.register();
		A0R_LILLY.register();
		A0U_CACTI.register();
		A0U_FOLIA.register();
		A0U_PRICLE.register();
		A0_COMPLETED_SET.register();
		A1C_AMY.register();
		A1C_CRYSTAL.register();
		A1C_FLUORA.register();
		A1M_DIANNA.register();
		A1R_RUBRA.register();
		A1R_SAPPHI.register();
		A1U_AQUA.register();
		A1U_EMMA.register();
		A1U_TORY.register();
		A1_COMPLETED_SET.register();
		A2C_CHORY.register();
		A2C_SPACEROCK.register();
		A2C_TELE.register();
		A2M_DRAGONBORNE.register();
		A2R_BOXES.register();
		A2R_ELYTRON.register();
		A2U_CRYSTAN.register();
		A2U_OPTICA.register();
		A2U_POPCHORN.register();
		A2_COMPLETED_SET.register();
		A3C_HELLROCK.register();
		A3C_INFERNO.register();
		A3C_PHOSPHOR.register();
		A3M_SIDERIS.register();
		A3R_CRACKLES.register();
		A3R_DEATHBONE.register();
		A3U_BURNS.register();
		A3U_MORB.register();
		A3U_QUZAT.register();
		A3_COMPLETED_SET.register();
		A4C_NEMES.register();
		A4C_SAM.register();
		A4C_SQUIDDLY.register();
		A4M_ENROTH.register();
		A4R_LANTAN.register();
		A4R_THORNE.register();
		A4U_CATCHER.register();
		A4U_PRISMARU.register();
		A4U_SCALES.register();
		A4_COMPLETED_SET.register();
		A5C_DAISY.register();
		A5C_LYON.register();
		A5C_POPPERS.register();
		A5M_ORCHALCUM.register();
		A5R_ALLIE.register();
		A5R_TULA.register();
		A5U_AZURI.register();
		A5U_RHODOS.register();
		A5U_SOL.register();
		A5_COMPLETED_SET.register();
		A6C_DRIPPLE.register();
		A6C_PUFF.register();
		A6C_WISPS.register();
		A6M_BOLT.register();
		A6R_ASTER.register();
		A6R_LUNA.register();
		A6U_HELIO.register();
		A6U_RAVEN.register();
		A6U_WHOOSH.register();
		A6_COMPLETED_SET.register();
		A7C_BREW.register();
		A7C_EXPER.register();
		A7C_HOPPS.register();
		A7R_PHEONIX.register();
		A7U_CARRI.register();
		A7R_DRACHIS.register();
		A7M_ERIS.register();
		A7U_SPECTRUM.register();
		A7U_TERRY.register();
		A7_COMPLETED_SET.register();
		A8C_RAWSHACH.register();
		A8C_ROASTER.register();
		A8C_SACCHAH.register();
		A8R_COOOKIEYS.register();
		A8M_LYRA.register();
		A8R_SHREW.register();
		A8U_DOH.register();
		A8U_GRILL.register();
		A8U_ROUTE.register();
		A8_COMPLETED_SET.register();
		A9C_SKELETON.register();
		A9C_SLIME.register();
		A9C_ZOMBIE.register();
		A9M_RENDOG.register();
		A9R_ENDERMAN.register();
		A9R_WITHERSKELETON.register();
		A9U_CREEPER.register();
		A9U_MAGMACUBE.register();
		A9U_SPIDER.register();
		A9_COMPLETED_SET.register();
		
		B0C_APHRODITE.register();
		B0C_HERMES.register();
		B0C_SOLIA.register();
		B0M_TERRA.register();
		B0R_ORANUS.register();
		B0R_POSEIDON.register();
		B0U_ARES.register();
		B0U_CRONOS.register();
		B0U_ZEUS.register();
		B0_COMPLETED_SET.register();
		B1C_BOWSON.register();
		B1C_BOZON.register();
		B1C_GLUON.register();
		B1M_HIGGS.register();
		B1R_MUON.register();
		B1R_PHOTON.register();
		B1U_ELECTRON.register();
		B1U_QUARK.register();
		B1U_TAU.register();
		B1_COMPLETED_SET.register();
		B2C_BRASSE.register();
		B2C_CUPER.register();
		B2C_FERRIS.register();
		B2M_MYTHRA.register();
		B2R_AURA.register();
		B2R_SILVA.register();
		B2U_BRAZEN.register();
		B2U_BUISNESS.register();
		B2U_STERLING.register();
		B2_COMPLETED_SET.register();
		B3C_CAPPE.register();
		B3C_FARMER.register();
		B3C_TROUSANTS.register();
		B3M_ISKALLIBUR.register();
		B3R_ARRY.register();
		B3R_RIPPER.register();
		B3U_ARCHAE.register();
		B3U_SHEEPISH.register();
		B3U_SPADEL.register();
		B3_COMPLETED_SET.register();
		B4C_PISTRON.register();
		B4C_REDDI.register();
		B4C_SPENCER.register();
		B4M_WATCHER.register();
		B4R_DETECTOS.register();
		B4R_RODGER.register();
		B4U_FUNNLES.register();
		B4U_PLATES.register();
		B4U_SHINER.register();
		B4_COMPLETED_SET.register();
		B5C_EMAP.register();
		B5C_MAPY.register();
		B5C_TEMPORALIS.register();
		B5M_AERODYNA.register();
		B5R_CRAFTMINE.register();
		B5R_RAILY.register();
		B5U_EQUESTRINE.register();
		B5U_MAGNETIS.register();
		B5U_SITFISH.register();
		B5_COMPLETED_SET.register();
		B6C_CALCIFLAME.register();
		B6C_CARBOFLAME.register();
		B6C_LITHIFLAME.register();
		B6M_CUPROFLAME.register();
		B6R_CESIFLAME.register();
		B6R_STRONTIFLAME.register();
		B6U_BARIFLAME.register();
		B6U_POTASSIFLAME.register();
		B6U_SODAFLAME.register();
		B6_COMPLETED_SET.register();
		B7C_CALCILIME.register();
		B7C_GRANITED.register();
		B7C_SANDE.register();
		B7M_OBSIDISHARD.register();
		B7R_BIRDPOOP.register();
		B7R_MAFIC.register();
		B7U_GNICEE.register();
		B7U_QUARTZOITEY.register();
		B7U_SHALEY.register();
		B7_COMPLETED_SET.register();
		B8C_GRAVELTY.register();
		B8C_SPAWNNEI.register();
		B8C_TORCHEROONI.register();
		B8M_MAGMALAVA.register();
		B8R_ARACHNE.register();
		B8R_SILFEESH.register();
		B8U_BSHROOM.register();
		B8U_INTERWEB.register();
		B8U_RSHROOM.register();
		B8_COMPLETED_SET.register();
	}
}
