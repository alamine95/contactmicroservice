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

import sn.cfoa.contactmicroservice.dto.requestDto.NoteRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.NoteResponseDto;
import sn.cfoa.contactmicroservice.model.Note;
import sn.cfoa.contactmicroservice.repository.NoteRepository;
import sn.cfoa.contactmicroservice.service.NoteService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class NoteController {
	
	@Autowired
	private NoteRepository noteRepository;
	
	private NoteService noteService;

	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@PostMapping("/notes")
	public ResponseEntity<NoteResponseDto> addNote(@RequestBody final NoteRequestDto noteRequestDto){
		NoteResponseDto noteResponseDto = noteService.addNote(noteRequestDto);
		return new ResponseEntity<>(noteResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/netes/{id}")
	public ResponseEntity<NoteResponseDto> getNote(@PathVariable final Integer id){
		NoteResponseDto noteResponseDto = noteService.getNoteById(id);
		return new ResponseEntity<>(noteResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/notes")
	public ResponseEntity<List<NoteResponseDto>> getNotes(){
		List<NoteResponseDto> noteResponseDtos = noteService.getNotes();
		return new ResponseEntity<>(noteResponseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/notes/contact/{id}")
	public ResponseEntity<List<Note>> getNoteByContact(@PathVariable Integer id){
		return new ResponseEntity<List<Note>>(noteRepository.getNoteByContactId(id), HttpStatus.OK);
	}
	
	@PostMapping("/notes/{id}")
	public ResponseEntity<NoteResponseDto> editNote(@RequestBody final NoteRequestDto noteRequestDto,
													@PathVariable final Integer id){
		NoteResponseDto noteResponseDto = noteService.editNote(id, noteRequestDto);
		return new ResponseEntity<>(noteResponseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<NoteResponseDto> deleteNote(@PathVariable final Integer id){
		NoteResponseDto noteResponseDto = noteService.deleteNote(id);
		return new ResponseEntity<>(noteResponseDto, HttpStatus.OK);
	}
	
}
