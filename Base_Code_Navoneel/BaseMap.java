import java.util.ArrayList;

/**
 * 
 * @author Navoneel
 *
 */
public abstract class BaseMap {
	
	private ArrayList<ArrayList<LegendsCell>> cellList;
	
	protected BaseMap(){
		
	}
	
	/**
	 * Square Grid Map Constructor
	 */
	protected BaseMap(int mapSize){
		this.buildGridMap(mapSize, mapSize);
	}
	
	/**
	 * Rectangular Grid Map Constructor -- [Place holder] -- Not used in Legends
	 */
	protected BaseMap(int mapRowSize, int mapColumnSize){
		this.buildGridMap(mapRowSize, mapColumnSize);
	}
	
	/**
	 * @category This is a default implementation of grid map/board, please override if necessary in the game's Map class.
	 * @param mapSize
	 */
	protected void buildGridMap(int mapRowSize, int mapColumnSize){
		int rows = mapRowSize;
		int columns = mapColumnSize;
		this.cellList = new ArrayList<ArrayList<LegendsCell>>(mapRowSize);
		
		for(int i = 0; i<rows; i++){
			this.cellList.add(new ArrayList<LegendsCell>());
		}
		
		for(int i = 0; i<rows; i++){
			for(int j = 0; j<columns; j++){
				this.cellList.get(i).add(j, new LegendsCell(i,j));
			}
		}
		
	}

	/**
	 * @return the cellList
	 */
	public ArrayList<ArrayList<LegendsCell>> getCellList() {
		return cellList;
	}

	/**
	 * @param cellList the cellList to set
	 */
	public void setCellList(ArrayList<ArrayList<LegendsCell>> cellList) {
		this.cellList = cellList;
	}

}
