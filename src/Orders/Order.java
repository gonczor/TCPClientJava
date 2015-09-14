package Orders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Order {
    protected String order;
    protected BufferedReader bufferedReader;
    protected PrintWriter printWriter;

    public Order(BufferedReader br, PrintWriter pr){
        this.bufferedReader = br;
        this.printWriter = pr;
    }

    public void sendOrder(){
        printWriter.print(order);
        printWriter.flush();
    }

    public abstract void receiveMessage() throws IOException;
    public abstract String toString();
}
