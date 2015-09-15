package ConnectionHandling;

import java.io.*;
import java.net.*;

public class Connection {

    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    private final String ADDRESS = "127.0.0.1"; //192.168.1.2
    private final Integer portNumber = 12345;

    public void EstablishConnection()
            throws IOException{

        socket = new Socket(ADDRESS, portNumber);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        printWriter = new PrintWriter(socket.getOutputStream(), true);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public boolean connectionIsClosed(){

        return socket.isClosed();
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

    public DataOutputStream getDataOutputStream(){
        return dataOutputStream;
    }

    public DataInputStream getDataInputStream(){
        return dataInputStream;
    }

    public BufferedReader getBufferedReader(){
        return bufferedReader;
    }

    public PrintWriter getPrintWriter(){
        return printWriter;
    }
}
