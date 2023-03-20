package sn.cfoa.contactmicroservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.cfoa.contactmicroservice.dto.requestDto.CategorieRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.CategorieResponseDto;
import sn.cfoa.contactmicroservice.model.Categorie;
import sn.cfoa.contactmicroservice.service.CategorieService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CategorieController {

	private CategorieService categorieService;

	public CategorieController(CategorieService categorieService) {
		this.categorieService = categorieService;
	}
	
	//build Create Categories REST API
	@PostMapping("/categories")
	public ResponseEntity<Categorie> addCategorie(@RequestBody final CategorieRequestDto categorieRequestDto){
		Categorie categorie = categorieService.addCategorie(categorieRequestDto);
		return new ResponseEntity<>(categorie, HttpStatus.OK);
	}
	
	//build get All categories REST API
	public ResponseEntity<List<CategorieResponseDto>> getCategories(){
		List<CategorieResponseDto> categorieResponseDtos = categorieService.getCategories();
		return new ResponseEntity<>(categorieResponseDtos, HttpStatus.OK);
	}
	
}
