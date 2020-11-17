/**
 * @category Class for individual cells for board
 * @author Navoneel
 *
 */

public abstract class Cell {
	
	private String symbol;
	private int cellRow, cellColumn;
	
	Cell(){
		this.symbol = "";
	}
	
	Cell(String symbol){
		this.symbol = symbol;
	}
	
	Cell(int cellRow, int cellColumn){
		this.cellRow = cellRow;
		this.cellColumn = cellColumn;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the cellRow
	 */
	public int getCellRow() {
		return cellRow;
	}

	/**
	 * @param cellRow the cellRow to set
	 */
	public void setCellRow(int cellRow) {
		this.cellRow = cellRow;
	}

	/**
	 * @return the cellColumn
	 */
	public int getCellColumn() {
		return cellColumn;
	}

	/**
	 * @param cellColumn the cellColumn to set
	 */
	public void setCellColumn(int cellColumn) {
		this.cellColumn = cellColumn;
	}
	
	

}
