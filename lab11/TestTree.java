// Nick and Kaitlyn

import ch08.trees.*;
import java.util.Random;
public class TestTree {
    public static int sum(BinarySearchTree<Integer> t) {
	int returner = 0;
	t.reset(1); //creating a queue in order
	for (int i = 0; i < t.size(); i ++){
	    int a = t.getNext(1);
	    returner = returner + a;
	}
	return returner;
    }
    public static void main(String[] args) {
	BinarySearchTree<Integer> tester = new BinarySearchTree<Integer>();
	int gensum = 0;
	Random rn = new Random();
	for (int i = 0; i < 10; i ++) {
	    int a = rn.nextInt(45);
	    System.out.println(a);
	    gensum = gensum + a;
	    tester.add(a);
	}
	System.out.println("Sum computed from adding generally: " + gensum);
	System.out.println("Sum computed from tree sum function: " + sum(tester));
    }

}
	
