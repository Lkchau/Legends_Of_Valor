import java.util.Scanner;

/**
 * 
 * @author Navoneel
 *
 */

public abstract class RolePlayingGame extends BaseGame {
	
	public abstract void initRpgGame(Scanner inputObj);

	/**
	 * @category Override as necessary in the implementing game class.
	 * @param mapSize
	 */
	public abstract void initRpgMap(int mapSize);

}
