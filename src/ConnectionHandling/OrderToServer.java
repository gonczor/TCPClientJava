package ConnectionHandling;

public class OrderToServer {

    Order order;

    public OrderToServer(OrderList orderList)
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

    public static String showAvailableOrders(){

        String availableOrders = new String();

        for(OrderList ol : OrderList.values()){

            availableOrders += ol.toString();
            availableOrders += "\n";
        }

        return availableOrders;
    }

    interface Order{}

    class OrderWelcomeMessage
            implements Order{

        public String toString(){
            return "Hello world!";
        }
    }
}