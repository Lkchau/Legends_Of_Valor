
public class FireSpell extends Spell {
	
	FireSpell(){
		
	}

	FireSpell(int spellID, String name, double cost, int level, double damage, double manaCost){
		super(spellID, name, cost, level, damage, manaCost);
	}
	
	@Override
	public void specialEffect(Monster monster) {
		monster.setDefense(monster.getDefense()*0.9);
		
	}

}
