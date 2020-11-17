
public class IceSpell extends Spell {
	
	IceSpell(){
		
	}

	IceSpell(int spellID, String name, double cost, int level, double damage, double manaCost){
		super(spellID, name, cost, level, damage, manaCost);
	}

	@Override
	public void specialEffect(Monster monster) {
		monster.setDamage(monster.getDamage()*0.9);
		
	}

}
