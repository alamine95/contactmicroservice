package sn.cfoa.contactmicroservice.service;

import java.util.List;

import sn.cfoa.contactmicroservice.dto.requestDto.RendezVousRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.RendezVousResponseDto;
import sn.cfoa.contactmicroservice.model.RendezVous;

public interface RendezVousService {

	public RendezVousResponseDto addRendezVous(RendezVousRequestDto rendezVousRequestDto);
	public RendezVousResponseDto getRendezVousId(Integer rendezVousId);
	public RendezVous getRendezVous(Integer rendezVousId);
	public List<RendezVousResponseDto> getRendezVouses();
	public RendezVousResponseDto deleteRendezVous(Integer rendezVousId);
	public RendezVousResponseDto editRendezVous(Integer rendezVousId, RendezVousRequestDto rendezVousRequestDto);
}
