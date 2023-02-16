package sn.cfoa.contactmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.cfoa.contactmicroservice.model.Mail;
import sn.cfoa.contactmicroservice.service.MaillService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000") 
public class MailController {

	@Autowired(required = true)
	private MaillService mailService;
	
	//Sending a simple Email
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody Mail mail) {
		String status = mailService.sendSimpleMail(mail);
		return status;
	}
	
	//Sending email with attachment
	@PostMapping("/sendMail/withAttachment")
	public String sendMailWithAttachment(@RequestBody Mail mail) {
		String status = mailService.sendMailWithAttachment(mail);
		return status;
	}
}
