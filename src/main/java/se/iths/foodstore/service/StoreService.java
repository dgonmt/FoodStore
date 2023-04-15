package se.iths.foodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.iths.foodstore.entity.Customer;
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


    OrdersRepo ordersRepo;
    private List<CartProduct> cartProducts = new ArrayList<>();

    @Autowired
    public StoreService(OrdersRepo ordersRepo) {
        this.ordersRepo=ordersRepo;
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


    public String calcAndRoundPriceOfCart() {
        double sum = 0;
        for (CartProduct p : this.cartProducts) {
            sum += Double.valueOf(p.getQuantity()) * Double.valueOf(p.getPrice());
        }
        String returnSum = String.valueOf(Math.floor(sum * 100) / 100);

        return returnSum;
    }

    // TODO Change this method to return orderdata for printing
    public void createOrder() {

        Orders orders = new Orders();
        orders.setCustomer_id(this.selectedCustomer.getId());
        orders.addOrderLine(this.cartProducts);
        ordersRepo.save(orders);
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


}
