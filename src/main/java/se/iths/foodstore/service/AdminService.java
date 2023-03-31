package se.iths.foodstore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.foodstore.entity.Admin;
import se.iths.foodstore.repo.AdminRepo;

import java.util.List;

@Service
public class AdminService {

    Admin admin;

    @Autowired
    AdminRepo repo;



    public void mockAdmins(){
        repo.save(new Admin("A", "1"));
        repo.save(new Admin("B", "2"));
    }

    public AdminService() {
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


    public boolean validateAdmin(String username, String password) {
        // return true if admin exists
        //else false

        return repo.existsByUsernameAndPassword(username, password);

    }

    public String welcomeAdmin(Admin admin) {
        if(repo.existsByUsernameAndPassword(admin.getUsername(), admin.getPassword())){
            return "Welcome " + admin.getUsername();
        } else {
            return "You don't have permission";
        }
    }
}
