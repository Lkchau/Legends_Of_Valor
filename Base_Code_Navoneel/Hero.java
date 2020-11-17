import java.util.ArrayList;

/**
 * 
 * @author Navoneel
 *
 */
public abstract class Hero {
	private int heroId;
	private String name;
	private double mana, hp, strength, agility, dexterity, money, defense;
	private int level,xp;
	private ArrayList<Armor> armors;
	private ArrayList<Weapon> weapons;
	private Armor equippedArmor;
	private Weapon equippedWeapon;
	private Potion potion;
	private Spell spell;
	
	public Hero(){
		
	}
	
	public Hero(int heroId, String name,double mana,double strength,double agility,double dexterity,double money,int xp) {
		this.heroId = heroId;
		this.name = name;
		this.mana = mana;
		this.hp = 100;
		this.strength = strength;
		this.agility = agility;
		this.dexterity = dexterity;
		this.defense = 0;
		this.money = money;
		this.level = 1;
		this.xp = xp;
		this.armors = new ArrayList<Armor>();
		this.weapons = new ArrayList<Weapon>();
		this.equippedArmor = null;
		this.equippedWeapon = null;
		this.potion = null;
		this.spell = null;
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
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
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
	 * @return the xp
	 */
	public int getXp() {
		return xp;
	}
	/**
	 * @param xp the xp to set
	 */
	public void setXp(int xp) {
		this.xp = xp;
	}
	/**
	 * @return the armors
	 */
	public ArrayList<Armor> getArmors() {
		return armors;
	}
	/**
	 * @param armors the armors to set
	 */
	public void setArmors(ArrayList<Armor> armors) {
		this.armors = armors;
	}
	/**
	 * @return the weapons
	 */
	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	/**
	 * @param weapons the weapons to set
	 */
	public void setWeapons(ArrayList<Weapon> weapons) {
		this.weapons = weapons;
	}
	/**
	 * @return the equippedArmor
	 */
	public Armor getEquippedArmor() {
		return equippedArmor;
	}
	/**
	 * @param equippedArmor the equippedArmor to set
	 */
	public void setEquippedArmor(Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
	}
	/**
	 * @return the equippedWeapon
	 */
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}
	/**
	 * @param equippedWeapon the equippedWeapon to set
	 */
	public void setEquippedWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
	/**
	 * @return the potion
	 */
	public Potion getPotion() {
		return potion;
	}
	/**
	 * @param potion the potion to set
	 */
	public void setPotion(Potion potion) {
		this.potion = potion;
	}
	/**
	 * @return the spell
	 */
	public Spell getSpell() {
		return spell;
	}
	/**
	 * @param spell the spell to set
	 */
	public void setSpell(Spell spell) {
		this.spell = spell;
	}
	
	/**
	 * @return the heroId
	 */
	public int getHeroId() {
		return heroId;
	}

	/**
	 * @return the defense
	 */
	public double getDefense() {
		return defense;
	}

	/**
	 * @param heroId the heroId to set
	 */
	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(double defense) {
		this.defense = defense;
	}

	public abstract void heroLevelUp();

}
