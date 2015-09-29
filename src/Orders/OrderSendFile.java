package Orders;

import Exceptions.BadFeedbackOrderFromServer;

import java.io.*;

public class OrderSendFile extends Order {

    protected final String dataFileName = "Data file";
    protected int bytesRead = 0;
    protected int fileSize = 0;
    protected byte [] fileData;

    public OrderSendFile(DataOutputStream os, DataInputStream is){

        super(os, is);
        order = "send_file";
    }

    public void handleDataTransfer() throws IOException, BadFeedbackOrderFromServer{

        checkFeedbackMessage();
        downloadFile();
        saveFile();
    }

    public int getSizeOfDataTransferred(){

        return getDownloadedFileSize();
    }

    protected void downloadFile() throws IOException{

        fileSize = getFileSize();
        fileData = new byte[fileSize];
        bytesRead = dataInputStream.read(fileData);
    }

    protected int getFileSize() throws IOException{

        String sizeString = bufferedReader.readLine();
        return Integer.parseInt(sizeString);
    }

    protected void saveFile() throws IOException{

        FileOutputStream fileOutputStream = new FileOutputStream(dataFileName);
        fileOutputStream.write(fileData);
        fileOutputStream.flush();
    }

    protected int getDownloadedFileSize(){

        return bytesRead;
    }
}
