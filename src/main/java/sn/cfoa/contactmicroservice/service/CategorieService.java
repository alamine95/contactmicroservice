package sn.cfoa.contactmicroservice.service;

import java.util.List;

import sn.cfoa.contactmicroservice.dto.requestDto.CategorieRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.CategorieResponseDto;
import sn.cfoa.contactmicroservice.model.Categorie;

public interface CategorieService {

	public Categorie addCategorie(CategorieRequestDto categorieRequestDto);
	public CategorieResponseDto getCategorieById(Integer categorieId);
	public Categorie getCategorie(Integer categorieId);
	public List<CategorieResponseDto> getCategories();
	public CategorieResponseDto editCategorie(Integer categorieId, CategorieRequestDto categorieRequestDto);
	public CategorieResponseDto deleteCategorie(Integer categoriId);
}
