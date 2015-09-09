package ConnectionHandling;

public class BadOrderException
        extends Exception {
    @Override
    public String getMessage(){

        return "Error occurred while entering order.";
    }
}
