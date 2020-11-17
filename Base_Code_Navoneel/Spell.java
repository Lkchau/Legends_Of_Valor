
public abstract class Spell {
	
	private String name;
	private double cost, damage, manaCost;
	private int level,spellID;
	
	Spell(){
		
	}
	
	Spell(int spellID, String name, double cost, int level, double damage, double manaCost){
		this.spellID = spellID;
		this.name = name;
		this.cost = cost;
		this.level = level;
		this.damage = damage;
		this.manaCost = manaCost;
	}
	
	public abstract void specialEffect(Monster monster);
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * @return the damage
	 */
	public double getDamage() {
		return damage;
	}
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(double damage) {
		this.damage = damage;
	}
	/**
	 * @return the manaCost
	 */
	public double getManaCost() {
		return manaCost;
	}
	/**
	 * @param manaCost the manaCost to set
	 */
	public void setManaCost(double manaCost) {
		this.manaCost = manaCost;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the spellID
	 */
	public int getSpellID() {
		return spellID;
	}

	/**
	 * @param spellID the spellID to set
	 */
	public void setSpellID(int spellID) {
		this.spellID = spellID;
	}
	

}
