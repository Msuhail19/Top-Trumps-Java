/**
* This class extends the player class.
* Class represents Human Player.
* This class is used by player humans and contains methods for use with their turns.
* Contains methods that may overwrite player class methods for a human player.
* @author Suhail Munshi
* @version 1.0
*/
public class Human extends Player {
	private String humanName;

	/**
	* Class constructor defining this object.
	* @param game
	* @param name - String name of the human player
	*/
	public Human(Game game, String name) {
		//Constructor
		super(game, name);
		humanName = name;
	}

	/**
	 * This method overwrites method of same name in player class for Human players.
	 * Method prints human's top card and prompts user to take their turn by inputting index number corresponding to attribute.
	 * Method returns index number chosen by user
	 * @return int chosenIndex 
	 */
	protected int takeTurn() {
		//Choose Human Turn
		System.out.println("------------" + humanName + "'s CARD SKILLS------------");
		super.pickCard().printAll();
		// User Choose Attribute here
		int chosenIndex;
		System.out.println("Choose attribute to fight with : ");
		while (true) {
			String input = Main.Scan.next();
			try {
				chosenIndex = Integer.parseInt(input);
				if (chosenIndex < 4 && chosenIndex >= 0)
					break;
				else
					System.out.println("Enter a number within the range.");
			} catch (NumberFormatException e) {
				System.out.println("Not a number. Try again.");
			}
		}
		return chosenIndex;
	}

}