package sn.cfoa.contactmicroservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.cfoa.contactmicroservice.dto.mapper;
import sn.cfoa.contactmicroservice.dto.requestDto.ContactRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.ContactResponseDto;
import sn.cfoa.contactmicroservice.model.Contact;
import sn.cfoa.contactmicroservice.repository.ContactRepository;
import sn.cfoa.contactmicroservice.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired(required = true)
	private ContactRepository contactRepository;
	
	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public Contact addContact(ContactRequestDto contactRequestDto) {
		Contact contact = new Contact();
		contact.setNom(contactRequestDto.getNom());
		contact.setPrenom(contactRequestDto.getPrenom());
		contact.setGenre(contactRequestDto.getGenre());
		contact.setAdresse(contactRequestDto.getAdresse());
		contact.setTelephone(contactRequestDto.getTelephone());
		contact.setEmail(contactRequestDto.getEmail());
		contact.setType(contactRequestDto.getType());
		return contactRepository.save(contact);
	}

	@Override
	public List<ContactResponseDto> getContacts() {
		List<Contact> contacts = StreamSupport
				.stream(contactRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return mapper.contactsToContactResponseDtos(contacts);
	}

	@Override
	public Contact getContact(Integer contactId) {
		return contactRepository.findById(contactId).orElseThrow(() ->
				new IllegalArgumentException("Contact with contactId " +contactId+ "could be not found"));
	}

	@Override
	public ContactResponseDto getContactById(Integer contactId) {
		return mapper.contactToContactResponseDto(getContact(contactId));
	}

	@Override
	public ContactResponseDto editContact(Integer contactId, ContactRequestDto contactRequestDto) {
		Contact contactToEdit = getContact(contactId);
		contactToEdit.setNom(contactRequestDto.getNom());
		contactToEdit.setPrenom(contactRequestDto.getPrenom());
		contactToEdit.setGenre(contactRequestDto.getGenre());
		contactToEdit.setAdresse(contactRequestDto.getAdresse());
		contactToEdit.setTelephone(contactRequestDto.getTelephone());
		contactToEdit.setEmail(contactRequestDto.getEmail());
		contactToEdit.setType(contactRequestDto.getType());
		contactRepository.save(contactToEdit);
		return mapper.contactToContactResponseDto(contactToEdit);
	}

	@Override
	public ContactResponseDto deleteContact(Integer contactId) {
		Contact contact = getContact(contactId);
		contactRepository.delete(contact);
		return mapper.contactToContactResponseDto(contact);
	}
	
	
	

}
