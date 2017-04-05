/* Nick and Kaitlyn
   minHeap class */
import ch09.priorityQueues.*;
import java.util.Random;
import support.*;
import java.util.*;
public class MinHeap<T extends Comparable<T>> implements PriQueueInterface<T> {
    private ArrayList<T> elements;
    private int lastIndex;
    private int maxIndex;
    public MinHeap(int Size) {
	lastIndex = -1;
	elements = new ArrayList<T>(Size);
	maxIndex = Size - 1;
    }
    public boolean isEmpty() {
	return (lastIndex == -1);
    }
    public boolean isFull() {
	return (lastIndex == maxIndex);
    }
    private void reheapUp(T element) {
	int hole = lastIndex; // hole where we are reheaping up from
	while ((hole > 0) && (element.compareTo(elements.get((hole -1) /2 )) <  0)) {
	    elements.set(hole, elements.get((hole-1)/2));
	    hole = ((hole-1))/2;
	}
	elements.set(hole,element);
    }
    private int newHole(int hole, T element) {
	int left = (hole * 2) + 1;
	int right = (hole * 2) + 2;
	if (left > lastIndex) {
	    return hole;
	}
	else if (left == lastIndex) {
	    if (element.compareTo(elements.get(left)) <0) {
		return hole;
	    }
	    else
		return left;
	}
	else
	    if (elements.get(left).compareTo(elements.get(right)) < 0){	
		// if the left child is small than the right, then look at the left child.
		if (elements.get(left).compareTo(element) < 0) {
		    return left;}
		else{
		    return hole;}
	    }
	    else {
		if (elements.get(right).compareTo(element) < 0){
		    //comparing if right child is less than element. If so, return right. else return left.
		    return right;}
		else{
		    return hole;}
	    }
    }
    private void reheapDown(T element) 
	  // Current root position is "empty";
	// Inserts element into the tree and ensures shape and order properties.
    {
	int hole = 0;      // current index of hole
	int newhole;       // index where hole should move to
	
	newhole = newHole(hole, element);   // find next hole
	while (newhole != hole)
	    {
		elements.set(hole,elements.get(newhole));  // move element up
		hole = newhole;                            // move hole down
		newhole = newHole(hole, element);          // find next hole
	    }
	elements.set(hole, element);           // fill in the final hole
    }
    
    public void enqueue(T element) throws PriQOverflowException {
	if (lastIndex == maxIndex) {
	    throw new PriQOverflowException("Priority Queue is full");
	}
	else {
	    lastIndex++;
	    elements.add(lastIndex, element);
	    reheapUp(element);
	}
    }
    public T dequeue() throws PriQUnderflowException {
	T hold;
	T toMove;
	if (lastIndex == -1) 
	    throw new PriQUnderflowException("Priority Queue is empty!");
	else {
	    hold = elements.get(0);
	    toMove = elements.remove(lastIndex);
	    lastIndex --;
	    if (lastIndex != -1)
		reheapDown(toMove);
	    return hold;
	}
    }

    public String toString() {
	// Returns string of all elements in the Heap;
	String returns = "the heap is: \n";
	for (int index = 0; index <= lastIndex; index++) {
	    returns = returns + index + ". " + elements.get(index) + "\n";
	}
	return returns;
    }
    public static void main(String[] args) {
	MinHeap<Integer> tester = new MinHeap<Integer>(50);
	Random rn = new Random();
	System.out.println("Is it empty? " + tester.isEmpty());
	for (int i = 0; i < 50; i ++) {
	    int a = rn.nextInt(100);
	    tester.enqueue(a);
	}
	System.out.println("Is it full? " + tester.isFull());
        while (!tester.isEmpty()) {
	    System.out.println(tester.dequeue());
	}
	System.out.println("Is it empty? " + tester.isEmpty());
    }
}
