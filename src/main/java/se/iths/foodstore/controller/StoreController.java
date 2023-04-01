package se.iths.foodstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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


    @GetMapping("/start")
    public String start() {


        return "start";
    }




}
