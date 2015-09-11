package ConnectionHandling;


public enum OrderList {

    WELCOME,
    SEND_FILE,
    LIST;

    private static OrderList chosenOrder;

    public static OrderList getChosenOrder(){
        return chosenOrder;
    }

    public static String getChosenOrderContent(){
        return chosenOrder.toString();
    }

    public static void setOrderFromString(String orderString)
            throws BadOrderException {

        if (orderString.equalsIgnoreCase("welcome"))
            chosenOrder = OrderList.WELCOME;
        else if (orderString.equalsIgnoreCase("send file"))
            chosenOrder = OrderList.SEND_FILE;
        else if (orderString.equalsIgnoreCase("l"))
            chosenOrder = OrderList.LIST;
        else
            throw new BadOrderException();
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

    public static String getListOfAvailableOrders(){

        String availableOrders = new String();

        for(OrderList ol : OrderList.values()){

            availableOrders += ol.toString();
            availableOrders += "\n";
        }

        return availableOrders;
    }
}
