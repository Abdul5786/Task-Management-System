package com.Abdul.TaskManagementSystem.controllers;

import com.Abdul.TaskManagementSystem.entities.User;
import com.Abdul.TaskManagementSystem.services.servicesImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeControllers
{

    @Autowired
    UserService userService;


    @PostMapping(value = "/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping(value = "/create-admin")
    public ResponseEntity<User> createUserAdmin(@RequestBody User user)
    {
        User savedUser = userService.createUserAdmin(user);
        return ResponseEntity.ok(savedUser);
    }



    @GetMapping(value = "/all")
//    @PreAuthorize("hasAuthority('')")
    public ResponseEntity<List<User>> getAlluser()
    {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

}
