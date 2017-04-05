import ch06.lists.*;
public class TestLast {
    public static <T> T Last(ListInterface<T> list) {
	//Will return the last item in a list of T. If the list is empty, it will return null and print out a message that the list is empty.
	T returns = null;
	list.reset();
	if (list.size() == 0) {
	    System.out.println("This is an empty list!");
	}
	else {
	    for (int i = 0; i < list.size(); i++) {
		returns = list.getNext();
	    }
	}
	return returns;
    }
    public static void main(String[] args) {
	ArraySortedList<String> test1 = new ArraySortedList<String>();
	test1.add("A");
	test1.add("B");
	test1.add("C");
        test1.add("D");
	System.out.println(Last(test1));
	ArraySortedList<String> empty = new ArraySortedList<String>();
	System.out.println(Last(empty));
	ArraySortedList<Integer> test2 = new ArraySortedList<Integer>();
	test2.add(1);
	test2.add(3);
	test2.add(5);
	test2.add(19);
	System.out.println(Last(test2));
	ArrayUnsortedList<Integer> test3 = new ArrayUnsortedList<Integer>();
	test3.add(1);
	test3.add(2);
	test3.add(3);
	System.out.println(Last(test3));
    }
}
