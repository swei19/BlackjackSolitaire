import java.util.Arrays;
import java.util.Collections;


public class Deck {
	Card[] deck;
	int drawCounter = -1;

	public void initDeck() {
		String[] cardsNames = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
		String[] suits = { "Hearts", "Diamonds", "Spades", "Clubs" };
		
		int counter = 0;
		Card currentCard = null;
		int cardValue;
		
		
		this.deck = new Card[52];
		for (int i = 0; i < cardsNames.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				if (i < 10) {
					cardValue = i + 1;
				} else {
					cardValue = 10;
				}
				currentCard = new Card(cardsNames[i], cardValue, suits[j]);
				this.deck[counter] = currentCard;
				counter += 1;
			}	
		}
	}
	
	public void shuffleDeck() {
		Collections.shuffle(Arrays.asList(deck));

	}
	
	public Card drawCard() {
		drawCounter += 1;
		return deck[drawCounter];
	}
	/*
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.initDeck();
		System.out.println(deck.drawCounter);
		deck.drawCard();
		System.out.println(deck.drawCounter);
	} */
/*
	public static void main(String[] args) {
		Deck currentDeck = new Deck();
		currentDeck.initDeck();
		currentDeck.shuffleDeck();
		
		System.out.println(Arrays.toString(currentDeck.deck));
		
	}
*/
	
}
