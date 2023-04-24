package se.iths.foodstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.iths.foodstore.entity.Orders;
import se.iths.foodstore.entity.Product;
import se.iths.foodstore.service.AdminService;
import se.iths.foodstore.service.OrderService;
import se.iths.foodstore.service.ProductService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;


    @GetMapping("/adminlogin")
    public String adminHandle() {
        return "login-admin";
    }

    @PostMapping("/adminlogin")
    public String loginAdmin(@RequestParam String username, @RequestParam String password, Model model){

        if (adminService.validateAdmin(username, password)) {
          model.addAttribute("adminName",  adminService.getAdmin(username).getUsername());
            return "adminpage";
        } else {
            return "index";
        }
    }

    @GetMapping("/adminpage")
    public String showAdminPage(){
        return "adminpage";
    }

    @GetMapping("/unhandled")
    public String unhandledOrders(Model m) {
        List<Orders> unhandledOrders = orderService.findUnhandledOrder(false);
        m.addAttribute("ordersUnhandled", unhandledOrders);
        return "unhandled";
    }

    @GetMapping("/handled")
    public String handledOrders(Model m) {
        List<Orders> unhandledOrders = orderService.findUnhandledOrder(true);
        m.addAttribute("ordersHandled", unhandledOrders);
        return "handled";
    }

    @PostMapping("/markOrderHandled")
    public String markOrderAsHandled(@RequestParam Long id, Model model){
        Orders order = orderService.getOrderById(id);
        order.setHandled(true);
        orderService.saveOrder(order);

        model.addAttribute("orderHandled", order.getId());
        return "markedorder";
    }

    @GetMapping("/newproduct")
    public String product(Model m){
        m.addAttribute("product", new Product());
        return "newproduct";
    }
    @PostMapping("/newproduct")
    public String addProduct(@ModelAttribute Product product, Model model){
        productService.setProduct(product);
        model.addAttribute("addedProduct", productService.SaveProductIfNew(product));

        return "newproduct";
    }
}
