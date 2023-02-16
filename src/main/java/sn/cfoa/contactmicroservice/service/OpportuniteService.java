package sn.cfoa.contactmicroservice.service;

import java.util.List;

import sn.cfoa.contactmicroservice.dto.requestDto.OpportuniteRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.OpportuniteResponseDto;
import sn.cfoa.contactmicroservice.model.Opportunite;

public interface OpportuniteService {

	public OpportuniteResponseDto addOpportunite(OpportuniteRequestDto opportuniteRequestDto);
	public List<OpportuniteResponseDto> getOpportunites();
	public OpportuniteResponseDto getOpportuniteById(Integer opportuniteId);
	public Opportunite getOpportunite(Integer opportuniteId);
	public OpportuniteResponseDto editOpportunite(Integer opportuniteId, OpportuniteRequestDto opportuniteRequestDto);
	public OpportuniteResponseDto deleteOpportunite(Integer opportuniteId);
}
