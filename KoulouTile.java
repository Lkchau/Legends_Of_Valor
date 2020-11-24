import java.util.ArrayList;

public class KoulouTile extends Tile implements Enterable{

    public KoulouTile(){
        super(true, false, null, null);
    }

	@Override
	public void enter(Character c) {
		((Hero) c).buff("Strength",1.1);
		
	}
	
	public void exit(Character c) {
		((Hero) c).buff("Strength",-1.1);
	}
}
