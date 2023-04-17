package se.iths.foodstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import se.iths.foodstore.service.ProductService;
import se.iths.foodstore.service.StoreService;



@Controller
@SessionScope
public class CustomerController {

    //--------------------------------------------------------------------------BEANS

    @Autowired // Handles the customer, cart and orders
    StoreService storeService;
    @Autowired // Loads the products from the database
    ProductService productService;

    //---------------------------------------------------------------------END-POINTS

    @GetMapping("/customerlogin") // Redirects to customer login
    public String customerHandle() {

        return "login-customer";
    }

    @PostMapping("/store") // Uses customer credentials to redirect to the store
    public String redirectCustomerToStore(@RequestParam String username,
                                          @RequestParam String password,
                                          Model m) {

        m.addAttribute("loggedCustomer", storeService.getLoggedCustomer(username, password));
        m.addAttribute("products", productService.getProducts(storeService.getSelectedCategory()));
        m.addAttribute("categories", productService.getCategories());
        m.addAttribute("selectedCategory", storeService.getSelectedCategory());

        return "storefront";
    }

    @GetMapping(value = "/store") // Shows the products depending on category
    public String filterByCategory(@RequestParam(name = "selectedCategory") String category,
                                 Model m) {

        m.addAttribute("selectedCategory", storeService.setAndGetCategory(category));
        m.addAttribute("products", productService.getProducts(storeService.getSelectedCategory()));
        m.addAttribute("categories", productService.getCategories());
        m.addAttribute("cartProductList", storeService.getCart());
        m.addAttribute("cartsum", storeService.calcAndRoundPriceOfCart());

        return "storefront";
    }

    @GetMapping("/storez")
    public String searchByProductName(@RequestParam(name = "searchProductName") String queryName,
                                      Model m) {
        m.addAttribute("selectedCategory", storeService.getSelectedCategory());
        m.addAttribute("products", productService.getProductByName(queryName));
        m.addAttribute("categories", productService.getCategories());
        m.addAttribute("cartProductList", storeService.getCart());
        m.addAttribute("cartsum", storeService.calcAndRoundPriceOfCart());

        return "storefront";
    }


    @PostMapping("/add-product") // Adds the product to the cart
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

        m.addAttribute("products", productService.getProducts(storeService.getSelectedCategory()));
        m.addAttribute("categories", productService.getCategories());
        m.addAttribute("cartProductList", storeService.getCart());
        m.addAttribute("selectedCategory", storeService.selectAll());
        m.addAttribute("cartsum", storeService.calcAndRoundPriceOfCart());


        return "storefront";
    }

    @PostMapping("/delete-product") // Deletes the product from the cart
    public String addProductToCart(@RequestParam int indexToRemove,
                                   Model m) {

        m.addAttribute("products", productService.getProducts(storeService.getSelectedCategory()));
        m.addAttribute("categories", productService.getCategories());
        m.addAttribute("cartProductList", storeService.removeItemInCart(indexToRemove));
        m.addAttribute("selectedCategory", storeService.getSelectedCategory());
        m.addAttribute("cartsum", storeService.calcAndRoundPriceOfCart());


        return "storefront";
    }

    @PostMapping("/decr")
    public String decrQuantity(@RequestParam int indexToModify,
                               Model m) {

        m.addAttribute("products", productService.getProducts(storeService.getSelectedCategory()));
        m.addAttribute("categories", productService.getCategories());
        m.addAttribute("cartProductList", storeService.decrItem(indexToModify));
        m.addAttribute("selectedCategory", storeService.getSelectedCategory());
        m.addAttribute("cartsum", storeService.calcAndRoundPriceOfCart());

        return "storefront";
    }

    @PostMapping("/incr")
    public String incrQuantity(@RequestParam int indexToModify,
                               Model m) {

        m.addAttribute("products", productService.getProducts(storeService.getSelectedCategory()));
        m.addAttribute("categories", productService.getCategories());
        m.addAttribute("cartProductList", storeService.incrItem(indexToModify));
        m.addAttribute("selectedCategory", storeService.getSelectedCategory());
        m.addAttribute("cartsum", storeService.calcAndRoundPriceOfCart());

        return "storefront";
    }

    @GetMapping("/placeorder") // Creates the order using the cart
    public String placeOrder(Model m) {

        // TODO Handle the return value from this call to display the order beautifully

        m.addAttribute("cart", storeService.createOrder());
        m.addAttribute("products", productService.getProducts(storeService.getSelectedCategory()));
        m.addAttribute("categories", productService.getCategories());
        m.addAttribute("selectedCategory", storeService.getSelectedCategory());
        m.addAttribute("cartsum", storeService.calcAndRoundPriceOfCart());

        return "checkout";
    }

//-------------------------------------------------------------------------------

}
