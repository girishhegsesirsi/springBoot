package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SBdemoApplication {

	public static void main(String[] args) {
		System.out.println("in spring boot main");
		SpringApplication.run(SBdemoApplication.class, args);
		System.out.println("in spring boot main");
	}

}
