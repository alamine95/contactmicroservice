package sn.cfoa.contactmicroservice.service;

import java.util.List;

import sn.cfoa.contactmicroservice.dto.requestDto.TacheRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.TacheResponseDto;
import sn.cfoa.contactmicroservice.model.Tache;

public interface TacheService {

	public TacheResponseDto addTache(TacheRequestDto tacheRequestDto);
	public TacheResponseDto getTacheById(Integer tacheId);
	public Tache getTache(Integer tacheId);
	public List<TacheResponseDto> getTaches();
	public TacheResponseDto editTache(Integer tacheId, TacheRequestDto tacheRequestDto);
	public TacheResponseDto deleteTache(Integer tacheId);
}
