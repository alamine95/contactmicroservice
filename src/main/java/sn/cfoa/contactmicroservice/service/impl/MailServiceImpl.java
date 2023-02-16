package sn.cfoa.contactmicroservice.service.impl;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import sn.cfoa.contactmicroservice.model.Mail;
import sn.cfoa.contactmicroservice.service.MaillService;

@Service
public class MailServiceImpl implements MaillService {
	
	@Autowired(required = true)
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;

	// Methode 1
	// To send a simple email
	@Override
	public String sendSimpleMail(Mail mail) {
		try {
			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			
			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(mail.getDestinataire());
			mailMessage.setText(mail.getText());
			mailMessage.setSubject(mail.getObject());
			
			// Sending the mail
			javaMailSender.send(mailMessage);
			return "Mail Sent Succesfully...";
		} 
		
		// Catch block to handle the exceptions
		catch (Exception e) {
			
			return "Error while Sending Mail";
		}
	}

	// Send an email with attachement
	@Override
	public String sendMailWithAttachment(Mail mail) {
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		
		try {
			// Setting multipart as true for a attachements to 
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(mail.getDestinataire());
			mimeMessageHelper.setText(mail.getText());
			mimeMessageHelper.setSubject(mail.getObject());
			
			// Adding the attachment
			FileSystemResource file = new FileSystemResource(new File(mail.getFile()));
			
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			
			// Sending the mail
			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		} 
		
		// Catch block to handle MessagingException
		catch (Exception e) {
			// Display message when exception occured
			
			return "Error while sending maill!!!";
		}
	}

	

}
