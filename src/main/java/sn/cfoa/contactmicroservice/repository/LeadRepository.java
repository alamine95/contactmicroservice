package sn.cfoa.contactmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sn.cfoa.contactmicroservice.model.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {

	@Query("FROM Lead where campagne_id = :id")
	List<Lead> getLeadByCampagneId(Integer id);
}
