package sn.cfoa.contactmicroservice.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import sn.cfoa.contactmicroservice.helper.ExcelHelper;
import sn.cfoa.contactmicroservice.model.Contact;
import sn.cfoa.contactmicroservice.repository.ContactRepository;

@Service
public class ExcelService {

	@Autowired
	private ContactRepository contactRepository;
	
	public ByteArrayInputStream load() {
		List<Contact> contacts = (List<Contact>) contactRepository.findAll();
		
		ByteArrayInputStream in = ExcelHelper.contactsToExcel(contacts);
		return in;
	}
	
	public void save(MultipartFile file) {
		try {
			List<Contact> contacts = ExcelHelper.excelToContacts(file.getInputStream());
			contactRepository.saveAll(contacts);
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " +e.getMessage());
		}
	}
	
}
