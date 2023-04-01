package se.iths.foodstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.iths.foodstore.service.CustomerService;
import se.iths.foodstore.service.ProductService;

import java.util.List;


@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;

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

        m.addAttribute("loggedCustomer",
                customerService.escortCustomer(username, password));

        prepareStore(m);

        return "test";
    }

//-------------------------------------------------------------------------------

//-------------------------------------------------------------------HELP-METHODS


    public void prepareStore(Model m) {
        m.addAttribute("products", productService.getAllProducts());
    }
//-------------------------------------------------------------------------------

}
