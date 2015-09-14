import java.io.IOException;
import java.net.*;
import ConnectionHandling.*;
import Exceptions.*;
import Interface.*;
import Orders.*;
import Orders.Factories.OrderFactory;

public class MainClass {

    static Connection connection;
    static InterfaceInput interfaceInput;

    public static void main(String[] args){

        MainClass mainClass = new MainClass();

        try{

            mainClass.setupClient();
            mainClass.handleConnection();
        }  catch (IOException e) {

            InterfaceMessages.errorMessages(e);
        } finally {

            System.out.println("End");
        }
    }

    void setupClient()
            throws IOException{

        connection = new Connection();
        interfaceInput = new InterfaceInput();
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

                Order order = getOrder();
                order.sendOrder();
                order.receiveMessage();
            } catch (BadOrderException e){

                InterfaceMessages.errorMessages(e);
                reiterateAfterBadOrderEntry = true;
            }
        } while (reiterateAfterBadOrderEntry);

        connection.endConnection();
    }

    Order getOrder() throws IOException, BadOrderException{
        String orderFromUser = interfaceInput.getOrder();
        OrderFactory orderFactory = OrderFactory.getFactory(orderFromUser);
        return orderFactory.createOrder(connection.getBufferedReader(), connection.getPrintWriter());
    }
}
