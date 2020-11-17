import java.util.ArrayList;

public class DatasetArmor {
	
	private static int armorID = 0;
	
	public static ArrayList<Armor> armorData(){
		ArrayList<Armor> armors = new ArrayList<Armor>();
		armors.add(new Armor(++armorID, "Platinum_Shield", 150 ,1 ,200));
		armors.add(new Armor(++armorID, "Breastplate", 350 ,3 ,600));
		armors.add(new Armor(++armorID, "Full_Body_Armor", 1000,8 ,1100));
		armors.add(new Armor(++armorID, "Wizard_Shield", 1200,10,1500));
		armors.add(new Armor(++armorID, "Speed_Boots", 550 ,4 ,600));
		armors.add(new Armor(++armorID, "Guardian_Angel", 1000,10,1000));
		
		return armors;
	}

}
