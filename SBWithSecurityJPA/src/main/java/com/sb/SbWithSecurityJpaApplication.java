package com.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SbWithSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbWithSecurityJpaApplication.class, args);
	}

}
