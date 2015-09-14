package Orders.Factories;

import Exceptions.*;
import Orders.*;

import java.io.BufferedReader;
import java.io.PrintWriter;

public abstract class OrderFactory {
    public static OrderFactory getFactory(String factory)
            throws BadOrderException{
        if(factory.equalsIgnoreCase("welcome"))
            return new OrderWelcomeFactory();
        else if (factory.equalsIgnoreCase("send file"))
            return new OrderSendFileFactory();
        else throw new BadOrderException();
    }

    public abstract Order createOrder(BufferedReader br, PrintWriter pr);
}
