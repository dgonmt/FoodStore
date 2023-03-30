package se.iths.foodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.foodstore.entity.User;
import se.iths.foodstore.repo.UserRepo;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    User user;

    public Optional<User> getUserByUserId(Long id) {
        return repo.getUserById(id);
    }

    public User createNewUser(String userName, String password) {
       return repo.save(new User(userName, password));
    }

    public void mockUsers() {
        repo.save(new User("Kalle","1"));
        repo.save(new User("Anka","1"));

    }
}
