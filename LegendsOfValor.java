import java.util.*;

// Concrete implementation of a rpg with a map
public class LegendsOfValor extends RolePlayingGameWithMap{
    private Colors color = Colors.getColors();
    private final String MAPTYPE;
    private final int MINMAPSIZE = 5;
    private final int MAXMAPSIZE = 10;
    private final int DEFAULTMAPSIZE = 8;
    private final double proportionToRecoverAfterTurn = 0.05;
    private final int numTurnsSpawnMob = 8;
    private boolean quit = false;

    // Constructor
    public LegendsOfValor(){
        super("LEGENDS");
        MAPTYPE = "LEGENDS";
    }

    // Run the game and print extra info if needed
    public void run(){
        int showInfo = welcomeScreen();
        switch(showInfo){
            case 2:
                printInstructions();
                break;
        }
//        setCustomMap();
        startGame();
    }

    //print out the welcome screen
    private int welcomeScreen(){
        System.out.println(color.coloredString("red","cyan"," ___            ___ ") + "                   Welcome to Legends: Monsters And Heroes!\r\n"+color.coloredString("red","cyan","/   \\          /   \\")+"                                              \r\n" + color.coloredString("red","cyan","\\_   \\        /  __/\r")+"\n" + color.coloredString("red","cyan", " _\\   \\      /  /__ \r") + "\n" + color.coloredString("red","cyan"," \\___  \\____/   __/ \r") + "\n"+color.coloredString("red","cyan","     \\_       _/    \r") + "\n"+color.coloredString("red","cyan","       | @ @  \\_    \r") + "\n" +color.coloredString("red","cyan","       |            \r") + "\n" + color.coloredString("red","cyan","     _/     /\\      \r") + "\n" + color.coloredString("red","cyan","    /o)  (o/\\ \\_    \r") + "\n"+color.coloredString("red","cyan","    \\_____/ /       \r") + "\n" +color.coloredString("red","cyan","      \\____/        "));
        UserPrompt prompter = UserPrompt.getPrompt();
        int response = prompter.promptMenuOptions(this.menus.getMenu("MENU").getMenu("StartMenu", null), false);
        return response;
    }

    // Start the game
    private void startGame(){
        System.out.println(Colors.getColors().coloredString("purple","\t\t\t\t\t\t\t\t\t\t L E T   T H E   G A M E   B E G I N\n"));
        setUpGame();
        runGame(UserPrompt.getPrompt());
    }

    // Set up a game
    private void setUpGame(){
        setUpInitialParty(UserPrompt.getPrompt());
        setInitialMonsterParty();
        printCurrentMap();
    }

    // run the game
    private void runGame(UserPrompt prompter){
        int roundNum = 1;
        do{
            System.out.println(Colors.getColors().coloredString("yellow", "\t\t\t\t\t\t\t\t\t G E T   R E A D Y   F O R   R O U N D   " + roundNum));
            playOneTurn(prompter,parties.get(0));
            playEnemyTurn(parties.get(1));
            checkWin();
            if(!quit){
                for(Party p : parties){
                    if(p.getPartyType().equalsIgnoreCase("HERO")){
                        recoverHeroAfterARound(p);
                    }
                }
                checkFaintedHero();
                roundNum++;
                if(roundNum%numTurnsSpawnMob == 0){
                    spawnMonsters();
                }
            }

        } while(!quit);

    }
    // First for loop checks if there is a hero in the monster's nexus, and if so print out that they won and end the game
    // Second for loop checks if there is a monster in the hero's nexus and if so print out that the heroes lost and end the game
    private void checkWin(){
        Board currBoard = map.getBoard();
        for(int i = 0; i < currBoard.getWidth();i++) {
            if(currBoard.getBoard()[0][i].getHeroOnTile()!=null){
                printVictoryScreen();
                break;
            }
        }
        for(int j = 0; j < currBoard.getWidth();j++){
            if(currBoard.getBoard()[currBoard.getHeight()-1][j].getMonsterOnTile()!=null){
                printLosingScreen();
                break;
            }
        }
    }

    //Specification: You can assume that during every round of a fight the heroes regain 10% of their hp and 10% of their mana.
    // Value changed to 5%
    // Heal the health and mana of heroes between rounds in a battle
    private void recoverHeroAfterARound(Party party){
        for(Character c: party.getParty()){
            if(c instanceof Hero && !c.isFainted()){
                Hero currHero = (Hero) c;
                Mana toRecover = new Mana((int) Math.round(currHero.getBaseMana().getMana()*proportionToRecoverAfterTurn));
                currHero.getMana().addMana(toRecover);
                Health hpToRecover = new Health((int) Math.round(currHero.getBaseHP().getHealth()*proportionToRecoverAfterTurn));
                currHero.getHp().addHealth(hpToRecover);
            }
        }
    }
    // Check if a monster fainted and if so, remove them from the map and update the alive heroes
    private void checkFaintedMonster(){
        for(Party p: parties){
            if(p.getPartyType().equalsIgnoreCase("Monster")){
                for(int i = 0; i < p.getParty().size();i++){
                    Character toRemove = p.getParty().get(i);
                    if(toRemove.isFainted()){
                        p.getParty().remove(i);
                        this.map.getBoard().getBoard()[toRemove.getCurrRow()][toRemove.getCurrCol()].setMonsterOnTile(null);
                        int amountMoneyGained = 100*toRemove.getLevel().getLevel();
                        Money moneyGained = new Money(amountMoneyGained);
                        for(Party heroParty: parties){
                            if(heroParty.getPartyType().equalsIgnoreCase("Hero")){
                                for(Character c: heroParty.getParty()){
                                    if(c instanceof Hero && !c.isFainted()){
                                        Hero currHeroToUpdate = (Hero) c;
                                        currHeroToUpdate.getWallet().add(moneyGained);
                                        currHeroToUpdate.getExp().add(2);
                                        currHeroToUpdate.levelUp();
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    // Check if a hero fainted, if so revive the hero
    private void checkFaintedHero(){
        boolean heroRevived = false;
        for(Party p: parties){
            if(p.getPartyType().equalsIgnoreCase("Hero")){
                for(int i = 0; i < p.getParty().size();i++){
                    Character currHero = p.getParty().get(i);
                    if(currHero.isFainted()){
                        this.map.move(currHero,"b");
                        if(currHero instanceof Hero){
                            ((Hero) currHero).revive();
                            heroRevived = true;
                        }
                    }
                }

            }
        }
        if(heroRevived){
            printCurrentMap();
        }
    }

    // Print out the losing screen and set to quit the game
    private void printLosingScreen() {
        System.out.println(Colors.getColors().coloredString("red", "                                                                          \r\n@@@@@@@      @@@@@@@@     @@@@@@@@     @@@@@@@@      @@@@@@      @@@@@@@  \r\n@@@@@@@@     @@@@@@@@     @@@@@@@@     @@@@@@@@     @@@@@@@@     @@@@@@@  \r\n@@!  @@@     @@!          @@!          @@!          @@!  @@@       @@!    \r\n!@!  @!@     !@!          !@!          !@!          !@!  @!@       !@!    \r\n@!@  !@!     @!!!:!       @!!!:!       @!!!:!       @!@!@!@!       @!!    \r\n!@!  !!!     !!!!!:       !!!!!:       !!!!!:       !!!@!!!!       !!!    \r\n!!:  !!!     !!:          !!:          !!:          !!:  !!!       !!:    \r\n:!:  !:!     :!:          :!:          :!:          :!:  !:!       :!:    \r\n :::: ::      :: ::::      ::           :: ::::     ::   :::        ::    \r\n:: :  :      : :: ::       :           : :: ::       :   : :        :     \r\n                                                                          "));
        quit = true;
    }
    // Print out the victory screen and set to quit the game
    private void printVictoryScreen(){
        System.out.println("         .* *.               `o`o`\r\n         *. .*              o`o`o`o      ^,^,^\r\n           * \\               `o`o`     ^,^,^,^,^\r\n              \\     ***        |       ^,^,^,^,^\r\n               \\   *****       |        /^,^,^\r\n                \\   ***        |       /\r\n    ~@~*~@~      \\   \\         |      /\r\n  ~*~@~*~@~*~     \\   \\        |     /\r\n  ~*~@smd@~*~      \\   \\       |    /     #$#$#        .`'.;.\r\n  ~*~@~*~@~*~       \\   \\      |   /     #$#$#$#   00  .`,.',\r\n    ~@~*~@~ \\        \\   \\     |  /      /#$#$#   /|||  `.,'\r\n_____________\\________\\___\\____|_/______/_________|\\/\\___||______\r\n                       "+Colors.getColors().coloredString("blue","V I C T O R Y !"));
        quit = true;
    }

    // Play out one turn of the rpg
    private void playOneTurn(UserPrompt prompter, Party p) {
        for(Character c: p.getParty()){
            boolean moved = false;
            String response = "";
            while(response.equalsIgnoreCase("I") || !moved){
                System.out.println("Time for " + c.getName() +"'s turn");
                response = printControlMenu(prompter);
                switch (response) {
                    case "I":
                    case "i":
                        printParty(0);
                        printParty(1);
                        printCurrentMap();
                        break;
                    case "Q":
                    case "q":
                        quit = true;
                        break;
                    case "E":
                    case "e":
                        if(c instanceof Hero){
                            Hero currHero = ((Hero) c);
                            if(currHero.getInv().getEquips().size() <= 0){
                                System.out.println(Colors.getColors().coloredString("red","You have no Equips to equip!"));
                                moved = false;
                            }
                            else{
                                moved = promptEquipItem(currHero);
                            }
                        }
                        else{
                            moved = false;
                        }
                        break;
                    case "P":
                    case "p":

                        if(c instanceof Hero){
                            promptPotionDrink((Hero) c);
                        }
                        moved = true;
                        break;
                    case "C":
                    case "c":
                        List<Character> attackableEnemies= map.getEnemiesInRange(c);
                        if(attackableEnemies.size()<1){
                            System.out.println(Colors.getColors().coloredString("red","No available targets!"));
                            moved = false;
                        } else{
                            int toAttack = prompter.promptList(attackableEnemies,"an enemy to cast spell on");
                            if(c instanceof Hero){
                                Hero currHero = ((Hero) c);
                                if(currHero.getInv().getSpells().size() <= 0){
                                    System.out.println(Colors.getColors().coloredString("red","You have no spells to cast!"));
                                    moved = false;
                                }
                                else{
                                    Character enemy = attackableEnemies.get(toAttack-1);
                                    if(enemy instanceof Debuffable){
                                        Debuffable monster = (Debuffable) enemy;
                                        if(!promptSpellCast(currHero, monster)){
                                            System.out.println(Colors.getColors().coloredString("red","Not enough mana to cast! or not an option"));
                                            moved = false;
                                        } else{
                                            moved = true;
                                        }
                                    }

                                }
                            }
                        }
                        checkFaintedMonster();
                        break;
                    case "F":
                    case "f":
                        attackableEnemies = map.getEnemiesInRange(c);
                        if(attackableEnemies.size()<1){
                            System.out.println(Colors.getColors().coloredString("red","No available targets!"));
                            moved = false;
                        } else{
                            int toAttack = prompter.promptList(attackableEnemies,"an enemy to attack");
                            attackEnemy(c,attackableEnemies.get(toAttack-1));
                            moved = true;
                        }
                        checkFaintedMonster();
                        break;
                    case "M":
                    case "m":
                        Tile currTile = map.getBoard().getBoard()[c.currRow][c.getCurrCol()];
                        if(currTile instanceof NexusTile){
                            ((NexusTile) currTile).enter(c);
                        } else{
                            System.out.println(Colors.getColors().coloredString("red", "\nThere is no market here, please redo your turn\n"));
                        }
                        printCurrentMap();
                        moved = false;
                        break;

                    default:
                        moved = performMove(response, c);
                        printCurrentMap();
                        break;
                }
            }
        }

    }

    // Allow the hero to attack an enemy
    private void attackEnemy(Character hero, Character enemy){
        if(hero instanceof Hero){
            Hero currHero = (Hero) hero;
            currHero.attack(enemy);
        }
    }

    // Allow the monster to attack the hero
    private void attackHero(Character monster, Character hero){
        if(monster instanceof Monster){
            Monster currMonster = (Monster) monster;
            currMonster.attack(hero);
        }
    }

    // Ask the user if they want to cast a spell
    private boolean promptSpellCast(Hero c, Debuffable enemy){
        HashMap<Integer, String> inventoryMap = new HashMap<>();
        int index = 1;
        for (Item item : c.getInv().getInventory()) {
            if(item instanceof Spell) inventoryMap.put(index, item.toString());
            index++;
        }
        int response = UserPrompt.getPrompt().promptMenuOptionsQuittable(new Menu("Please choose a spell to cast", inventoryMap, null, null), false);
        if(response == -1) return  false;
        Item spell = c.getInv().getByItemName(inventoryMap.get(response).split(" ")[0]);
        if(spell instanceof Spell){
            return ((Spell) spell).cast(c,enemy);
        } else{
            return false;
        }
    }

    // Ask the user if they want to drink a potion
    private boolean promptPotionDrink(Hero c){
        HashMap<Integer, String> inventoryMap = new HashMap<>();
        int index = 1;
        for (Item item : c.getInv().getInventory()) {
            if(item instanceof Potion) inventoryMap.put(index, item.toString());
            index++;
        }
        int response = UserPrompt.getPrompt().promptMenuOptionsQuittable(new Menu("Please choose a potion to drink", inventoryMap, null, null), false);
        if(response!= -1){
            Item potion = c.getInv().getByItemName(inventoryMap.get(response).split(":")[0]);
            if(potion instanceof Potion){
                ((Potion) potion).consume(c);
                c.getInv().getInventory().remove(potion);
            }
            return true;
        }
        else{
            return false;
        }
    }

    // play the enemy's turn
    private void playEnemyTurn(Party p) {
        printEnemyScreen();
        for(Character c: p.getParty()){
            if(map.getEnemiesInRange(c).size()>=1 && !map.getEnemiesInRange(c).get(0).isFainted() ){
                attackHero(c,map.getEnemiesInRange(c).get(0));
            }
            else{
                performMove("s",c);
            }
        }
        printCurrentMap();

    }

    // print out the screen to indicate the enemy's turn
    public void printEnemyScreen(){
        System.out.println("   .\r\n  / \\\r\n  | |\r\n  | |\r\n  |.|                                         "+ Colors.getColors().coloredString("red","E N E M Y ' S   T U R N") +"\r\n  |.|\r\n  |:|\r\n  |:|\r\n`--8--'\r\n   8\r\n   O");
    }


    // prompt user to equip an item
    private boolean promptEquipItem(Hero c){
        HashMap<Integer, String> inventoryMap = new HashMap<>();
        int index = 1;
        for (Item item : c.getInv().getInventory()) {
            if(item instanceof Equippable) inventoryMap.put(index, item.toString());
            index++;
        }
        int response = UserPrompt.getPrompt().promptMenuOptionsQuittable(new Menu("Please choose an Equip to equip", inventoryMap, null, null), false);
        if(response != -1){
            Item equip = c.getInv().getByItemName(inventoryMap.get(response));
            if(equip instanceof Equippable){
                ((Equippable) equip).equip(c);
            }
            return true;
        }
        else{
            return false;
        }


    }

    // Print out the details of the party in question
    private void printParty(int index){
        System.out.println(parties.get(index).toString());
    }

    // Print out the controls for the user
    private String printControlMenu(UserPrompt prompter){
        Menu controlsMenu = this.menus.getMenu("MENU").getMenu("ControlMenu", null);
        return prompter.promptMenuOptionsKey(controlsMenu, false);
    }

    // Ask and set up a custom sized map
    private void setCustomMap(){
        UserPrompt prompter = UserPrompt.getPrompt();
        boolean setMapSize = prompter.promptYN("Would you like to set a map size? (Default is an " + DEFAULTMAPSIZE + "x" + DEFAULTMAPSIZE + " board!)");
        if(setMapSize){
            MapFactory mf = new MapFactory();
            map = mf.getMap(MAPTYPE, prompter.promptForIntWithPrompt("Please enter a map size: ", MINMAPSIZE,MAXMAPSIZE,false));
        }
    }

    // Set up initial party (maybe can add more parties later?)
    private void setUpInitialParty(UserPrompt prompter){
        parties.add(new Party());
        System.out.println(color.coloredString("red", "\t\t\t\t\t\t\t\t\t\t\t\t*   CHOOSE YOUR TEAM   *\n"));
        Menu characterMenu = this.menus.getMenu("MENU").getMenu("CreateHeroMenu", null);
        do{
            createHero(prompter, 0, characterMenu);
        }
        while(parties.get(0).getPartySize() < 3);
        System.out.println(parties.get(0));
        int[] initialPartyLocation = this.map.setRandomPartyLocation(parties.get(0),"Hero");
        parties.get(0).setPartyType("Hero");
    }

    private void setInitialMonsterParty(){
        parties.add(new Party());
        while(getParties().get(1).getPartySize()<3){
            createMonster(1);
        }
        this.map.setRandomPartyLocation(parties.get(1),"Monster");
        parties.get(1).setPartyType("Monster");
        System.out.println(parties.get(1));
    }
    private void spawnMonsters(){
        for(int i = 0; i < parties.size();i++){
            if(parties.get(i).getPartyType().equalsIgnoreCase("Monster")){
                for(int j = 0; j < 3; j++){
                    createMonster(i);

                }
                this.map.setRandomPartyLocation(parties.get(i),"Monster");
                printSpawnMonsterMessage();
            }
        }
    }

    private void printSpawnMonsterMessage(){
        System.out.println(Colors.getColors().coloredString("red", "New monsters have spawned"));
        printCurrentMap();
    }

    private void createMonster(int partyIndex){
        CharacterFactory factory = new CharacterFactory();
        CharacterAbstractFactory abstractFactory = factory.getCharacterAbstractFactory("monster");
        Level highestMonsterLevel = parties.get(0).getHighestLevel();
        HashMap<Integer, Character> enemiesToChooseFrom = generatePossibleEnemies(FileParser.getFileParser(), highestMonsterLevel);
        List<Integer> keys = new ArrayList<>(enemiesToChooseFrom.keySet());
        Random r = new Random();
        Character newEnemy = enemiesToChooseFrom.get(keys.get(r.nextInt(keys.size())));
        int newMonsterID = 1;
        for(Character c: parties.get(partyIndex).getParty()){
            if(c.getCharID() == newMonsterID){
                newMonsterID++;
            }
        }
        newEnemy.setCharID(newMonsterID);
        parties.get(partyIndex).addCharacter(newEnemy);
    }
    private HashMap<Integer, Character> generatePossibleEnemies(FileParser fp, Level highestMonsterLevel){
        CharacterFactory factory = new CharacterFactory();
        CharacterAbstractFactory abstractFactory = factory.getCharacterAbstractFactory("monster");
        HashMap<String, String[]> exoskeletons = fp.readMonstersAndHeroesHashNameToInfo( "Exoskeletons");
        exoskeletons.remove("Name");
        exoskeletons.remove("");
        HashMap<String, String[]> dragons = fp.readMonstersAndHeroesHashNameToInfo( "Dragons");
        dragons.remove("Name");
        dragons.remove("");
        HashMap<String, String[]> spirits = fp.readMonstersAndHeroesHashNameToInfo( "Spirits");
        spirits.remove("Name");
        spirits.remove("");

        int index = 1;
        HashMap<Integer, Character> possibleEnemies = new HashMap<>();
        for(String key: exoskeletons.keySet()){
            Character monsterGenerated = abstractFactory.getCharacter("Exoskeleton", key);
            if(monsterGenerated.getLevel().getLevel() <= highestMonsterLevel.getLevel()) {
                possibleEnemies.put(index, monsterGenerated);
                index++;
            }
        }
        for(String key: dragons.keySet()){
            Character monsterGenerated = abstractFactory.getCharacter("Dragon", key);
            if(monsterGenerated.getLevel().getLevel() <= highestMonsterLevel.getLevel()) {
                possibleEnemies.put(index, monsterGenerated);
                index++;

            }
        }
        for(String key: spirits.keySet()){
            Character monsterGenerated = abstractFactory.getCharacter("Spirit", key);
            if(monsterGenerated.getLevel().getLevel() <= highestMonsterLevel.getLevel())
            {
                possibleEnemies.put(index, monsterGenerated);
                index++;
            }
        }
        return possibleEnemies;
    }

    // Create a specific hero based on user input and possible heroes
    private void createHero(UserPrompt prompter, int partyIndex, Menu characterMenu){
        CharacterFactory factory = new CharacterFactory();
        CharacterAbstractFactory abstractFactory = factory.getCharacterAbstractFactory("hero");
        String currentHeroType = prompter.promptMenuOptionsValue(characterMenu, false);
        String characterInfo = choicesWithinClass(currentHeroType, FileParser.getFileParser(), prompter);
        Character toAdd = abstractFactory.getCharacter(currentHeroType,characterInfo);
        toAdd.setCharID(parties.get(partyIndex).getPartySize()+1);
        parties.get(partyIndex).addCharacter(toAdd);
    }

    // show and prompt for a certain hero within an archetype
    private String choicesWithinClass(String type, FileParser fp, UserPrompt prompter){
        Menu characterMenu = this.menus.getMenu("MENU").getMenu(type, null);
        int characterIndex = prompter.promptMenuOptions(characterMenu, false);
        String[] actualInfo = characterMenu.getOptions().get(characterIndex).split("\t\\|\t");
        String characterInfo = actualInfo[0];
        characterMenu.getOptions().remove(characterIndex);
        return characterInfo;
    }

    // print out the current state of the map
    private void printCurrentMap(){
        System.out.println(this.map);

    }

    // Perform a move on the map and trigger any events based on what tile the party enters
    private boolean performMove(String res, Character c){
        boolean moved = false;
        switch(res){
            case "W":
            case "w":
                moved = this.map.move(c,"w");
                break;
            case "A":
            case "a":
                moved = this.map.move(c,"a");
                break;
            case "S":
            case "s":
                moved = this.map.move(c,"s");
                break;
            case "D":
            case "d":
                moved = this.map.move(c,"d");
                break;
            case "B":
            case "b":
                moved = this.map.move(c,"b");
                break;
            case "T":
            case "t":
                moved = this.map.move(c,"t");

                break;
            default:
                break;
        }
        return moved;

    }

    // Print out instructions
    public void printInstructions(){
        System.out.println(color.coloredString("Light yellow","__________               .__         .___        _____       \r\n\\______   \\_____    _____|__| ____   |   | _____/ ____\\____  \r\n |    |  _/\\__  \\  /  ___/  |/ ___\\  |   |/    \\   __\\/  _ \\ \r\n |    |   \\ / __ \\_\\___ \\|  \\  \\___  |   |   |  \\  | (  <_> )\r\n |______  /(____  /____  >__|\\___  > |___|___|  /__|  \\____/ \r\n        \\/      \\/     \\/        \\/           \\/             "         ));
        System.out.println("Movement:\t" + color.coloredString("Light magenta", "W") + " - " + "move upwards" );
        System.out.println("\t\t\t" + color.coloredString("Light magenta", "A") + " - " + "move left" );
        System.out.println("\t\t\t" + color.coloredString("Light magenta", "S") + " - " + "move backwards" );
        System.out.println("\t\t\t" + color.coloredString("Light magenta", "D") + " - " + "move right" );
        System.out.println(color.coloredString("red", "NOTE:") + " diagonal movement is not possible!\n");
        System.out.println("You can have up to " + color.coloredString("blue","THREE") + " heroes for your adventure.");
        System.out.println("You will be prompted to buy/sell or fight whenever you come across events that require you to do so! Please type in something corresponding to the response at those times!");
        System.out.println("To " + color.coloredString("cyan", "QUIT") + " please type in q whenever you are to make a move! You will not be able to leave during a fight or in the market (unless if you force quit that is)\n");
        UserPrompt up = UserPrompt.getPrompt();
        up.promptString("Please type in any key to start the game!",false);
    }
}
