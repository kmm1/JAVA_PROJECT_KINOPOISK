/**
 * Created by icons on 2.4.17.
 */
public class Product {

    private int productId;
    private String productName;
    private String productModel;
    private int productAvailable;
    private int productPrice;


    public Product(int productId, String productName, String productModel, int productAvailable, int productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productModel = productModel;
        this.productAvailable = productAvailable;
        this.productPrice = productPrice;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductAvailable(int productAvailable) {
        this.productAvailable = productAvailable;
    }

    public int getProductAvailable() {
        return productAvailable;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductPrice() {
        return productPrice;
    }
}