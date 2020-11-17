import java.util.ArrayList;

public class DatasetSpell {
	
	private static int spellID = 0;
	
	public static ArrayList<FireSpell> fireSpellData(){
		ArrayList<FireSpell> fireSpells = new ArrayList<FireSpell>();
		fireSpells.add(new FireSpell(++spellID,"Flame_Tornado",700,4,850 ,300));
		fireSpells.add(new FireSpell(++spellID,"Breath_of_Fire",350,1,450 ,100));
		fireSpells.add(new FireSpell(++spellID,"Heat_Wave",450,2,600 ,150));
		fireSpells.add(new FireSpell(++spellID,"Lava_Comet",800,7,1000,550));
		fireSpells.add(new FireSpell(++spellID,"Hell_Storm",600,3,950 ,600));
		
		return fireSpells;
	}
	
	public static ArrayList<IceSpell> iceSpellData(){
		ArrayList<IceSpell> iceSpells = new ArrayList<IceSpell>();
		iceSpells.add(new IceSpell(++spellID,"Snow_Cannon",500,2,650,250));
		iceSpells.add(new IceSpell(++spellID,"Ice_Blade",250,1,450,100));
		iceSpells.add(new IceSpell(++spellID,"Frost_Blizzard",750,5,850,350));
		iceSpells.add(new IceSpell(++spellID,"Arctic_Storm",700,6,800,300));
		
		return iceSpells;
	}
	
	public static ArrayList<LightningSpell> lightningSpellData(){
		ArrayList<LightningSpell> lightningSpells = new ArrayList<LightningSpell>();
		lightningSpells.add(new LightningSpell(++spellID,"Lightning_Dagger",400,1,500,150));
		lightningSpells.add(new LightningSpell(++spellID,"Thunder_Blast",750,4,950,400));
		lightningSpells.add(new LightningSpell(++spellID,"Electric_Arrows",550,5,650,200));
		lightningSpells.add(new LightningSpell(++spellID,"Spark_Needles",500,2,600,200));
		
		return lightningSpells;
	}

}
