package ConnectionHandling;

public class BadOrderException
        extends Exception {
    @Override
    public String getMessage(){

        return "No such orderFromList.";
    }
}
