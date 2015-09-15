package Interface;

import ConnectionHandling.*;

public class InterfaceMessages {

    public static void connectionOK(Connection connection) {

        PrintStatements.print("Connection established with:");
        PrintStatements.print("Host: " + connection.getHostAddress());
        PrintStatements.print("On port: " + connection.getPortNumber());
    }

    public static void initialMessage(){

        PrintStatements.print("Please enter order. The list of available orders is following:");
        listAvailableOrders();
    }

    public static void listAvailableOrders(){
        String s = OrderList.getListOfAvailableOrders();
        PrintStatements.print(s);
    }

    public static void showReceivedMessage(String message){

        PrintStatements.print(message);
    }

    public static void errorMessages(Exception e){

        System.err.println(e.getMessage());
    }
}
