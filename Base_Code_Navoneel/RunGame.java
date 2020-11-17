import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Navoneel
 *
 */

public class RunGame {

	public static void main(String[] args) {
		Scanner inputObj = new Scanner(System.in);
		LegendsMonstersAndHeroes legendsMonstersAndHeroes = new LegendsMonstersAndHeroes();
		legendsMonstersAndHeroes.initRpgGame(inputObj);
		//GameController.initGame(inputObj);
		inputObj.close();

	}

}
