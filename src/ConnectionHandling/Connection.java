package ConnectionHandling;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

public class Connection {

    //TODO
    //find in documentation what's wrong with dataOutputStream
    //and why only printWriter works

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private PrintWriter printWriter;

    //temporary data with addresses, ports and messages to be sent
    final String ADDRESS = "127.0.0.1";
    final int portNumber = 12345;
    String messageToSend = "Hello world!";

    public void EstablishConnection()
            throws IOException{

        socket = new Socket(ADDRESS, portNumber);
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        printWriter = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendMessage()
            throws IOException{

        //dataOutputStream.writeUTF(messageToSend);
        //dataOutputStream.flush();
        printWriter.println("Hello hello!");
    }

    public void endConnection()
            throws IOException{
        socket.close();
        dataOutputStream.close();
        printWriter.close();
    }
}
