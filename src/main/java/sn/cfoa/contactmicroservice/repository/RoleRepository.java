package sn.cfoa.contactmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.cfoa.contactmicroservice.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByNom(String roleNom);
}
