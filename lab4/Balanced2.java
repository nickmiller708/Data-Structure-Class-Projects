// Made by Nick MIller and Ben McKernan
import ch03.stacks.*;
import java.io.*;
public class Balanced2 {
    public static boolean isBal(String aLine) {
	//return true or false, depending on whether the String aLine is balancend with respect to {}, [], and ()
	ArrayStack<String> myStack = new ArrayStack<String>();
	System.out.println(aLine);
	boolean test = true;
	int i = 0;
	while ((i <= aLine.length()) && (test == true)) {
	    if (aLine.charAt(i) = "{") {
		myStack.push("{");
	    }
	    else if (aLine.charAt(i) = "[") {
		myStack.push("[");}
	    else if (aLine.charAt(i) = "(") {
		myStack.push("(");
	    }
	    try {
		if (aLine.charAt(i) = "}"){
		    if (myStack.top = "{"){
			myStack.pop();}
		}
		else if (aLine.charAt(i) = "]") {
			if (myStack.top = "[") {
			    myStack.pop();}
		}
		else if (aLine.charAt(i) = ")") {
		    if (myStack.top = ")" ){
			    myStack.pop();}
		}
	    }
	    catch (StackUnderflowException e) {
		test = false;
	    }
	}
	boolean returns;
	if (!myStack.isEmpty()) {
	    returns = false;
	}
	else if ((myStack.isEmpty() == true) && (test == true)) {
	    returns = true;
	}
	return returns;
    }
    public static void main(String[] args) {
	Filereader fin = new Filereader("bal.txt");
	Scanner myScan = new Scanner(fin);
	while (!fin.hasNextLine()) {
	    isBal(fin.nextLine());
	}
    }
}
