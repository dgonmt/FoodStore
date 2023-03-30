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

    public void mockProducts() {
        repo.save(new Product("Apples","Fruits",110.0,1.99));
        repo.save(new Product("Bananas","Fruits",80.0,0.99));
        repo.save(new Product("Oranges","Fruits",130.0,2.49));
        repo.save(new Product("Pineapples","Fruits",240.0,3.99));
        repo.save(new Product("Mangoes","Fruits",170.0,2.99));
        repo.save(new Product("Carrots","Vegetables",120.0,1.49));
        repo.save(new Product("Broccoli","Vegetables",150.0,2.99));
        repo.save(new Product("Cucumbers","Vegetables",100.0,1.29));
        repo.save(new Product("Spinach","Vegetables",90.0,0.99));
        repo.save(new Product("Cauliflower","Vegetables",200.0,3.49));
        repo.save(new Product("Chicken Breast","Meats",200.0,5.99));
        repo.save(new Product("Ground Beef","Meats",220.0,7.99));
        repo.save(new Product("Pork Chops","Meats",190.0,6.49));
        repo.save(new Product("Salmon Fillet","Meats",180.0,8.99));
        repo.save(new Product("Tilapia Fillet","Meats",150.0,4.99));
        repo.save(new Product("Brown Rice","Grains",190.0,2.99));
        repo.save(new Product("Quinoa","Grains",100.0,4.49));
        repo.save(new Product("Whole Wheat Bread","Grains",120.0,2.49));
        repo.save(new Product("Oatmeal","Grains",80.0,1.99));
        repo.save(new Product("Whole Grain Pasta","Grains",150.0,3.49));

    }
}
