// The Card class below creates the card object, along with getter methods for all instance variables.

public class Card {
	private int value; // To store the points worth of the card
	private String cardName; // To store the name of the card
	private String suit; // To store the rank the card belongs to
	private String displayName; // To store the name + suit of the card which will be displayed in the game.

	public Card(String cardName, int value, String suit) {
		this.cardName = cardName;
		this.value = value;
		this.suit = suit;
		this.displayName = cardName + suit;
	}

	public int getValue() {
		return value;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getCardName() {
		return cardName;
	}

	public String getSuit() {
		return suit;
	}

}
