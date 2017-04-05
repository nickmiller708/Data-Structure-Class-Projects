public class BadExpressionExtension extends RuntimeException {
    public BadExpressionExtension() {
	super();
    }
    public BadExpressionExtension(String message){
	super(message);
    }
}
