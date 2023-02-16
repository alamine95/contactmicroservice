package sn.cfoa.contactmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.cfoa.contactmicroservice.dto.requestDto.LeadRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.LeadResponseDto;
import sn.cfoa.contactmicroservice.service.LeadService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class LeadController {

	@Autowired(required = true)
	private final LeadService leadService;

	public LeadController(LeadService leadService) {
		this.leadService = leadService;
	}
	
	@PostMapping("/leads")
	public ResponseEntity<LeadResponseDto> addLead(@RequestBody final LeadRequestDto leadRequestDto){
		LeadResponseDto leadResponseDto = leadService.addLead(leadRequestDto);
		return new ResponseEntity<>(leadResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/leads/{id}")
	public ResponseEntity<LeadResponseDto> getLeadById(@PathVariable final Integer id){
		LeadResponseDto leadResponseDto = leadService.getLeadById(id);
		return new ResponseEntity<>(leadResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/leads")
	public ResponseEntity<List<LeadResponseDto>> getLeads(){
		List<LeadResponseDto> leadResponseDtos = leadService.getLeads();
		return new ResponseEntity<>(leadResponseDtos, HttpStatus.OK);
	}
	
	@PostMapping("/leads/{id}")
	public ResponseEntity<LeadResponseDto> editLead(@RequestBody final LeadRequestDto leadRequestDto, 
													@PathVariable final Integer id){
		LeadResponseDto leadResponseDto = leadService.editLead(id, leadRequestDto);
		return new ResponseEntity<>(leadResponseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/leads/{id}")
	public ResponseEntity<LeadResponseDto> deleteLead(@PathVariable final Integer id){
		LeadResponseDto leadResponseDto = leadService.deleteLead(id);
		return new ResponseEntity<>(leadResponseDto, HttpStatus.OK);
	}
	
}
