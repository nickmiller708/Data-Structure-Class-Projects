import ch06.lists.*;
public class StreetAddress implements Comparable<StreetAddress> {
    int numofStreet;
    String nameofStreet;
    public StreetAddress(int num, String name){
	numofStreet = num;
	nameofStreet = name;
    }
    public int getNum() {
	return numofStreet;
    }
    public String getString() {
	return nameofStreet;
    }
    public boolean equals(Object o){
	StreetAddress test = (StreetAddress) o;
	boolean returner = false;
	if ((test.getNum() == numofStreet) && (nameofStreet.equals(test.getString())))
	    returner = true;
	return returner;
    }
    public int compareTo(StreetAddress t) {
	if (nameofStreet.compareTo(t.getString()) == 0) {
	    return numofStreet-t.getNum();
	}
	else {
	    return nameofStreet.compareTo(t.getString());
	}
    }
    public String toString() {
	String returns = "This person lives at: " + numofStreet + " " + nameofStreet;
	return returns;
    }
    public static void main(String[] args) {
	StreetAddress mine = new StreetAddress(416, "English Oaks Drive");
	StreetAddress yours = new StreetAddress(417, "English Oaks Drive");
	System.out.println(mine.equals(yours));
	System.out.println(mine.compareTo(yours));
	System.out.println(yours.compareTo(mine));
	System.out.println(mine);
	System.out.println(yours);
    }
}
