package com.Abdul.TaskManagementSystem.services.servicesImpl;

import com.Abdul.TaskManagementSystem.entities.User;
import com.Abdul.TaskManagementSystem.respositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService
{
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepo.findByEmail(username).orElseThrow(() -> new RuntimeException("user not found with username "   +username));
        return user;
    }
}
