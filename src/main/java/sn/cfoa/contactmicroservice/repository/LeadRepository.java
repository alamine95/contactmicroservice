package sn.cfoa.contactmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.cfoa.contactmicroservice.model.Lead;

public interface LeadRepository extends JpaRepository<Lead, Integer> {

}
