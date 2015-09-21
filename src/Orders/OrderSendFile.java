package Orders;

import Exceptions.BadFeedbackOrderFromServer;

import java.io.*;

public class OrderSendFile extends Order {

    protected final String dataFileName = "Data";

    public OrderSendFile(DataOutputStream os, DataInputStream is){
        super(os, is);
        order = "send_file";

    }

    public void handleDataTransfer() throws IOException, BadFeedbackOrderFromServer{

        checkFeedbackMessage();
        downloadFile();
    }

    //TODO refactor, split into separate methods
    //TODO test after the server is finished
    protected void downloadFile() throws IOException{
        //TODO check if receiving data in small packets is possible
        int fileSize = getFileSize();
        int bytesRead = 0;
        int totalNumberOfBytesRead = 0;
        byte [] fileByteArray = new byte[fileSize];

        bytesRead = dataInputStream.read(fileByteArray);
        totalNumberOfBytesRead += bytesRead;
        if (noMoreDataToReceive(bytesRead)){
            System.out.println("Received " + totalNumberOfBytesRead + "bytes.\n");
        }

        FileOutputStream fileOutputStream = new FileOutputStream(dataFileName);
        fileOutputStream.write(fileByteArray);
        fileOutputStream.flush();
    }

    protected int getFileSize() throws IOException{
        String sizeString = bufferedReader.readLine();
        return Integer.parseInt(sizeString);
    }

    protected boolean noMoreDataToReceive(int check){
        return check == -1;
    }
}
