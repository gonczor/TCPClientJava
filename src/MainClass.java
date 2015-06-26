import java.net.*;

public class MainClass {

    static String ADDRESS = "127.0.0.1";

    public static void main(String[] args){
        try{

            Socket mySocket = new Socket(ADDRESS, 12345);
            System.out.println(mySocket.getInetAddress());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
