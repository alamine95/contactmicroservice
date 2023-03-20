package sn.cfoa.contactmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sn.cfoa.contactmicroservice.model.Opportunite;

@Repository
public interface OpportuniteRepository extends JpaRepository<Opportunite, Integer> {

	@Query("FROM Opportunite  where contact_id = :id")
	List<Opportunite> getOpportuniteByContactId(Integer id);
}
