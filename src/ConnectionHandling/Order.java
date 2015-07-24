package ConnectionHandling;

public class Order {

    OrderFromList orderFromList;

    public Order(OrderList orderList)
            throws NoSuchOrderException{

        switch (orderList) {
            case WELCOME:
                orderFromList = new OrderWelcomeMessage();
                break;
            case SENDFILE:
                orderFromList = new OrderSendFile();
                break;
            default:
                throw new NoSuchOrderException();
        }
    }

    public String sendOrderToServer(){

        return orderFromList.toString();
    }

    public static String showAvailableOrders(){

        String availableOrders = new String();

        for(OrderList ol : OrderList.values()){

            availableOrders += ol.toString();
            availableOrders += "\n";
        }

        return availableOrders;
    }

    abstract class OrderFromList{}

    class OrderWelcomeMessage
            extends OrderFromList{

        public String toString(){
            return "Hello world!";
        }
    }

    class OrderSendFile
            extends OrderFromList{

        public String toString(){
            return "Send File";
        }
    }
}