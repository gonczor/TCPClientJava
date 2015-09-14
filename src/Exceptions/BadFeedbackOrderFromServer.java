package Exceptions;

public class BadFeedbackOrderFromServer
        extends BadOrderException {

    @Override
    public String getMessage(){

        return "Error occurred while checking order from server.\nConnection shut down.";
    }
}
