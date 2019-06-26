import java.util.Arrays;

public class Card {
	private int value;
	private String cardName;
	private String suit;
	private String displayName;

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
