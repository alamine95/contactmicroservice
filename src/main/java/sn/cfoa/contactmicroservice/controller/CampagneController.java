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

import sn.cfoa.contactmicroservice.dto.requestDto.CampagneRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.CampagneResponseDto;
import sn.cfoa.contactmicroservice.service.CampagneService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CampagneController {

	private final CampagneService campagneService;

	public CampagneController(CampagneService campagneService) {
		this.campagneService = campagneService;
	}
	
	@PostMapping("/campagnes")
	public ResponseEntity<CampagneResponseDto> addCampagne(@RequestBody final CampagneRequestDto campagneRequestDto){
		CampagneResponseDto campagneResponseDto = campagneService.addCampagne(campagneRequestDto);
		return new ResponseEntity<>(campagneResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/campagnes")
	public ResponseEntity<List<CampagneResponseDto>> getCampagnes(){
		List<CampagneResponseDto> campagneResponseDtos = campagneService.getCampagnes();
		return new ResponseEntity<>(campagneResponseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/campagnes/{id}")
	public ResponseEntity<CampagneResponseDto> getCampagne(@PathVariable final Integer id){
		CampagneResponseDto campagneResponseDto = campagneService.getCampagneById(id);
		return new ResponseEntity<>(campagneResponseDto, HttpStatus.OK);
	}
	
	@PostMapping("/campagnes/{id}")
	public ResponseEntity<CampagneResponseDto> editeCampagne(
				@RequestBody final CampagneRequestDto campagneRequestDto,
				@PathVariable final Integer id){
		CampagneResponseDto campagneResponseDto = campagneService.editeCampagne(id, campagneRequestDto);
		return new ResponseEntity<>(campagneResponseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/campagnes/{id}")
	public ResponseEntity<CampagneResponseDto> deleteCampagne(@PathVariable final Integer id){
		CampagneResponseDto campagneResponseDto = campagneService.deleteCampagne(id);
		return new ResponseEntity<>(campagneResponseDto, HttpStatus.OK);
	}
	
}
