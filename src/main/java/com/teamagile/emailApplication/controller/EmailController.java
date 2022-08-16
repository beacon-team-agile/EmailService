package com.teamagile.emailApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamagile.emailApplication.domain.requests.EmailApplStatusRequest;
import com.teamagile.emailApplication.domain.requests.EmailTokenRequest;
import com.teamagile.emailApplication.domain.responses.common.ResponseStatus;
import com.teamagile.emailApplication.service.EmailSenderService;

@RestController
@RequestMapping("email")
public class EmailController {

	EmailSenderService emailSvc;
	
	@Autowired
	public EmailController(EmailSenderService emailSvc) {
		this.emailSvc = emailSvc;
	}
	

    @PostMapping("send_reg_token")
    public ResponseStatus sendRegTokenToAddress(
    		@RequestBody EmailTokenRequest req) {
    	if(req == null) return ResponseStatus.builder().success(false).message("Empty Request!").build();
    	ResponseStatus resp = emailSvc.sendRegTokenMail(req.getToken(), req.getEmail());
    	return resp;
    }
    

    @PostMapping("send_reg_status")
    public ResponseStatus sendApplicationStatusToEmployee(
    		@RequestBody EmailApplStatusRequest req) {
    	if(req == null) return ResponseStatus.builder().success(false).message("Empty Request!").build();
    	ResponseStatus resp = emailSvc.sendApplStatusMail(req.getEmail(), req.getApproved(), req.getComment());
    	return resp;
    	
    }

}
