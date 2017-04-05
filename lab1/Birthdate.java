// Birthdate Assignment by Nick Miller
// Worked primarily on my own, but did get some help from Minh Duc Thuong Nguyen (Luke) to check over my code

import ch01.Date;
import java.util.Scanner;
import java.lang.Math;
public class Birthdate {
    protected  Date theDate;
    public Birthdate (int month, int day, int year) {
	Date bdate;
	bdate = new Date(month, day, year);
	theDate = bdate;
    }
    public String ToString() {
	return ("Your birthday is:"+theDate.getMonth()+"/"+theDate.getDay()+"/"+theDate.getYear());
	    }
    public int  daysToBDate(Date today)
    {
	Date thisyear = new Date(theDate.getMonth(), theDate.getDay(), today.getYear());
	Date nextbirthday = new Date(theDate.getMonth(), theDate.getDay(), today.getYear() + 1);
	int returndate;
	int liliantoday, liliannext, lilianthisbirth;
	liliantoday = today.lilian();
	liliannext = nextbirthday.lilian();
	lilianthisbirth = thisyear.lilian();
	//need to calculate the lilian for all.
	returndate = 0;
       	if (liliantoday < lilianthisbirth)
	    returndate = (lilianthisbirth - liliantoday);
	else if (liliantoday > lilianthisbirth)
	    returndate = -(liliannext -liliantoday);
	else if (liliantoday == lilianthisbirth)
	    returndate =  0;
	return returndate;
    }
    public static  void main (String[] args)  {
	int day,month, year;
	Scanner myscan = new Scanner(System.in);
	System.out.println("Please enter your birthday like 03 06 1995");
	month = myscan.nextInt();
	day = myscan.nextInt();
	year = myscan.nextInt();
	Birthdate myBirthday = new Birthdate(month, day, year);
	int todayday, todaymonth, todayyear;
	System.out.println("Please enter today's date lke 09 23 2016");
	todaymonth = myscan.nextInt();
	todayday = myscan.nextInt();
	todayyear = myscan.nextInt();
	Date todaydate = new Date(todaymonth, todayday, todayyear);
	System.out.println("  ");
	int days;
	days = 0;
	days = myBirthday.daysToBDate(todaydate);
	if (days < 0)
	    System.out.println("there will be" + Math.abs(days)+ " days until your next birthday!");
	else if (days > 0)
	    System.out.println("Your birthday will be in " +days+ " days!");
	else if (days == 0)
	    System.out.println("Happy Birthday!!!");
    }
}
