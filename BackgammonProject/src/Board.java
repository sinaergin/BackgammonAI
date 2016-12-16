import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Board stateinin tutulacagi sinif
public class Board {

    public static final int WHITEOUT = 99;
    public static final int BLACKOUT = 999;
    
	public List<Integer> whites;
	public List<Integer> blacks;
	public int TestChange;
	public int aaa;
	//initial Board
	public Board(){
		whites = new ArrayList<Integer>();
		blacks = new ArrayList<Integer>();
		
		whites.add(1);
		whites.add(1);
		whites.add(12);
		whites.add(12);
		whites.add(12);
		whites.add(12);
		whites.add(12);
		whites.add(17);
		whites.add(17);
		whites.add(17);
		whites.add(19);
		whites.add(19);
		whites.add(19);
		whites.add(19);
		whites.add(19);
		
		blacks.add(6);
		blacks.add(6);
		blacks.add(6);
		blacks.add(6);
		blacks.add(6);
		blacks.add(8);
		blacks.add(8);
		blacks.add(8);
		blacks.add(13);
		blacks.add(13);
		blacks.add(13);
		blacks.add(13);
		blacks.add(13);
		blacks.add(24);
		blacks.add(24);
	}
	public Board(Board b){
		whites = new ArrayList<Integer>();
		blacks = new ArrayList<Integer>();
		this.whites.addAll(b.whites);
		this.blacks.addAll(b.blacks);
	}
	public static Board newBoard(Board b,int indexOfMovingChecker,int zar){
		Board retB = new Board(b);
		int checkerValue = retB.whites.get(indexOfMovingChecker);
		int newValueOfChecker = checkerValue+zar;
		if (Collections.frequency(b.blacks,newValueOfChecker) == 0){//KIRIK YOK
			retB.whites.set(indexOfMovingChecker, newValueOfChecker);
			}
		else if(Collections.frequency(b.blacks,newValueOfChecker) == 1){//KIRIK VAR
			retB.whites.set(indexOfMovingChecker, newValueOfChecker);
			retB.blacks.set(b.blacks.indexOf(checkerValue), BLACKOUT);
			}
		return retB;
	}
	
	public Board(int a,int b,int c,int d){
		whites = new ArrayList<Integer>();
		blacks = new ArrayList<Integer>();
		
		whites.add(1);
		whites.add(1);
		whites.add(a);
		whites.add(b);
		whites.add(12);
		whites.add(12);
		whites.add(12);
		whites.add(17);
		whites.add(17);
		whites.add(17);
		whites.add(19);
		whites.add(19);
		whites.add(19);
		whites.add(19);
		whites.add(19);
		
		blacks.add(c);
		blacks.add(d);
		blacks.add(6);
		blacks.add(6);
		blacks.add(6);
		blacks.add(8);
		blacks.add(8);
		blacks.add(8);
		blacks.add(13);
		blacks.add(13);
		blacks.add(13);
		blacks.add(13);
		blacks.add(13);
		blacks.add(24);
		blacks.add(24);
	}
}
