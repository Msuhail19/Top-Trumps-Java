import java.util.*;

/**
 * Class is for use with Computer type player.
 * Contains methods that decides logic for Smart Computer type player.
 * @author Suhail Munshi
 * @version 1.0
 */
public class SmartComputer extends Player {
	private Random r = new Random();
	private String name;

	/**
	 * Constructor for Computer class.
	 * @param Game game
	 * @param String name
	 */
	public SmartComputer(Game game, String Name) {
		//Constructor
		super(game, Name);
		name = Name;
	}

	/**
	 * Method returns integer index number after deciding highest corresponding attribute value.
	 * Index value will be between 0 and 3
	 * @return int - between 0 and 3.
	 */
	protected int chooseAttribute() {
		Card card = pickCard();

		int a = card.getAttribute(0).getValue();
		int b = card.getAttribute(1).getValue();
		int c = card.getAttribute(2).getValue();
		int d = card.getAttribute(3).getValue();

		//Selects largest attribute.
		//If two attributes are same size chooses largest one.
		if (a >= b && a >= c && a >= d)
			return 0;
		else if (b >= a && b >= c && b >= d)
			return 1;
		else if (c >= a && c >= b && c >= d)
			return 2;
		else if (d >= a && d >= b && d >= c)
			return 3;
		else
			return 0;

	}

	/**
	 * Method will be called by Game class. This method overwirites method of same name in Player class.
	 * Method returns integer value decided by chooseAttribute method.
	 * @return int chooseAttribute()
	 */
	protected int takeTurn() {
		//Computer's turn
		System.out.println("-----------------"+name+"-------------------");
		pickCard().printAll();
		return chooseAttribute();
	}

}