package Interface;

import ConnectionHandling.Connection;

public class InitialisationMessages {

    public static void connectionOK(Connection connection) {

        PrintStatements.print("Connection established with:");
        PrintStatements.print("Host: " + connection.getHostAddress());
        PrintStatements.print("On port: " + connection.getPortNumber());
    }
}
