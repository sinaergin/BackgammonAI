import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<String> parentNode = new Node<String>("Parent"); 
		Node<String> childNode1 = new Node<String>("Child 1", parentNode);
		Node<String> childNode2 = new Node<String>("Child 2");     

		Board asdCCC = new Board();
		Board asd = new Board(5,3,6,7);
		List<Board> x = Utility.getValidMovesWithij(asdCCC,2,3);
		System.out.println("SIZE: "+x.size());
		for (Board bbb : x) {
			System.out.println(Utility.calculate(bbb));
		}
		//int a = Utility.calculate(asd);
		//System.out.println(a);
		
		//childNode2.setParent(parentNode); 
//parentNode.addChild(childNode2);
		//Node<String> grandchildNode = new Node<String>("Grandchild of parentNode. Child of childNode1", childNode1); 
		//List<Node<String>> childrenNodes = parentNode.getChildren();
		//int i = 0;
		//for (int checkers : asd.whites) {
		//	System.out.println(i +") white: " + asd.whites.get(i) + " black: " + asd.blacks.get(i++));
		//}
		//System.out.println(childrenNodes.get(1).getChildren().get(0).getData());
	}

}
