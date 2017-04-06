/**
 * Created by icons on 2.4.17.
 */
public class Products {

    private int id;
    private String productName;
    private String productModel;
    private int productAvailable;
    private int productPrice;


    public Products(int id, String productName, String productModel, int productAvailable, int productPrice) {
        this.id = id;
        this.productName = productName;
        this.productModel = productModel;
        this.productAvailable = productAvailable;
        this.productPrice = productPrice;
    }

    public void setProductId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return id;
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