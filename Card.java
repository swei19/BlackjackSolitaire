import java.util.Arrays;

public class Card {
	public int value;
	public String cardName;
	public String suit;
	public String displayName;

	public Card(String cardName, int value, String suit) {
		this.cardName = cardName;
		this.value = value;
		this.suit = suit;
		this.displayName = cardName + suit;
	}

}
