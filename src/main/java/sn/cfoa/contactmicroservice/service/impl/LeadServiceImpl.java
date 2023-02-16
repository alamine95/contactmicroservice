package sn.cfoa.contactmicroservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sn.cfoa.contactmicroservice.dto.mapper;
import sn.cfoa.contactmicroservice.dto.requestDto.LeadRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.LeadResponseDto;
import sn.cfoa.contactmicroservice.model.Campagne;
import sn.cfoa.contactmicroservice.model.Lead;
import sn.cfoa.contactmicroservice.repository.LeadRepository;
import sn.cfoa.contactmicroservice.service.CampagneService;
import sn.cfoa.contactmicroservice.service.LeadService;

@Service
public class LeadServiceImpl implements LeadService {
	
	private final LeadRepository leadRepository;
	private CampagneService campagneService;

	public LeadServiceImpl(LeadRepository leadRepository, CampagneService campagneService) {
		this.leadRepository = leadRepository;
		this.campagneService = campagneService;
	}

	@Override
	public LeadResponseDto addLead(LeadRequestDto leadRequestDto) {
		Lead lead = new Lead();
		lead.setNom(leadRequestDto.getNom());
		lead.setPrenom(leadRequestDto.getPrenom());
		lead.setAge(leadRequestDto.getAge());
		lead.setGenre(leadRequestDto.getGenre());
		lead.setProfession(leadRequestDto.getProfession());
		if(leadRequestDto.getCampagneId() == null) {
			throw new IllegalArgumentException("Lead need a campagne");
		}
		Campagne campagne = campagneService.getCampagne(leadRequestDto.getCampagneId());
		lead.setCampagne(campagne);
		leadRepository.save(lead);
		return mapper.leadToLeadResponseDto(lead);
	}

	@Override
	public LeadResponseDto getLeadById(Integer leadId) {
		return mapper.leadToLeadResponseDto(getLead(leadId));
	}

	@Override
	public Lead getLead(Integer leadId) {
		Lead lead = leadRepository.findById(leadId).orElseThrow(() ->
				new IllegalArgumentException("lead with id:" +leadId+ "could not be found"));
		return lead;
	}

	@Override
	public List<LeadResponseDto> getLeads() {
		List<Lead> leads = StreamSupport
				.stream(leadRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return mapper.leadsToLeadResponseDtos(leads);
	}

	@Transactional
	@Override
	public LeadResponseDto editLead(Integer leadId, LeadRequestDto leadRequestDto) {
		Lead leadToEdit = getLead(leadId);
		leadToEdit.setNom(leadRequestDto.getNom());
		leadToEdit.setPrenom(leadRequestDto.getPrenom());
		leadToEdit.setAge(leadRequestDto.getAge());
		leadToEdit.setGenre(leadRequestDto.getGenre());
		leadToEdit.setProfession(leadRequestDto.getProfession());
		if(leadRequestDto.getCampagneId() != null) {
			Campagne campagne = campagneService.getCampagne(leadRequestDto.getCampagneId());
			leadToEdit.setCampagne(campagne);
		}
		leadRepository.save(leadToEdit);
		return mapper.leadToLeadResponseDto(leadToEdit);
	}

	@Override
	public LeadResponseDto deleteLead(Integer leadId) {
		Lead lead = getLead(leadId);
		leadRepository.delete(lead);
		return mapper.leadToLeadResponseDto(lead);
	}

}
