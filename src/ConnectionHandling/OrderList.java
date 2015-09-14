package ConnectionHandling;

public enum OrderList {

    WELCOME,
    SEND_FILE,
    LIST;

    public static String getListOfAvailableOrders(){

        String availableOrders = "";

        for(OrderList ol : OrderList.values()){

            availableOrders += ol.toString();
            availableOrders += "\n";
        }

        return availableOrders;
    }
}
