package se.iths.foodstore.entity;

import jakarta.persistence.*;
import se.iths.foodstore.model.CartProduct;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customer_id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLineList = new ArrayList<>();

    public Orders(){}

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public void setId(Long orderId) {
        this.id = orderId;
    }

    public Long getId() {
        return this.id;
    }

    public void addOrderLine(List<CartProduct> cartProducts) {

        for (CartProduct p : cartProducts) {
            OrderLine orderLine = new OrderLine();
            orderLine.setProductName(p.getProductName());
            orderLine.setQuantity(p.getQuantity());
            orderLine.setTimestamp();
            orderLine.setOrders(this);
            orderLineList.add(orderLine);
        }
    }
}
