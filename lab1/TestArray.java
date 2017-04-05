import java.util.Scanner;
public class TestArray {
    public static void main(String[] arg) {
	int n;
	float sum, myaverage;
	Scanner myscan = new Scanner(System.in);
	float  [] numbers = new float[10];
	sum = 0;
	myaverage = 0;
      	System.out.println("Please enter 10 integers!");
	for (n= 0; n<= 9; n++)
		       {
		       numbers[n] = myscan.nextFloat();
		       }
	
	n = 0;
	for (n= 0;  n <= 9; n++) {
		sum = sum + numbers[n];
		}
	myaverage = sum/(10);
	System.out.println("Your sum is: " + sum + ". And your average is: " + myaverage);
    }
}		       
