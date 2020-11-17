/**
 * 
 * @author Navoneel
 *
 */
public class LegendsCell extends Cell {
	
	private boolean heroCell;
	
	LegendsCell(){
		super();
	}
	
	LegendsCell(String symbol){
		super(symbol);
	}
	
	LegendsCell(int cellRow, int cellColumn){
		super(cellRow, cellColumn);
		this.setHeroCell(false);
	}

	/**
	 * @return the heroCell
	 */
	public boolean isHeroCell() {
		return heroCell;
	}

	/**
	 * @param heroCell the heroCell to set
	 */
	public void setHeroCell(boolean heroCell) {
		this.heroCell = heroCell;
	}

}
