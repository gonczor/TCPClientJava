package ConnectionHandling;


public enum OrderList {

    WELCOME,
    SEND_FILE,
    LIST;

    public String toString(OrderList orderList) {
        return orderList.toString();
    }
}
