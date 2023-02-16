package sn.cfoa.contactmicroservice.repository;

import org.springframework.data.repository.CrudRepository;

import sn.cfoa.contactmicroservice.model.Tache;

public interface TacheRepository extends CrudRepository<Tache, Integer> {

}
