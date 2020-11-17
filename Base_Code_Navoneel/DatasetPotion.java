import java.util.ArrayList;

public class DatasetPotion {
	
	private static int potionID = 0;
	
	public static ArrayList<Potion> potionData(){
		ArrayList<Potion> potions = new ArrayList<Potion>();
		potions.add(new Potion(++potionID, "Healing_Potion",250 ,1 ,100, 0, 0, 0, 0, 0));
		potions.add(new Potion(++potionID, "Strength_Potion",200 ,1 ,0, 0, 0, 0, 75, 0));
		potions.add(new Potion(++potionID, "Magic_Potion",350 ,2 ,0, 100, 0, 0, 0, 0));
		potions.add(new Potion(++potionID, "Luck_Elixir",500 ,4 ,0, 0, 65, 0, 0, 0));
		potions.add(new Potion(++potionID, "Mermaid_Tears",850 ,5 ,100, 100, 100, 0, 100, 0));
		potions.add(new Potion(++potionID, "Ambrosia",1000,8 ,150, 150, 150, 150, 150, 150));
		
		return potions;
	}


}
