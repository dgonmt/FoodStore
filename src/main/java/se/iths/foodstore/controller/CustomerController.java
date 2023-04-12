package se.iths.foodstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import se.iths.foodstore.entity.Customer;
import se.iths.foodstore.model.CartProduct;
import se.iths.foodstore.service.CustomerService;
import se.iths.foodstore.service.ProductService;
import se.iths.foodstore.service.StoreService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


@Controller
@SessionScope
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;
    @Autowired
    StoreService storeService;

    Customer customer;

    List<CartProduct> cartProducts = new ArrayList<>();


    /* Customer login/validation
     *
     * Index exposes two buttons -> Customer and Administrator
     * When user has defined its role, the app redirects the user
     * to a login form. Depending on chosen role, the user gets to be validated.
     *
     * */


    //---------------------------------------------------------------------END-POINTS

    @GetMapping("/customerlogin") // Validates the customer
    public String customerHandle() {
        System.out.println("/customerlogin GET");

        return "login-customer";
    }

    @PostMapping("/customerlogin")
    public String redirectCustomerToStore(@RequestParam String username,
                                          @RequestParam String password,
                                          Model m) {

        System.out.println("/customerlogin POST");

        customer = customerService.escortCustomer(username, password);

        m.addAttribute("loggedCustomer", customer);

        prepareStore(m);

        return "storefront";
    }


    @PostMapping("/add-product")
    public String addProductToCart(@RequestParam Long productId,
                                   @RequestParam String productName,
                                   @RequestParam String price,
                                   @RequestParam String quantity,
                                   Model m) {
        cartProducts.add(new CartProduct(
                productId,
                productName,
                price,
                quantity));

        String sum = String.valueOf(calculateAndRoundTotal(cartProducts));

        m.addAttribute("cartProductList", cartProducts);
        m.addAttribute("cartsum", sum);
        prepareStore(m);

        printArray(cartProducts);

        return "storefront";
    }

    @PostMapping("/delete-product")
    public String addProductToCart(@RequestParam int indexToRemove,
                                   Model m) {

        cartProducts.remove(indexToRemove);


        String sum = String.valueOf(calculateAndRoundTotal(cartProducts));


        m.addAttribute("cartProductList", cartProducts);
        m.addAttribute("cartsum", sum);

        prepareStore(m);


        return "storefront";
    }

    @GetMapping("/placeorder")
    public String placeOrder(Model m) {

        storeService.createOrder(customer, cartProducts);
        prepareStore(m);
        return "storefront";
    }

//-------------------------------------------------------------------------------

//-------------------------------------------------------------------HELP-METHODS

    public void prepareStore(Model m) {
        m.addAttribute("products", productService.getAllProducts());
    }

    public String calculateAndRoundTotal(List<CartProduct> cart) {
        double sum = 0;
        for (CartProduct p : cart) {
            sum += Double.valueOf(p.getQuantity()) * Double.valueOf(p.getPrice());
        }
        String returnSum = String.valueOf(Math.floor(sum * 100) / 100);

        return returnSum;
    }

    public void printArray(List<CartProduct> list) {
        for (CartProduct o : list) {
            System.out.println(o.getProductName());
        }

        System.out.println("------------------");
    }

//-------------------------------------------------------------------------------

}
