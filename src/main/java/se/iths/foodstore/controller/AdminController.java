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
public class AdminController {

    @Autowired
    AdminService adminService;

    /* Admin login/validation
     *
     * Index(/start) exposes two buttons -> Customer and Administrator
     * When user has defined its role, the app redirects the user
     * to a login form. Depending on chosen role, the user gets to be validated.
     *
     * */


    @GetMapping("/adminlogin")
    public String adminHandle() {
        return "login";
    }

    @PostMapping("/adminlogin")
    public String loginAdmin(@RequestParam String username,
                             @RequestParam String password,
                             Model m){


        if (adminService.validateAdmin(username, password)) {
            return "adminpage";
        } else {
            return "start";
        }

    }


//-------------------------------------------------------------------------------


}
