
import java.io.IOException;
import java.net.*;
import ConnectionHandling.*;
import Interface.*;
//import com.sun.jmx.remote.util.OrderClassLoaders;

public class MainClass {

    public static void main(String[] args){

        Connection connection = new Connection();

        try{

            setupNewConnection(connection);
            handleConnection(connection);
        } catch (UnknownHostException e) {

            System.err.println(e.getMessage());
        }  catch (IOException e) {

            System.err.println(e.getMessage());
        } finally {

            System.out.println("End");
        }
    }

    static void setupNewConnection(Connection connection)
            throws IOException{
        connection.EstablishConnection();
        InterfaceMessages.connectionOK(connection);
    }

    static void handleConnection(Connection connection)
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
        connection.sendOrder();
        receivedOrder = InterfaceInput.getOrder();
        //TODO get rid of these temporary solutions
        do{
            reiterateAfterBadOrderEntry = false;
            try{

                connection.setNewOrderToSend(OrderList.WELCOME);
                //set new order
            } catch (NoSuchOrderException e){

                System.err.println(e.getMessage());
                reiterateAfterBadOrderEntry = true;
            }finally {

                connection.endConnection();
            }
        }while (reiterateAfterBadOrderEntry);


        //System.out.println(connection.receiveMessage());
    }
}
