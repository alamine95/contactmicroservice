package sn.cfoa.contactmicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sn.cfoa.contactmicroservice.model.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer> {

}
