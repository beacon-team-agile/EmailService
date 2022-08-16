package com.teamagile.emailApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}) //INDEV ONLY, DISABLES SECURITY
        
public class EmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

}
