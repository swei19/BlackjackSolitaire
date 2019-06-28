import java.util.Arrays;
import java.util.Collections;

/**
 The Deck method creates the deck object, which works with the deck class. 
 It creates all the cards that makes up a deck using a loop and then add it to an Array.
 The Deck class also have the shuffleDeck method that randomizes index order of the items 
 in the array and a drawCard method that accesses the array with drawCounter based on the number of 
 cards already drawn
 */

public class Deck {
	private Card[] deck; // Array to store the deck of cards
	private int drawCounter = -1; // Accesses the deck Array based on the number of cards already drawn
	private final String[] cardsNames = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	private final String[] suits = { "H", "D", "S", "C" };

	// The initDeck methods creates the deck object using a loop.

	public void initDeck() {

		int deckCounter = 0;
		int cardValue;

		Card currentCard;

		this.deck = new Card[52]; // A deck contains 52 cards

		for (int i = 0; i < cardsNames.length; i++) { // Loop through each card name
			for (int j = 0; j < suits.length; j++) { // Loop through each suit
				if (i < 10) {
					cardValue = i + 1; // If i is below 10, then the card values follows i.
										// Add one to adjust for zero indexing
				} else {
					cardValue = 10; // Jack, Queen and Kings are all value 10
				}

				currentCard = new Card(cardsNames[i], cardValue, suits[j]); // Create card using card class
				this.deck[deckCounter] = currentCard; // Add the card to the Array
				deckCounter += 1; // Keep track of the number of cards already added to deck
			}
		}
	}

	public void shuffleDeck() {
		Collections.shuffle(Arrays.asList(deck)); // Randomizes the index order of the items in the Array

	}

	public Card drawCard() {
		drawCounter += 1; // Keep track of the number of cards drawn
		return deck[drawCounter]; // Return the next card of the array based on the number of cards drawn
	}

}
