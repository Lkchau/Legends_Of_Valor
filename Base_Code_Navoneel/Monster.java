
public abstract class Monster {
	private String name;
	private double hp, defense, damage, dodgeChance;
	private int level;
	
	public Monster(){
		
	}
	
	public Monster(String name,int level,double damage,double defense,double dodgeChance){
		this.name = name;
		this.defense = defense;
		this.damage = damage;
		this.dodgeChance = dodgeChance;
		this.level = level;
		this.hp = 100*level;	
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
	 * @return the dodgeChance
	 */
	public double getDodgeChance() {
		return dodgeChance;
	}
	/**
	 * @param dodgeChance the dodgeChance to set
	 */
	public void setDodgeChance(double dodgeChance) {
		this.dodgeChance = dodgeChance;
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

}
