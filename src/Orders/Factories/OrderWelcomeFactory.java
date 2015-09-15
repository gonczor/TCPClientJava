package Orders.Factories;

import Orders.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class OrderWelcomeFactory extends OrderFactory {

    public Order createOrder(DataOutputStream os, DataInputStream is){
        return new OrderWelcome(os, is);
    }
}
