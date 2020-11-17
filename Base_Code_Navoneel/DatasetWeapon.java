import java.util.ArrayList;

public class DatasetWeapon {
	
	private static int weaponID = 0;
	
	public static ArrayList<Weapon> weaponData(){
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();
		weapons.add(new Weapon(++weaponID, "Sword",500 ,1,800 ,1));
		weapons.add(new Weapon(++weaponID, "Bow",300 ,2,500 ,2));
		weapons.add(new Weapon(++weaponID, "Scythe",1000,6,1100,2));
		weapons.add(new Weapon(++weaponID, "Axe",550 ,5,850 ,1));
		weapons.add(new Weapon(++weaponID, "TSwords",1400,8,1600,2));
		weapons.add(new Weapon(++weaponID, "Dagger",200 ,1,250 ,1  ));
		
		return weapons;
	}

}
