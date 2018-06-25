import java.util.*;

/**
* Class intialises and creates an object of type player.
* @author Suhail Munshi
* @version 1.0
*/
public class Player {
	//
	// Insert objects for use in class
	//
	protected String Name;
	protected int CardNo;
	protected Game game;
	protected Queue<Card> Deck;
	public int indexNo = 0;
	protected String Attribute1;
	protected String Attribute2;
	protected String Attribute3;
	protected String Attribute4;
	public Random r = new Random();

	/**
	 * Class constructor to initialise variables for use in class.
	 * @param Game g - Game object
	 * @param String name - Name of player
	 */
	public Player(Game g, String name) {
		//Constructor for Player Class
		game = g;
		CardNo = g.CardNumber;
		Name = name;
		Deck = new LinkedList<Card>();
		Initialise();
	}

	/**
	 * Allows human or computer to take their turn. Overwritten in extended classes (Human,Computer and Random Computer Classes).
	 * Returns 0 if player is predictable computer - Thereby having them choose the first attribute.
	 * @return int index
	 */
	 protected int takeTurn() {
		System.out.println("------------" + Name + "'s CARD SKILLS------------");
		pickCard().printAll();
		return 0;
	}
	
	/**
	 * This method intialises the players individual deck usings the number of Cards intialised in the constructor.
	 * Initialise method adds attributes with randomised values to each card, then adds each card to the queue Deck.
	 * <p>
	 * This method also changes the attribute names based on the selection of the user in one of the game methods.
	 */
	private void Initialise() {
		switch (game.deckType) {
			case 1:
				Attribute1 = "Melee";
				Attribute2 = "Ranged";
				Attribute3 = "Magicka";
				Attribute4 = "Luck";
				break;
			case 2:
				Attribute1 = "Affordability";
				Attribute2 = "Horsepower";
				Attribute3 = "Style";
				Attribute4 = "Comfort";
				break;
			case 3:
				Attribute1 = "Shooting";
				Attribute2 = "Speed";
				Attribute3 = "Defense";
				Attribute4 = "Dribbling";
				break;
			case 4:
				Attribute1 = "Fame";
				Attribute2 = "Wealth";
				Attribute3 = "Influence";
				Attribute4 = "Acting";
				break;
			case 5:
				Attribute1 = "Efficiency";
				Attribute2 = "Special Abilities";
				Attribute3 = "Resources";
				Attribute4 = "Intelligence";
				break;	
		}
	
		for (int i = 0; i < CardNo; i++) {
			Card card = new Card(this);

			card.addAtribute(new Attribute(Attribute1, gRandom()));
			card.addAtribute(new Attribute(Attribute2, gRandom()));
			card.addAtribute(new Attribute(Attribute3, gRandom()));
			card.addAtribute(new Attribute(Attribute4, gRandom()));
			addCard(card);
		}
	}
	
	/**
	 * Takes parameter index and returns attribute corresponding to that index.
	 * This attribute is taken from the top card. Returns null if player has no Deck left.
	 * @param int index
	 * @return Attribute - or null
	 */
	protected Attribute getAttribute(int index) {
		if (Deck.peek() != null) {
			return Deck.peek().getAttribute(index);
		} else {
			return null;
		}
	}

	/**
	 * Returns random value of size between 0 and 9.
	 * @return int value
	 */
	protected int gRandom(){
		int value = r.nextInt(10);
		return value;
	}

	/**
	 * Return number of Cards left in a players' deck as integer
	 * @return int Deck.size()
	*/
	protected int getCardSize() {
		return Deck.size();
	}

	/**
	 * Returns card at front of Queue Deck without removing from deck (Queue Deck) for a given player.
	 * @return Card Deck.peek()
	 */
	protected Card pickCard() {
		return Deck.peek();
	}

	/**
	 * Method to remove card from (deck) queue Deck
	 * @param Card card
	 */
	protected void removeCard(Card card) {
		Deck.remove(card);
	}

	/**
	 * Method to add card to end of (deck) queue Deck
	 * @param Card card
	 */
	protected void addCard(Card card) {
		Deck.add(card);
	}
	
	
	
}
