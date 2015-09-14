package Orders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class OrderWelcome extends Order{
    public OrderWelcome(BufferedReader br, PrintWriter pr){
        super(br, pr);
        order = "welcome";
    }

    public void receiveMessage() throws IOException {
        System.out.println(bufferedReader.readLine());
    }

    public String toString(){
        return order;
    }
}
