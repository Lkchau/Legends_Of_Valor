
// Implementation of a tile, deals with the handling of market events
public class NexusTile extends Tile implements Enterable{
    // each market tile has a market
    private Market market;

    // Constructor
    public NexusTile(){
        super(true, false, null, null);
        setMarket(new Market());
    }

    // Getter and setter for market
    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    // Perform market event
    @Override
    public void enter(Character c) {
            boolean quit = false;
            printMarketIntroduction();
            do{
                System.out.println();
                int response = this.market.promptMarketMainMenu();
                switch(response){
                    case 1:
                        showMarketBuyMenu();
                        break;
                    case 2:
                        showMarketSellMenu();
                        break;
                    case 3:
                        quit = true;
                }
            } while(!quit);

    }

    // Show buy options
    private void showMarketBuyMenu(){
        String itemType = this.market.promptBuy();
        this.market.buyItem(itemType, getHeroOnTile());
    }

    // Show sell options
    private void showMarketSellMenu(){
        this.market.sellItem(getHeroOnTile());
    }

    // Print market's intro
    private void printMarketIntroduction(){
        System.out.println("                     ,---.           ,---.\r\n                    / /\"`.\\.--\"\"\"--./,'\"\\ \\\r\n                    \\ \\    _       _    / /\r\n                     `./  / __   __ \\  \\,'\r\n                      /    /_O)_(_O\\    \\\r\n                      |  .-'  ___  `-.  |\r\n                   .--|       \\_/       |--.\r\n                 ,'    \\   \\   |   /   /    `.\r\n                /       `.  `--^--'  ,'       \\\r\n             .-\"\"\"\"\"-.    `--.___.--'     .-\"\"\"\"\"-.\r\n.-----------/         \\------------------/         \\--------------.\r\n| .---------\\         /----------------- \\         /------------. |\r\n| |          `-`--`--'                    `--'--'-'             | |\r\n| |                                                             | |\r\n| |"+ Colors.getColors().coloredString("yellow","                     W E L C O M E                           ")+"| |\r\n| |                                                             | |\r\n| |"+Colors.getColors().coloredString("yellow","                          T O                                ")+"| |\r\n| |                                                             | |\r\n| |"+Colors.getColors().coloredString("yellow","                  T H E   M A R K E T                        ")+"| |\r\n| |                                                             | |\r\n| |_____________________________________________________________| |\r\n|_________________________________________________________________|\r\n                   )__________|__|__________(\r\n                  |            ||            |\r\n                  |____________||____________|\r\n                    ),-----.(      ),-----.(\r\n                  ,'   ==.   \\    /  .==    `.\r\n                 /            )  (            \\\r\n                 `==========='    `==========='  ");
    }

    @Override
    public String toString() {
        Colors color = Colors.getColors();
        StringBuilder marketTileString = new StringBuilder(super.toString());
        String colorToMake = "green";
        if(isOccupied()) {
            marketTileString.setCharAt(marketTileString.length()/2, 'X');
            colorToMake = "blue";
        }
        else{
            marketTileString.setCharAt(marketTileString.length()/2, 'M');
        }

        return color.coloredString(colorToMake,marketTileString.toString());
    }
}
