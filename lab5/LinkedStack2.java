// Nick Miller and Minh Duc Nguyen
// LinkedStack2.java
// program runs as expected
import ch03.stacks.*;
import support.LLNode;

public class LinkedStack2<T> extends LinkedStack<T>{
    public LinkedStack2(){
	super();}

    //TOSTRING
    public String toString(){
	LLNode<T> top2= top;
	String c="";
	int count1=1;
	while (top2!=null){
	    c=c+count1+top2.getInfo()+"\n";
	    count1++;
	    top2=top2.getLink();}
	return c;}

    //POPSOME
    public void popSome(int count){
	for(int i=0;i<count;i++){
	   super.pop();}}
    //INSPECTOR FUNCTION
    public T inspector(int position){
	LLNode<T> top3= top;
	try{
	    for(int e=0; e<position-1;e++){
		top3=top3.getLink();
	    }
	    return top3.getInfo();
	}
	catch (NullPointerException error2){
	    return null;
	}
    }
    //SIZEOF FUNCTION
    public int sizeOf() {
	//returns the size of the stack
	int count3 = 0;
	LLNode<T> top4 = top;
	while (top4!= null) {
	    count3++;
	    top4 = top4.getLink();
		}
	return count3;
    }
    //MAIN
    public static void main (String[] args){
	LinkedStack2<String> test=new LinkedStack2<String>();
	String a=" ABC ";
	String b=" DEF ";
	test.push(" XYZ ");
	test.push(a);
	test.push(b);

	System.out.println(test);
	System.out.println("The size of the stack is: " + test.sizeOf());
	//expected answer is 3
	try {test.popSome(2);}
	catch (StackUnderflowException error){
	    System.out.println("There are not enough object in the stack");}
	System.out.println(test);
	System.out.println(test.inspector(1)); //should print out XYZ
	System.out.println(test.inspector(4)); //should return null
	System.out.println("The new size of the stack is: " + test.sizeOf());
	//Expected answer is 1;
    }
}
 
