import java.util.ArrayList;

public class LegendsMarket extends Market {
	
	private ArrayList<Armor> armors = new ArrayList<>();
	private ArrayList<Weapon> weapons = new ArrayList<>();
	private ArrayList<Spell> fireSpells = new ArrayList<>();
	private ArrayList<Spell> iceSpells = new ArrayList<>();
	private ArrayList<Spell> lightningSpells = new ArrayList<>();
	private ArrayList<Potion> potions = new ArrayList<>();
	
	public LegendsMarket(){
		
	}
	
	public LegendsMarket(ArrayList<Armor> armors, ArrayList<Weapon> weapons, 
							ArrayList<FireSpell> fireSpells, ArrayList<IceSpell> iceSpells, ArrayList<LightningSpell> lightningSpells,
							ArrayList<Potion> potions){
		this.armors.addAll(armors);
		this.weapons.addAll(weapons);
		this.fireSpells.addAll(fireSpells);
		this.iceSpells.addAll(iceSpells);
		this.lightningSpells.addAll(lightningSpells);
		this.potions.addAll(potions);
	}

	@Override
	public void buy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sell() {
		// TODO Auto-generated method stub

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
	 * @return the fireSpells
	 */
	public ArrayList<Spell> getFireSpells() {
		return fireSpells;
	}

	/**
	 * @param fireSpells the fireSpells to set
	 */
	public void setFireSpells(ArrayList<Spell> fireSpells) {
		this.fireSpells = fireSpells;
	}

	/**
	 * @return the iceSpells
	 */
	public ArrayList<Spell> getIceSpells() {
		return iceSpells;
	}

	/**
	 * @param iceSpells the iceSpells to set
	 */
	public void setIceSpells(ArrayList<Spell> iceSpells) {
		this.iceSpells = iceSpells;
	}

	/**
	 * @return the lightningSpells
	 */
	public ArrayList<Spell> getLightningSpells() {
		return lightningSpells;
	}

	/**
	 * @param lightningSpells the lightningSpells to set
	 */
	public void setLightningSpells(ArrayList<Spell> lightningSpells) {
		this.lightningSpells = lightningSpells;
	}

	/**
	 * @return the potions
	 */
	public ArrayList<Potion> getPotions() {
		return potions;
	}

	/**
	 * @param potions the potions to set
	 */
	public void setPotions(ArrayList<Potion> potions) {
		this.potions = potions;
	}

}
