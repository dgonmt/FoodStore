package se.iths.foodstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.foodstore.entity.Product;
import se.iths.foodstore.entity.User;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository <User, Long> {

    public Optional<User> getUserById(Long id);
}
