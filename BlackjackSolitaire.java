import java.util.ArrayList;
import java.util.Scanner;


/*   Play Pile
 *   1   2   3   4   5 
                            Discard Pile
	 6   7   8   9   10       17  18 

        11  12  13            19  20 

        14  15  16    
 * 
 */

public class BlackjackSolitaire {
	ArrayList<Integer> playedPositions = new ArrayList<Integer>();
	private int userInput;
	private int cardsPlaced = 0;
	private boolean userEnd = false;
	
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
			
			if (cardsPlaced == 0) {
				System.out.print("Enter a number between 1 and 20. Enter 17 to 20 to discard. Enter 0 to end game with finishing. You drew a "
						+ currentCard.getDisplayName() + ". " + "Enter your number: ");
			} else {
				System.out.print("You drew a " + currentCard.getDisplayName() + ". Enter your number: ");
			}

			userInput = getValidInt(userPrompt);

			if (userInput == 0) {
				userEnd = true;
			} else {
				board.placeCard(userInput, currentCard);
				playedPositions.add(userInput);
				
				if (userInput < 17) {
					cardsPlaced += 1;
				}
				
				System.out.println("\n");
				board.displayBoard();
			}
		}
		userPrompt.close();
		System.out.println("\n");
		System.out.println("The game will now calculate your score...");
		
		Score score = new Score(board.getBoard());
		score.calculateRowScores();
		score.calculateColScores();
		System.out.println("You received a score of " + score.getScore() + "!");
		System.out.println("The game has now ended. Thank you for playing!");
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
