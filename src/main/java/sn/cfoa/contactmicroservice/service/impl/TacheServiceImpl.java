package sn.cfoa.contactmicroservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sn.cfoa.contactmicroservice.dto.mapper;
import sn.cfoa.contactmicroservice.dto.requestDto.TacheRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.TacheResponseDto;
import sn.cfoa.contactmicroservice.model.Contact;
import sn.cfoa.contactmicroservice.model.Tache;
import sn.cfoa.contactmicroservice.repository.TacheRepository;
import sn.cfoa.contactmicroservice.service.ContactService;
import sn.cfoa.contactmicroservice.service.TacheService;

@Service
public class TacheServiceImpl implements TacheService {
	
	private final TacheRepository tacheRepository;
	private ContactService contactService;
	
	public TacheServiceImpl(TacheRepository tacheRepository, ContactService contactService) {
		this.tacheRepository = tacheRepository;
		this.contactService = contactService;
	}

	@Transactional
	@Override
	public TacheResponseDto addTache(TacheRequestDto tacheRequestDto) {
		Tache tache = new Tache();
		tache.setObject(tacheRequestDto.getObject());
		tache.setDateEcheance(tacheRequestDto.getDateEcheance());
		tache.setEtape(tacheRequestDto.getEtape());
		tache.setPriorite(tacheRequestDto.getPriorite());
		if(tacheRequestDto.getContactId() == null) {
			throw new IllegalArgumentException("note need a contact");
		}
		Contact contact = contactService.getContact(tacheRequestDto.getContactId());
		tache.setContact(contact);
		tacheRepository.save(tache);
		return mapper.tacheToTacheResponseDto(tache);
	}

	@Override
	public TacheResponseDto getTacheById(Integer tacheId) {
		return mapper.tacheToTacheResponseDto(getTache(tacheId));
	}

	@Override
	public Tache getTache(Integer tacheId) {
		Tache tache = tacheRepository.findById(tacheId).orElseThrow(() -> 
				new IllegalArgumentException(
						"tache with id:" +tacheId+ "could not be found"));
		return tache;
	}

	@Override
	public List<TacheResponseDto> getTaches() {
		List<Tache> taches = StreamSupport
				.stream(tacheRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return mapper.tachesToTacheResponseDtos(taches);
	}

	@Transactional
	@Override
	public TacheResponseDto editTache(Integer tacheId, TacheRequestDto tacheRequestDto) {
		Tache tacheToEdit = getTache(tacheId);
		tacheToEdit.setObject(tacheRequestDto.getObject());
		tacheToEdit.setDateEcheance(tacheRequestDto.getDateEcheance());
		tacheToEdit.setEtape(tacheRequestDto.getEtape());
		tacheToEdit.setPriorite(tacheRequestDto.getPriorite());
		if(tacheRequestDto.getContactId() != null) {
			Contact contact = contactService.getContact(tacheRequestDto.getContactId());
			tacheToEdit.setContact(contact);
		}
		return mapper.tacheToTacheResponseDto(tacheToEdit);
	}

	@Transactional
	@Override
	public TacheResponseDto deleteTache(Integer tacheId) {
		Tache tache = getTache(tacheId);
		tacheRepository.delete(tache);
		return mapper.tacheToTacheResponseDto(tache);
	}
	
}
