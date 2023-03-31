package se.iths.foodstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import se.iths.foodstore.entity.Admin;
import se.iths.foodstore.entity.Product;
import se.iths.foodstore.service.AdminService;
import se.iths.foodstore.service.ProductService;
import se.iths.foodstore.service.CustomerService;

@Controller
public class StoreController {

    @Autowired
    ProductService productService;
    @Autowired
    AdminService adminService;
    @Autowired
    CustomerService customerService;


    /*
    * Section 1
    * User definition & login/validation
    *
    * Index exposes two buttons -> Customer and Administrator
    * When user has defined its role, the app redirects the user
    * to a login form. Depending on chosen role, the user gets to be validated.
    *
    * */

    @GetMapping("/start") // Directs the user depending on role
    public String welcomePage() {
        return "start";
    }

    @GetMapping("/customerlogin") // Validates the customer
    public String customerHandle() {
        return "login";
    }

    @PostMapping("/customerlogin")
    public String loginCustomer(@RequestParam String username,
                                @RequestParam String password,
                                Model m) {

        customerService.validateUser(username, password);


        return "storefront";
    }
    @GetMapping("/adminlogin")
    public String adminHandle() {
        return "login";
    }
    @PostMapping("/adminlogin")
    public String loginAdmin(@RequestParam String username,
                             @RequestParam String password,
                             Model m){
        return "adminpage";
    }


//-------------------------------------------------------------------------------

    @GetMapping("/index")
    public String choiceView(){
        productService.mockProducts(); // Mock method to create sample products
        adminService.mockAdmins(); // Mock method to create sample Admins
        customerService.mockUsers(); // Mock method to create sample users/customers
    return "index";
    }




    @PostMapping("/index")
    public RedirectView choiceForm(@RequestParam String choice){
        if(choice.equals("admin")){
        return new RedirectView("admin");
        } else{
            return new RedirectView("user");
        }
    }



    @GetMapping("/admin")
    String getUser(Model m) {
        m.addAttribute("admin", new Admin());
        return "admininlogg";
    }

    @PostMapping("/admin")
    String userForm(@ModelAttribute Admin admin) {
        adminService.setAdmin(admin);
        return "redirect:/adminOptions";
    }



    @GetMapping("/adminOptions")
    String getOptions(Model model) {
        Admin admin = adminService.getAdmin();
        if (admin == null) {
            // If there's no admin in the session, redirect back to the admin page
            return "redirect:/admin";
        } else {
            model.addAttribute("admin", admin);
            model.addAttribute("welcome", adminService.welcomeAdmin(admin));
            return "adminOptions";
        }
    }

    @PostMapping("/adminOptions")
    public RedirectView adminChoice(@RequestParam("choice") String choice) {
        if (choice.equals("orders")) {
            return new RedirectView("/orders");
        } else {
            return new RedirectView("/new");
        }

    }

    @GetMapping("/user")
    public String userView(){
        return "login";
    }

    @GetMapping("/new")
    public String newProduct(Model m){
    m.addAttribute("product", new Product());
    return "newproduct";
    }

    @PostMapping("/new")
    public String productForm(@ModelAttribute Product product, Model m){
        productService.add(product);

        return "newproduct";
    }

}
