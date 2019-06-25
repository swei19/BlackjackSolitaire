import java.util.Arrays;
import java.util.Collections;

public class Deck {
	Card[] deck;
	int drawCounter = -1;

	public void initDeck() {
		String[] cardsNames = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String[] suits = { "H", "D", "S", "C" };

		int deckCounter = 0;
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
				this.deck[deckCounter] = currentCard;
				deckCounter += 1;
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

}
