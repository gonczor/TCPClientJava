package ConnectionHandling;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Connection {

    private Socket socket;
    private DataOutputStream dataOutputStream;

    //temporary data with addresses, ports and messages to be sent
    final String ADDRESS = "127.0.0.1";
    final int portNumber = 12345;

    public void EstablishConnection()
            throws IOException{

        socket = new Socket(ADDRESS, portNumber);
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    public void sendMessage()
            throws IOException{

        dataOutputStream.writeChars("Hello world!");
        dataOutputStream.flush();
    }

    public void endConnection()
            throws IOException{
        dataOutputStream.close();
        socket.close();
    }
}
