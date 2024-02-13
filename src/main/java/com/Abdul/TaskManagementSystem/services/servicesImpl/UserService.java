package com.Abdul.TaskManagementSystem.services.servicesImpl;

import com.Abdul.TaskManagementSystem.entities.User;
import com.Abdul.TaskManagementSystem.enums.UserRole;
import com.Abdul.TaskManagementSystem.respositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    UserRepo userRepo;

     @Autowired
     private PasswordEncoder passwordEncoder;
    public User createUser(User user)
    {
        // create User
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserRole(UserRole.USER);
        User savedUser = userRepo.save(user);
        return   savedUser;
    }
    public User createUserAdmin(User user)
    {
        // creating ADMIN User
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserRole(UserRole.ADMIN);
        User savedUser = userRepo.save(user);
        return   savedUser;
    }

    public List<User> getAllUser()
    {
        List<User> all = userRepo.findAll();
        return all;
    }
}
