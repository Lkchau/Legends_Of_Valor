import java.util.List;

// Abstract idea of a Map to show location and directions
public abstract class Map {
    protected Board board;
    protected int mapSize;

    // Constructors
    public Map(Board board, int size){
        setBoard(board);
        setMapSize(size);
    }
    public Map(int size){
        this(new Board(), size);
    }
    public Map(){
        this(8);
    }

    // getters and setters
    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    // abstract methods to be implemented
    public abstract int[] setRandomPartyLocation(Party p, String heroType);
    public abstract boolean move(Character p, String direction);
    public abstract List<Character> getEnemiesInRange(Character c);

}
