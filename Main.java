import java.util.Scanner;

/**
 * Main class intitailises Game and uses user input to choose type of game.
 * @author Suhail Munshi
 * @author ID : 201231965
 * @version 1.0
 */
public class Main {

	public static Scanner Scan = new Scanner(System.in);
	protected static int a, b, c;

	/**
	 * Main method.
	 * Calls methods to decide settings for the game which the main method calls a method to initialise.
	 */
	public static void main(String[] args) {

		howManyCards();
		howManyComputers();
		howManyPlayers();
		Game game = new Game(a, b, c);
		game.playRound();
	}

	/**
	* Method howManyPlayers prompts and verifies user input in order to retrieve number of human players.
	*/
	static void howManyPlayers() {
		while (true) {
			System.out.println("How many Human Players are there? Enter a number between 1 and 9");
			String input = Scan.next();
			try {
				a = Integer.parseInt(input);
				if (a > 0 && a < 10)
					break;
				else {
					System.out.println("Error : Number outside of range.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Not a number. Try again.");
			}
		}
	}

	/**
	 * Method howManyComputer prompts and verifies user input in order to retrieve number of computer players
	 */
	static void howManyComputers() {
		while (true) {
			System.out.println("How many Computer Players are there? Enter a number between 0 and 9.");
			String input = Scan.next();
			try {
				b = Integer.parseInt(input);
				if (b >= 0 && b < 10) {
					break;
				} else {
					System.out.println("Error : Number outside of range.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Not a number. Try again.");
			}
		}
	}

	/**
	 * Method howManyCards prompts and verifies user input in order to retrieve number of computer players
	 */
	static void howManyCards() {

		while (true) {
			System.out.println("How many Cards per player? Enter a number between 1 and 9.");
			String input = Scan.next();
			try {
				c = Integer.parseInt(input);
				if (c > 0 && c < 10) {
					break;
				} else {
					System.out.println("Error : Number outside of range.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Not a number. Try again.");
			}
		}

	}

}