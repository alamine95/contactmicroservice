package sn.cfoa.contactmicroservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.cfoa.contactmicroservice.dto.mapper;
import sn.cfoa.contactmicroservice.dto.requestDto.CategorieRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.CategorieResponseDto;
import sn.cfoa.contactmicroservice.model.Categorie;
import sn.cfoa.contactmicroservice.repository.CategorieRepository;

@Service
public class CategorieServiceImpl implements sn.cfoa.contactmicroservice.service.CategorieService {
	
	@Autowired(required = true)
	private CategorieRepository categorieRepository;
	
	

	public CategorieServiceImpl(CategorieRepository categorieRepository) {
		this.categorieRepository = categorieRepository;
	}

	@Override
	public Categorie addCategorie(CategorieRequestDto categorieRequestDto) {
		Categorie categorie = new Categorie();
		categorie.setCodeCate(categorieRequestDto.getCodeCate());
		categorie.setLibelle(categorieRequestDto.getLibelle());
		categorie.setDesc(categorieRequestDto.getDesc());
		return categorieRepository.save(categorie);
	}

	@Override
	public CategorieResponseDto getCategorieById(Integer categorieId) {
		return mapper.categorieToCategorieResponseDto(getCategorie(categorieId));
	}

	@Override
	public Categorie getCategorie(Integer categorieId) {
		return categorieRepository.findById(categorieId).orElseThrow(() ->
				new IllegalArgumentException("Categorie with categorieId" +categorieId+ "could be not found"));
	}

	@Override
	public List<CategorieResponseDto> getCategories() {
		List<Categorie> categories = StreamSupport
				.stream(categorieRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return mapper.categoriesToCategorieResponseDtos(categories);
	}

	@Override
	public CategorieResponseDto editCategorie(Integer categorieId, CategorieRequestDto categorieRequestDto) {
		Categorie categorieToEdit = getCategorie(categorieId);
		categorieToEdit.setCodeCate(categorieRequestDto.getCodeCate());
		categorieToEdit.setLibelle(categorieRequestDto.getLibelle());
		categorieToEdit.setDesc(categorieRequestDto.getDesc());
		categorieRepository.save(categorieToEdit);
		return mapper.categorieToCategorieResponseDto(categorieToEdit);
	}

	@Override
	public CategorieResponseDto deleteCategorie(Integer categoriId) {
		Categorie categorie = getCategorie(categoriId);
		categorieRepository.delete(categorie);
		return mapper.categorieToCategorieResponseDto(categorie);
	}

}
