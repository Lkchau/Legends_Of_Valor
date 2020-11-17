
public class Weapon {
	
	private String name;
	private double cost, damage;
	private int level, hands, weaponID;
	
	Weapon(){
		
	}
	
	Weapon(int weaponID, String name, double cost, int level, double damage, int hands){
		this.weaponID = weaponID;
		this.name = name;
		this.cost = cost;
		this.level = level;
		this.damage = damage;
		this.hands = hands;
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
	 * @return the hands
	 */
	public int getHands() {
		return hands;
	}

	/**
	 * @param hands the hands to set
	 */
	public void setHands(int hands) {
		this.hands = hands;
	}

	/**
	 * @return the weaponID
	 */
	public int getWeaponID() {
		return weaponID;
	}

	/**
	 * @param weaponID the weaponID to set
	 */
	public void setWeaponID(int weaponID) {
		this.weaponID = weaponID;
	}

}
