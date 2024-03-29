package se.iths.foodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.iths.foodstore.entity.Customer;
import se.iths.foodstore.entity.OrderLine;
import se.iths.foodstore.entity.Orders;
import se.iths.foodstore.model.CartProduct;
import se.iths.foodstore.repo.OrdersRepo;

import java.util.ArrayList;
import java.util.List;


@Service
@SessionScope
public class StoreService {


    String selectedCategory = "all";

    @Autowired
    CustomerService customerService;

    Customer selectedCustomer;
    @Autowired
    OrdersRepo ordersRepo;
    private List<CartProduct> cartProducts = new ArrayList<>();

    @Autowired
    public StoreService() {
    }


    public void addProductToCart(Long productId,
                                              String productName,
                                              String price,
                                              String quantity) {
        cartProducts.add(new CartProduct(
                productId,
                productName,
                price,
                quantity
        ));

    }

    public List<CartProduct> removeItemInCart(int index) {
        this.cartProducts.remove(index);

        return this.cartProducts;
    }

    public List<CartProduct> decrItem(int index) {
        this.cartProducts.get(index).decrQuantity();

        return this.cartProducts;
    }

    public List<CartProduct> incrItem(int index) {
        this.cartProducts.get(index).incrQuantity();

        return this.cartProducts;
    }


    public String calcAndRoundPriceOfCart() {
        double sum = 0;
        for (CartProduct p : this.cartProducts) {
            p.setTotPrice(Double.valueOf(p.getQuantity()) * Double.valueOf(p.getPrice()));
            sum += Double.valueOf(p.getTotPrice());
        }
        String returnSum = String.valueOf(Math.floor(sum * 100) / 100);

        return returnSum;
    }

    // TODO Change this method to return orderdata for printing
    public List<CartProduct> createOrder() {

        Orders orders = new Orders();
        orders.setCustomer_id(this.selectedCustomer.getId());
        orders.addOrderLine(this.cartProducts);
        ordersRepo.save(orders);

        return this.cartProducts;

    }

    public List<CartProduct> getCart() {
        return this.cartProducts;
    }

    public String setAndGetCategory(String category) {
        this.selectedCategory = category;

        return this.selectedCategory;
    }

    public String getSelectedCategory() {
        return this.selectedCategory;
    }

    public Customer getLoggedCustomer(String username, String password) {
        selectedCustomer = customerService.escortCustomer(username, password);

        return selectedCustomer;
    }

    public String selectAll() {
        this.selectedCategory = "all";

        return this.selectedCategory;
    }


}
