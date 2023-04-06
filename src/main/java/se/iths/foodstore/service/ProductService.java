package se.iths.foodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.foodstore.entity.Product;
import se.iths.foodstore.repo.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public Optional<Product> findById(Long id) {
        return repo.findById(id);
    }
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

}
