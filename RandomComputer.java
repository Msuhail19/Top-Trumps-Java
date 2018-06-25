import java.util.*;
/**
 * Class contains methods that overwrite Player taketurn methods.
 * Class is used for Random computer upon being choosen by user.
 * Represents Random computer
 * @author Suhail Munshi
 * @version 1.0
 */
public class RandomComputer extends Player{
	private Random r = new Random();
	private String CoName;

	/**
	 * Constructor for RandomComputer class.
	 * @param Game game - Game object
	 * @param String name - Computer name
	 */
	public RandomComputer(Game game,String name){
		//Constructor
		super(game,name);
		CoName = name;
	}
	
	/**
	 * Method overwrites takeTurn methos in Player class for RandomComputer players. 
	 * Prints computer's card.
	 * Returns random integer between 0 and 3.
	 * @return int r.nextInt(4) - random integer.
	 */
	protected int takeTurn(){
		//Computer's turn
		System.out.println("It is " + CoName +"'s turn");
		System.out.println("------------"+Name+"'s CARD SKILLS------------");
		pickCard().printAll();
		return r.nextInt(4);
	}
	
}