package se.iths.foodstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.iths.foodstore.entity.Product;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository <Product, Long> {
    public List<Product> findProductsByCategory(String category);

    public List<Product> findProductByName(String name);

    @Query("SELECT DISTINCT p.category FROM Product p")
    public List<String> findAllCategories();


    List<Product> findByName(String name);
    boolean existsByName(String name);

}
