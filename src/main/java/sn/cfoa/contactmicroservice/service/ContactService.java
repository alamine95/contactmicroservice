package sn.cfoa.contactmicroservice.service;


import java.util.List;

import sn.cfoa.contactmicroservice.dto.requestDto.ContactRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.ContactResponseDto;
import sn.cfoa.contactmicroservice.model.Contact;

public interface ContactService {

	public Contact addContact(ContactRequestDto contactRequestDto);
	public ContactResponseDto getContactById(Integer contactId);
	public Contact getContact(Integer contactId);
	public List<ContactResponseDto> getContacts();
	public ContactResponseDto editContact(Integer contactId, ContactRequestDto contactRequestDto);
	public ContactResponseDto deleteContact(Integer contactId);
	
}
