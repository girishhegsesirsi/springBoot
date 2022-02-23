package com.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.model.AuthenticationRequest;
import com.sb.model.AuthenticationResponse;
import com.sb.service.MyUserDetailsService;
import com.sb.util.JwtUtil;

@RestController
public class HomeResourceController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	MyUserDetailsService userDetailsService;
	@Autowired
	JwtUtil jwtUtil;
	
	@GetMapping("/")
	public String home() { 
		return ("<h1>Welcome JPA</h1>");
	}
	
	@GetMapping("/hello")
	public String user() {
		return "<h1>Hello World</h1>";
	}
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),authenticationRequest.getPassword()));
	}
		catch(BadCredentialsException e) {
			throw new Exception("Incorrect UserName or Password", e);
		}
		
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
	    final String jwt = jwtUtil.generateToken(userDetails);
	    
	    return ResponseEntity.ok(new AuthenticationResponse (jwt));
	}
}
