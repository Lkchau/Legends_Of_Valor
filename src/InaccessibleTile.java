import java.util.ArrayList;

public class InaccessibleTile extends Tile{
    // Representation of an inaccessible tile
    public InaccessibleTile(){
        super(false, true, null, null);
    }

    @Override
    public String toString() {
        Colors color = Colors.getColors();
        return color.coloredString("","red", super.toString());
    }
}
