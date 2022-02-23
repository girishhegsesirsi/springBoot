package com.sb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sb.dao.UserRepository;
import com.sb.model.User;
import com.sb.resources.MyUserDetails;
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userrepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//return new MyUserDetails(username);
		Optional<User> user= userrepository.findByUserName(username);
		
		user.orElseThrow(()->  new UsernameNotFoundException("User not found"));
		return user.map(MyUserDetails::new).get();
	}

	
}
