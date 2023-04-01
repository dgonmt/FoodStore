package se.iths.foodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.iths.foodstore.entity.Customer;
import se.iths.foodstore.repo.CustomerRepo;

@Service
@SessionScope
public class CustomerService {

    CustomerRepo repo;

    public CustomerService(CustomerRepo repo) {
        this.repo = repo;
    }

    public Customer escortCustomer(String username, String password) {
        if (repo.existsByUsernameAndPassword(username, password)) {
            return repo.getCustomersByUsername(username);
        } else {
            return repo.save(new Customer(username, password));
        }
    }
}
