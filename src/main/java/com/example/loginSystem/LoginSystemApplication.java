package com.example.loginSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LoginSystemApplication {

	public static void main(String[] args) {

        SpringApplication.run(LoginSystemApplication.class, args);
	}

}
