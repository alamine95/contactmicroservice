package sn.cfoa.contactmicroservice.service;


import java.util.List;

import sn.cfoa.contactmicroservice.dto.requestDto.NoteRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.NoteResponseDto;
import sn.cfoa.contactmicroservice.model.Note;

public interface NoteService {

	public NoteResponseDto addNote(NoteRequestDto noteRequestDto);
	public NoteResponseDto getNoteById(Integer noteId);
	public Note getNote(Integer noteId);
	public List<NoteResponseDto> getNotes();
	public NoteResponseDto editNote(Integer noteId, NoteRequestDto noteRequestDto);
	public NoteResponseDto deleteNote(Integer noteId);
}
