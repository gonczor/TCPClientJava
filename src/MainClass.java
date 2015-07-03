import java.io.IOException;
import java.net.*;
import ConnectionHandling.*;
import Interface.InitialisationMessages;
import Interface.NoSuchOrderException;
import Interface.OrderList;

public class MainClass {

    public static void main(String[] args){

        Connection connection = new Connection();

        try{

            handleNewConnectionCreation(connection);
            connection.setNewMessageToSend(OrderList.WELCOME);
            handleExistingConnection(connection);

        } catch (UnknownHostException e) {

            System.err.println(e.getMessage());
        } catch (NoSuchOrderException e) {

            System.err.println(e.getMessage());
        } catch (IOException e) {

            System.err.println(e.getMessage());
        } finally {

            System.out.println("End");
        }
    }

    static void handleNewConnectionCreation (Connection connection)
            throws IOException{
        connection.EstablishConnection();
        InitialisationMessages.connectionOK(connection);
    }

    static void handleExistingConnection(Connection connection)
            throws IOException{
        connection.sendMessage();
        connection.endConnection();
    }
}
