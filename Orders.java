import java.util.HashMap;
import java.util.Map;

/**
 * Created by icons on 2.4.17.
 */
public class Orders {
    private long id;
    private Map <String, Integer> goodsInOrder;
    private String orderFormolazedDate;
    private String orderClosingDate;
    private String orderStatus;


    public Orders(long id, Map<String, Integer> goodsInOrder, String orderFormolazedDate,
                 String orderClosingDate, String orderStatus) {
        this.id = id;
        this.goodsInOrder = goodsInOrder;
        this.orderFormolazedDate = orderFormolazedDate;
        this.orderClosingDate = orderClosingDate;
        this.orderStatus = orderStatus;
    }


    public void setOrderNumber(long id) {
        this.id = id;
    }

    public long getOrderNumber() {
        return id;
    }

    public void setGoodsInOrder(Map<String, Integer> goodsInOrder) {
        this.goodsInOrder = goodsInOrder;
    }

    public Map<String, Integer> getGoodsInOrder() {
        return goodsInOrder;
    }

    public void SetOrderFormolazedDate(String orderFormolazedDate) {
        this.orderFormolazedDate = orderFormolazedDate;
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
