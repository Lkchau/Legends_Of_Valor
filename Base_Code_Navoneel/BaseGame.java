import java.util.Scanner;

/**
 * 
 * @author Navoneel
 *
 */

public abstract class BaseGame {
	
	public abstract void playGame(Scanner inputObj);
	public abstract boolean checkWinner();
	public abstract void continueGameSession(Scanner inputObj);
	public abstract void printGameSessionSummary();

}
