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
			System.out.print("Insert Number between 1 to 20. You drew a " + currentCard.displayName + " ." + "Your Number: ");

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
		board.calculateRowScores();
		board.calculateColScores();
		System.out.println("You received a score of " + board.score);
	}

	public int getValidInt(Scanner userPrompt) {

		while (true) {
			if (userPrompt.hasNextInt()) {
				int userInput = userPrompt.nextInt();
				if (playedPositions.contains(userInput)) {
					System.out.println("Please choose different spot la");

				} else if (userInput < 0 || userInput > 20) {
					System.out.println("NUMBER BETWEEN 0 and 20");

				} else {
					return userInput;
				}

			} else {
				System.out.println("Number plx");
				userPrompt.next();
			}

		}

	}



}
