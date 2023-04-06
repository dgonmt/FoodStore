package se.iths.foodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.iths.foodstore.entity.Customer;
import se.iths.foodstore.entity.Orders;
import se.iths.foodstore.model.CartProduct;
import se.iths.foodstore.repo.OrdersRepo;

import java.util.List;


@Service
@SessionScope
public class StoreService {


    OrdersRepo ordersRepo;

    @Autowired
    public StoreService(OrdersRepo ordersRepo) {
        this.ordersRepo=ordersRepo;
    }

    public void createOrder(Customer customer, List<CartProduct> products) {

        Orders orders = new Orders();
        orders.setCustomer_id(customer.getId());
        orders.addOrderLine(products);
        ordersRepo.save(orders);


    }

}
