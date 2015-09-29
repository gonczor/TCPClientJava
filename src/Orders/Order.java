package Orders;

import Exceptions.BadFeedbackOrderFromServer;

import java.io.*;

/*
Note:
Since the programme allows user to list the available orders
and java doesn't have standard mechanisms for listing all inheriting
classes, the list of available orders is stored in enum in OrderList.
Remember to add new order to the enum after creating one.
 */

public abstract class Order {
    protected String order;
    protected DataInputStream dataInputStream;
    protected DataOutputStream dataOutputStream;
    protected BufferedReader bufferedReader;
    protected PrintWriter printWriter;

    public Order(DataOutputStream os, DataInputStream is){
        this.dataInputStream = is;
        this.dataOutputStream = os;
        bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
        printWriter = new PrintWriter(dataOutputStream, true);
    }

    public void sendOrder(){
        printWriter.print(order);
        printWriter.flush();
    }

    protected void checkFeedbackMessage()
            throws IOException, BadFeedbackOrderFromServer{
        if(!order.equalsIgnoreCase(receiveMessage()))
            throw new BadFeedbackOrderFromServer();
    }

    protected String receiveMessage() throws IOException{

    return bufferedReader.readLine();
    }

    public String toString(){
        return order;
    }

    public abstract int getSizeOfDataTransferred();

    public abstract void handleDataTransfer()
            throws IOException, BadFeedbackOrderFromServer;

}
