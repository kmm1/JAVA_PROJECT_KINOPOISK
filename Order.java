/**
 * Created by icons on 2.4.17.
 */
public class Order {
    private long orderNumber;
    private String goodsInOrder;
    private String orderFormolazedDate;
    private String orderClosingDate;
    private String orderStatus;

    Order order = new Order (001, "Speed 21", "01.01.2017",
            "01.01.2017", "delivered");

    public Order(long orderNumber, String goodsInOrder, String orderFormolazedDate,
                 String orderClosingDate, String orderStatus) {
        this.orderNumber = orderNumber;
        this.goodsInOrder = goodsInOrder;
        this.orderFormolazedDate = orderFormolazedDate;
        this.orderClosingDate = orderClosingDate;
        this.orderStatus = orderStatus;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setGoodsInOrder(String goodsInOrder) {
        this.goodsInOrder = goodsInOrder;
    }

    public String getGoodsInOrder() {
        return goodsInOrder;
    }

    public void SetOrderFormolazedDate(String orderFormolazedDate) {
        this.goodsInOrder = orderFormolazedDate;
    }

    public String getOrderFormolazedDate() {
        return orderFormolazedDate;
    }

    public void SetOrderClosingDate(String orderClosingDate) {
        this.orderClosingDate = orderClosingDate;
    }

    public String getOrderClosingDate() {
        return orderClosingDate;
    }

    public void SetOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
