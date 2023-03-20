package sn.cfoa.contactmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sn.cfoa.contactmicroservice.model.RendezVous;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Integer> {

	@Query("FROM RendezVous where contact_id = :id")
	List<RendezVous> getRendezVousByContactId(Integer id);
}
