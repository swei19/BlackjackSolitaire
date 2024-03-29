
//The Board class is responsible for displaying the board of the game itself. 

public class Board {
	private Card[][] board;
	private Card[] discard;
	private int[] displayState = new int[16];
	private int[] discardState = new int[4];

	public Board() {
		board = new Card[4][5];
		discard = new Card[4];
	}

	/**
	  The below method generates and displays the board.It uses a double loop to go
	  through each row and column and checks if there is a non-null value. If there
	  is, display that card's name otherwise display '---'. The discard pile is also
	  generated here in a similar fashion. String formatting is used to ensure that
	  numbers with more characters do not 'mis-align' the board by ensuring space
	  padding with left-justification.
	 */
	
	/**
	  initDisplayState helps display the state of the game and the board number when no card is
	  placed at that position.
	*/
	
	public void initDisplayState() {
		for (int i = 1; i <= 20; i++) {
			if (i < 17) {
				displayState[i - 1] = i;
			} else {
				discardState[i - 17] = i;
			}
		}
	}

	
	public void displayBoard() {
		int discardCounter = 0;
		int displayCounter = 0;
		int discardDisplayCounter = 0;
		
		initDisplayState();

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {
				if (i > 1 && (j == 0 || j == 4)) {
					System.out.printf("%-4s", "");
					displayCounter -= 1;
				} else if (board[i][j] != null) {
					System.out.printf("%-4s", board[i][j].getDisplayName());
				} else
					System.out.printf("%-4s", displayState[displayCounter]);
					displayCounter += 1;
			}

			if (i == 1 || i == 2) { // Generate the discard pile in the 2nd and 3rd row
				System.out.printf("%-6s", "");
				for (int j = 0; j < 2; j++) {
					if (discard[discardCounter] != null) {
						System.out.printf("%-4s", discard[discardCounter].getDisplayName());
					
					} else {
						System.out.printf("%-4s", discardState[discardDisplayCounter]);
			
					}
					discardCounter += 1;
					discardDisplayCounter += 1;
				}

			}
			
			/**
			  The below if statement ensures that the whole game can be seen without
			  scrolling up the console. Without the below, you would need to scroll up to
			  see the game due to the extra line.
			 */
			
			if (i < 3) {
				System.out.println("\n");
			}
		}

	}

	/**
	  The below method places the card onto the board based on the board number
	  chosen by the user. As the board contains columns that are not used, the
	  formula below ensures that the card is placed at the right spot chosen by the
	  player.
	 */
	public void placeCard(int position, Card card) {

		int row;
		int col;

		if (position >= 17) { // 17 and above numbers are numbers in the discard pile.
			discard[position - 17] = card;
			return;
		} else if (position >= 14) {
			position += 2;
		} else if (position <= 10) {
			position -= 1;
		}

		if (position > 4) {
			row = position / 5;
			col = position - 5 * (position / 5);
		} else {
			row = 0;
			col = position;
		}

		board[row][col] = card;

	}

	public Card[][] getBoard() {
		return board;
	}

	public Card[] getDiscard() {
		return discard;
	}

}
