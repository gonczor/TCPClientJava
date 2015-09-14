package Orders.Factories;

import Orders.*;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class OrderSendFileFactory extends OrderFactory {

    public Order createOrder(BufferedReader br, PrintWriter pr){
        return new OrderSendFile(br, pr);
    }
}
