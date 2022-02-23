package com.sb.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("blah")
		.password("blah")
		.roles("USER")
		.and()
		.withUser("foo")
		.password("foo")
		.roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder getPaswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity httpSec) throws Exception{
		/*
		 * httpSec.authorizeRequests()
		 * .antMatchers("/","static/css","static/js").permitAll()
		 * .antMatchers("/**").hasRole("ADMIN") .and().formLogin();
		 */
		
		 httpSec.authorizeRequests()
		 .antMatchers("/admin").hasRole("ADMIN") 
		 .antMatchers("/user").hasAnyRole("USER","ADMIN") 
		  .antMatchers("/").permitAll()
		  .and().formLogin();
	}
}
