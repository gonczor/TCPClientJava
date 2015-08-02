
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
        /*
        TODO
        user gets welcome message and is asked to type in order, or press l to list available orders
        [orders displayed]
        order read
        if no such order exception, order to type in again
        if exit, then return
        otherwise send order to server
        handle connection
         */
        String receivedOrder;
        boolean reiterateAfterBadOrderEntry;

        InterfaceMessages.initialMessage();

        receivedOrder = interfaceInput.getOrder();
        //TODO get rid of these temporary solutions
        do{
            reiterateAfterBadOrderEntry = false;
            try{

                connection.setNewOrderToSend(OrderList.WELCOME);
                connection.sendOrder();
            } catch (NoSuchOrderException e){

                System.err.println(e.getMessage());
                reiterateAfterBadOrderEntry = true;
            }finally {

                System.out.println(connection.receiveMessage());
                connection.endConnection();
            }
        }while (reiterateAfterBadOrderEntry);

    }
}
