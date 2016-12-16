import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utility {

    public static final int PTSBLOTWHITE = -1;//Beyaz tekli eksi puan demek
    public static final int PTSBLOTBLACK = 1;//Siyah tekli arti puan demek
    //içerdeki kapilar ÇARPI vurma katsayisi
    public static final int PTSWHITEHIT = -10;//Beyaz kirik eksi puan demek
    public static final int PTSBLACKHIT = 5;//Siyah kirik arti puan demek
    public static final int PTSWHITEANCHOR = 4;//Beyaz kapi arti puan demek
    public static final int PTSBLACKANCHOR = -2;//Siyah kapi eksi puan demek
    public static final int CLOSER = 2;
    public static final int WHITEOUT = 99;
    public static final int BLACKOUT = 999;
    
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
						returnValue += PTSBLOTWHITE * CLOSER;
					else if (bchecker - wchecker > 6 && bchecker - wchecker <=12)
						returnValue += PTSBLOTWHITE;
				}
			}
		}
		for (int bchecker : board.blacks) {
			if (Collections.frequency(board.blacks,bchecker) == 1)
			{//in a blot state
				for (int wchecker : whiteset) {
					if (bchecker - wchecker <= 6 && bchecker - wchecker > 0)
						returnValue += PTSBLOTBLACK * CLOSER;
					else if (bchecker - wchecker > 6 && bchecker - wchecker <=12)
						returnValue += PTSBLOTBLACK;
				}
			}
		}
		
		
		//System.out.println("BLOTS: "+returnValue);
		return returnValue;
	}

	public static int calcHits(Board board) {
		int returnValue = 0;
		
		int whitesHit = Collections.frequency(board.whites,WHITEOUT);
		int blackAnchorsOnHome = 1;
		if(whitesHit > 0 )
			returnValue += PTSWHITEHIT * whitesHit ;
		
		int blacksHit = Collections.frequency(board.blacks,BLACKOUT);
		if(blacksHit > 0 )
			returnValue += PTSBLACKHIT * blacksHit ;

		
		//System.out.println("HITS: "+returnValue);
		return returnValue;
	}

	public static int calcAnchors(Board board) {
		int returnValue = 0;

		//setler icinde indislerin degerleri tutuluyor
		Set<Integer> whiteset = new HashSet<>();
		whiteset.addAll(board.whites);
		Set<Integer> blackset = new HashSet<>();
		blackset.addAll(board.blacks);
		
		for (Integer checker : whiteset) {
			if(isOnBoard(checker)){
				if (Collections.frequency(board.whites,checker) > 1){
					returnValue += PTSWHITEANCHOR * (checker > 18 ? 2 : 1);
				}
			}
		}

		for (Integer checker : blackset) {
			if(isOnBoard(checker)){
				if (Collections.frequency(board.blacks,checker) > 1){
					returnValue += PTSBLACKANCHOR * (checker < 7 ? 2 : 1);
				}
			}
		}
		//System.out.println( "ANCHORS: "+returnValue);
		return returnValue;
	}
	
	public static boolean isOnBoard(int checker){
		boolean returnValue = checker >= 1 && checker <=24; 
		return returnValue;
	}
	
	public static List<Board> validMoves(Board board){
		List<Board> retBoard = new ArrayList<Board>();
		Board tempBoard = board;
		int i = 1;
		int j = 1;
		Date d1 = new Date();
		//for (int asayi = 0; asayi<100; asayi++) {//TEST
			for (int x : board.whites) {
				for(i = 1; i<7;i++){
					for(j = 1; j<7;j++){
						retBoard.addAll(getValidMovesWithij(board,i,j));
					}
				}
			}	
		//}//TEST
		Date d2 = new Date();
		
		long seconds = (d2.getTime()-d1.getTime());
		System.out.println(seconds);
		return retBoard;
		
	}
	
	public static List<Board> getValidMovesWithij(Board b , int i , int j){
		//int retVal =0;
		List<Board> retB = new ArrayList<Board>();
		
		Set<Integer> whiteset = new HashSet<>();
		whiteset.addAll(b.whites);
		
		for (Integer x : whiteset) {
			if(Collections.frequency(b.blacks,x)< 2){
				Board ilkZarBoard = Board.newBoard(b,b.whites.indexOf(x),i);

				Set<Integer> whitesetilkZar = new HashSet<>();
				whitesetilkZar.addAll(ilkZarBoard.whites);

				for (Integer y : whitesetilkZar) {
					if(Collections.frequency(ilkZarBoard.blacks,y)< 2){
						retB.add(Board.newBoard(ilkZarBoard,ilkZarBoard.whites.indexOf(y),j));
					}
				}
				}
		}	
		
		return retB;
	}
	
}
