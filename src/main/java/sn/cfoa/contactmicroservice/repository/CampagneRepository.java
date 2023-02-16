package sn.cfoa.contactmicroservice.repository;

import org.springframework.data.repository.CrudRepository;

import sn.cfoa.contactmicroservice.model.Campagne;

public interface CampagneRepository extends CrudRepository<Campagne, Integer> {
	
}
