package com.teamagile.emailApplication.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.teamagile.emailApplication.domain.responses.common.ResponseStatus;

@Service
public class EmailSenderService {
	
    @Autowired
    private JavaMailSender emailSender;
    
    final String DEFAULT_FROM_EMAIL = "alantsousmtp@outlook.com";
    final String DEFAULT_TO_DOMAIN = "http://localhost:9000/authentication-service/credential/register?token=";
    
    public ResponseStatus sendRegTokenMail(String token, String email){
    	try {
            SimpleMailMessage m = new SimpleMailMessage(); 
            m.setFrom(DEFAULT_FROM_EMAIL);
            m.setTo(email); 
            m.setSubject("Your Registration"); 
        	
            String newLine = System.getProperty("line.separator");
            StringBuilder emailBody = new StringBuilder();
            emailBody.append("Use the following link to register an account:");
            emailBody.append(newLine);
            emailBody.append(DEFAULT_TO_DOMAIN);
            emailBody.append(token);
//	        MimeMessage mi = emailSender.createMimeMessage();
//	        MimeMessageHelper mime_helper = new MimeMessageHelper(mi, "utf-8");
//	        mime_helper.setFrom(DEFAULT_FROM_EMAIL);
//	        mime_helper.setSubject("Registeration Link"); 
//	        mime_helper.setTo(email);
//	        
//	        StringBuilder mimeBody = new StringBuilder();
//	        mimeBody.append("<h3> Your registeration had been approved <h3><br>");
//	        mimeBody.append("<a href=/");
//	        mimeBody.append(DEFAULT_TO_DOMAIN);
//	        mimeBody.append(token);
//	        mimeBody.append(">Create an account with the following link</a>");
//	        
//	        mime_helper.setText(mimeBody.toString(), true);
//	        emailSender.send(mi);
            m.setText(emailBody.toString());
            emailSender.send(m);	
	        return ResponseStatus.builder().message("email sent successfully").success(true).build();
//    	}catch(MessagingException ms) {
//	        return ResponseStatus.builder().message("MessagingException thrown, email not sent").success(false).build();
    	}catch(Exception etc_exc) {
	        return ResponseStatus.builder().message(etc_exc.getMessage()).success(false).build();
    	}      
    }
    
    
    public ResponseStatus sendApplicationStatusMail(String email, Boolean status, String comment){
    	try {
            SimpleMailMessage m = new SimpleMailMessage(); 
            
            m.setFrom(DEFAULT_FROM_EMAIL);
            m.setTo(email); 
            m.setSubject("Your Application Status"); 
        	
            String newLine = System.getProperty("line.separator");
            StringBuilder emailBody = new StringBuilder();
            if(status) {
                emailBody.append("Your application had been approved.");
                emailBody.append(newLine);
                emailBody.append("A comment from the approver: ");
                emailBody.append(comment);
                emailBody.append(newLine);
            }else {
                emailBody.append("Your application had been denied for the following reason: ");
                emailBody.append(newLine);
                emailBody.append(comment);
                emailBody.append(newLine);
            }
            m.setText(emailBody.toString());
            emailSender.send(m);	        
	        return ResponseStatus.builder().message("email sent successfully").success(true).build();
    	}catch(Exception etc_exc) {
	        return ResponseStatus.builder().message(etc_exc.getMessage()).success(false).build();
    	}      
    }

}
