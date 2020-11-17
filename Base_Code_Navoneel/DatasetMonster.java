import java.util.ArrayList;

public class DatasetMonster {
	
	public static ArrayList<Dragon> dragonData(){
		ArrayList<Dragon> dragons = new ArrayList<Dragon>();
		dragons.add(new Dragon("Desghidorrah", 3, 300, 400, 35));
		dragons.add(new Dragon("Chrysophylax", 2, 200, 500, 20));
		dragons.add(new Dragon("BunsenBurner", 4, 400, 500, 45));
		dragons.add(new Dragon("Natsunomeryu", 1, 100,200,10));
		dragons.add(new Dragon("TheScaleless", 7,700,600,75));
		dragons.add(new Dragon("Kas-Ethelinh",5,600,500,60));
		dragons.add(new Dragon("Alexstraszan",10,1000,9000,55));
		dragons.add(new Dragon("Phaarthurnax",6,600,700,60));
		dragons.add(new Dragon("D-Maleficent",9,900,950,85));
		dragons.add(new Dragon("TheWeatherbe",8,800,900,80));
		dragons.add(new Dragon("Igneel",6,600,400,60));
		dragons.add(new Dragon("BlueEyesWhite",9,900,600,75));
		
		return dragons;
	}
	
	public static ArrayList<Exoskeleton> exoskeletonData(){
		ArrayList<Exoskeleton> exoskeletons = new ArrayList<Exoskeleton>();
		exoskeletons.add(new Exoskeleton("Cyrrollalee",7 ,700 ,800 ,75));
		exoskeletons.add(new Exoskeleton("Brandobaris",3 ,350 ,450 ,30));
		exoskeletons.add(new Exoskeleton("BigBad-Wolf",1 ,150 ,250 ,15));
		exoskeletons.add(new Exoskeleton("WickedWitch",2 ,250 ,350 ,25));
		exoskeletons.add(new Exoskeleton("Aasterinian",4 ,400 ,500 ,45));
		exoskeletons.add(new Exoskeleton("Chronepsish",6 ,650 ,750 ,60));
		exoskeletons.add(new Exoskeleton("Kiaransalee",8 ,850 ,950 ,85));
		exoskeletons.add(new Exoskeleton("St-Shargaas",5 ,550 ,650 ,55));
		exoskeletons.add(new Exoskeleton("Merrshaullk",10,1000,900 ,55));
		exoskeletons.add(new Exoskeleton("St-Yeenoghu",9 ,950 ,850 ,90));
		exoskeletons.add(new Exoskeleton("DocOck",6 ,600 ,600 ,55));
		exoskeletons.add(new Exoskeleton("Exodia",10,1000,1000,50));
		
		return exoskeletons;
	}
	
	public static ArrayList<Spirit> spiritData(){
		ArrayList<Spirit> spirits = new ArrayList<Spirit>();
		spirits.add(new Spirit("Andrealphus", 2,600,500,40));
		spirits.add(new Spirit("Aim-Haborym", 1,450,350,35));
		spirits.add(new Spirit("Andromalius", 3,550,450,25));
		spirits.add(new Spirit("Chiang-shih", 4,700,600,40));
		spirits.add(new Spirit("FallenAngel", 5,800,700,50));
		spirits.add(new Spirit("Ereshkigall", 6,950,450,35));
		spirits.add(new Spirit("Melchiresas", 7,350,150,75));
		spirits.add(new Spirit("Jormunngand", 8,600,900,20));
		spirits.add(new Spirit("Rakkshasass", 9,550,600,35));
		spirits.add(new Spirit("Taltecuhtli", 1,300,200,50));
		spirits.add(new Spirit("Casper", 1,100,100,50));
		spirits.add(new Spirit("Ghastly", 1,100,100,50));
		
		return spirits;
	}

}
