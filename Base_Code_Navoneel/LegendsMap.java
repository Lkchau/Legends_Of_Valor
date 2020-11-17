import java.util.SplittableRandom;

/**
 * 
 * @author Navoneel
 *
 */

public class LegendsMap extends BaseMap {

	private int mapSize, heroCellRow, heroCellColumn;

	public LegendsMap(){
		super();
	}

	/**
	 * @category 
	 * @param mapSize
	 */
	public LegendsMap(int mapSize){
		super(mapSize);
		this.mapSize = mapSize;
		this.heroCellRow = 0;
		this.heroCellColumn = 0;
		customizeBaseMap(mapSize);
	}

	private void customizeBaseMap(int mapSize){
		int mapGridSize = mapSize*mapSize;
		long totalCommonCells = Math.round((0.6*mapGridSize))-1;
		long totalMarketCells = Math.round((0.2*mapGridSize))-2;
		long totalBlockedCells = Math.round((0.2*mapGridSize));
		long commonCellsCount = 0, marketCellsCount = 0, blockedCellsCount = 0;
		SplittableRandom random = new SplittableRandom();
		int cellType;
		mapGridSize = mapGridSize-3;
		int rows = mapSize;
		int columns = mapSize;
		for(int i = 0; i<rows; i++){
			for(int j = 0; j<columns; j++){
				if(i == 0 && j == 0){
					this.getCellList().get(i).get(j).setSymbol("C");
					this.getCellList().get(i).get(j).setHeroCell(true);
				}
				else if((i == 0 && j == 1) || (i == 1 && j == 0)){
					this.getCellList().get(i).get(j).setSymbol("M");
				}
				else{
					while(mapGridSize > 0){
						cellType = random.nextInt(0, 100);
						if(cellType >= 0 && cellType <= 20 && blockedCellsCount != totalBlockedCells){
							this.getCellList().get(i).get(j).setSymbol("X");
							blockedCellsCount++;
							mapGridSize--;
							break;
						}
						if(cellType >= 21 && cellType <=50 && marketCellsCount != totalMarketCells){
							this.getCellList().get(i).get(j).setSymbol("M");
							marketCellsCount++;
							mapGridSize--;
							break;
						}
						if(cellType >= 51 && cellType < 100 && commonCellsCount != totalCommonCells){
							this.getCellList().get(i).get(j).setSymbol("C");
							commonCellsCount++;
							mapGridSize--;
							break;
						}
					}
				}
			}
		}
	}

	public void drawLegendsMap(){
		int rows = this.mapSize;
		int columns = this.mapSize;
		System.out.println();
		for(int i = 0; i<rows; i++){
			for(int j = 0; j<columns; j++){
				if(this.getCellList().get(i).get(j).getSymbol().equals("C")){
					if(this.getCellList().get(i).get(j).isHeroCell()){
						System.out.print(" | H");
					}
					else{
						System.out.print(" |  ");
					}
				}
				else{
					if(this.getCellList().get(i).get(j).isHeroCell()){
						System.out.print(" | H"); 
					}
					else{
						System.out.print(" | "+this.getCellList().get(i).get(j).getSymbol());
					}
				}
			}
			System.out.print(" |");
			System.out.println();
		}
	}

	/**
	 * @return the mapSize
	 */
	public int getMapSize() {
		return mapSize;
	}

	/**
	 * @return the heroCellRow
	 */
	public int getHeroCellRow() {
		return heroCellRow;
	}

	/**
	 * @return the heroCellColumn
	 */
	public int getHeroCellColumn() {
		return heroCellColumn;
	}

	/**
	 * @param mapSize the mapSize to set
	 */
	public void setMapSize(int mapSize) {
		this.mapSize = mapSize;
	}

	/**
	 * @param heroCellRow the heroCellRow to set
	 */
	public void setHeroCellRow(int heroCellRow) {
		this.heroCellRow = heroCellRow;
	}

	/**
	 * @param heroCellColumn the heroCellColumn to set
	 */
	public void setHeroCellColumn(int heroCellColumn) {
		this.heroCellColumn = heroCellColumn;
	}

}
