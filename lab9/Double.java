//Nick Miller/Sean Dunn
/* Doubly Linked List Class works as expected!*/
import support.*;
import ch06.lists.*;
public class Double<T extends Comparable<T>> implements ListInterface<T> {
    protected DLLNode<T> front, back;
    protected int numElements;
    protected DLLNode<T> curPosition; // only used in getNext() and getPrevious();
    public Double() {
	front = null;
	back = null;
	numElements = 0;
    }
    public void add(T element) {
	//will add a node.
	DLLNode<T> adder = new DLLNode<T>(element);
	if(numElements == 0){
	    front = adder;
	    back = adder;
	    numElements++;
	}
	else
	    {
		DLLNode node = front;
		while(node != null)
		    if(((Comparable)node.getInfo()).compareTo(element)>=0)
		       {
			   if(node==front)
			       {
				   adder.setLink(front);
				   front.setBack(adder);
				   front = adder;
				   numElements++;
			       }
			   else
			       {
				   adder.setBack(node.getBack());
				   adder.setLink(node);
				   node.getBack().setLink(adder);
				   node.setBack(adder);
				   numElements++;
			       }
			   break;
		       }
		       else
			   {
			       node = (DLLNode) node.getLink();
			   }
		       if(node == null)
			   {
			       back.setLink(adder);
			       adder.setBack(back);
			       back = adder;
			       numElements++;
			   }
		       }
	    }	
    public int size() {	
	return numElements;
    }
    protected DLLNode<T> find(T target) {
	DLLNode<T> returner = front;
	while (returner != null) {
	    if (returner.getInfo().compareTo(target) == 0) 
		break;
	    else
		returner = (DLLNode) returner.getLink();
	}
	if (returner == null)
	    return null;
	else
	    return returner;
    }
    public boolean contains (T element) {
	DLLNode<T> found = find(element);
	if (found == null) {
	    return false; }
	else 
	    return true;
    }
    public T get(T element) {
	DLLNode<T> found = find(element);
	if (found == null)
	    return null;
	else
	    return found.getInfo();
    }
    public String toString() {
	DLLNode<T> currNode = front;
	String returner = "";
	while (currNode!=(null)) {
	    returner = returner + currNode.getInfo() + "\n";
	    currNode = (DLLNode) currNode.getLink();
	}
	return returner;
    }
    public void reset() {
	curPosition = front;
    }
    public T getNext() {
	T next = curPosition.getInfo();
	if (curPosition.getLink() == null)
	    reset();
	else
	    curPosition = (DLLNode) curPosition.getLink();
	return next;
    }
    public void resetBack() {
	curPosition = back;
    }
    public T getPrevious() {
	T element = curPosition.getInfo();
	if (curPosition == front) 
	    resetBack();
	else
	    curPosition = curPosition.getBack();
	return element;
    }
    public  boolean remove(T element){
	if(contains(element))
	    {
		DLLNode<T> found = front;
		if (numElements == 1)
		    {
			front = null;
			back = null;
			numElements--;
			return true;
		    }
		else
		    {
			while(found!=null)
			    {
				if((Comparable)found.getInfo().compareTo(element)==0)
				    {
					if(found == front)
					    {
						front = (DLLNode)front.getLink();
						front.setBack(null);
						numElements--;
					    }
					else if (found == back)
					    {
						back = back.getBack();
						back.setLink(null);
						numElements--;
					    }
					else
					    {
						found.getBack().setLink(found.getLink());
						((DLLNode)found.getLink()).setBack(found.getBack());
						numElements--;
					    }
					return true;
				    }
				else
				    {
					found = (DLLNode) found.getLink();
				    }
			    }
		    }
	    }
	return false;
    }
    public static void main(String[] args) {
	
	Double<String> d = new Double<String>();
	d.add("Hello");
	d.add("Zoo");
	d.add("Computer Science");
        d.add("Arthur");
        d.add("Goodbye");
	d.add("Mathematics");
	d.add("Testing");
	System.out.println(d);
	
        System.out.println( "Contains -Hello- " + d.contains("Hello"));
	System.out.println("Contains -Spring- " + d.contains("Spring"));
	System.out.println("size: " + d.size());
	d.resetBack();
	for (int i = 0; i < d.size(); i++){
	    String item = (String)d.getPrevious();
	    System.out.println(item);
	 } //good stopping point
        d.remove("Zoo");
        d.remove("Arthur");
	d.remove("Testing"); 
	System.out.println("size: " + d.size()); 
	System.out.println(d);
	d.remove("Goodbye");
	d.remove("Hello");
	System.out.println(d);
	d.remove ("Computer Science");
	d.remove("Mathematics");
	System.out.println(d);
    }
}
