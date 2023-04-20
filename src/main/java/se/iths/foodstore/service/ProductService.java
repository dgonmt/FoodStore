package se.iths.foodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.foodstore.entity.Product;
import se.iths.foodstore.repo.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    Product product;

    @Autowired
    ProductRepo repo;

    public Optional<Product> findById(Long id) {
        return repo.findById(id);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public List<Product> getProductByCategory(String category) {
        return repo.findProductsByCategory(category);
    }

    public List<Product> getProductByName(String name) {
        return repo.findProductByName(name);
    }

    public List<String> getCategories() {
        return repo.findAllCategories();
    }

    public List<Product> getProducts(String category) {
        if (category.equals("all")) {
            return getAllProducts();
        } else {
            return getProductByCategory(category);
        }
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String SaveProductIfNew(Product product){
        if(repo.existsByName(product.getName())){
            update(product);
            return "Updated product, " + product.getName();
        } else {
            repo.save(product);
            return "Added product, " + product.getName();
        }

    }

    private void update(Product product) {
        if (repo.existsByName(product.getName())) {
            Product existingProduct = repo.findProductByName(product.getName()).get(0);
            existingProduct.setPricePerKg(product.getPricePerKg());
            existingProduct.setWeight(product.getWeight());
            existingProduct.setCategory(product.getCategory());

            repo.save(existingProduct);
        }
    }
}
