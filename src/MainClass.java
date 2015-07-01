<<<<<<< HEAD
public class MainClass {
    public static void main(String[] args){

        System.out.print("Starting out job.");
=======
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
>>>>>>> 2df532c0e77e3180952d9f464ad3266c12a17884
    }
}
