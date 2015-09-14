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

    public BufferedReader getBufferedReader(){
        return bufferedReader;
    }

    public PrintWriter getPrintWriter(){
        return printWriter;
    }
}
