package se.iths.foodstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.foodstore.entity.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository <Customer, Long> {

    public Optional<Customer> getUserById(Long id);

    public boolean existsByUsernameAndPassword(String username, String password);

    public Customer getCustomersByUsername(String username);

}
