import java.util.ArrayList;
import java.util.List;

// Representation of a tile on a board that can be accessed or occupied
public class Tile {
    private boolean accessible;
    private boolean occupied;

    // List of Character for maybe future implementation of multiple parties on a tile
//    private List<Character> charactersOnTile;
    private final int DEFAULTTILELENGTH = 5;
    private Character monsterOnTile = null;
    private Character heroOnTile = null;

    // Construtctors
    public Tile(boolean accessible, boolean occupied, Character heroOnTile, Character monsterOnTile){
        setAccessible(accessible);
        setOccupied(occupied);
        setHeroOnTile(heroOnTile);
        setMonsterOnTile(monsterOnTile);
    }
    public Tile(){
        this(true, false, null, null);
    }

    // setters and getters
    public boolean isAccessible(){
        return accessible;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public int getTileLength(){
        return DEFAULTTILELENGTH;
    }

    public void setHeroOnTile(Character heroOnTile) {
        this.heroOnTile = heroOnTile;
    }

    public Character getHeroOnTile() {
        return heroOnTile;
    }

    public void setMonsterOnTile(Character monsterOnTile) {
        this.monsterOnTile = monsterOnTile;
    }

    public Character getMonsterOnTile() {
        return monsterOnTile;
    }

    // remove a certain Character on the tile
    public void remove(Character p){
        if(heroOnTile!= null && p.equals(heroOnTile)){
            heroOnTile = null;
        }
        else if(monsterOnTile!= null && p.equals(monsterOnTile)){
            monsterOnTile = null;
        }
    }

    public void add(Character p){
        if(p instanceof Hero){
            heroOnTile = p;
        }
        else if(p instanceof Monster){
            monsterOnTile = p;
        }
    }


    public String toString(){
        return new String(new char[DEFAULTTILELENGTH]).replace("\0", " ");
    }
}
