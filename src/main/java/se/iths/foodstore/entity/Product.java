package se.iths.foodstore.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "weight")
    @Min(0)
    private double weight;

    @Column(name = "price_per_kg")
    @Min(0)
    private double pricePerKg;

    public Product() {
    }
    public Product(String name, String category, double weight, double pricePerKg) {
        this.name=name;
        this.category=category;
        this.weight=weight;
        this.pricePerKg=pricePerKg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double price) {
        this.pricePerKg = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
