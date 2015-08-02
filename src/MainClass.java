
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

            System.err.println(e.getMessage());
        }  catch (IOException e) {

            System.err.println(e.getMessage());
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
                System.out.println(connection.receiveMessage());
            } catch (NoSuchOrderException e){

                System.err.println(e.getMessage());
                reiterateAfterBadOrderEntry = true;
            }
        } while (reiterateAfterBadOrderEntry);

        connection.endConnection();
    }

    void handleOrder()
            throws IOException, NoSuchOrderException{

        String receivedOrder;

        receivedOrder = interfaceInput.getOrder();
        OrderList orderFromList = Order.stringToOrderList(receivedOrder);

        if (showListChosen(orderFromList)){

            System.out.println(Order.showAvailableOrders());
            receivedOrder = interfaceInput.getOrder();
            orderFromList = Order.stringToOrderList(receivedOrder);
        }

        connection.setNewOrderToSend(orderFromList);
        connection.sendOrder();

    }

    private boolean showListChosen(OrderList orderList){

        return orderList == OrderList.LIST;
    }

    //TODO temporarily unavailable. To be implemented in final version
    /*
    private boolean exitChosen(OrderList orderList){

        return orderList == OrderList.EXIT;
    }*/
}
