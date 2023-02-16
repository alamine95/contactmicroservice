package sn.cfoa.contactmicroservice.repository;

import org.springframework.data.repository.CrudRepository;

import sn.cfoa.contactmicroservice.model.Note;

public interface NoteRepository extends CrudRepository<Note, Integer> {

}
