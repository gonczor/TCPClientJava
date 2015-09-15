package Orders.Factories;

import Exceptions.*;
import Orders.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public abstract class OrderFactory {
    public static OrderFactory getFactory(String factory)
            throws BadOrderException{
        if(factory.equalsIgnoreCase("welcome"))
            return new OrderWelcomeFactory();
        else if (factory.equalsIgnoreCase("send file"))
            return new OrderSendFileFactory();
        else throw new BadOrderException();
    }

    public abstract Order createOrder(DataOutputStream os, DataInputStream is);
}
