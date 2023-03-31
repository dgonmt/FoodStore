package se.iths.foodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.foodstore.entity.Customer;
import se.iths.foodstore.repo.UserRepo;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    UserRepo repo;

    Customer customer;



    public Customer createNewUser(String userName, String password) {
       return repo.save(new Customer(userName, password));
    }

    public void mockUsers() {
        repo.save(new Customer("Kalle","1"));
        repo.save(new Customer("Anka","1"));

    }

    public String validateUser(String username, String password) {

    }

}
