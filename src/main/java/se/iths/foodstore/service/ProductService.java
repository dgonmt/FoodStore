package se.iths.foodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.foodstore.entity.Product;
import se.iths.foodstore.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void add(Product product) {
        repo.save(product);
    }
}
