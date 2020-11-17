
public class Potion {
	
	private int potionID, level;
	private String name;
	private double cost, hp, mana, agility, dexterity, strength, defense;
	
	Potion(){
		
	}
	
	Potion(int potionID, String name, double cost, int level, double hp, double mana, double agility, double dexterity, double strength, double defense){
		this.potionID = potionID;
		this.name = name;
		this.cost = cost;
		this.level = level;
		this.hp = hp;
		this.mana = mana;
		this.agility = agility;
		this.dexterity = dexterity;
		this.strength = strength;
		this.defense = defense;
	}

	/**
	 * @return the potionID
	 */
	public int getPotionID() {
		return potionID;
	}

	/**
	 * @param potionID the potionID to set
	 */
	public void setPotionID(int potionID) {
		this.potionID = potionID;
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
	 * @return the hp
	 */
	public double getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(double hp) {
		this.hp = hp;
	}

	/**
	 * @return the mana
	 */
	public double getMana() {
		return mana;
	}

	/**
	 * @param mana the mana to set
	 */
	public void setMana(double mana) {
		this.mana = mana;
	}

	/**
	 * @return the agility
	 */
	public double getAgility() {
		return agility;
	}

	/**
	 * @param agility the agility to set
	 */
	public void setAgility(double agility) {
		this.agility = agility;
	}

	/**
	 * @return the dexterity
	 */
	public double getDexterity() {
		return dexterity;
	}

	/**
	 * @param dexterity the dexterity to set
	 */
	public void setDexterity(double dexterity) {
		this.dexterity = dexterity;
	}

	/**
	 * @return the strength
	 */
	public double getStrength() {
		return strength;
	}

	/**
	 * @param strength the strength to set
	 */
	public void setStrength(double strength) {
		this.strength = strength;
	}

	/**
	 * @return the defense
	 */
	public double getDefense() {
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(double defense) {
		this.defense = defense;
	}

}
