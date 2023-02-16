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

import sn.cfoa.contactmicroservice.dto.requestDto.OpportuniteRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.OpportuniteResponseDto;
import sn.cfoa.contactmicroservice.service.OpportuniteService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class OpportuniteController {

	@Autowired
	private final OpportuniteService opportuniteService;
	

	public OpportuniteController(OpportuniteService opportuniteService) {
		this.opportuniteService = opportuniteService;
	}
	
	// Create Opportunite Endpoit RestAPI
	@PostMapping("opportunites")
	public ResponseEntity<OpportuniteResponseDto> addOpportunite(@RequestBody final OpportuniteRequestDto opportuniteRequestDto){
		OpportuniteResponseDto opportuniteResponseDto = opportuniteService.addOpportunite(opportuniteRequestDto);
		return new ResponseEntity<>(opportuniteResponseDto, HttpStatus.OK);
	}
	
	// Get Single Opportunite with id Endpoit RestAPI
	@GetMapping("/opportunites/{id}")
	public ResponseEntity<OpportuniteResponseDto> getOpportunite(@PathVariable final Integer id){
		OpportuniteResponseDto opportuniteResponseDto = opportuniteService.getOpportuniteById(id);
		return new ResponseEntity<>(opportuniteResponseDto, HttpStatus.OK);
	}
	
	// Get All Opportunites Endpoit RestAPI
	@GetMapping("/opportunites")
	public ResponseEntity<List<OpportuniteResponseDto>> getOpportunites(){
		List<OpportuniteResponseDto> opportuniteResponseDtos = opportuniteService.getOpportunites();
		return new ResponseEntity<>(opportuniteResponseDtos, HttpStatus.OK);
	}
	
	// Edite Opportunite By Id
	@PostMapping("/opportunites/{id}")
	public ResponseEntity<OpportuniteResponseDto> editeOpportunite(@PathVariable final Integer id,
																	@RequestBody final OpportuniteRequestDto opportuniteRequestDto){
		OpportuniteResponseDto opportuniteResponseDto = opportuniteService.editOpportunite(id, opportuniteRequestDto);
		return new ResponseEntity<>(opportuniteResponseDto, HttpStatus.OK);
	}
	
	// Delete Opportunite By Id
	@DeleteMapping("/opportunites/{id}")
	public ResponseEntity<OpportuniteResponseDto> deleteOpportunite(@PathVariable final Integer id){
		OpportuniteResponseDto opportuniteResponseDto = opportuniteService.deleteOpportunite(id);
		return new ResponseEntity<>(opportuniteResponseDto, HttpStatus.OK);
	}
}
