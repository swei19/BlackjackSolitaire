
public class Score {
	Card[][] board;
	int score;
	
	public Score (Card[][] board) {
		this.board = board;
		this.score = 0;
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
