import java.util.ArrayList;

public class BushTile extends Tile implements Enterable{
    public BushTile(){
        super(true, false, null, null);
    }

	@Override
	public void enter(Character c) {
		((Hero) c).buff("Dexterity",1.1);
		
	}
	
	public void exit(Character c) {
		((Hero) c).buff("Dexterity",-1.1);
	}
}
