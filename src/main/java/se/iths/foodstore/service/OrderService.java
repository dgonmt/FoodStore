package se.iths.foodstore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.foodstore.entity.Orders;
import se.iths.foodstore.repo.OrdersRepo;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrdersRepo repo;

    public List<Orders> findOrder(boolean isHandled) {
        return repo.findByHandled(isHandled);
    }

    public List<Orders> findAllOrders() {
        return repo.findAll();
    }

    public Orders getOrderById(Long id) {
        return repo.getProductOrderById(id);
    }

    public void saveOrder(Orders order){
        repo.save(order);
    }
}
