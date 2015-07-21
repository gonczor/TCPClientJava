package ConnectionHandling;

import java.io.*;
import java.net.*;

public class Connection {

    //TODO
    //test image sending

    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;
    private OrderToServer orderToServer;

    private final String ADDRESS = "127.0.0.1"; //192.168.1.2
    private final Integer portNumber = 12345;

    public void EstablishConnection()
            throws IOException{

        socket = new Socket(ADDRESS, portNumber);
        printWriter = new PrintWriter(socket.getOutputStream(), true);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void setNewOrderToSend(OrderList orderList)
            throws NoSuchOrderException{
        orderToServer = new OrderToServer(orderList);
    }

    public void sendOrder()
            throws IOException{

        printWriter.println(orderToServer.sendOrderToServer());
    }

    public String receiveMessage()
            throws IOException{

        String receivedMessage;
        receivedMessage = bufferedReader.readLine();
        return receivedMessage;
    }

    public void endConnection()
            throws IOException{

        printWriter.close();
        socket.close();
    }

    public String getHostAddress(){
        return ADDRESS;
    }

    public String getPortNumber(){
        return portNumber.toString();
    }
}
