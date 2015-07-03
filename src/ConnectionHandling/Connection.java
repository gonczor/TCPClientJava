package ConnectionHandling;

import java.io.*;
import java.net.*;

public class Connection {

    //TODO
    //test image sending

    private Socket socket;
    private PrintWriter printWriter;
    private Message message;

    private final String ADDRESS = "127.0.0.1";
    private final Integer portNumber = 12345;

    public void EstablishConnection()
            throws IOException{

        socket = new Socket(ADDRESS, portNumber);
        printWriter = new PrintWriter(socket.getOutputStream(), true);
    }

    public void setNewMessageToSend(OrderList orderList)
            throws NoSuchOrderException{
        message = new Message(orderList);
    }

    public void sendMessage()
            throws IOException{

        printWriter.println(message.sendOrderToServer());
    }

    public String receiveMessage()
            throws IOException{

        //TODO
        //temporary solution
        return "Message"; //dataInputStream.readUTF();
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
