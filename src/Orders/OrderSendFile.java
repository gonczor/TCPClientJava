package Orders;

import Exceptions.BadFeedbackOrderFromServer;

import java.io.*;

public class OrderSendFile extends Order {

    public OrderSendFile(DataOutputStream os, DataInputStream is){
        super(os, is);
        order = "send_file";
    }

    public void handleDataTransfer() throws IOException, BadFeedbackOrderFromServer{

        checkFeedbackMessage();
        downloadFile();
    }

    protected void downloadFile(){

    }
}
