package sn.cfoa.contactmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sn.cfoa.contactmicroservice.model.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {

	@Query("FROM Note where contact_id = :id")
	List<Note> getNoteByContactId(Integer id);
}
