package se.iths.foodstore.model;

public class CartProduct {

    private Long id;
    private String productName;
    private String price;
    private String quantity;


    public CartProduct() {}

    public CartProduct(Long id, String productName, String price, String quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    // TODO change type of quantity variable in order to not write this ugly..
    public void incrQuantity() {
        int number = Integer.valueOf(this.quantity);
        number++;
        this.quantity = String.valueOf(number);
    }

    // TODO change type of quantity variable in order to not write this ugly..
    public void decrQuantity() {
        int number = Integer.valueOf(this.quantity);
        number--;
        this.quantity = String.valueOf(number);
    }

}
