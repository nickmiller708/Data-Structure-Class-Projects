/* Nick Miller and Levi Sledd
   TestTree file for different sized trees. Contains function to print data for different sized trees */
import java.util.Random;
public class TestTree15 {
    public static BinarySearchTree2<Integer> buildintTree(int size) {
	int b = 4*size;
	int[] used = new int[b];
	for (int i = 0; i < b; i++) 
	    used[i] = -1;
	Random rn = new Random();
	BinarySearchTree2<Integer> returner = new BinarySearchTree2<Integer>();
	for (int i = 0; i < size; i++) {
	    int adder = rn.nextInt(b); 
	    if (used[adder] == -1) {
		returner.add(adder);
		used[adder] = 0;
	    }
	    else
		i--;
	}
	return returner;
    }
    public static void  printer(int size) {
	System.out.println("\n---------------");
	System.out.println("size " + size + " trees! \n");
	int[] count = new int[200];
	double heighttotal = 0;
	for (int i = 0; i <200; i++) {
	    BinarySearchTree2<Integer> test = buildintTree(size);
	    int heights = test.height();
	    heighttotal = heighttotal + heights;
	    count[heights] += 1;
	}
	double average = (heighttotal/200);
	System.out.println("Average height: " + average + "\n");
	for (int i = 0; i <200; i++) {
	    if (count[i] != 0) {
		System.out.println("height: " + i + " " +count[i]);
	    }
	}
    }
    public static void main(String[] args) {
	/*BinarySearchTree2<Integer> test1 = buildintTree(5);
	System.out.println("\n" + test1.height());
	System.out.println("\n");
	BinarySearchTree2<Integer> test2 = buildintTree(5);
	System.out.println("\n" + test2.height());
	BinarySearchTree2<Integer> test3 = buildintTree(15);
	System.out.println("\n" + test3.height());*/
	int[] count = new int[200];
	double heighttotal = 0;
	for (int i = 0; i <200; i++) {
	    BinarySearchTree2<Integer> test = buildintTree(1000);
	    int heights = test.height();
	    heighttotal = heighttotal + heights;
	    count[heights] += 1;
	}
	double average = (heighttotal/200);
	System.out.println("Average height: " + average + "\n");
	for (int i = 0; i <200; i++) {
	    if (count[i] != 0) {
		System.out.println("height: " + i + " " +count[i]);
	    }
	}
	printer(25);
	printer(50);
	printer(100);
	for (int i = 200; i <= 12800; i =i*2) {
	    printer(i);
	}
    }
}
