package com.teamagile.emailApplication.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
	
	private final String EMAIL_HOST = "smtp-mail.outlook.com";
	private final String EMAIL_USERNAME = "alantsousmtp@outlook.com";
	private final String EMAIL_PASSWORD = "SMTPAndGarbage";
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost(EMAIL_HOST);
	    mailSender.setPort(587);
	    
	    mailSender.setUsername(EMAIL_USERNAME);
	    mailSender.setPassword(EMAIL_PASSWORD);
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
	    return mailSender;
	}
}
