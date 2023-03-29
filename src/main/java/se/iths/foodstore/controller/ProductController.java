package se.iths.foodstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import se.iths.foodstore.entity.Product;
import se.iths.foodstore.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/index")
    public String choiceView(){
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
    public String adminView(){
        return "admininlogg";
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
