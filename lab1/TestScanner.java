import java.util.Scanner;
public class TestScanner {
    public static void main(String[] args) {
    Scanner myscan = new Scanner(System.in);
    int integer1, integer2;
    System.out.println("Please enter two integers!");
    integer1 = myscan.nextInt();
    integer2 = myscan.nextInt();
    System.out.println("The two integers you entered are:" + integer1 + " " + integer2);
    System.out.println("Please enter two decimal numbers!");
    float  float1, float2;
    float1 = myscan.nextFloat();
    float2 = myscan.nextFloat();
    float  average = (float1 + float2)/(2);
    System.out.println("Your two decimals are:" + float1 + " " + float2);
    System.out.println("Your average for those numbers is:" + average);
    }
}
