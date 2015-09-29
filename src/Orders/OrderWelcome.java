package Orders;

import Interface.InterfaceMessages;

import java.io.*;

public class OrderWelcome extends Order{
    public OrderWelcome(DataOutputStream os, DataInputStream is){
        super(os, is);
        order = "welcome";
    }

    public void handleDataTransfer() throws IOException {
        InterfaceMessages.showReceivedMessage(bufferedReader.readLine());
    }

    public int getSizeOfDataTransferred() {
        return 0;
    }
}
