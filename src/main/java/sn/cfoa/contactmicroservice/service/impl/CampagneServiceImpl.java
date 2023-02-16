package sn.cfoa.contactmicroservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.cfoa.contactmicroservice.dto.mapper;
import sn.cfoa.contactmicroservice.dto.requestDto.CampagneRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.CampagneResponseDto;
import sn.cfoa.contactmicroservice.model.Campagne;
import sn.cfoa.contactmicroservice.repository.CampagneRepository;
import sn.cfoa.contactmicroservice.service.CampagneService;

@Service
public class CampagneServiceImpl implements CampagneService {
	
	@Autowired
	private final CampagneRepository campagneRepository;
	
	public CampagneServiceImpl(CampagneRepository campagneRepository) {
		this.campagneRepository = campagneRepository;
	}

	@Override
	public CampagneResponseDto addCampagne(CampagneRequestDto campagneRequestDto) {
		Campagne campagne = new Campagne();
		campagne.setNom(campagneRequestDto.getNom());
		campagne.setDateDebut(campagneRequestDto.getDateDebut());
		campagne.setChiffreAttendue(campagneRequestDto.getChiffreAttendue());
		campagne.setType(campagneRequestDto.getType());
		campagne.setEtape(campagneRequestDto.getEtape());
		campagne.setFin(campagneRequestDto.getFin());
		campagneRepository.save(campagne);
		return mapper.campagneToCampagneResponseDto(campagne);
	}

	@Override
	public CampagneResponseDto getCampagneById(Integer campagneId) {
		Campagne campagne = getCampagne(campagneId);
		return mapper.campagneToCampagneResponseDto(campagne);
	}

	@Override
	public List<CampagneResponseDto> getCampagnes() {
		List<Campagne> campagnes = StreamSupport
				.stream(campagneRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return mapper.campagnesToCampagneResponseDtos(campagnes);
	}

	@Override
	public Campagne getCampagne(Integer campagneId) {
		return campagneRepository.findById(campagneId).orElseThrow(() ->
				new IllegalArgumentException("could not find campagne id:" +campagneId));
	}

	@Override
	public CampagneResponseDto editeCampagne(Integer campagneId, CampagneRequestDto campagneRequestDto) {
		Campagne campagneToEdit = getCampagne(campagneId);
		campagneToEdit.setNom(campagneRequestDto.getNom());
		campagneToEdit.setDateDebut(campagneRequestDto.getDateDebut());
		campagneToEdit.setChiffreAttendue(campagneRequestDto.getChiffreAttendue());
		campagneToEdit.setType(campagneRequestDto.getType());
		campagneToEdit.setEtape(campagneRequestDto.getEtape());
		campagneToEdit.setFin(campagneRequestDto.getFin());
		return mapper.campagneToCampagneResponseDto(campagneToEdit);
	}

	@Override
	public CampagneResponseDto deleteCampagne(Integer campagneId) {
		Campagne campagne = getCampagne(campagneId);
		campagneRepository.delete(campagne);
		return mapper.campagneToCampagneResponseDto(campagne);
	}
}
