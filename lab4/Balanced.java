// Made by:
import ch03.stacks.*;
import java.io.*;
public class Balanced {
    public static boolean isBal (String aLine) {
	boolean test;
	ArrayStack<char> myStack = new ArrayStack<char>();
	System.out.println(aLine);
	int len=aLine.length();
	int i =0;
	while ((i<=len) && (test==true)){
	    char  string1=aLine.charAt(i);
	    if (string1.compareTo("{")==0){
		myStack.push(string1);
	    }
	    else if ((aLine.charAt(i).compareTo("["))==0){
		myStack.push(aLine.charAt(i));
	    }
	    else if ((aLine.charAt(i).compareTo("("))==0){
		myStack.push(aLine.charAt(i));
	    }
	    try{
		if ((aLine.charAt(i).compareTo("}"))==0){
		    if ((myStack.top().compareTo("{"))==0){
			myStack.pop();
		    }
		}
		else if ((aLine.charAt(i).compareTo("]"))==0){
		     if ((myStack.top().compareTo("["))==0){
			myStack.pop();
		    }
		}
		else if ((aLine.charAt(i).compareTo(")"))==0){
		    if ((myStack.top().compareTo("("))==0){
			myStack.pop();
		    }
		}
	    }
	    catch(StackUnderflowException e){
		test=false;
	    }
	    i++;
	}
	return test;
    }
    public static void main(String [] args){
	FileReader fin= new FileReader("bal.txt");
	Scanner input= new Scanner(fin);
	boolean var1= true;
	while (var1=true){
	    System.out.println(isBal(input));
	    if ((input.hasNextLine())==false){
		var1=false;
	    }
	    else{
		input.nextLine();
	    }
	}
		
    }
}
	     
