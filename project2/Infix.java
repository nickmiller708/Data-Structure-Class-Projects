// made by Nick Miller
// help by Minh Duc Nguyen on getting a while loop to work in evaluate.

import java.util.Scanner;
import ch03.stacks.*;
import java.lang.Math;
public class Infix {
    public static int precedent(char operand) {
	// will return the precedent for which operation is performed!
	int precedent = 0;
	switch(operand) {
	case '^':
	    precedent = 3;
	    break;
	case '*':
	case '/':
	    precedent = 2;
	    break;
	case '+':
	case '-':
	    precedent = 1;
	    break;
	}   
	return precedent;
    }
    public static void  operations(ArrayStack <Character> list1, ArrayStack<Double> list2) {
	// Will have two parameters, being the two stacks from evaluate, and then performing the correct operations.
	double returns = 0;
	char op1 = list1.top();
	list1.pop();
	double num1 = list2.top();
	list2.pop();
	double num2 = list2.top();
	list2.pop();
	if (op1 == '^') {
	    returns = Math.pow(num1, num2);
	}
	else if  (op1 == '*')
	    returns = num2*num1;
	else if (op1 == '/') 
	    returns = num2/num1;
	else if (op1 == '+')
	    returns = num2 + num1;
	else if (op1 == '-')
	    returns = num2 - num1;
	list2.push(returns); 
	    	
    } 
    public static double evaluate( String expression) {
	ArrayStack<Character> ops = new ArrayStack<Character>();
	ArrayStack<Double> num = new ArrayStack<Double>();
	Scanner myScan = new Scanner(expression);
	String myString; //will make a string out of the next character (operator) in the String expression
	char myChar;
	while (myScan.hasNext()) {
	    if (myScan.hasNextDouble()) {
		double stacknum = myScan.nextDouble();
		num.push(stacknum);
	    }
	    else  {
		myString = myScan.next();
		myChar = myString.charAt(0);
		switch (myChar) {
		case '(':
		    ops.push(myChar);
		    break;
		case '+':
		case '-':
		case '^':
		case '*':
		case '/':
		    if (ops.isEmpty() == true) {
			ops.push(myChar);
			operations(ops,num);}
		    else {
			while  ((ops.top() != '(')&&(ops.isEmpty() == true)&&(precedent(ops.top()) >= precedent(myChar))) {
			    operations(ops, num); // will perform the operation or push the character onto the stack.
			}
			ops.push(myChar);}
		    break;
		case ')':
		    // performs the operation.
		    while  (ops.top() != '(') {
			operations(ops, num);
			ops.pop();
			}
		    break;
		default:
		    break;
	    	}
	    }
	}
	if ((num.isEmpty()== false) && (ops.isEmpty()== false)) {
	    operations(ops, num);
	}
	else {
	    throw new StackUnderflowException("Trying to do an operation on an empty stack!");}
	double returns = num.top(); // will return the last value on the num stack, which should be the correct answer.
	num.pop();  
	return returns;
    }
    public static void main(String[] args) {
	String exp1 = "( 2 + 3 * 6) / (2 - 1 + 2 * 2)";
	String exp2 = "(2+5)*(15/(2+3))+5*(7-5)";
	String exp3 = "2 + 2";
	String exp4 = "1.0 + 1.0";
	try {
	    System.out.println(evaluate(exp1));}
	catch (Exception e) {
	    System.out.println(e);
	}
	try {
	    System.out.println(evaluate(exp2));}
	catch (Exception e) {
	    System.out.println(e);
	}
	try {
	    System.out.println(evaluate(exp3));}
	catch (Exception e) {
	    System.out.println(e);
	}
	try {
	    System.out.println(evaluate(exp4));}
	catch (Exception e) {
	    System.out.println(e);
	}
	    
    }
}
