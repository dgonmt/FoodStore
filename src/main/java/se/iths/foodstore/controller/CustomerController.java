package se.iths.foodstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.iths.foodstore.service.AdminService;
import se.iths.foodstore.service.CustomerService;
import se.iths.foodstore.service.ProductService;


@Controller
public class CustomerController {

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    /* Customer login/validation
     *
     * Index exposes two buttons -> Customer and Administrator
     * When user has defined its role, the app redirects the user
     * to a login form. Depending on chosen role, the user gets to be validated.
     *
     * */


    @GetMapping("/customerlogin") // Validates the customer
    public String customerHandle() {
        return "login";
    }

    @PostMapping("/customerlogin")
    public String redirectCustomerToStore(@RequestParam String username,
                                          @RequestParam String password,
                                          Model m) {

        m.addAttribute("loggedCustomer", customerService.validateCustomer(username, password));


        return "storefront";
    }
//-------------------------------------------------------------------------------

}
