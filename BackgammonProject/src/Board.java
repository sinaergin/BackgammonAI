import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//Board stateinin tutulacagi sinif
public class Board {
	
	public List<Integer> whites;
	public List<Integer> blacks;
	
	//initial Board
	public Board(){
		whites = new ArrayList<Integer>();
		blacks = new ArrayList<Integer>();
		
		whites.add(5);
		whites.add(17);
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
		
		blacks.add(3);
		blacks.add(4);
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
