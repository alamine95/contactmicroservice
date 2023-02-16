package sn.cfoa.contactmicroservice.service;

import sn.cfoa.contactmicroservice.model.Mail;

public interface MaillService  {

	//Send a simple email
	String sendSimpleMail(Mail mail);
	
	//To send an email with attachement
	String sendMailWithAttachment(Mail mail);
}
