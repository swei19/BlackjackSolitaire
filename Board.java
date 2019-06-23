public class Board {
	Card[][] board;
	String[] discard;

	public Board() {
		board = new Card[4][5];
		discard = new String[4];
	}

	public void initBoard() {

		for (int i = 0; i < board.length; i++) {
			discard[i] = " ";
			for (int j = 0; j < board[i].length; j++) {

				if (i > 1 && (j == 0 || j == 4)) {
					continue;
				} else {
					//board[i][j] = new Card("", 10, "Hearts");
				}

			}
		}
	}

	public void displayBoard() {

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != null) {
					System.out.print("[" + board[i][j] + "] ");

				} else {
					System.out.print("    ");
				}
			}

			if (i == 1 || i == 2) {
				System.out.print("   ");
				for (int k = 0; k < 2; k++) {
					System.out.print("[" + discard[i] + "]  ");
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
		
		if (position > 4) {
			row = 4;
			col = position % 5;
		} else {
			row = position;
			col = 0;
		}
		board[row][col] = card;		
	}
	


	public static void main(String[] args) {
		Board currentBoard = new Board();

		currentBoard.initBoard();
		currentBoard.displayBoard();
	}
	
}
