package se.iths.foodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.foodstore.entity.Customer;
import se.iths.foodstore.repo.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo repo;

    Customer customer;

    public void mockUsers() {
        repo.save(new Customer("Kalle","1"));
        repo.save(new Customer("Anka","1"));

    }

    public Customer validateCustomer(String username, String password) {

        if (repo.existsByUsernameAndPassword(username, password)) {
            return repo.getCustomersByUsername(username);
        } else {
            return repo.save(new Customer(username, password));
        }

    }

}
