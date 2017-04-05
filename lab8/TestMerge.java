import java.util.*;
import ch06.lists.*;
import java.io.*;
public class TestMerge {
    protected static ArrayIndexedList list;
    public static <T> ArrayIndexedList<T> merge(ArraySortedList<T> list1, ArraySortedList<T> list2) {
	list  = new ArrayIndexedList<T>();
	list1.reset();
	list2.reset();
	int size1 = list1.size();
	int size2 = list2.size();
	T compare1 = list1.getNext(); //T from list1 to compare
	T compare2 = list2.getNext(); //T from list2 to compare
	int count1=0;
	int count2=0;
	while ((count1!=size1)&&(count2!=size2)){
		if ((((Comparable)compare1).compareTo((Comparable)compare2)) < 0) 
		    {	
			list.add(compare1);
			compare1=list1.getNext();
			count1++;
		    }
		else 
		    {
			list.add(compare2);
			System.out.println(compare2);
			compare2=list2.getNext();
			count2++;
		    }
	    }
	
	if (count1==size1){
	    list.add(compare1);
	    for (int i =count2;i<size2-1;i++){
		T adder = list2.getNext();
		list.add(adder);}}

	else{
	    list.add(compare2);
	    for (int i = count1; i<size1-1; i++) {
		T adder = list1.getNext();
		list.add(adder);
	    }
	}
	
    return list;
    }
    public int getSize() {
	return list.size();}
    public String toString() {
	return list.toString();
    }
    public static void main(String[] args) {
	try {
	Scanner myscan = new Scanner(new File("addresses.txt"));
	ArraySortedList<StreetAddress> list1 = new ArraySortedList<StreetAddress>();
	ArraySortedList<StreetAddress> list2 = new ArraySortedList<StreetAddress>();
	for (int i = 0; i < 10; i++) {
	    StreetAddress adder = new StreetAddress(myscan.nextInt(), myscan.nextLine());
	    list1.add(adder);
	}
	while (myscan.hasNextLine()) {
	    StreetAddress adder = new StreetAddress(myscan.nextInt(), myscan.nextLine());
	    list2.add(adder);
	}
	ArrayIndexedList<StreetAddress> printer = merge(list1, list2);
	System.out.println(list1);
	System.out.println(list2);
	System.out.println(printer.size());
	System.out.println(printer + " " + list1 + " " + list2);
	
	}
	catch (FileNotFoundException e) {
	    System.out.println("file not found!");
	}
    }
}
