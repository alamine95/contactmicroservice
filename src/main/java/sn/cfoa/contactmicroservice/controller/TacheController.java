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

import sn.cfoa.contactmicroservice.dto.requestDto.TacheRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.TacheResponseDto;
import sn.cfoa.contactmicroservice.model.Tache;
import sn.cfoa.contactmicroservice.repository.TacheRepository;
import sn.cfoa.contactmicroservice.service.TacheService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TacheController {
	
	@Autowired
	private TacheRepository tacheRepository;

	@Autowired(required = true)
	private final TacheService tacheService;
	
	public TacheController(TacheService tacheService) {
		this.tacheService = tacheService;
	}

	@PostMapping("/taches")
	public ResponseEntity<TacheResponseDto> addTache(@RequestBody final TacheRequestDto tacheRequestDto){
		TacheResponseDto tacheResponseDto = tacheService.addTache(tacheRequestDto);
		return new ResponseEntity<>(tacheResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/taches/{id}")
	public ResponseEntity<TacheResponseDto> getTache(@PathVariable final Integer id){
		TacheResponseDto tacheResponseDto = tacheService.getTacheById(id);
		return new ResponseEntity<>(tacheResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/taches")
	public ResponseEntity<List<TacheResponseDto>> getTaches(){
		List<TacheResponseDto> tacheResponseDtos = tacheService.getTaches();
		return new ResponseEntity<>(tacheResponseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/taches/contact/{id}")
	public ResponseEntity<List<Tache>> getTacheByContact(@PathVariable Integer id){
		return new ResponseEntity<List<Tache>>(tacheRepository.getTacheByContactId(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/taches/{id}")
	public ResponseEntity<TacheResponseDto> deleteTache(@PathVariable final Integer id){
		TacheResponseDto tacheResponseDto = tacheService.deleteTache(id);
		return new ResponseEntity<>(tacheResponseDto, HttpStatus.OK);
	}
	
	@PostMapping("/taches/{id}")
	public ResponseEntity<TacheResponseDto> editTache(@RequestBody final TacheRequestDto tacheRequestDto,
													  @PathVariable final Integer id){
		TacheResponseDto tacheResponseDto = tacheService.editTache(id, tacheRequestDto);
		return new ResponseEntity<>(tacheResponseDto, HttpStatus.OK);
	}
	
}
