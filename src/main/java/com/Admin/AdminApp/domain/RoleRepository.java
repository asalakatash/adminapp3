package com.Admin.AdminApp.domain;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository <Role, Long> {
	@Query(nativeQuery=true)
	Set<RolesOnHP> getRolesOnHP();
}
