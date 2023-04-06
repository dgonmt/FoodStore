package se.iths.foodstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.foodstore.entity.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Long> {
}
