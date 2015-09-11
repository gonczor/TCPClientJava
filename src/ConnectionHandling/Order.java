package ConnectionHandling;

public class Order {

    private OrderFromList orderFromList;

    public Order(OrderList orderList)
            throws BadOrderException {

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
            throws BadOrderException {

        if (orderString.equalsIgnoreCase("welcome"))
            return OrderList.WELCOME;
        else if (orderString.equalsIgnoreCase("send file"))
            return OrderList.SEND_FILE;
        else if (orderString.equalsIgnoreCase("l"))
            return OrderList.LIST;
        else
            throw new BadOrderException();
    }

    public String setOrderContent(){

        return orderFromList.toString();
    }

    public static String giveListOfAvailableOrders(){

        String availableOrders = new String();

        for(OrderList ol : OrderList.values()){

            availableOrders += ol.toString();
            availableOrders += "\n";
        }

        return availableOrders;
    }

    private interface OrderFromList{}

    private class OrderWelcomeMessage
            implements OrderFromList{

        public String toString(){
            return "Hello world!";
        }
    }

    private class OrderSendFile
            implements OrderFromList{

        public String toString(){
            return "Send File";
        }
    }
}