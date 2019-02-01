package com.Admin.AdminApp.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository <Users, Long> {

	@Query(nativeQuery=true)
    Set<UsersOnHP> getUsersOnHP();
	@Query(nativeQuery=true)
    ArrayList<UsersRoleArray> getUsersRoleArray(@Param("userid") long userid);
	@Query(nativeQuery=true)
    Set<UsersWithRole> getUsersWithRole();
}
