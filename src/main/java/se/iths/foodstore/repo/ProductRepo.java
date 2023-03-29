package se.iths.foodstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.foodstore.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository <Product, Long> {
}
