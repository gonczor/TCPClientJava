package ConnectionHandling;

public class Order {

    OrderFromList orderFromList;

    public Order(OrderList orderList)
            throws NoSuchOrderException{

        /*
         * only orders that have anything to do with communication
         * with server are dealt with here
         */

        switch (orderList) {
            case WELCOME:
                orderFromList = new OrderWelcomeMessage();
                break;
            case SEND_FILE:
                orderFromList = new OrderSendFile();
                break;
        }
    }

    public static OrderList stringToOrderList(String orderString)
            throws NoSuchOrderException{

        if (orderString.equalsIgnoreCase("welcome"))
            return OrderList.WELCOME;
        else if (orderString.equalsIgnoreCase("send file"))
            return OrderList.SEND_FILE;
        else if (orderString.equalsIgnoreCase("l"))
            return OrderList.LIST;
        else
            throw new NoSuchOrderException();

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

    //TODO
    //I don't know whether this is best approach
    //I fear that the names are misleading
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