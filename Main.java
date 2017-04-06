import java.util.HashMap;
import java.util.Map;

/**
 * Created by icons on 2.4.17.
 */
public class Main {
    public static void main(String[] args) {


        Customers costomer = new Customers(1, "Владимир", "Гавриленок", "gva.sky@gmail.com",
                "abc", "+375293035157", "Минск, ул. Гуртьева, 6-5");

        Products product = new Products(1, "Kite", "Speed 21",
                3, 2300);


        Map<String, Integer> goodsInOrder = new HashMap<>();
        Orders order = new Orders(1, goodsInOrder, "01.01.2016",
                "01.01.2016", "delivered");
        order.getGoodsInOrder().put("Flysurfer Speed 21", 1);

    }
}