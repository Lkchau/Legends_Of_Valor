import java.util.ArrayList;

public class DatasetHero {
	
	private static int heroID = 0;
	
	public static ArrayList<Paladin> paladinData(){
		ArrayList<Paladin> availablePaladin = new ArrayList<Paladin>();
		availablePaladin.add(new Paladin(++heroID,"Solonor_Thelandira",300,750,650,700,2500,7));
		availablePaladin.add(new Paladin(++heroID,"Sehanine_Moonbow",300,750,700,700,2500,7));
		availablePaladin.add(new Paladin(++heroID,"Skoraeus_Stonebones",250,650,600,350,2500,4));
		availablePaladin.add(new Paladin(++heroID,"Garl_Glittergold",100,600,500,400,2500,5));
		availablePaladin.add(new Paladin(++heroID,"Amaryllis_Astra",500,500,500,500,2500,5));
		availablePaladin.add(new Paladin(++heroID,"Caliber_Heist",400,400,400,400,2500,8));
		
		return availablePaladin;
	}
	
	public static ArrayList<Sorcerer> sorcererData(){
		ArrayList<Sorcerer> availableSorcerer = new ArrayList<Sorcerer>();
		availableSorcerer.add(new Sorcerer(++heroID,"Rillifane_Rallathil",1300,750,450,500,2500,9));
		availableSorcerer.add(new Sorcerer(++heroID,"Segojan_Earthcaller",900,800,500,650,2500,5));
		availableSorcerer.add(new Sorcerer(++heroID,"Reign_Havoc",800,800,800,800,2500,8));
		availableSorcerer.add(new Sorcerer(++heroID,"Reverie_Ashels",900,800,700,400,2500,7));
		availableSorcerer.add(new Sorcerer(++heroID,"Radiant_Ash",800,850,400,600,2500,6));
		availableSorcerer.add(new Sorcerer(++heroID,"Skye_Soar",1000,700,400,500,2500,5));
		
		return availableSorcerer;
	}
	
	public static ArrayList<Warrior> warriorData(){
		ArrayList<Warrior> availableWarrior = new ArrayList<Warrior>();
		availableWarrior.add(new Warrior(++heroID,"Gaerdal_Ironhand",100,700,500,600,2500,7));
		availableWarrior.add(new Warrior(++heroID,"Sehanine_Monnbow",600,700,800,500,2500,8));
		availableWarrior.add(new Warrior(++heroID,"Muamman_Duathall",300,900,500,750,2500,6));
		availableWarrior.add(new Warrior(++heroID,"Flandal_Steelskin",200,750,650,700,2500,7));
		availableWarrior.add(new Warrior(++heroID,"Undefeated_Yoj",400,800,400,700,2500,7));
		availableWarrior.add(new Warrior(++heroID,"Eunoia_Cyn",400,700,800,600,2500,6));
		
		return availableWarrior;
	}

}
