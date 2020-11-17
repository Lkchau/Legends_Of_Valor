import java.util.Scanner;

public class GameController {
	
	public static void initGame(Scanner inputObj){
		boolean wrongGameChosen = true;
		int gameChoice = 0;
		
		System.out.println("----------------Welcome to Game 611---------------");
		System.out.println("Please choose a game :");
		System.out.println("1-> Legends : Monsters and Heroes");
		System.out.println("---------------------------------------------------");
		
		while(wrongGameChosen){
			try {
				System.out.println("");
				System.out.println("Enter your choice : ");
				gameChoice = inputObj.nextInt();
				switch (gameChoice) {
				case 1:
					wrongGameChosen = false;
					inputObj.nextLine();
					LegendsMonstersAndHeroes legendsMonstersAndHeroes = new LegendsMonstersAndHeroes();
					legendsMonstersAndHeroes.initRpgGame(inputObj);
					break;

				default:
					wrongGameChosen = true;
					System.out.println("Wrong Choice! Please enter a valid choice.");
				}
			} catch (Exception e) {
				inputObj.nextLine();
				System.out.println("Wrong Choice! Please enter a valid choice.");
			}
		}
	};

}
