//Nick Miller and Yixin Liu;
// tests the total number of times the Fibonacii sequence is called for any n-th term in the sequence.
public class TestFib 
{
    public static int count = 0;
    public static int fib(int n) {
	// returns the n-th Fibonacci number where fib(0) = fib(1) = 1
	// this function will not be explicitely called because we are interested in the number of times that the function is called.
	count++;
	if (n <= 1) 
	    return 1;
	
	else 
	    
	    return fib(n-1) + fib(n-2);	
    }
    public static int count(int n) {
	// returns the number of times the Fibonacci function is called when asked for the n-th Fibonacci number.
	return count;
    }
    public static void main(String[] args) {
	// main function to see how many times fib is called for the values given in lab.
	
	System.out.println("n = 2");
	System.out.println("Number in fibonacci sequence: " + fib(2));
	System.out.println("Number of times the function is called: "+ count(2)+ "\n");
	count = 0;
	System.out.println("n=4");
	System.out.println("Number in fibonacci sequence: " + fib(4));
	System.out.println("Number of times the function is called: "+ count(4) + "\n");
	count = 0;
	System.out.println("n=6");
	System.out.println("Number in fibonacci sequence: " + fib(6));
	System.out.println("Number of times the function is called: "+ count(6) + "\n");
	count = 0;
	System.out.println("n=8");
	System.out.println("Number in fibonacci sequence: " + fib(8));
	System.out.println("Number of times the function is called: "+ count(8));
	System.out.println("n = 10");
	System.out.println("Number in fibonacci sequence: " + fib(10));
	System.out.println("Number of times the function is called: "+ count(10) + "\n");
	count = 0;
	System.out.println("n=12");
	System.out.println("Number in fibonacci sequence: " + fib(12));
	System.out.println("Number of times the function is called: "+ count(12) + "\n");
	count = 0;
	System.out.println("n=14");
	System.out.println("Number in fibonacci sequence: " + fib(14));
	System.out.println("Number of times the function is called: "+ count(14) +"\n");
	count = 0;
	System.out.println("n=16");
	System.out.println("Number in fibonacci sequence: " + fib(16));
	System.out.println("Number of times the function is called: "+ count(16)+ "\n");
    }
}
