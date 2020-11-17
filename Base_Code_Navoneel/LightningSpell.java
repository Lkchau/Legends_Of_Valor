
public class LightningSpell extends Spell {
	
	LightningSpell(){
		
	}

	LightningSpell(int spellID, String name, double cost, int level, double damage, double manaCost){
		super(spellID, name, cost, level, damage, manaCost);
	}

	@Override
	public void specialEffect(Monster monster) {
		monster.setDodgeChance(monster.getDodgeChance()*0.9);
		
	}

}
