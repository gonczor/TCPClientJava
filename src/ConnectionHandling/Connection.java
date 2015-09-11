package ConnectionHandling;

import java.io.*;
import java.net.*;

public class Connection {

    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;

    private final String ADDRESS = "127.0.0.1"; //192.168.1.2
    private final Integer portNumber = 12345;

    public void EstablishConnection()
            throws IOException{

        socket = new Socket(ADDRESS, portNumber);
        printWriter = new PrintWriter(socket.getOutputStream(), true);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void sendOrder()
            throws IOException{

        printWriter.print(OrderList.getChosenOrderContent());
        printWriter.flush();
    }

    public String receiveMessage()
            throws IOException{

        String receivedMessage;
        receivedMessage = bufferedReader.readLine();
        return receivedMessage;
    }

    public void checkInitialMessage()
            throws IOException, BadOrderException {

        String receivedFeedbackMessage = receiveMessage();
        System.out.println("received: " + receivedFeedbackMessage);
        OrderList receivedFeedbackOrder = OrderList.stringToOrderList(receivedFeedbackMessage);

        if (!receivedFeedbackOrder.equals(OrderList.getChosenOrder())){
            throw new BadFeedbackOrderFromServer();
        }
    }

    /*
    Since the correctness of received order has been checked
    passing orders entered by user is possible and safe.
    */
    public void receiveData(){


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
