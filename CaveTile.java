import java.util.ArrayList;

public class CaveTile extends Tile implements Enterable{
    public CaveTile(){
        super(true, false, null, null);
    }

	@Override
	public void enter(Character c) {
        Hero hero = (Hero) c;
		hero.buff("Agility",1.1);
		
	}
	
	public void exit(Character c) {
		((Hero) c).buff("Agility",-1.1);
	}
}
