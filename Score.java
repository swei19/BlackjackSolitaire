
//The Score class contains various methods to calculate the score of the game.

public class Score {
	private Card[][] board;
	private int score;

	public int getScore() {
		return score;
	}

	public Score(Card[][] board) {
		this.board = board;
		this.score = 0;
	}

	// Calculate and return a score given the value sum of a given row or column of cards
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
			return 1;
		}
	}

	// The method below generates the score in case an ace was used in a column or row
	
	public int aceScoringRules(int currentCardsTotal, int numRows) {
		/**
		  If there are only two spots, the only combinations to get 11 is an ace and a
		  value 10 card. This actually means the card combination is a 21 and therefore
		  should receive a blackjack scoring.
		 */
		if (currentCardsTotal == 11 && numRows == 2) {
			return 10;
		} else {
			
			// Return the higher of the score with Ace acting as a one and Ace acting as a 11.

			int aceAsOneScore = scoringRules(currentCardsTotal);
			int aceAsElevenScore = scoringRules(currentCardsTotal + 10);
			// Add 10 because 1 is already counted.

			if (aceAsOneScore >= aceAsElevenScore) {
				return aceAsOneScore;
			} else {
				return aceAsElevenScore;
			}
		}

	}

	/**
	 *  The way to calculate the score is separated into two methods to ensure cleaner code and to handle the
	 *  Ace card more appropriately. The below method, calculateRowScores calculate the player's score 
	 *  by looping through each row and then for each row, loop through each 
	 *  column (calculate score horizontally).
	 *  
	 *  The calculateColScore is the opposite, where it loops through each column and for each column, 
	 *  each row.
	 */
	
	public void calculateRowScores() {

		int rowWiseCardValues = 0;
		boolean hasAce = false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				Card currentCard = board[i][j];
				if (currentCard != null) {
					rowWiseCardValues += currentCard.getValue();

					if (board[i][j].getCardName().equals("A")) {
						hasAce = true;
					}
				}

			}
			if (hasAce) {
				score += aceScoringRules(rowWiseCardValues, 4);

			} else {
				score += scoringRules(rowWiseCardValues);
			}
			hasAce = false;
			rowWiseCardValues = 0;
		}

	}

	/**
	  The below method calculates the value sum of the columns or vertically. It
	  also keeps tracks of the number of cards in that column so to ensure that the
	  two cards column with a score of 21 is given the blackjack score.
	 */

	public void calculateColScores() {
		int columnWiseCardValues = 0;

		boolean hasAce = false;
		int numRows = 0;

		for (int i = 0; i < board[0].length; i++) {
			for (int k = 0; k < board.length; k++) {
				if (board[k][i] != null) {
					numRows += 1;
					columnWiseCardValues += board[k][i].getValue();
					if (board[k][i].getCardName().equals("A")) {
						hasAce = true;
					}

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
