package ConnectionHandling;


public enum OrderList {

    WELCOME,
    RECEIVEFILE,
    SENDFILE;

    public String toString(OrderList orderList) {
        return orderList.toString();
    }
}
