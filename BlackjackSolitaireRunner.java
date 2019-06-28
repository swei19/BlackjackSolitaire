
/** When you first start this BlackjackSolitaire game, you will see empty spaces in the form of "---". 
    Please refer below to see which spaces correspond to which number. 

        Play Pile
     1   2   3   4   5 
                            Discard Pile
	 6   7   8   9   10       17  18 

        11  12  13            19  20 

        14  15  16    
  
 */

public class BlackjackSolitaireRunner {

	public static void main(String[] args) {
		BlackjackSolitaire bjs = new BlackjackSolitaire();
		bjs.play();
	}
}