package se.iths.foodstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.foodstore.entity.Orders;


import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders, Long> {

    List<Orders> findByHandled(boolean isHandled);

    Orders getProductOrderById(Long id);

}
