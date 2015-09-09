package Interface;

import ConnectionHandling.Connection;

public class InterfaceMessages {

    public static void connectionOK(Connection connection) {

        PrintStatements.print("Connection established with:");
        PrintStatements.print("Host: " + connection.getHostAddress());
        PrintStatements.print("On port: " + connection.getPortNumber());
    }

    public static void initialMessage(){

        PrintStatements.print("Please enter order, or type in \'l\' to list available orders");
    }

    public static void errorMessages(Exception e){

        System.err.println(e.getMessage());
    }
}
