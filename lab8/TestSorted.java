import java.util.*;
import java.io.*;
import ch06.lists.*;
public class TestSorted {
    protected ArraySortedList<StreetAddress> list;
    public TestSorted (String filename){
	list = new ArraySortedList<StreetAddress>();
	try {
	    Scanner myscan = new Scanner(new File(filename));
	    while (myscan.hasNextLine()) {
		StreetAddress adder = new StreetAddress(myscan.nextInt(), myscan.nextLine());
		list.add(adder);
	    }
	}
	catch (FileNotFoundException e) {
	    System.out.println("File not found!");
	}
    }
    public String toString() {
	String returners = "";
	for (int i = 0; i < list.size(); i++)
	    returners = returners + list.getNext() + "\n";
	return returners;
    }
    public static void main(String[] args) {
	TestSorted list1 = new TestSorted("addresses.txt");
	System.out.println(list1);
    }
}
