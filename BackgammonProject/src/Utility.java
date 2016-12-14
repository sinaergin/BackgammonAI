import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utility {

    public static final int BLOTWHITE = -1;//Daha sonra degistirilecek
    public static final int BLOTBLACK = 1;
    public static final int CLOSER = 2;
    public static final int WHITEOUT = 99;
    public static final int BLACKOUT = 999;
    public static final int WHITEHIT = -10;
    public static final int BLACKHIT = 5;
    
	public static int calculate(Board board){
		int returnValue = 0;
		
		returnValue += calcPlots(board);
		returnValue += calcHits(board);
		returnValue += calcAnchors(board);
		
		return returnValue;
	}
	
	public static int calcPlots(Board board) {
		int returnValue = 0;
		//setler icinde indislerin degerleri tutuluyor
		Set<Integer> whiteset = new HashSet<>();
		whiteset.addAll(board.whites);
		Set<Integer> blackset = new HashSet<>();
		blackset.addAll(board.blacks);
		
		for (int wchecker : board.whites) {
			if (Collections.frequency(board.whites,wchecker) == 1)
			{//in a blot state
				for (int bchecker : blackset) {
					if (bchecker - wchecker <= 6 && bchecker - wchecker > 0)
						returnValue += BLOTWHITE * CLOSER;
					else if (bchecker - wchecker > 6 && bchecker - wchecker <=12)
						returnValue += BLOTWHITE;
				}
			}
		}
		for (int bchecker : board.blacks) {
			if (Collections.frequency(board.blacks,bchecker) == 1)
			{//in a blot state
				for (int wchecker : whiteset) {
					if (bchecker - wchecker <= 6 && bchecker - wchecker > 0)
						returnValue += BLOTBLACK * CLOSER;
					else if (bchecker - wchecker > 6 && bchecker - wchecker <=12)
						returnValue += BLOTBLACK;
				}
			}
		}
		return returnValue;
	}

	public static int calcHits(Board board) {
		int returnValue = 0;
		
		int whitesHit = Collections.frequency(board.whites,WHITEOUT);
		if(whitesHit > 0 )
			returnValue += WHITEHIT * whitesHit ;
		
		int blacksHit = Collections.frequency(board.blacks,BLACKOUT);
		if(blacksHit > 0 )
			returnValue += BLACKHIT * blacksHit ;
		
		return returnValue;
	}

	public static int calcAnchors(Board board) {
		int returnValue = 0;
		
		return returnValue;
	}
	
	
}
