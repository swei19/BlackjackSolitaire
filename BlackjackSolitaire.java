import java.util.ArrayList;
import java.util.Scanner;

/**
 This class bring all the other classes together. 
 It is responsible for interacting with the user and based on this input, provide direction to the other
 classes. It also ensures that the user does not enter an invalid input. 
 
 Please refer to the BlackjackSolitaireRunner class to see which spots in the board 
 corresponds to which number.
 */

public class BlackjackSolitaire {

	ArrayList<Integer> playedPositions = new ArrayList<Integer>(); // Keep tracks of used spots in the board
	private int userInput;
	private int cardsPlaced = 0; // Keeps track of the number of cards placed (excluding discard pile)
	private boolean userEnd = false; // Provide an option to end the game prematurely

	public void play() {

		Card currentCard;

		Board board = new Board();
		board.displayBoard();

		Deck deck = new Deck();
		deck.initDeck();
		deck.shuffleDeck();

		Scanner userPrompt = new Scanner(System.in);

		while (cardsPlaced < 16 & !userEnd) {
			currentCard = deck.drawCard();

			if (cardsPlaced == 0) { // When the game begins, provide extra instructions.
				System.out.print("Enter a number between 1 and 20. Enter 17 to 20 to discard. "
						         + "Enter 0 to end game prematurely. You drew a "
								 + currentCard.getDisplayName() + ". " + "Enter your number: ");
			} else {
				System.out.print("You drew a " + currentCard.getDisplayName() + ". Enter your number: ");
			}

			userInput = getValidInt(userPrompt); // Ensures user input is valid

			if (userInput == 0) { // If player enters 0, the game ends prematurely.
				userEnd = true;
			} else {
				board.placeCard(userInput, currentCard);
				playedPositions.add(userInput);

				if (userInput < 17) {
					cardsPlaced += 1; // Cards above 17 corresponds to the discard pile and do not count here.
				}

				System.out.println("\n"); // Ensure nice separation from previous board displays.
				board.displayBoard();
			}
		}
		userPrompt.close();
		
		System.out.println("\n");
		System.out.println("The game will now calculate your score...");

		Score score = new Score(board.getBoard());
		score.calculateRowScores(); //
		score.calculateColScores();
		
		System.out.println("You received a score of " + score.getScore() + "!");
		System.out.println("The game has now ended. Thank you for playing!");
	}

	/**
	  The below method ensures three things: 
	  1. Ensures that the number the player chosen on the board is not already occupied. 
	  2. Ensures that the player plays a number between 0 and 20 
	  3. Ensures that the player enters an integer
	 */
	public int getValidInt(Scanner userPrompt) {

		while (true) {
			if (userPrompt.hasNextInt()) {
				int userInput = userPrompt.nextInt();
				if (playedPositions.contains(userInput)) {
					System.out.println(
							"The spot you chosen has already been occupied. Please choose another that's empty.");

				} else if (userInput < 0 || userInput > 20) {
					System.out.println("Please enter a number between 0 and 20.");

				} else {
					return userInput;
				}

			} else {
				System.out.println("You did not enter a valid number. Please enter a number between 0 and 20.");
				userPrompt.next();
			}

		}

	}

}
