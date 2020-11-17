import java.util.ArrayList;

public class Player {
	
	private String name;
	private ArrayList<Hero> chosenHeroes;
	
	Player(){
		
	}
	
	Player(String name){
		this.name = name;
		this.chosenHeroes = new ArrayList<Hero>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the chosenHeroes
	 */
	public ArrayList<Hero> getChosenHeroes() {
		return chosenHeroes;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param chosenHeroes the chosenHeroes to set
	 */
	public void setChosenHeroes(ArrayList<Hero> chosenHeroes) {
		this.chosenHeroes = chosenHeroes;
	}
	
	public void addChosenHeroes(Hero chosenHero) {
		this.chosenHeroes.add(chosenHero);
	}

}
