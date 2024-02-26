package org.example.securiry.service;

import org.example.securiry.entities.User;
import org.example.securiry.repositries.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepositry userRepositry;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        load user by userName
       User user= userRepositry.findByEmail(username).orElseThrow(()->new RuntimeException("user not found"));
        return user;
    }
}
