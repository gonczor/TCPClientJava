
import java.io.IOException;
import java.net.*;
import ConnectionHandling.*;
import Interface.*;

public class MainClass {

    Connection connection;
    InterfaceInput interfaceInput;

    public static void main(String[] args){

        MainClass mainClass = new MainClass();


        try{

            mainClass.setupClient(mainClass);
            mainClass.handleConnection();
        } catch (UnknownHostException e) {

            InterfaceMessages.errorMessages(e);
        }  catch (IOException e) {

            InterfaceMessages.errorMessages(e);
        } finally {

            System.out.println("End");
        }
    }

    void setupClient(MainClass mainClass)
            throws IOException{

        mainClass.connection = new Connection();
        mainClass.interfaceInput = new InterfaceInput();
        connection.EstablishConnection();
        InterfaceMessages.connectionOK(connection);
    }

    void handleConnection()
            throws IOException{

        boolean reiterateAfterBadOrderEntry;

        InterfaceMessages.initialMessage();

        do{
            reiterateAfterBadOrderEntry = false;
            try{

                handleOrder();
                //TODO create the handling of received data
                System.out.println(connection.receiveMessage());
                handleDataReceiving();
            } catch (BadOrderException e){

                InterfaceMessages.errorMessages(e);
                reiterateAfterBadOrderEntry = true;
            }
        } while (reiterateAfterBadOrderEntry);

        connection.endConnection();
    }

    void handleOrder()
            throws IOException, BadOrderException {

        String receivedOrder = new String();

        OrderList orderFromList = interpretOrderFromUser(receivedOrder);

        if (showListChosen(orderFromList)){

            System.out.println(Order.giveListOfAvailableOrders());
            orderFromList = interpretOrderFromUser(receivedOrder);
        }

        connection.setOrderFromOrderList(orderFromList);
        connection.sendOrder();
    }

    private OrderList interpretOrderFromUser(String receivedOrder)
            throws IOException, BadOrderException{
        receivedOrder = interfaceInput.getOrder();
        return Order.stringToOrderList(receivedOrder);
    }

    private boolean showListChosen(OrderList orderList){

        return orderList == OrderList.LIST;
    }

    /*
    Description of algorithm:
    1. The server sends message saying what it will do next. This is to
    prevent unexpected behavior if the order was interpreted wrong.
    2. At this level an exception can be thrown to be handled and send or
    insert order by user again
    3. Then the server performs ordered action: sends message, file or specified data.
     */

    private void handleDataReceiving()
            throws IOException, BadOrderException {

        try {
            connection.checkInitialMessage();
            connection.receiveData();
        }
        catch (BadFeedbackOrderFromServer e){

            //TODO this needs to close connection not receiving any data
            //but not end the whole programme
            connection.endConnection();
            InterfaceMessages.errorMessages(e);
        }
    }


    //TODO temporarily unavailable. To be implemented in final version
    /*
    private boolean exitChosen(OrderList orderList){

        return orderList == OrderList.EXIT;
    }*/
}
