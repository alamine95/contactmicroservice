package sn.cfoa.contactmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sn.cfoa.contactmicroservice.model.Tache;

@Repository
public interface TacheRepository extends CrudRepository<Tache, Integer> {

	@Query("FROM Tache where contact_id = :id")
	List<Tache>getTacheByContactId(Integer id);
}
