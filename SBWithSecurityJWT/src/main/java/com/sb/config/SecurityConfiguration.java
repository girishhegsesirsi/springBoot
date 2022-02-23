package com.sb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sb.filter.JwtRequestFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { 
	

@Autowired
UserDetailsService userDetailsService;
@Autowired
JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder getPaswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	@Bean
	public AuthenticationManager  authenticationManagerBean()throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity httpSec) throws Exception{
		/*
		 * httpSec.authorizeRequests()
		 * .antMatchers("/","static/css","static/js").permitAll()
		 * .antMatchers("/**").hasRole("ADMIN") .and().formLogin();
		 */
		
		 httpSec.
		 csrf().disable().authorizeRequests()
		 .antMatchers("/authenticate").permitAll()
		  .anyRequest()
		  .authenticated()
		  .and().sessionManagement()
		  .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 httpSec.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
	}
	
}
