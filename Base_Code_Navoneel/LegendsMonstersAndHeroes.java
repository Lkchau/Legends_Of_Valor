import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SplittableRandom;

/**
 * 
 * @author Navoneel
 *
 */

public class LegendsMonstersAndHeroes extends RolePlayingGame {
	private SplittableRandom random = new SplittableRandom();
	private boolean inputFlag = true;
	private int numberOfHero;
	private LegendsMap legendsMap;
	private LegendsMarket legendsMarket;
	private ArrayList<Paladin> availablePaladin;
	private ArrayList<Sorcerer> availableSorcerer;
	private ArrayList<Warrior> availableWarrior;
	private ArrayList<Dragon> dragons;
	private ArrayList<Exoskeleton> exoskeletons;
	private ArrayList<Spirit> spirits;
	private ArrayList<Monster> spawnedMonsters;
	private String playerInput;
	private Player player;

	@Override
	public void initRpgGame(Scanner inputObj){
		this.initRpgMap(8);
		this.initAvailableHeroes();
		this.initMonsters();
		this.initMarket();
		System.out.println("Enter gamer name of the player (can be alphanumeric) : ");
		String playerName = inputObj.nextLine();
		this.player = new Player(playerName);
		this.initChosenHeroes(inputObj);
		this.playGame(inputObj);

	}

	@Override
	public void playGame(Scanner inputObj) {
		this.legendsMap.drawLegendsMap();
		while(true){
			System.out.println("Where do you want to move - ");
			this.playerInput = inputObj.nextLine();

			switch(this.playerInput){
			case "w" : 
				this.moveUp(inputObj);
				break;
			case "W" : 
				this.moveUp(inputObj);
				break;
			case "s" :
				this.moveDown(inputObj);
				break;
			case "S" :
				this.moveDown(inputObj);
				break;
			case "a" :
				this.moveLeft(inputObj);
				break;
			case "A" :
				this.moveLeft(inputObj);
				break;
			case "d" :
				this.moveRight(inputObj);
				break;
			case "D" :
				this.moveRight(inputObj);
				break;
			case "p" :
				this.showPlayerStats();
				break;
			case "P" :
				this.showPlayerStats();
				break;
			case "i" :
				System.out.println("W/w : Up");
				System.out.println("S/s : Down");
				System.out.println("A/a : Left");
				System.out.println("D/d : Right");
				System.out.println("P/p : Player Info");
				System.out.println("Q/q : Quit");
				break;
			case "I" :	
				System.out.println("W/w : Up");
				System.out.println("S/s : Down");
				System.out.println("A/a : Left");
				System.out.println("D/d : Right");
				System.out.println("P/p : Player Info");
				System.out.println("Q/q : Quit");
				break;
			case "q" :
				System.out.println("Game closed");
				System.exit(0);
			case "Q" :
				System.out.println("Game closed");
				System.exit(0);
			default : 
				System.out.println("Invalid Input!");
			}
		}

	}

	@Override
	public boolean checkWinner() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void continueGameSession(Scanner inputObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printGameSessionSummary() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initRpgMap(int mapSize) {
		this.legendsMap = new LegendsMap(mapSize);

	}

	public void initMarket(){

		this.legendsMarket = new LegendsMarket(DatasetArmor.armorData(), DatasetWeapon.weaponData(), 
				DatasetSpell.fireSpellData(), DatasetSpell.iceSpellData(), DatasetSpell.lightningSpellData(), 
				DatasetPotion.potionData());

	}

	public void initAvailableHeroes(){
		availablePaladin = new ArrayList<Paladin>();
		availablePaladin.addAll(DatasetHero.paladinData());

		availableSorcerer = new ArrayList<Sorcerer>();
		availableSorcerer.addAll(DatasetHero.sorcererData());

		availableWarrior = new ArrayList<Warrior>();
		availableWarrior.addAll(DatasetHero.warriorData());
	}

	public void showAvailableHeroes(){
		System.out.println();
		System.out.println("| Available Heroes |");
		System.out.println("Paladins");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println("| ID |     Name     | Mana | Strength | Agility | Dexterity | Starting Money | Starting Experience |");
		System.out.println();
		for(Paladin tempPaladin : this.availablePaladin){
			System.out.println("| "+tempPaladin.getHeroId()+" | "
					+ tempPaladin.getName()+" | "
					+ tempPaladin.getMana()+" | "
					+ tempPaladin.getStrength()+" | "
					+ tempPaladin.getAgility()+" | "
					+ tempPaladin.getDexterity()+" | "
					+ tempPaladin.getMoney()+" | "
					+ tempPaladin.getXp()+" | ");
		}
		System.out.println("---------------------------------------------------------------------------------------------------------");

		System.out.println();
		System.out.println("Sorcerers");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println("| ID |     Name     | Mana | Strength | Agility | Dexterity | Starting Money | Starting Experience |");
		System.out.println();
		for(Sorcerer tempSorcerer : this.availableSorcerer){
			System.out.println("| "+tempSorcerer.getHeroId()+" | "
					+ tempSorcerer.getName()+" | "
					+ tempSorcerer.getMana()+" | "
					+ tempSorcerer.getStrength()+" | "
					+ tempSorcerer.getAgility()+" | "
					+ tempSorcerer.getDexterity()+" | "
					+ tempSorcerer.getMoney()+" | "
					+ tempSorcerer.getXp()+" | ");
		}
		System.out.println("---------------------------------------------------------------------------------------------------------");

		System.out.println();
		System.out.println("Warriors");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println("| ID |     Name     | Mana | Strength | Agility | Dexterity | Starting Money | Starting Experience |");
		System.out.println();
		for(Warrior tempWarrior : this.availableWarrior){
			System.out.println("| "+tempWarrior.getHeroId()+" | "
					+ tempWarrior.getName()+" | "
					+ tempWarrior.getMana()+" | "
					+ tempWarrior.getStrength()+" | "
					+ tempWarrior.getAgility()+" | "
					+ tempWarrior.getDexterity()+" | "
					+ tempWarrior.getMoney()+" | "
					+ tempWarrior.getXp()+" | ");
		}
		System.out.println("---------------------------------------------------------------------------------------------------------");

	}

	public void initChosenHeroes(Scanner inputObj){
		ArrayList<Hero> allAvailableHero = new ArrayList<Hero>();
		allAvailableHero.addAll(availablePaladin);
		allAvailableHero.addAll(availableSorcerer);
		allAvailableHero.addAll(availableWarrior);

		while(this.inputFlag){
			System.out.println("Enter the number of heroes to recruit(1, 2 or 3) : ");
			this.playerInput = inputObj.nextLine();
			switch(this.playerInput){
			case "1" : 
				this.numberOfHero = 1;
				this.inputFlag = false;
				break;
			case "2" : 
				this.numberOfHero = 2;
				this.inputFlag = false;
				break;
			case "3" : 
				this.numberOfHero = 3;
				this.inputFlag = false;
				break;
			default : 
				System.out.println("Invalid choice");
			}
		}
		this.showAvailableHeroes();
		int heroChoice;
		for(int i = 0; i<this.numberOfHero; i++){
			this.inputFlag = true;
			while(this.inputFlag){
				System.out.println("Choose hero ID to recruit hero(1 to 18) : ");
				try {
					boolean heroAdded = false;
					heroChoice = inputObj.nextInt();
					for(Hero hero : allAvailableHero){
						if(hero.getHeroId() == heroChoice){
							hero.setHeroId(i+1);
							this.player.addChosenHeroes(hero);
							this.inputFlag = false;
							heroAdded = true;
						}
					}
					if(!heroAdded){
						System.out.println("Hero with the input ID does not exist!");
					}
				} catch (Exception e) {
					inputObj.nextLine();
					System.out.println("Invalid input, please try again!");
				}
			}
		}
		inputObj.nextLine();
	}

	public void showPlayerStats(){
		System.out.println();
		System.out.println("Player Name : "+this.player.getName());
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("| ID |     Name     | HP | Mana | Strength | Agility | Dexterity | Money | Experience | Level |");
		System.out.println();
		for(Hero tempHero : this.player.getChosenHeroes()){
			System.out.println("| "+tempHero.getHeroId()+" | "
					+ tempHero.getName()+" | "
					+ tempHero.getHp()+" | "
					+ tempHero.getMana()+" | "
					+ tempHero.getStrength()+" | "
					+ tempHero.getAgility()+" | "
					+ tempHero.getDexterity()+" | "
					+ tempHero.getMoney()+" | "
					+ tempHero.getXp()+" | "
					+ tempHero.getLevel()+" | ");

		}
		System.out.println("-----------------------------------------------------------------------------------------------");
	}

	public void initMonsters(){
		dragons = new ArrayList<Dragon>();
		dragons.addAll(DatasetMonster.dragonData());

		exoskeletons = new ArrayList<Exoskeleton>();
		exoskeletons.addAll(DatasetMonster.exoskeletonData());

		spirits = new ArrayList<Spirit>();
		spirits.addAll(DatasetMonster.spiritData());
	}

	public void spawnMonster(Scanner inputObj){
		int spawnProbability = this.random.nextInt(0, 10);
		if(spawnProbability>=0 && spawnProbability<=2){
			System.out.println("This place seems safe");
		}
		else{
			System.out.println("Monsters have appeared!");
			int spawnType,spawnMonster;
			spawnedMonsters = new ArrayList<Monster>();
			for(int i = 0; i< this.numberOfHero; i++){
				spawnType = this.random.nextInt(0, 3);
				if(spawnType==0){
					spawnMonster = this.random.nextInt(0, this.dragons.size());
					spawnedMonsters.add(dragons.get(spawnMonster));
				}
				if(spawnType==1){
					spawnMonster = this.random.nextInt(0, this.exoskeletons.size());
					spawnedMonsters.add(exoskeletons.get(spawnMonster));
				}
				if(spawnType==2){
					spawnMonster = this.random.nextInt(0, this.spirits.size());
					spawnedMonsters.add(spirits.get(spawnMonster));
				}
			}
		}
		this.showSpawnedMonsters();
		this.fight(inputObj);
	}

	public void showSpawnedMonsters(){
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("|     Name     | HP | Damage | Defense | Dodge Change | Level |");
		System.out.println();
		for(Monster tempMonster : this.spawnedMonsters){
			System.out.println("| "+tempMonster.getName()+" | "
					+ tempMonster.getHp()+" | "
					+ tempMonster.getDamage()+" | "
					+ tempMonster.getDefense()+" | "
					+ tempMonster.getDodgeChance()+" | "
					+ tempMonster.getLevel()+" | ");

		}
		System.out.println("-----------------------------------------------------------------------------------------------");
	}

	public void moveUp(Scanner inputObj){
		String userInput;
		if((this.legendsMap.getHeroCellRow()-1)<0){
			System.out.println("Can not move outside map!");
			this.legendsMap.drawLegendsMap();
		}
		else if(this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()-1).get(this.legendsMap.getHeroCellColumn()).getSymbol().equals("X")){
			System.out.println("Path blocked!");
			this.legendsMap.drawLegendsMap();
		}
		else if(this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()-1).get(this.legendsMap.getHeroCellColumn()).getSymbol().equals("M")){
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(false);
			this.legendsMap.setHeroCellRow(this.legendsMap.getHeroCellRow()-1);
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(true);
			this.legendsMap.drawLegendsMap();
			System.out.println("There is a market in the area.");
			this.inputFlag = true;
			while(this.inputFlag){
				System.out.println("Wanna visit? (Y/N) : ");
				userInput = inputObj.nextLine();
				switch(userInput){
				case "Y" :
					for(int i = 0;i<this.numberOfHero;i++){
						this.visitMarket(inputObj,this.player.getChosenHeroes().get(i));
					}
					this.inputFlag = false;
				case "y" :
					for(int i = 0;i<this.numberOfHero;i++){
						this.visitMarket(inputObj,this.player.getChosenHeroes().get(i));
					}
					this.inputFlag = false;
				case "N" :
					this.inputFlag = false;
				case "n" :
					this.inputFlag = false;
				default : 
					System.out.println("Invalid Input!");
				}
			}
		}
		else{
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(false);
			this.legendsMap.setHeroCellRow(this.legendsMap.getHeroCellRow()-1);
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(true);
			this.legendsMap.drawLegendsMap();
			this.spawnMonster(inputObj);
		}

	}

	public void moveDown(Scanner inputObj){
		String userInput;
		if((this.legendsMap.getHeroCellRow()+1)>=this.legendsMap.getMapSize()){
			System.out.println("Can not move outside map!");
			this.legendsMap.drawLegendsMap();
		}
		else if(this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()+1).get(this.legendsMap.getHeroCellColumn()).getSymbol().equals("X")){
			System.out.println("Path blocked!");
			this.legendsMap.drawLegendsMap();
		}
		else if(this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()+1).get(this.legendsMap.getHeroCellColumn()).getSymbol().equals("M")){
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(false);
			this.legendsMap.setHeroCellRow(this.legendsMap.getHeroCellRow()+1);
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(true);
			this.legendsMap.drawLegendsMap();
			System.out.println("There is a market in the area.");
			this.inputFlag = true;
			while(this.inputFlag){
				System.out.println("Wanna visit? (Y/N) : ");
				userInput = inputObj.nextLine();
				switch(userInput){
				case "Y" :
					for(int i = 0;i<this.numberOfHero;i++){
						this.visitMarket(inputObj,this.player.getChosenHeroes().get(i));
					}
					this.inputFlag = false;
				case "y" :
					for(int i = 0;i<this.numberOfHero;i++){
						this.visitMarket(inputObj,this.player.getChosenHeroes().get(i));
					}
					this.inputFlag = false;
				case "N" :
					this.inputFlag = false;
				case "n" :
					this.inputFlag = false;
				default : 
					System.out.println("Invalid Input!");
				}
			}
		}
		else{
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(false);
			this.legendsMap.setHeroCellRow(this.legendsMap.getHeroCellRow()+1);
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(true);
			this.legendsMap.drawLegendsMap();
			this.spawnMonster(inputObj);
		}

	}

	public void moveLeft(Scanner inputObj){
		String userInput;
		if((this.legendsMap.getHeroCellColumn()-1)<0){
			System.out.println("Can not move outside map!");
			this.legendsMap.drawLegendsMap();
		}
		else if(this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()-1).getSymbol().equals("X")){
			System.out.println("Path blocked!");
			this.legendsMap.drawLegendsMap();
		}
		else if(this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()-1).getSymbol().equals("M")){
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(false);
			this.legendsMap.setHeroCellColumn(this.legendsMap.getHeroCellColumn()-1);
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(true);
			this.legendsMap.drawLegendsMap();
			System.out.println("There is a market in the area.");
			this.inputFlag = true;
			while(this.inputFlag){
				System.out.println("Wanna visit? (Y/N) : ");
				userInput = inputObj.nextLine();
				switch(userInput){
				case "Y" :
					for(int i = 0;i<this.numberOfHero;i++){
						this.visitMarket(inputObj,this.player.getChosenHeroes().get(i));
					}
					this.inputFlag = false;
				case "y" :
					for(int i = 0;i<this.numberOfHero;i++){
						this.visitMarket(inputObj,this.player.getChosenHeroes().get(i));
					}
					this.inputFlag = false;
				case "N" :
					this.inputFlag = false;
				case "n" :
					this.inputFlag = false;
				default : 
					System.out.println("Invalid Input!");
				}
			}
		}
		else{
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(false);
			this.legendsMap.setHeroCellColumn(this.legendsMap.getHeroCellColumn()-1);
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(true);
			this.legendsMap.drawLegendsMap();
			this.spawnMonster(inputObj);
		}

	}

	public void moveRight(Scanner inputObj){
		String userInput;
		if((this.legendsMap.getHeroCellColumn()+1)>=this.legendsMap.getMapSize()){
			System.out.println("Can not move outside map!");
			this.legendsMap.drawLegendsMap();
		}
		else if(this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()+1).getSymbol().equals("X")){
			System.out.println("Path blocked!");
			this.legendsMap.drawLegendsMap();
		}
		else if(this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()+1).getSymbol().equals("M")){
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(false);
			this.legendsMap.setHeroCellColumn(this.legendsMap.getHeroCellColumn()+1);
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(true);
			this.legendsMap.drawLegendsMap();
			System.out.println("There is a market in the area.");
			this.inputFlag = true;
			while(this.inputFlag){
				System.out.println("Wanna visit? (Y/N) : ");
				userInput = inputObj.nextLine();
				switch(userInput){
				case "Y" :
					for(int i = 0;i<this.numberOfHero;i++){
						this.visitMarket(inputObj,this.player.getChosenHeroes().get(i));
					}
					this.inputFlag = false;
				case "y" :
					for(int i = 0;i<this.numberOfHero;i++){
						this.visitMarket(inputObj,this.player.getChosenHeroes().get(i));
					}
					this.inputFlag = false;
				case "N" :
					this.inputFlag = false;
				case "n" :
					this.inputFlag = false;
				default : 
					System.out.println("Invalid Input!");
				}
			}
		}
		else{
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(false);
			this.legendsMap.setHeroCellColumn(this.legendsMap.getHeroCellColumn()+1);
			this.legendsMap.getCellList().get(this.legendsMap.getHeroCellRow()).get(this.legendsMap.getHeroCellColumn()).setHeroCell(true);
			this.legendsMap.drawLegendsMap();
			this.spawnMonster(inputObj);
		}

	}

	public void visitMarket(Scanner inputObj, Hero hero){
		String userInput;
		System.out.println("Hello, "+hero.getName());
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("Welcome to Legends Market");
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("1. Buy");
		System.out.println("2. Sell");
		System.out.println("3. Close Market");
		System.out.println("4. Go to Main Menu");
		this.inputFlag = true;
		while(this.inputFlag){
			System.out.println("Choose option : ");
			userInput = inputObj.nextLine();
			switch(userInput){
			case "1" : 
				System.out.println("What do you want to buy?");
				System.out.println("1. Armor");
				System.out.println("2. Weapon");
				System.out.println("3. Spell");
				System.out.println("4. Potion");
				System.out.println("5. Close Market");
				System.out.println("6. Go to Main Menu");

				while(this.inputFlag){
					System.out.println("Enter choice : ");
					userInput = inputObj.nextLine();
					switch(userInput){
					case "1" : 
						this.showArmors(this.legendsMarket.getArmors());
						int armorChoice;
						while(this.inputFlag){
							System.out.println("Choose armor ID : ");
							try {
								boolean armorAdded = false;
								armorChoice = inputObj.nextInt();
								for(Armor armor : this.legendsMarket.getArmors()){
									if(armor.getArmorID() == armorChoice){
										if(armor.getCost()<=hero.getMoney() && armor.getLevel()<=hero.getLevel()){
											hero.getArmors().add(armor);
											hero.setMoney(hero.getMoney()-armor.getCost());
											hero.getArmors().get(hero.getArmors().size()-1).setArmorID(hero.getArmors().size());
											if(hero.getEquippedArmor().equals(null)){
												hero.setEquippedArmor(armor);
												hero.setDefense(hero.getEquippedArmor().getDefense());
											}
											this.inputFlag = false;
											armorAdded = true;
										}
										else{
											System.out.println("Can not buy this armor");
											this.visitMarket(inputObj, hero);
											this.inputFlag = false;
											break;
										}
									}
								}
								if(!armorAdded){
									System.out.println("Armor with the input ID does not exist!");
								}
							} catch (Exception e) {
								inputObj.nextLine();
								System.out.println("Invalid input, please try again!");
							}
						}
						inputObj.nextLine();
						inputFlag = false;
						break;

					case "2" : 
						this.showWeapons(this.legendsMarket.getWeapons());
						int weaponChoice;
						while(this.inputFlag){
							System.out.println("Choose weapon ID : ");
							try {
								boolean armorAdded = false;
								weaponChoice = inputObj.nextInt();
								for(Weapon weapon : this.legendsMarket.getWeapons()){
									if(weapon.getWeaponID() == weaponChoice){
										if(weapon.getCost()<=hero.getMoney() && weapon.getLevel()<=hero.getLevel()){
											hero.getWeapons().add(weapon);
											hero.setMoney(hero.getMoney()-weapon.getCost());
											hero.getWeapons().get(hero.getWeapons().size()-1).setWeaponID(hero.getWeapons().size());
											if(hero.getEquippedWeapon().equals(null)){
												hero.setEquippedWeapon(weapon);
											}
											this.inputFlag = false;
											armorAdded = true;
										}
										else{
											System.out.println("Can not buy this weapon");
											this.visitMarket(inputObj, hero);
											this.inputFlag = false;
											break;
										}
									}
								}
								if(!armorAdded){
									System.out.println("Weapon with the input ID does not exist!");
								}
							} catch (Exception e) {
								inputObj.nextLine();
								System.out.println("Invalid input, please try again!");
							}
						}
						inputObj.nextLine();
						inputFlag = false;
						break;
					case "3" : 
						this.showSpells(this.legendsMarket.getFireSpells());
						this.showSpells(this.legendsMarket.getIceSpells());
						this.showSpells(this.legendsMarket.getLightningSpells());
						ArrayList<Spell> allSpell = new ArrayList<Spell>();
						allSpell.addAll(this.legendsMarket.getFireSpells());
						allSpell.addAll(this.legendsMarket.getIceSpells());
						allSpell.addAll(this.legendsMarket.getLightningSpells());
						int spellChoice;
						while(this.inputFlag){
							System.out.println("Choose spell ID : ");
							try {
								boolean armorAdded = false;
								spellChoice = inputObj.nextInt();
								for(Spell spell : allSpell){
									if(spell.getSpellID() == spellChoice){

										hero.setSpell(spell);;
										hero.setMoney(hero.getMoney()-spell.getCost());

										this.inputFlag = false;
										armorAdded = true;
									}
									else{
										System.out.println("Can not buy this spell");
										this.visitMarket(inputObj, hero);
										this.inputFlag = false;
										break;
									}
								}
							if(!armorAdded){
								System.out.println("spell with the input ID does not exist!");
							}
						} catch (Exception e) {
							inputObj.nextLine();
							System.out.println("Invalid input, please try again!");
						}
					}
					inputObj.nextLine();
					inputFlag = false;
					break;
				case "4" : 
					this.showPotions(this.legendsMarket.getPotions());
					int potionChoice;
					while(this.inputFlag){
						System.out.println("Choose potion ID : ");
						try {
							boolean armorAdded = false;
							potionChoice = inputObj.nextInt();
							for(Potion potion : this.legendsMarket.getPotions()){
								if(potion.getPotionID() == potionChoice){

									hero.setPotion(potion);
									hero.setMoney(hero.getMoney()-potion.getCost());

									this.inputFlag = false;
									armorAdded = true;
								}
								else{
									System.out.println("Can not buy this potion");
									this.visitMarket(inputObj, hero);
									this.inputFlag = false;
									break;
								}
							}

							if(!armorAdded){
								System.out.println("Potion with the input ID does not exist!");
							}
						} catch (Exception e) {
							inputObj.nextLine();
							System.out.println("Invalid input, please try again!");
						}
					}
					inputObj.nextLine();
					inputFlag = false;
					break;
				case "5" : 
					this.inputFlag = false;
					break;
				case "6" : 
					this.visitMarket(inputObj, hero);
					this.inputFlag = false;
					break;
				default : 
					System.out.println("Invalid Choice!");
				}
			}
			this.inputFlag = false;
			break;
		case "2" : 
			System.out.println("What do you want to sell?");
			this.inputFlag = false;
			break;
		case "3" : 
			this.inputFlag = false;
			break;
		case "4" : 
			this.visitMarket(inputObj, hero);
			this.inputFlag = false;
			break;
		default : 
			System.out.println("Invalid Choice!");
		}
	}

}

public void showArmors(ArrayList<Armor> armors){
	System.out.println();
	System.out.println("------------------------------------------------------------------------------------------");
	System.out.println("| ID |     Name     | Cost | Level | Defense |");
	System.out.println();
	for(Armor tempArmor : armors){
		System.out.println("| "+tempArmor.getArmorID() +" | "
				+ tempArmor.getName()+" | "
				+ tempArmor.getCost()+" | "
				+ tempArmor.getLevel()+" | "
				+ tempArmor.getDefense()+" | ");

	}
	System.out.println("-----------------------------------------------------------------------------------------------");
}

public void showWeapons(ArrayList<Weapon> weapons){
	System.out.println();
	System.out.println("------------------------------------------------------------------------------------------");
	System.out.println("| ID |     Name     | Cost | Level | Damage | Hands |");
	System.out.println();
	for(Weapon tempWeapon : weapons){
		System.out.println("| "+tempWeapon.getWeaponID()+" | "
				+ tempWeapon.getName()+" | "
				+ tempWeapon.getCost()+" | "
				+ tempWeapon.getLevel()+" | "
				+ tempWeapon.getDamage()+" | "
				+ tempWeapon.getHands()+" | ");

	}
	System.out.println("-----------------------------------------------------------------------------------------------");
}

public void showPotions(ArrayList<Potion> potions){
	System.out.println();
	System.out.println("------------------------------------------------------------------------------------------");
	System.out.println("| ID |     Name     | Cost | Level | HP | Mana | Agility | Dexterity | Strength | Defense |");
	System.out.println();
	for(Potion tempPotion : potions){
		System.out.println("| "+tempPotion.getPotionID()+" | "
				+ tempPotion.getName()+" | "
				+ tempPotion.getCost()+" | "
				+ tempPotion.getLevel()+" | "
				+ tempPotion.getHp()+" | "
				+ tempPotion.getMana()+" | "
				+ tempPotion.getAgility()+" | "
				+ tempPotion.getDexterity()+" | "
				+ tempPotion.getStrength()+" | "
				+ tempPotion.getDefense()+" | ");

	}
	System.out.println("-----------------------------------------------------------------------------------------------");
}

public void showSpells(ArrayList<Spell> spells){
	System.out.println();
	System.out.println("------------------------------------------------------------------------------------------");
	System.out.println("| ID |     Name     | Cost | Level | Damage | Mana Cost |");
	System.out.println();
	for(Spell tempSpell : spells){
		System.out.println("| "+tempSpell.getSpellID()+" | "
				+ tempSpell.getName()+" | "
				+ tempSpell.getCost()+" | "
				+ tempSpell.getLevel()+" | "
				+ tempSpell.getDamage()+" | "
				+ tempSpell.getManaCost()+" | ");

	}
	System.out.println("-----------------------------------------------------------------------------------------------");
}

public void fight(Scanner inputObj){
	Hero activeHero;
	Monster activeMonster;
	int totalMonsterLevel = 0;
	for(Monster tempMonster : this.spawnedMonsters){
		totalMonsterLevel += tempMonster.getLevel();
	}
	boolean heroALive = true, monsterAlive = true;
	while(heroALive && monsterAlive){
		for(int i = 0; i<this.numberOfHero; i++){
			activeHero = null;
			activeMonster = null;
			for(int j=i; j<this.numberOfHero; j++){
				if(this.player.getChosenHeroes().get(j).getHp()>0){
					activeHero = this.player.getChosenHeroes().get(j);
					break;
				}
			}
			for(int j=i; j<this.numberOfHero; j++){
				if(this.spawnedMonsters.get(j).getHp()>0){
					activeMonster = this.spawnedMonsters.get(j);
					break;
				}
			}
			if(activeHero.equals(null) || activeHero == null){
				System.out.println("Oh no! All your heroes have fainted! You need to restart your adventure!");
				System.exit(0);
			}
			if(activeMonster.equals(null) || activeMonster == null){
				System.out.println("Awesome! You have defeated all monsters in this area. Move ahead!");
				for(int x=0; x<this.numberOfHero; x++){
					if(this.player.getChosenHeroes().get(x).getHp() == 0.0){
						this.player.getChosenHeroes().get(x).setHp(this.player.getChosenHeroes().get(x).getLevel()*50);
						this.player.getChosenHeroes().get(x).heroLevelUp();
					}
					else{
						this.player.getChosenHeroes().get(x).setXp(this.player.getChosenHeroes().get(x).getXp()+2);
						this.player.getChosenHeroes().get(x).setMoney(this.player.getChosenHeroes().get(x).getMoney()+(100*totalMonsterLevel));
						this.player.getChosenHeroes().get(x).heroLevelUp();
					}
				}
				this.playGame(inputObj);
			}

			this.heroRoundOption(activeHero, activeMonster,inputObj);
			this.monsterAttck(activeHero, activeMonster);
		}
	}
}

public void heroRoundOption(Hero activeHero, Monster activeMonster, Scanner inputObj){
	String userInput;
	System.out.println();
	System.out.println("Choose an option : ");
	System.out.println("1. Regular Attack");
	System.out.println("2. Spell Attack");
	System.out.println("3. Use Potion");
	System.out.println("4. Change Armor/Weapon");
	this.inputFlag = true;
	while(this.inputFlag){
		System.out.println("Player Input : ");
		userInput = inputObj.nextLine();
		switch(userInput){
		case "1" :
			this.heroRegularAttack(activeHero, activeMonster);
			this.inputFlag = false;
			break;
		case "2" :
			if(activeHero.getSpell().equals(null) || activeHero.getSpell() == null){
				System.out.println("Hero does not own a spell!");
			}
			else{
				this.heroCastSpell(activeHero, activeMonster);
				this.inputFlag = false;
				break;
			}
		case "3" :
			if(activeHero.getPotion().equals(null) || activeHero.getPotion() == null){
				System.out.println("Hero does not own a potion!");
			}
			else{
				this.heroUsePotion(activeHero);
				this.inputFlag = false;
				break;
			}
		case "4" :
			this.heroChangeEquipment(activeHero, inputObj);
			this.inputFlag = false;
			break;
		default :
			System.out.println("Invalid Input");
		}
	}
}

public void heroRegularAttack(Hero activeHero, Monster activeMonster){
	double damageToMonster;
	int monsterDodge = this.random.nextInt(0, 100);
	if(monsterDodge<activeMonster.getDodgeChance()){
		System.out.println(" Monster "+activeMonster.getName()+"dodged attack from Hero "+activeHero.getName());
	}
	else{
		if(activeHero.getEquippedWeapon().equals(null) || activeHero.getEquippedWeapon() == null){
			damageToMonster = (activeHero.getStrength()-activeMonster.getDefense())*0.05;
		}
		else{
			damageToMonster = (activeHero.getStrength()+activeHero.getEquippedWeapon().getDamage()-activeMonster.getDefense())*0.05;
		}
		if((activeMonster.getHp()-damageToMonster)<0){
			activeMonster.setHp(0);
			System.out.println("Monster "+activeMonster.getName()+" has died!");
		}
		else{
			activeMonster.setHp(activeMonster.getHp()-damageToMonster);
			System.out.println("Hero "+activeHero.getName()+" dealt "+damageToMonster+" damage to Monster "+activeMonster.getName());
		}
	}

}

public void heroCastSpell(Hero activeHero, Monster activeMonster){
	double damageToMonster = 0;
	int monsterDodge = this.random.nextInt(0, 100);
	if(monsterDodge<activeMonster.getDodgeChance()){
		System.out.println(" Monster "+activeMonster.getName()+"dodged attack from Hero "+activeHero.getName());
		activeHero.setMana(activeHero.getMana()-activeHero.getSpell().getManaCost());
	}
	else{
		damageToMonster = (activeHero.getSpell().getDamage()+((activeHero.getDexterity()/10000)*activeHero.getSpell().getDamage()));
		if((activeMonster.getHp()-damageToMonster)<0){
			activeMonster.setHp(0);
			System.out.println("Monster "+activeMonster.getName()+" has died!");
		}
		else{
			activeMonster.setHp(activeMonster.getHp()-damageToMonster);
			activeHero.getSpell().specialEffect(activeMonster);
			System.out.println("Hero "+activeHero.getName()+" dealt "+damageToMonster+" damage to Monster "+activeMonster.getName()+" using Spell "+activeHero.getSpell().getName());
		}
	}
}

public void heroUsePotion(Hero activeHero){
	activeHero.setHp(activeHero.getHp()+activeHero.getPotion().getHp());
	activeHero.setMana(activeHero.getMana()+activeHero.getPotion().getMana());
	activeHero.setAgility(activeHero.getAgility()+activeHero.getPotion().getAgility());
	activeHero.setDexterity(activeHero.getDexterity()+activeHero.getPotion().getDexterity());
	activeHero.setStrength(activeHero.getStrength()+activeHero.getPotion().getStrength());
	activeHero.setDefense(activeHero.getDefense()+activeHero.getPotion().getDefense());
	activeHero.setPotion(null);
}

public void heroChangeEquipment(Hero activeHero, Scanner inputObj){
	String userInput;
	boolean inputFlag = true;
	System.out.println();
	System.out.println("What do you want to change(1 or 2)?");
	System.out.println("1). Armor");
	System.out.println("2). Weapon");

	while(inputFlag){
		System.out.println("Player Input : ");
		userInput = inputObj.nextLine();
		switch(userInput){
		case "1" :
			this.showArmors(activeHero.getArmors());
			int armorChoice;
			while(this.inputFlag){
				System.out.println("Choose new armor ID : ");
				try {
					boolean armorAdded = false;
					armorChoice = inputObj.nextInt();
					for(Armor armor : activeHero.getArmors()){
						if(armor.getArmorID() == armorChoice){
							activeHero.setEquippedArmor(armor);
							activeHero.setDefense(activeHero.getEquippedArmor().getDefense());
							this.inputFlag = false;
							armorAdded = true;
						}
					}
					if(!armorAdded){
						System.out.println("Armor with the input ID does not exist!");
					}
				} catch (Exception e) {
					inputObj.nextLine();
					System.out.println("Invalid input, please try again!");
				}
			}
			inputObj.nextLine();
			inputFlag = false;
			break;
		case "2" :
			this.showWeapons(activeHero.getWeapons());
			int weaponChoice;
			while(this.inputFlag){
				System.out.println("Choose new weapon ID : ");
				try {
					boolean weaponAdded = false;
					weaponChoice = inputObj.nextInt();
					for(Weapon weapon : activeHero.getWeapons()){
						if(weapon.getWeaponID() == weaponChoice){
							activeHero.setEquippedWeapon(weapon);
							this.inputFlag = false;
							weaponAdded = true;
						}
					}
					if(!weaponAdded){
						System.out.println("Weapon with the input ID does not exist!");
					}
				} catch (Exception e) {
					inputObj.nextLine();
					System.out.println("Invalid input, please try again!");
				}
			}
			inputObj.nextLine();
			inputFlag = false;
			break;
		default:
			System.out.println("Invalid Input");
		}
	}
}

public void monsterAttck(Hero activeHero, Monster activeMonster){
	double damageToHero = 0;
	int heroDodge = this.random.nextInt(0, 2000);
	if(heroDodge<activeHero.getAgility()){
		System.out.println(" Hero "+activeHero.getName()+"dodged attack from Monster "+activeMonster.getName());
	}
	else{
		damageToHero = activeMonster.getDamage()-activeHero.getDefense();
		if((activeHero.getHp()-damageToHero)<0){
			activeHero.setHp(0);
			System.out.println("Monster "+activeMonster.getName()+" dealt "+damageToHero+" damage to Hero "+activeHero.getName());
			System.out.println("Hero "+activeHero.getName()+" has fainted! ");
		}
		else{
			activeHero.setHp(activeHero.getHp()-damageToHero);
			System.out.println("Monster "+activeMonster.getName()+" dealt "+damageToHero+" damage to Hero "+activeHero.getName());
		}
	}

}

}
