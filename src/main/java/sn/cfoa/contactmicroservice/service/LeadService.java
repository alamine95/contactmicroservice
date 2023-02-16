package sn.cfoa.contactmicroservice.service;

import java.util.List;

import sn.cfoa.contactmicroservice.dto.requestDto.LeadRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.LeadResponseDto;
import sn.cfoa.contactmicroservice.model.Lead;

public interface LeadService {

	public LeadResponseDto addLead(LeadRequestDto leadRequestDto);
	public LeadResponseDto getLeadById(Integer leadId);
	public Lead getLead(Integer leadId);
	public List<LeadResponseDto> getLeads();
	public LeadResponseDto editLead(Integer leadId, LeadRequestDto leadRequestDto);
	public LeadResponseDto deleteLead(Integer leadId);
}
