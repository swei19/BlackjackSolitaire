public class Board {
	Card[][] board;
	Card[] discard;
	int score = 0;

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

	public int cardsPlaced() {
		return board.length;
	}

	public int numOfDiscards() {
		return discard.length;
	}

	public int scoringRules(int currentCardsTotal) {

		if (currentCardsTotal > 21) {
			return 0;
		} else if (currentCardsTotal == 21) {
			return 7;
		} else if (currentCardsTotal == 20) {
			return 5;
		} else if (currentCardsTotal == 19) {
			return 4;
		} else if (currentCardsTotal == 18) {
			return 3;
		} else if (currentCardsTotal == 17) {
			return 2;
		} else {
			return 0;
		}
	}

	public int aceScoringRules(int currentCardsTotal, int numRows) {
		if (currentCardsTotal == 21 && numRows == 2) {
			return 10;
		} else {
			int aceAsOneScore = scoringRules(currentCardsTotal);
			int aceAsElevenScore = scoringRules(currentCardsTotal + 10);

			if (aceAsOneScore >= aceAsElevenScore) {
				return aceAsOneScore;
			} else {
				return aceAsElevenScore;
			}
		}

	}

	public void calculateRowScores() {

		int rowWiseCardValues = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				Card currentCard = board[i][j];
				if (currentCard != null) {
					rowWiseCardValues += currentCard.value;
				}

			}

			score += scoringRules(rowWiseCardValues);

			rowWiseCardValues = 0;
		}

	}

	public void calculateColScores() {
		int columnWiseCardValues = 0;

		boolean hasAce = false;
		int numRows = 0;

		for (int i = 0; i < board[0].length; i++) {
			for (int k = 0; k < board.length; k++) {
				if (board[k][i] != null) {
					columnWiseCardValues += board[k][i].value;
					if (board[k][i].cardName == "A") {
						hasAce = true;
					}
					numRows += 1;
				}
			}

			if (hasAce) {
				score += aceScoringRules(columnWiseCardValues, numRows);

			} else {
				score += scoringRules(columnWiseCardValues);
			}

			hasAce = false;
			columnWiseCardValues = 0;
			numRows = 0;
		}

	}

}
