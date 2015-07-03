package Interface;

public class NoSuchOrderException
        extends Exception {
    @Override
    public String getMessage(){

        return "No such order.";
    }
}
