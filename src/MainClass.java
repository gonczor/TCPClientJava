import java.io.IOException;
import java.net.*;
import ConnectionHandling.*;

public class MainClass {

    public static void main(String[] args){

        Connection connection = new Connection();

        try{
            connection.EstablishConnection();
            connection.sendMessage();
            connection.endConnection();
        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("End");
        }
    }
}
