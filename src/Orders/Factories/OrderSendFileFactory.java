package Orders.Factories;

import Orders.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class OrderSendFileFactory extends OrderFactory {

    public Order createOrder(DataOutputStream os, DataInputStream is){
        return new OrderSendFile(os, is);
    }
}
