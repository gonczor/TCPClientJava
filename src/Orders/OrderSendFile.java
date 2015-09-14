package Orders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class OrderSendFile extends Order {

    public OrderSendFile(BufferedReader br, PrintWriter pr){
        super(br, pr);
        order = "send file";
    }

    public void receiveMessage() throws IOException{
        System.out.println(bufferedReader.readLine());
    }

    public String toString(){
        return order;
    }
}
