package sn.cfoa.contactmicroservice.service;

import java.util.List;

import sn.cfoa.contactmicroservice.dto.requestDto.CampagneRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.CampagneResponseDto;
import sn.cfoa.contactmicroservice.model.Campagne;

public interface CampagneService {

	public CampagneResponseDto addCampagne(CampagneRequestDto campagneRequestDto);
	public CampagneResponseDto getCampagneById(Integer campagneId);
	public List<CampagneResponseDto> getCampagnes();
	public Campagne getCampagne(Integer campagneId);
	public CampagneResponseDto editeCampagne(Integer campagneId, CampagneRequestDto campagneRequestDto);
	public CampagneResponseDto deleteCampagne(Integer campagneId);
}
