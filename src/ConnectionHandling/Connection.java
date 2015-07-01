package ConnectionHandling;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Connection {

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    //temporary data with addresses, ports and messages to be sent
    final String ADDRESS = "127.0.0.1";
    final int portNumber = 12345;

    public void EstablishConnection()
            throws IOException{

        socket = new Socket(ADDRESS, portNumber);
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataInputStream = new DataInputStream(socket.getInputStream());
    }

    public void sendMessage()
            throws IOException{

        dataOutputStream.writeChars("Hello world!");
        dataOutputStream.flush();
    }

    public String receiveMessage()
            throws IOException{

        return dataInputStream.readUTF();
    }

    public void endConnection()
            throws IOException{
        dataOutputStream.close();
        dataInputStream.close();
        socket.close();
    }
}
