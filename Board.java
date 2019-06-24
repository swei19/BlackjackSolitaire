public class Board {
	Card[][] board;
	Card[] discard;

	public Board() {
		board = new Card[4][5];
		discard = new Card[4];
	}

	public void displayBoard() {
		String whiteSpace = "";
		
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {
				if (i > 1 && (j == 0 || j == 4)) {
					System.out.print("    ");
				} else if (board[i][j] != null) {
					if (board[i][j].value < 10) {
						whiteSpace = " ";
					} else {
						whiteSpace = "";
					}
					
					System.out.print("[" + board[i][j].value + whiteSpace + "]");

				} else
					System.out.print("[  ]");
			}

			if (i == 1 || i == 2) {
				System.out.print("      ");
				for (int k = 0; k < 2; k++) {
					if (discard[i] != null) {
						System.out.print("[" + discard[i].value + whiteSpace + "]");
					} else {
						System.out.print("[  ]");
					}
				}
			}

			if (i < 3) {
				System.out.println("\n");
			}
		}

	}

	public void placeCard(int position, Card card) {

		int row;
		int col;
		
		if (position >= 17) {
			discard[position - 17] = card;
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
	
	public int cardsPlaced() {
		return board.length;
	}
	
	public int numOfDiscards() {
		return discard.length;
	}


}
