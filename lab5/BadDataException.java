// Nick Miller and Minh Duc Nguyen
// BadDataException.java
// Lab 5
// Runs as expected when used in Rational.java
public class BadDataException extends RuntimeException {
    public BadDataException() {
	super();
    }
    public BadDataException(String message) {
	super(message);
    }
}
