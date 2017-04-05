import ch01.Date;
import java.util.Scanner;
public class TestDate {
    public static void main(String[]arg){
	int month, day, year;
	int birthmonth, birthday, birthyear;
	Scanner myscan = new Scanner(System.in);
	System.out.println("Please enter Today's  date like 01 23 2015!");
	month = myscan.nextInt();
	day = myscan.nextInt();
	year = myscan.nextInt();
	Date Today = new Date(month, day, year);
	System.out.println("Please enter your birthday like 03 06 1995!");
	birthmonth = myscan.nextInt();
	birthday = myscan.nextInt();
	birthyear = myscan.nextInt();
	Date Birthdate= new Date(birthmonth, birthday, birthyear);
	System.out.println("Today's Date is: " + Today.toString());
	System.out.println("Your birthday is: " + Birthdate.toString());
    }
}
