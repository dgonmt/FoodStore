package se.iths.foodstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import se.iths.foodstore.entity.Customer;
import se.iths.foodstore.model.CartProduct;
import se.iths.foodstore.service.CustomerService;
import se.iths.foodstore.service.ProductService;
import se.iths.foodstore.service.StoreService;

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


    String selectedCategory = "all";
    String cartSum;


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

    @PostMapping("/store")
    public String redirectCustomerToStore(@RequestParam String username,
                                          @RequestParam String password,
                                          Model m) {

        System.out.println("/customerlogin POST");

        m.addAttribute("loggedCustomer", customerService.escortCustomer(username, password));
        m.addAttribute("loggedCustomer", storeService.getLoggedCustomer(username, password));
        m.addAttribute("products", productService.getProducts(storeService.getSelectedCategory()));
        m.addAttribute("categories", productService.getCategories());
        m.addAttribute("selectedCategory", storeService.getSelectedCategory());


        //prepareStore(m);

        return "storefront";
    }

    @GetMapping(value = "/store")
    public String showByCategory(@RequestParam(name = "selectedCategory") String category,
                                 Model m) {


        // TODO Fix products-attribute to get correct data
        m.addAttribute("products", productService.getProducts(selectedCategory));
        m.addAttribute("categories", productService.getCategories());
        m.addAttribute("cartProductList", storeService.getCart());
        m.addAttribute("selectedCategory", storeService.setAndGetCategory(category));
        m.addAttribute("cartsum", storeService.calcAndRoundPriceOfCart());

        return "storefront";
    }


    @PostMapping("/add-product")
    public String addProductToCart(@RequestParam Long productId,
                                   @RequestParam String productName,
                                   @RequestParam String price,
                                   @RequestParam String quantity,
                                   Model m) {

        storeService.addProductToCart(
                productId,
                productName,
                price,
                quantity
        );


        m.addAttribute("products", productService.getProducts(selectedCategory));
        m.addAttribute("categories", productService.getCategories());
        m.addAttribute("cartProductList", storeService.getCart());
        m.addAttribute("selectedCategory", storeService.getSelectedCategory());
        m.addAttribute("cartsum", storeService.calcAndRoundPriceOfCart());


        return "storefront";
    }

    @PostMapping("/delete-product")
    public String addProductToCart(@RequestParam int indexToRemove,
                                   Model m) {


        m.addAttribute("products", productService.getProducts(selectedCategory));
        m.addAttribute("categories", productService.getCategories());
        m.addAttribute("cartProductList", storeService.removeItemInCart(indexToRemove));
        m.addAttribute("selectedCategory", storeService.getSelectedCategory());
        m.addAttribute("cartsum", storeService.calcAndRoundPriceOfCart());

        //prepareStore(m);


        return "storefront";
    }

    @GetMapping("/placeorder")
    public String placeOrder(Model m) {

        storeService.createOrder();
        prepareStore(m);
        return "storefront";
    }

//-------------------------------------------------------------------------------

//-------------------------------------------------------------------HELP-METHODS

    public void prepareStore(Model m) {
        m.addAttribute("products", productService.getAllProducts());
        m.addAttribute("categories", productService.getCategories());
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
