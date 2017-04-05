// This is the appointment class for project 1
// Made by Nick Miller
// Assistance by: No one
import ch01.Date;
public class Appt {
    protected Date apptdate;
    protected Time appttime;
    protected String apptreason;
    public Appt (Date date, String reason, Time time) {
	apptdate = date;
	apptreason = reason;
	appttime = time;
    }
    public Time getTime() {
	return appttime;
    }
    public Date getDate() {
	return apptdate;
    }
    public String getPurpose() {
	return apptreason;
    }
    public String toString() {
	String thing = "Your reason for the appointment is : " + apptreason + " \n Your time is: " + appttime + " \n Your date is: " + apptdate;
	return thing;
    }
    public static void main(String[] args) {
	Date thing = new Date(12,12,2015);
	Time thing1 = new Time(12,45);
	String purpose = "Test is today! Need to Study!";
	Appt appointment = new Appt(thing, purpose, thing1);
	System.out.println("This will show the time of the appointment 12:45 p.m        " + "\n" + appointment.getTime());
	System.out.println("This will show the purpose of the visit.  " + "\n" + appointment.getPurpose());
	System.out.println("This will show the date of the visit: 12/12/2015." + "\n" + appointment.getDate());
	System.out.println("This will show the toString() function");
	System.out.println(appointment);
	System.out.println("Testing complete!");
    }
}
