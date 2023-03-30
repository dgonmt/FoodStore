package se.iths.foodstore.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.foodstore.entity.Admin;

import java.util.List;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

    List<Admin> findByUsernameAndPassword(String username, String password);

    boolean existsByUsernameAndPassword(String username, String password);


}
