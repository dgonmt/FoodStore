package se.iths.foodstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import se.iths.foodstore.entity.Admin;
import se.iths.foodstore.entity.Product;
import se.iths.foodstore.service.AdminService;
import se.iths.foodstore.service.ProductService;

import java.sql.SQLException;

@Controller
public class StoreController {

    @Autowired
    ProductService productService;

    @Autowired
    AdminService adminService;

    @GetMapping("/index")
    public String choiceView(){
    return "index";
    }

    @GetMapping("/start")
    public String startPage() {
        return "start";
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
          //  model.addAttribute("welcome", adminService.welcomeAdmin(admin));
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
        return "userinlogg";
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
