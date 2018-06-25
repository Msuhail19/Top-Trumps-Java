
import java.util.*;

/**
 * Class in order to generate a card.
 */
public class Card {
	private Player p;
	private ArrayList<Attribute> Attributes;

	/**
	 * Constructor for use in class upon class initialisation.
	 * @param Player player
	 */
	public Card(Player player) {
		p = player;
		Attributes = new ArrayList<Attribute>();
	}

	/**
	 * Method to add an attribute to this card.
	 * @param Attribute
	 */
	protected void addAtribute(Attribute a) {
		Attributes.add(a);
	}

	/**
	 * This method returns an attribute using the index number provided.
	 * Null is returned if this index number is out of range
	 * @param int index
	 * @return Attribute
	 */
	protected Attribute getAttribute(int index) {
		try {
			return Attributes.get(index);
		} catch (Exception e) {
			System.out.println("Please enter a number that is on the list provided.");
			return null;
		}
	}

	/**
	 * This method prints out the attributes onto the screen for this card.
	 * This allows the player to choose an attribute to play with.
	 */
	protected void printAll() {
		for (int x = 0; x < Attributes.size(); x++) {
			Attribute selected = Attributes.get(x);
			System.out.println("[" + x + "]--" + selected.Name + " : " + selected.skillValue);
		}
		System.out.println(" ");
	}

}