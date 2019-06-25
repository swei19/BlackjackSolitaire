public class Board {
	Card[][] board;
	Card[] discard;

	public Board() {
		board = new Card[4][5];
		discard = new Card[4];
	}

	public void displayBoard() {
		int discardCounter = 0;

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {
				if (i > 1 && (j == 0 || j == 4)) {
					System.out.printf("%-4s", "");
				} else if (board[i][j] != null) {
					System.out.printf("%0$-4s", board[i][j].displayName);

				} else
					System.out.printf("%0$-4s", "---");
			}

			if (i == 1 || i == 2) {
				System.out.printf("%-6s", "");
				for (int j = 0; j < 2; j++) {
					if (discard[discardCounter] != null) {

						System.out.printf("%0$-4s", discard[discardCounter].displayName);
						discardCounter += 1;
					} else {
						System.out.printf("%0$-4s", "---");
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
	




}
