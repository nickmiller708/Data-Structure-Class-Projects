// Nick Miller and Austin Lotspeich
// LinkedQ<T> class
import support.LLNode;
import ch05.queues.*;
public class LinkedQ<T> extends LinkedUnbndQueue<T> {
    public LinkedQ() {
	super();
    }
    public String toString() {
	LLNode<T> currNode = front;
	String returns = "";
	while (currNode != null) {
	    returns = returns +  currNode.getInfo() + " ";
	    currNode = currNode.getLink();
	}
	return returns;
    }
    public static void main(String[] args) {
	LinkedQ<Double> test = new LinkedQ<Double>();
	test.enqueue(1.0);
	test.enqueue(2.0);
	test.enqueue(3.0);
	System.out.println("Testing with Double");
	System.out.println(test + "\n");
	LinkedQ<String> test2 = new LinkedQ<String>();
	test2.enqueue("Hello,");
	test2.enqueue("Today is Tuesday.");
	test2.enqueue("We are testing this class for a String.");
	System.out.println("Testing with String");
	System.out.println(test2 + "\n");
	LinkedQ<Integer> test3 = new LinkedQ<Integer>();
	test3.enqueue(1);
	test3.enqueue(2);
	test3.enqueue(3);
	System.out.println("Testing with Integers.");
	System.out.println(test3 + "\n");
	System.out.println("End of testing");
    }
}
