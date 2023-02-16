package sn.cfoa.contactmicroservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.cfoa.contactmicroservice.dto.mapper;
import sn.cfoa.contactmicroservice.dto.requestDto.OpportuniteRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.OpportuniteResponseDto;
import sn.cfoa.contactmicroservice.model.Contact;
import sn.cfoa.contactmicroservice.model.Opportunite;
import sn.cfoa.contactmicroservice.repository.OpportuniteRepository;
import sn.cfoa.contactmicroservice.service.ContactService;
import sn.cfoa.contactmicroservice.service.OpportuniteService;

@Service
public class OpportuniteServiceImpl implements OpportuniteService {

	@Autowired
	private final OpportuniteRepository opportuniteRepository;
	@Autowired
	private final ContactService contactService;
	
	public OpportuniteServiceImpl(OpportuniteRepository opportuniteRepository, ContactService contactService) {
		this.opportuniteRepository = opportuniteRepository;
		this.contactService = contactService;
	}

	@Transactional
	@Override
	public OpportuniteResponseDto addOpportunite(OpportuniteRequestDto opportuniteRequestDto) {
		Opportunite opportunite = new Opportunite();
		opportunite.setNom(opportuniteRequestDto.getNom());
		opportunite.setType(opportuniteRequestDto.getType());
		opportunite.setEtape(opportuniteRequestDto.getEtape());
		opportunite.setMontant(opportuniteRequestDto.getMontant());
		opportunite.setDate(opportuniteRequestDto.getDate());
		if(opportuniteRequestDto.getContactId() == null) {
			throw new IllegalArgumentException("opportinute need a contact");
		}
		Contact contact = contactService.getContact(opportuniteRequestDto.getContactId());
		opportunite.setContact(contact);
		opportuniteRepository.save(opportunite);
		return mapper.opportuniteToOpportuniteResponseDto(opportunite);
	}

	@Override
	public List<OpportuniteResponseDto> getOpportunites() {
		List<Opportunite> opportunites = StreamSupport
				.stream(opportuniteRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return mapper.opportunitesToOpportuniteResponseDtos(opportunites);
	}

	@Override
	public OpportuniteResponseDto getOpportuniteById(Integer opportuniteId) {
		return mapper.opportuniteToOpportuniteResponseDto(getOpportunite(opportuniteId));
	}

	@Override
	public Opportunite getOpportunite(Integer opportuniteId) {
		Opportunite opportunite = opportuniteRepository.findById(opportuniteId).orElseThrow(() ->
					new IllegalArgumentException(
							"opportunite with id:" +opportuniteId+ "could not be found"));
		return opportunite;
	}

	@Override
	public OpportuniteResponseDto editOpportunite(Integer opportuniteId, OpportuniteRequestDto opportuniteRequestDto) {
		Opportunite opportuniteToEdit = getOpportunite(opportuniteId);
		opportuniteToEdit.setNom(opportuniteRequestDto.getNom());
		opportuniteToEdit.setType(opportuniteRequestDto.getType());
		opportuniteToEdit.setEtape(opportuniteRequestDto.getEtape());
		opportuniteToEdit.setMontant(opportuniteRequestDto.getMontant());
		opportuniteToEdit.setDate(opportuniteRequestDto.getDate());
		if(opportuniteRequestDto.getContactId() != null) {
			Contact contact = contactService.getContact(opportuniteRequestDto.getContactId());
			opportuniteToEdit.setContact(contact);
		}
		return mapper.opportuniteToOpportuniteResponseDto(opportuniteToEdit);
	}

	@Override
	public OpportuniteResponseDto deleteOpportunite(Integer opportuniteId) {
		Opportunite opportunite = getOpportunite(opportuniteId);
		opportuniteRepository.delete(opportunite);
		return mapper.opportuniteToOpportuniteResponseDto(opportunite);
	}							
	
}
