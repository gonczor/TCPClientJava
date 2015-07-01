package ConnectionHandling;

import java.io.*;
import java.net.*;

public class Connection {

    //TODO
    //choose format to send messages
    //TODO
    //test image sending

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private PrintWriter printWriter;
    private ObjectOutputStream objectOutputStream;

    //temporary data with addresses, ports and messages to be sent
    final String ADDRESS = "127.0.0.1";
    final int portNumber = 12345;

    public void EstablishConnection()
            throws IOException{

        socket = new Socket(ADDRESS, portNumber);
        printWriter = new PrintWriter(socket.getOutputStream(), true);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        //dataOutputStream = new DataOutputStream(socket.getOutputStream());
        //dataInputStream = new DataInputStream(socket.getInputStream());
    }

    public void sendMessage()
            throws IOException{

        objectOutputStream.writeChars("Hello world!");
        objectOutputStream.flush();
        //printWriter.println("Hello world!");
        //dataOutputStream.writeUTF("Hello world!");
        //dataOutputStream.flush();
    }

    public String receiveMessage()
            throws IOException{

        return dataInputStream.readUTF();
    }

    public void endConnection()
            throws IOException{
        //dataOutputStream.close();
        //dataInputStream.close();
        //printWriter.close();
        objectOutputStream.close();
        socket.close();
    }
}
