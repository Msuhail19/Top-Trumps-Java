import java.util.*;

/**
* This class contains all the necessary logic for a top trumps style game as described in the assignment brief.
* @author Suhail Munshi
* @version 1.0  - 09/11/17
*/

public class Game {
	//Initialise variables
	Random r = new Random();
	private ArrayList<Player> Players;
	protected int CardNumber = 5;
	protected int ComputerNumber = 3;
	protected int PlayerNumber = 1;
	protected int highestValue;
	protected int Round = 0;
	protected int order = 0;
	protected Player theChosenOne;
	protected Player winningPlayer;
	public int computerLevel;
	public int deckType;

	/**
	*Constructs and initialises a game with a number of human and 
	*computer players with a number of cards specified with input parameters.
	*@param PlayerNo number of human players
	*@param CompNo	number of Computer players
	*@param CardNo number of cards for each player
	*/
	public Game(int PlayerNo, int CompNo, int CardNo) {
		//Constructor to create the game
		Players = new ArrayList<Player>();
		CardNumber = CardNo;
		ComputerNumber = CompNo;
		PlayerNumber = PlayerNo;
		Round = 1;
		settings();
		createGame();
	}

	/**
	*This method determines what type of computer the user would like to play.
	*It also validates input for this to avoid errors.
	*/
	protected void settings() {
		while (true) {
			System.out.println("Select Computer Player Mode : ");
			System.out.println("[1]Predictable");
			System.out.println("[2]Random");
			System.out.println("[3]Smart");
			String input = Main.Scan.next();
			try {
				computerLevel = Integer.parseInt(input);
				if (computerLevel < 4 && computerLevel > 0)
					break;
			} catch (NumberFormatException e) {
				System.out.println("Not a number. Try again.");
			}
		}
		while (true) {
			System.out.println("Select Deck Type : ");
			System.out.println("[1]Fantasy");
			System.out.println("[2]Cars");
			System.out.println("[3]Footballers");
			System.out.println("[4]Celebrities");
			System.out.println("[5]Superheroes");
			String input = Main.Scan.next();
			try {
				deckType = Integer.parseInt(input); 
				if (deckType < 6 && deckType > 0)
					break;
				else 
					System.out.println("Error : Not within range. Retry entry.");
			} catch (NumberFormatException e) {
				System.out.println("Not a number. Try again.");
			}
		}
	}

	/**
	* Creates the game by using an initialised array list and adding a player.
	* This player can be human or computer.
	* Human and computer classes extend from player for easy access and definining.
	*/
	protected void createGame() {
		//Add the number of human players.
		for (int j = 0; j < PlayerNumber; j++) {
			System.out.println("Choose name for Human player " + (j + 1) + " : ");
			Players.add(new Human(this, Main.Scan.next()));
		}
		//Decide type of computer to use.
		//Add number of players.
		String computerType = "";
		switch (computerLevel) {
		case 1:
			for (int j = 0; j < ComputerNumber; j++) {
				Players.add(new Player(this, "Computer " + (j + 1)));
			}
			computerType = "Predictable";
			break;
		case 2:
			for (int j = 0; j < ComputerNumber; j++) {
				Players.add(new RandomComputer(this, "Computer " + (j + 1)));
			}
			computerType = "Random";
			break;
		case 3:
			for (int j = 0; j < ComputerNumber; j++) {
				Players.add(new SmartComputer(this, "Computer " + (j + 1)));
			}
			computerType = "Smart";
			break;
		}
		System.out.println("Computer type : " + computerType + " selected.");
		theChosenOne = Players.get(order);
	}

	/**
	* This is the method ran by the main in order to start gameplay.
	* This method calls other methods in order to simulate the game.
	*/
	protected void playRound() {
		if (Players.size() == 1) {
			endGame();
		} else {
			//Print number of cards for each player.
			for (Player player : Players) {
				System.out.println(player.Name + " has " + player.getCardSize() + " cards.");
			}
			//Chosen user takes turn.
			System.out.println("It is " + theChosenOne.Name + " 's turn");
			getWinningPlayer(theChosenOne.takeTurn());
			giveCards();
			playerNext();
		}
	}

	/**
	* Method ran to find winning player according to the game rules.
	* Upon finding a tie, the winner is randomized between the tieing players.
	* @param int x - index number of attribute chosen for comparison
	*/
	protected void getWinningPlayer(int x) {
		highestValue = theChosenOne.getAttribute(x).getValue();
		winningPlayer = theChosenOne;

		for (Player player : Players) {
			System.out.println("-------------" + player.Name + "--------------");
			System.out.println(player.getAttribute(x).printA());
			//decide if chosen one really is winner
			if (player.getAttribute(x).getValue() > highestValue) {
				winningPlayer = player;
				highestValue = player.getAttribute(x).getValue();
			}
		}
		//Check for ties
		ArrayList<Player> TiePlayers = new ArrayList<Player>();
		for(Player player : Players){
			if(player.getAttribute(x).getValue() == highestValue){
				TiePlayers.add(player);
			}
		}
		//If tie exists ---
		if(TiePlayers.size()>1){
			System.out.println("Tie detected. Randomizing winner...");
			winningPlayer = TiePlayers.get(r.nextInt(TiePlayers.size()));	
		}
		
		System.out.println("\n" + winningPlayer.Name + " is this rounds winner.");
	}

	/**
	* Method that selects the next player to have a turn.
	* Also checks if there is only a single player left at which point the game is ended.
	*/
	protected void playerNext() {
		toRemove();
		int noOfPlayers = Players.size() - 1;
		order++;
		if (noOfPlayers < order)
			order = 0;
		theChosenOne = Players.get(order);
		if (Players.size() == 1) {
			endGame();
		} else {
			playRound();
		}
	}

	/**
	* Removes any players with no cards left in deck.
	*/
	protected void toRemove() {
		ArrayList<Player> toRemove = new ArrayList<Player>();
		for (Player player : Players) {
			if (player.getCardSize() == 0) {
				System.out.println(player.Name + " has ran out of cards. They have been removed.");
				toRemove.add(player);
			}
		}
		Players.removeAll(toRemove);
	}

	/**
	* Method hands cards from top of deck to winning player
	*/
	protected void giveCards() {
		for (Player player : Players) {
			if (player != winningPlayer) {
				//hand over the top card.
				Card card = player.pickCard();
				winningPlayer.addCard(card);
				player.removeCard(card);
			}
			if (player == winningPlayer) {
				Card card = player.pickCard();
				player.removeCard(card);
				player.addCard(card);
			}
		}
	}

	/**
	* Method ends the game at the point only one player is left.
	*/
	protected void endGame() {
		System.out.println("---------------------------------------------");
		System.out.println(Players.get(0).Name + " is the winner of the Game!");
		System.out.println("---------------------------------------------");
	}

}