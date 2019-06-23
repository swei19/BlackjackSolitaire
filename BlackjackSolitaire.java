import java.util.Scanner;

public class BlackjackSolitaire {
	int score = 0;
	
	
	public static void main(String[] args) {
		int userInput;
		int currentCardsPlaced  = 0;
		Card currentCard;
		boolean userEnd = false;
		
		Deck deck = new Deck();
		deck.initDeck();
		deck.shuffleDeck();
		
		Board board =  new Board();
		board.displayBoard();

		
		
		Scanner userPrompt = new Scanner(System.in);
		
		while (currentCardsPlaced != 16 & !userEnd) {
			currentCard = deck.drawCard();
			System.out.print("Insert Number between 1 to 20. You drew a " + currentCard.value + " ." + "Your Number: ");
			
			userInput = userPrompt.nextInt();
			if (userInput == 0) {
				userEnd = true;
			} else {
				board.placeCard(userInput,  currentCard);
				board.displayBoard();
	
			}
			

			
		}
		
		userPrompt.close();

		
		
		
		
	}
}
