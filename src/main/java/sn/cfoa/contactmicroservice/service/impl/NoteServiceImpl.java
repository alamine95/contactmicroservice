package sn.cfoa.contactmicroservice.service.impl;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sn.cfoa.contactmicroservice.dto.mapper;
import sn.cfoa.contactmicroservice.dto.requestDto.NoteRequestDto;
import sn.cfoa.contactmicroservice.dto.responseDto.NoteResponseDto;
import sn.cfoa.contactmicroservice.model.Contact;
import sn.cfoa.contactmicroservice.model.Note;
import sn.cfoa.contactmicroservice.repository.NoteRepository;
import sn.cfoa.contactmicroservice.service.ContactService;
import sn.cfoa.contactmicroservice.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
	
	private final NoteRepository noteRepository;
	private ContactService contactService;

	public NoteServiceImpl(NoteRepository noteRepository, ContactService contactService) {
		this.noteRepository = noteRepository;
		this.contactService = contactService;
	}

	@Transactional
	@Override
	public NoteResponseDto addNote(NoteRequestDto noteRequestDto) {
		Note note = new Note();
		note.setRemarque(noteRequestDto.getRemarque());
		if(noteRequestDto.getContactId() == null) {
			throw new IllegalArgumentException("note need a contact");
		}
		Contact contact = contactService.getContact(noteRequestDto.getContactId());
		note.setContact(contact);
		noteRepository.save(note);
		return mapper.noteToNoteResponseDto(note);
	}

	@Override
	public NoteResponseDto getNoteById(Integer noteId) {
		return mapper.noteToNoteResponseDto(getNote(noteId));
	}

	@Override
	public Note getNote(Integer noteId) {
		Note note = noteRepository.findById(noteId).orElseThrow(() ->
				new IllegalArgumentException(
						"note with id:" +noteId+ "could not be found"));
		return note;
	}

	@Override
	public List<NoteResponseDto> getNotes() {
		List<Note> notes = StreamSupport
				.stream(noteRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return mapper.notesToNoteResponseDtos(notes);
	}

	@Transactional
	@Override
	public NoteResponseDto editNote(Integer noteId, NoteRequestDto noteRequestDto) {
		Note noteToEdit = getNote(noteId);
		noteToEdit.setRemarque(noteRequestDto.getRemarque());
		if(noteRequestDto.getContactId() != null) {
			Contact contact = contactService.getContact(noteRequestDto.getContactId());
			noteToEdit.setContact(contact);
		}
		return mapper.noteToNoteResponseDto(noteToEdit);
	}

	@Override
	public NoteResponseDto deleteNote(Integer noteId) {
		Note note = getNote(noteId);
		noteRepository.delete(note);
		return mapper.noteToNoteResponseDto(note);
	}
	

}
