package se.iths.foodstore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.foodstore.entity.Admin;
import se.iths.foodstore.repo.AdminRepo;

@Service
public class AdminService {

    Admin admin;

    @Autowired
    AdminRepo repo;


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


    public Admin getAdmin(String username){
      return repo.getAdminByUsername(username);
    }


    public String welcomeAdmin(Admin admin) {
        if(repo.existsByUsernameAndPassword(admin.getUsername(), admin.getPassword())){
            return "Welcome " + admin.getUsername();
        } else {
            return "You don't have permission";
        }
    }
}
