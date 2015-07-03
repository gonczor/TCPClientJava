package ConnectionHandling;

import Interface.NoSuchOrderException;

public class Message {

    Order order;

    public Message(OrderList orderList)
            throws NoSuchOrderException{

        switch (orderList) {
            case WELCOME:
                order = new OrderWelcomeMessage();
                break;

            default:
                throw new NoSuchOrderException();
        }
    }

    public String sendOrderToServer(){

        return order.toString();
    }

    interface Order{

    }

    class OrderWelcomeMessage
            implements Order{

        public String toString(){
            return "Hello world!";
        }
    }
}