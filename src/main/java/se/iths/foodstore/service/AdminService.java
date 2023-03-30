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
}
