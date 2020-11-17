
public class Sorcerer extends Hero {
	
	public Sorcerer(){
		
	}
	
	public Sorcerer(int heroId, String name,double mana,double strength,double agility,double dexterity,double money,int xp){
		super(heroId,name,mana,strength,agility,dexterity,money,xp);
	}

	@Override
	public void heroLevelUp() {
		if(this.getXp()>(this.getLevel()*10)){
			this.setXp(this.getXp()-((this.getLevel()*10)));
			this.setLevel(this.getLevel()+1);
			this.setAgility(this.getAgility()*1.1);
			this.setDexterity(this.getDexterity()*1.1);
			this.setStrength(this.getStrength()*1.05);
			this.setHp(this.getLevel()*100);
			this.setMana(this.getMana()*1.1);
		}
	}
}
