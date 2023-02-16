package sn.cfoa.contactmicroservice.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.cfoa.contactmicroservice.dto.requestDto.ContactRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.ContactResponseDto;
import sn.cfoa.contactmicroservice.model.Contact;
import sn.cfoa.contactmicroservice.service.ContactService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

	private ContactService contactService;

	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	// build create contacts REST API
	@PostMapping("/contacts")
	public ResponseEntity<Contact> addContact(@RequestBody final ContactRequestDto contactRequestDto){
		Contact contact = contactService.addContact(contactRequestDto);
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}
	
	// build getAll contacts REST API
	@GetMapping("/contacts")
	public ResponseEntity<List<ContactResponseDto>> getContacts(){
		List<ContactResponseDto> contactResponseDtos = contactService.getContacts();
		return new ResponseEntity<>(contactResponseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/contacts/{id}")
	public ResponseEntity<ContactResponseDto> getContactById(@PathVariable final Integer id){
		ContactResponseDto contactResponseDto = contactService.getContactById(id);
		return new ResponseEntity<>(contactResponseDto, HttpStatus.OK);
	}
	
	@PostMapping("/contacts/{id}")
	public ResponseEntity<ContactResponseDto> editContact(@RequestBody final ContactRequestDto contactRequestDto,
															@PathVariable final Integer id){
		ContactResponseDto contactResponseDto = contactService.editContact(id, contactRequestDto);
		return new ResponseEntity<>(contactResponseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<ContactResponseDto> deleteContact(@PathVariable final Integer id){
		ContactResponseDto contactResponseDto = contactService.deleteContact(id);
		return new ResponseEntity<>(contactResponseDto, HttpStatus.OK);
	}
	
			
}
