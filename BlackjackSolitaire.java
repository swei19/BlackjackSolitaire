import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackSolitaire {
	ArrayList<Integer> playedPositions = new ArrayList<Integer>();

	public void play() {

		int userInput;
		Card currentCard;
		
		int cardsPlaced = 0;
		
		boolean userEnd = false;

		Deck deck = new Deck();
		deck.initDeck();
		deck.shuffleDeck();

		Board board = new Board();
		board.displayBoard();

		Scanner userPrompt = new Scanner(System.in);

		while (cardsPlaced < 16 & !userEnd) {
			currentCard = deck.drawCard();
			System.out.print("Enter a number between 1 and 20. Enter 17 to 20 to discard. You drew a " + currentCard.displayName + " ." + "Your Number: ");

			userInput = getValidInt(userPrompt);

			if (userInput == 0) {
				userEnd = true;
			} else {
				board.placeCard(userInput, currentCard);
				playedPositions.add(userInput);
				if (userInput < 17) {
					cardsPlaced += 1;
				} 
				
				
				board.displayBoard();
			}

		}
		userPrompt.close();
		Score score = new Score(board.board);
		score.calculateRowScores();
		score.calculateColScores();
		System.out.println("You received a score of " + score.score);
	}

	public int getValidInt(Scanner userPrompt) {

		while (true) {
			if (userPrompt.hasNextInt()) {
				int userInput = userPrompt.nextInt();
				if (playedPositions.contains(userInput)) {
					System.out.println("The spot you chosen has already been occupied. Please choose another thats empty.");

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
