//IncDate Lab3: by Nick Miller and Dongwei Fu
import ch01.Date;
public class IncDate extends Date {
    public IncDate(int newmonth, int newday, int newyear) {
	super(newmonth, newday, newyear);
    }
    public String toString() {
	String returns = "I'm an IncDate!  " + super.toString();
	return returns;
    }
    public void increment() {
	//Increments only to the next day!
	boolean leapyear;
		if ((year%4 == 0) && (year%100 != 0)){
	    leapyear = true;}
	else if (year%400 == 0) {
	    leapyear = true;}
	else  {
	    leapyear = false;}
	switch (month){
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
		if (day < 31) {
		    day = day+ 1;
		}
		else if ((day == 31) && (month == 12)) {
		    day = 1;
		    month = 1;
		    year = year + 1;
		}
		else if (day == 31) {
		    day = 1;
		    month = month + 1; }
		break;
	case 2:
		if (leapyear == true) {
		    if (day <29) {
			day = day + 1;
		    }
		    else if (day == 29) {
			day = 1;
			month = month + 1;}
		}
		else if (leapyear == false) {
		    if (day < 28) {
			day = day + 1;}
		    else if (day == 28) {
			day = 1;
			month = month + 1;}
		}
		break;
	case 4:
	case 6:
	case 9:
	case 11:
		if (day < 30) {
		    day= day + 1;
		}
		else if (day == 30) {
		    day = 1;
		    month= month + 1;
		}
		break;
	    
	    }
    }
    public void increment(int nDays) {
	boolean leapyear;
	if ((year%4 == 0) && (year%100 != 0)){
	    leapyear = true;}
	else if (year%400 == 0) {
	    leapyear = true;}
	else  {
	    leapyear = false;}
	while (nDays != 0) {
	    switch (month){
	    case 1:
	    case 3:
	    case 5:
	    case 7:
	    case 8:
	    case 10:
	    case 12:
		if (day < 31) {
		    day = day + 1;
		}
		else if ((day == 31) && (month == 12)) {
		    day = 1;
		    month = 1;
		    year = year + 1;
		}
		else if (day == 31) {
		    day= 1;
		    month = month + 1; }
		break;
	    case 2:
		if (leapyear == true) {
		    if (day <29) {
			day = day + 1;
		    }
		    else if (day == 29) {
			day = 1;
			month = month + 1;}
		}
		else if (leapyear == false) {
		    if (day < 28) {
			day = day + 1;}
		    else if (day == 28) {
			day = 1;
			month = month + 1;}
		}
		break;
	    case 4:
	    case 6:
	    case 9:
	    case 11:
		if (day < 30) {
		    day = day + 1;
		}
		else if (day == 30) {
		    day= 1;
		    month= month + 1;
		}
		break;
	    }
	    nDays = nDays -1;
	}
    }
    public static void main(String [] args){
	IncDate ans = new IncDate(12,12,2015);
	IncDate op1 = new IncDate(2,24, 2000);
	IncDate op2 = new IncDate(12,31, 2002);
	IncDate op3 = new IncDate(2,28, 2013); //not leap year
	IncDate op4 = new IncDate(2, 28, 2012); //leap year
	System.out.println(ans);
	System.out.println(op1);
	System.out.println(op2);
	System.out.println(op3);
	System.out.println(op4);
	ans.increment();
	op1.increment();
	op2.increment();
	op3.increment();
	op4.increment();
	System.out.println("Testing increment for 1 day");
	System.out.println("Expected answer: 12/13/2015 \n" + ans);
	System.out.println("Expected answer: 2/25/2000 \n" + op1);
	System.out.println("Expected answer: 1/1/2003 \n" + op2);
	System.out.println("Expected answer: 3/1/2013 \n" + op3);
	System.out.println("Expected answer: 2/29/2012 \n" + op4);
	IncDate op5 = new IncDate(1,1,2014);
	IncDate op6 = new IncDate(2,28,2013);
	IncDate op7 = new IncDate(2,29,2012);
	System.out.println("Testing increment function for nDays");
	op5.increment(7);
	op6.increment(3);
	op7.increment(5);
	System.out.println("Expected answer: 1/8/2014 \n" + op5);
	System.out.println("Expected answer: 3/3/2013 \n" + op6);
	System.out.println("Expected answer: 3/5/2012 \n" + op7);
	Date[] mylist=new Date[4];
	mylist[0]=new Date(2,3,2014);
	mylist[1]=new Date(12,31,2015);
	mylist[2]=new IncDate(2,28,2004);
	mylist[3]=new IncDate(3,31,2007);
        for (int n=0;n<=3;n++){
	    System.out.println(mylist[n]);}
	for (int n=0;n<=3;n++){
	    if ((mylist[n] instanceof IncDate)==true){
		IncDate d=(IncDate) mylist[n];
		d.increment();
		System.out.println(d);}
	}
	Date d1 = new Date(12,24,2015);
	IncDate d2 = new IncDate(1,1,2012);
	
	System.out.println("d1:  " + d1);
	System.out.println("d2:  " + d2);
	d1 = d2;
	System.out.println("d1 =d2 now");
	System.out.println("d1:  " +d1);
	System.out.println("d2:  " + d2);
	d2.increment();
	System.out.println("d1 after incrementing d2 \n" + d1);
	System.out.println("d2 after incrementing d2 \n" + d2);
	// Since d1 = d2, d1 holds the memory location of d2, which is an incdate. So, after incrementing d2 and asking to print out d1, it will print out an incremented d2. 
	// When testing an array of date and incdate objects, we went through the array to print out everything in the array. Then, we tested the instance of IncDate, so it incremented anything in the array that was an incdate and then printed tHhe incdate. The incdate will still remember that it is an incdate in the array.
    }
}
// Hello this is a comment