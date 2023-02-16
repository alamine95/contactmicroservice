package sn.cfoa.contactmicroservice.controller;

import java.util.List;

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

import sn.cfoa.contactmicroservice.dto.requestDto.RendezVousRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.RendezVousResponseDto;
import sn.cfoa.contactmicroservice.service.RendezVousService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class RendezVousController {

	private RendezVousService rendezVousService;

	public RendezVousController(RendezVousService rendezVousService) {
		this.rendezVousService = rendezVousService;
	}
	
	@PostMapping("/rendezVous")
	public ResponseEntity<RendezVousResponseDto> addRendezVous(@RequestBody final RendezVousRequestDto rendezVousRequestDto){
		RendezVousResponseDto rendezVousResponseDto = rendezVousService.addRendezVous(rendezVousRequestDto);
		return new ResponseEntity<>(rendezVousResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/rendezVous/{id}")
	public ResponseEntity<RendezVousResponseDto> getRendezVous(@PathVariable final Integer id){
		RendezVousResponseDto rendezVousResponseDto = rendezVousService.getRendezVousId(id);
		return new ResponseEntity<>(rendezVousResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/rendezVous")
	public ResponseEntity<List<RendezVousResponseDto>> getRendezVouses(){
		List<RendezVousResponseDto> rendezVousResponseDtos = rendezVousService.getRendezVouses();
		return new ResponseEntity<>(rendezVousResponseDtos, HttpStatus.OK);
	}
	
	@DeleteMapping("/rendezVous/{id}")
	public ResponseEntity<RendezVousResponseDto> deleteRendezVous(@PathVariable final Integer id){
		RendezVousResponseDto rendezVousResponseDto = rendezVousService.deleteRendezVous(id);
		return new ResponseEntity<>(rendezVousResponseDto, HttpStatus.OK);
	}
	
	@PostMapping("/rendezVous/{id}")
	public ResponseEntity<RendezVousResponseDto> editRendezVous(@RequestBody final RendezVousRequestDto rendezVousRequestDto,
											@PathVariable final Integer id){
		RendezVousResponseDto rendezVousResponseDto = rendezVousService.editRendezVous(id, rendezVousRequestDto);
		return new ResponseEntity<>(rendezVousResponseDto, HttpStatus.OK);
	}

}
