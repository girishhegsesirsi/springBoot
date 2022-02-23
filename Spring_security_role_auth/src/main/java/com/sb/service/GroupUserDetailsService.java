package com.sb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sb.entity.User;
import com.sb.repository.UserRepository;

@Service
public class GroupUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("loadUserByUsername() from GroupUserDetailsService");
    	System.out.println("loading the user: "+username);
        Optional<User> user = repository.findByUserName(username);
        return user.map(GroupUserDetails::new)
                .orElseThrow(() -> {
                	System.out.println("User not found");
               return new UsernameNotFoundException(username + " Not Found");
    });
    }
}
