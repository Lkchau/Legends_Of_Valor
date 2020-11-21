import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// Concrete implementation of Map for the specific game Legends Monsters and heroes
public class LegendsMap extends Map{
    // Read external file for map proportions and generate map based off it
    HashMap<String, Double> proportions = getMapProportions();

    public LegendsMap(int size){
        super(size);
        generateMap();
    }
    public LegendsMap(){
        super();
        generateMap();
    }

    private void generateMap(){
        setBoard(new Board(mapSize));
        fillMap();
    }

    // Set a random location for the party (can start on market tiles)
    public int[] setRandomPartyLocation(Party p, String partyType){
        if(partyType.equalsIgnoreCase("MONSTER")){
            return this.board.setRandomSpot(p,0);
        }else if(partyType.equalsIgnoreCase("HERO")){
            return this.board.setRandomSpot(p,board.getHeight()-1);
        }
        return null;
    }

    // perform movement on the map
    public boolean move(Character c, String direction){
        int currRow = c.getCurrRow();
        int currCol = c.getCurrCol();
        int moveRow = currRow;
        int moveCol = currCol;

        switch(direction){
            case "w":
                moveRow--;
                if(c instanceof Hero){
                    if(board.getBoard()[currRow][currCol].getMonsterOnTile() != null){
                        System.out.println(Colors.getColors().coloredString("red","There is an enemy in the way! Please kill it first"));
                        return false;
                    }
                }
                break;
            case "a":
                moveCol--;
                break;
            case "s":
                moveRow++;
                if(c instanceof Monster){
                    if(board.getBoard()[currRow][currCol].getHeroOnTile() != null){
                        return false;
                    }
                }
                break;
            case "d":
                moveCol++;
                break;
            case "b":
                moveRow = c.getSpawnRow();
                moveCol = c.getSpawnCol();
                break;
            case "t":
                UserPrompt prompter = UserPrompt.getPrompt();
                if(c.getTeleportedFromRow() != -1 && c.getTeleportedFromCol() != -1){
                    moveRow = c.getTeleportedFromRow();
                    moveCol = c.getTeleportedFromCol();
                    if(board.getBoard()[moveRow][moveCol].getHeroOnTile()==null){
                        System.out.println("Teleporting back to where " + c.getName().toString() + " came from.");
                        c.setTeleportedFromRow(-1);
                        c.setTeleportedFromCol(-1);
                    }
                }
                else{
                    do{
                        moveCol = prompter.promptForIntWithPrompt("Choose a column to teleport to.",0,mapSize-1,false);
                        if(!getBoard().getBoard()[0][moveCol].isAccessible()){
                            System.out.println("Trying to teleport to an inaccessible area!");
                        }
                        else if(moveCol == currCol - 1 || moveCol == currCol + 1 || moveCol == currCol){
                            System.out.println("You cannot teleport within the same lane!");
                        }
                    } while(!getBoard().getBoard()[0][moveCol].isAccessible() || (moveCol == currCol - 1 || moveCol == currCol + 1 || moveCol == currCol));
                    int maxPositionToMoveTo = getPositionOfFirstMonsterInLane(moveCol)+1;
                    moveRow = prompter.promptForIntWithPrompt("Choose a row to teleport to.", maxPositionToMoveTo,mapSize-1,false);
                    c.setTeleportedFromCol(currCol);
                    c.setTeleportedFromRow(currRow);
                }
                break;

            default:
                break;
        }
        return moved(currRow, currCol, moveRow, moveCol, c);
    }

    private boolean moved(int currRow, int currCol, int moveRow, int moveCol, Character c){
        boolean moved = false;
        if(moveRow < 0 || moveRow >= board.getWidth() || moveCol < 0 || moveCol >= board.getHeight()){
            printOutOfMapError();
        }
        else{
            if(c instanceof Hero){
                if(board.getBoard()[moveRow][moveCol].isAccessible() && board.getBoard()[moveRow][moveCol].getHeroOnTile() == null){
                    c.setCurrRow(moveRow);
                    c.setCurrCol(moveCol);
                    board.changeOccupancy(currRow,currCol, c, false);
                    board.changeOccupancy(moveRow, moveCol, c, true);
                    moved = true;
                }
                else{
                    printOutOfMapError();
                }
            } else if(c instanceof Monster){
                if(board.getBoard()[moveRow][moveCol].isAccessible() && board.getBoard()[moveRow][moveCol].getMonsterOnTile() == null){
                    c.setCurrRow(moveRow);
                    c.setCurrCol(moveCol);
                    board.changeOccupancy(currRow,currCol, c, false);
                    board.changeOccupancy(moveRow, moveCol, c, true);
                    moved = true;
                }
                else{
                    printOutOfMapError();
                }
            }

        }
        return moved;
    }

    public List<Character> getEnemiesInRange(Character c){
        List<Character> inRange = new ArrayList<>();
        int charCol = c.getCurrCol();
        int charRow = c.getCurrRow();

        int rowStart  = Math.max( charRow - 1, 0   );
        int rowFinish = Math.min( charRow + 1, mapSize - 1 );
        int colStart  = Math.max( charCol - 1, 0   );
        int colFinish = Math.min( charCol + 1, mapSize - 1 );

        for ( int curRow = rowStart; curRow <= rowFinish; curRow++ ) {
            for ( int curCol = colStart; curCol <= colFinish; curCol++ ) {
                if(c instanceof Hero){
                    if(board.getBoard()[curRow][curCol].getMonsterOnTile()!= null){
                        inRange.add(board.getBoard()[curRow][curCol].getMonsterOnTile());
                    }
                }
                else if(c instanceof Monster){
                    if(board.getBoard()[curRow][curCol].getHeroOnTile()!= null){
                        inRange.add(board.getBoard()[curRow][curCol].getHeroOnTile());
                    }
                }

            }
        }

        return inRange;
    }


    // Prints if user tries to go off map
    public void printOutOfMapError(){
        System.out.println(Colors.getColors().coloredString("red","Invalid move, trying to move out of map or into inaccessible area!") + " Please redo your turn");
    }

    // Weighted randomness to help make a randomized map
    public static <E> E weightedRandom(HashMap<E, Double> proportions) {
        Random r = new Random();
        E result = null;
        double max = Double.MAX_VALUE;
        for (E element : proportions.keySet()) {
            double value = -Math.log(r.nextDouble()) / proportions.get(element);
            if (value < max) {
                max = value;
                result = element;
            }
        }

        return result;
    }

    // Fill map based off of proportions and randomness
    private void fillMap(){
        TileFactory tileCreator = new TileFactory();
        for(int i = 0; i < board.getHeight(); i++){
            for (int j = 0; j < board.getWidth();j++){
                if(mapSize%(j+1) == 2){
                    board.setTile(i,j,tileCreator.getTile("Inaccessible"));
                }
                else if(i == 0 || i == mapSize-1){
                    board.setTile(i,j,tileCreator.getTile("Nexus"));
                }
                else{
                    board.setTile(i,j,tileCreator.getTile(weightedRandom(proportions)));
                }
            }
        }
    }

    // Retrieve map proportions
    private HashMap<String, Double> getMapProportions(){
        FileParser fp = FileParser.getFileParser();
        HashMap<String, Double> mapProportion = new HashMap<>();
        List<String> proportionsFromList = fp.readFile("", "MapProportions");
        for(String prop: proportionsFromList){
            String[] propParts = prop.split(": ");
            String currKey = propParts[0];
            Double currValue = Double.parseDouble(propParts[1]);
            mapProportion.put(currKey, currValue);
        }
        return mapProportion;
    }

    private int getPositionOfFirstMonsterInLane(int colNum){
        int position = -1;
        int leftCol = colNum - 1;
        int rightCol = colNum + 1;

        if(rightCol >= mapSize){
            rightCol = mapSize-1;
        }

        if(leftCol < 0){
            leftCol = 0;
        }

        for(int i = leftCol; i <= rightCol; i++){
            if(getPositionOfFirstMonsterInColumn(i) > position){
                position = getPositionOfFirstMonsterInColumn(i);
            }
        }
        return position;
    }

    private int getPositionOfFirstMonsterInColumn(int colNum){
        int position = -1;
        for(int i = 0; i < board.getHeight()-1;i++){
            if(board.getBoard()[i][colNum].getMonsterOnTile()!=null){
                if(i > position){
                    position = i;
                }
            }
        }


        return position;
    }

    // To be used by the toString to print out the representations of each tile on the map
    private String legend(){
        StringBuilder legend = new StringBuilder();
        legend.append(Colors.getColors().coloredString("purple", "\t\t\t\t\t\tL E G E N D\n"));
        TileFactory tile = new TileFactory();
        legend.append(tile.getTile("Inaccessible")+ ": NonAcessible\t");
        legend.append(tile.getTile("Nexus")+ ": Nexus\t");
        legend.append(Colors.getColors().coloredString("blue", "H_") + ": Hero location\t");
        legend.append(Colors.getColors().coloredString("red", "M_") + ": Monster location");
        return legend.toString();
    }

    @Override
    public String toString() {
        return boardStr() + legend();
    }

    private static String getOuterCellStr(char c){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            str.append(c).append(" - ");
        }
        str.append(c).append("   ");
        return str.toString();
    }

    private static String getInnerCellStr(String component){
        return "| " + component + " |   ";
    }

    private String getCellComponent(int row, int col){
        StringBuilder tileContents = new StringBuilder();
        Tile currTile = this.board.getBoard()[row][col];
        if (currTile.getHeroOnTile() != null) {
            tileContents.append(Colors.getColors().coloredString("blue", "H" + currTile.getHeroOnTile().getCharID()));
        } else {
            tileContents.append("  ");
        }
        tileContents.append(" ");
        if(currTile.getMonsterOnTile() != null){
            tileContents.append(Colors.getColors().coloredString("red","M" + currTile.getMonsterOnTile().getCharID()));
        } else{
            tileContents.append("  ");
        }
        return tileContents.toString();
    }

    private void createInnerCell(Tile[][] map, List<StringBuilder> printableMap, int row, int col) {
        String component = getCellComponent(row/3, col);
        if (map[row/3][col] instanceof InaccessibleTile)
            component = Colors.getColors().coloredBackground("red","     ");
        printableMap.get(row).append(getInnerCellStr(component));
    }

    private static void createOutterCell(Tile[][] map, List<StringBuilder> printableMap, int row, int col) {
        switch (map[row/3][col].getClass().getName()){
            case "NexusTile":
                printableMap.get(row).append(getOuterCellStr('N'));
                break;
            case "CommonTile":
                printableMap.get(row).append(getOuterCellStr('P'));
                break;
            case "KoulouTile":
                printableMap.get(row).append(getOuterCellStr('K'));
                break;
            case "CaveTile":
                printableMap.get(row).append(getOuterCellStr('C'));
                break;
            case "BushTile":
                printableMap.get(row).append(getOuterCellStr('B'));
                break;
            case "InaccessibleTile":
                printableMap.get(row).append(getOuterCellStr('I'));
                break;
        }
    }

    public String boardStr() {
        int size = 8;
        List<StringBuilder> printableMap = new ArrayList<StringBuilder>();

        for (int row = 0; row < size * 3; row++) {
            printableMap.add(new StringBuilder());
            if ((row / 3) % 2 == 0) {
                for (int col = 0; col < size; col++) {
                    if (row % 2 == 0) {
                        createOutterCell(this.board.getBoard(), printableMap, row, col);
                    } else {
                        createInnerCell(this.board.getBoard(), printableMap, row, col);
                    }

                    if (col == size - 1)
                        printableMap.get(row).append("\n");
                }
            } else {
                for (int col = 0; col < size; col++) {
                    if (row % 2 == 1) {
                        createOutterCell(this.board.getBoard(), printableMap, row, col);
                    } else {
                        createInnerCell(this.board.getBoard(), printableMap, row, col);
                    }

                    if (col == size - 1)
                        printableMap.get(row).append("\n");
                }
            }

            if (row % 3 == 2)
                printableMap.get(row).append("\n");
        }
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < size * 3; i++) {
            b.append(printableMap.get(i));
        }
        return b.toString();
    }
}
