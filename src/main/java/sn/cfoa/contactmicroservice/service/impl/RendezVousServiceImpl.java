package sn.cfoa.contactmicroservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sn.cfoa.contactmicroservice.dto.mapper;
import sn.cfoa.contactmicroservice.dto.requestDto.RendezVousRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.RendezVousResponseDto;
import sn.cfoa.contactmicroservice.model.Contact;
import sn.cfoa.contactmicroservice.model.RendezVous;
import sn.cfoa.contactmicroservice.repository.RendezVousRepository;
import sn.cfoa.contactmicroservice.service.ContactService;
import sn.cfoa.contactmicroservice.service.RendezVousService;

@Service
public class RendezVousServiceImpl implements RendezVousService {
	
	private final RendezVousRepository rendezVousRepository;
	private ContactService contactService;

	public RendezVousServiceImpl(RendezVousRepository rendezVousRepository, ContactService contactService) {
		this.rendezVousRepository = rendezVousRepository;
		this.contactService = contactService;
	}

	@Transactional
	@Override
	public RendezVousResponseDto addRendezVous(RendezVousRequestDto rendezVousRequestDto) {
		RendezVous rendezVous = new RendezVous();
		rendezVous.setDate(rendezVousRequestDto.getDate());
		rendezVous.setHeure(rendezVousRequestDto.getHeure());
		rendezVous.setObject(rendezVousRequestDto.getObject());
		if(rendezVousRequestDto.getContactId() == null) {
			throw new IllegalArgumentException("rendez-vous need a contact");
		}
		Contact contact = contactService.getContact(rendezVousRequestDto.getContactId());
		rendezVous.setContact(contact);
		rendezVousRepository.save(rendezVous);
		return null;
	}

	@Override
	public RendezVousResponseDto getRendezVousId(Integer rendezVousId) {
		return mapper.rendezVousToRendezVousResponseDto(getRendezVous(rendezVousId));
	}

	@Override
	public RendezVous getRendezVous(Integer rendezVousId) {
		RendezVous rendeVous = rendezVousRepository.findById(rendezVousId).orElseThrow(() ->
				new IllegalArgumentException(
						"rendez-vous with id:" +rendezVousId+ "could not be found"));
		return rendeVous;
	}

	@Override
	public List<RendezVousResponseDto> getRendezVouses() {
		List<RendezVous> rendezVous = StreamSupport
				.stream(rendezVousRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return mapper.rendezVousesToRendezVousResponseDtos(rendezVous);
	}

	@Override
	public RendezVousResponseDto deleteRendezVous(Integer rendezVousId) {
		RendezVous rendezVous = getRendezVous(rendezVousId);
		rendezVousRepository.delete(rendezVous);
		return mapper.rendezVousToRendezVousResponseDto(rendezVous);
	}

	@Transactional
	@Override
	public RendezVousResponseDto editRendezVous(Integer rendezVousId, RendezVousRequestDto rendezVousRequestDto) {
		RendezVous rendezVousToEdit = getRendezVous(rendezVousId);
		rendezVousToEdit.setDate(rendezVousRequestDto.getDate());
		rendezVousToEdit.setHeure(rendezVousRequestDto.getHeure());
		rendezVousToEdit.setObject(rendezVousRequestDto.getObject());
		if(rendezVousRequestDto.getContactId() != null) {
			Contact contact = contactService.getContact(rendezVousRequestDto.getContactId());
			rendezVousToEdit.setContact(contact);
		}
		return mapper.rendezVousToRendezVousResponseDto(rendezVousToEdit);
	}

}
