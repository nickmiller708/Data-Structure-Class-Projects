// Nick and Kaitlyn
// Testing for leafCount() function
import ch08.trees.*;
import java.util.Random;
public class TestBST {
    public static void main(String[] args ) {
	Random rn = new Random();
	BST<Integer> tester = new BST<Integer>();
	for (int i = 0; i < 10; i ++) {
	    int a = rn.nextInt(45);
	    System.out.println(a);
	    tester.add(a);
	}
	System.out.println("\n");
	System.out.println("Leaf count for the tree: " + tester.leafCount());
    }
}
