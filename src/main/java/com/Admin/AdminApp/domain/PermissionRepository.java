package com.Admin.AdminApp.domain;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PermissionRepository extends CrudRepository <Permission, Long> {
	@Query(nativeQuery=true)
    Set<pojoPermission> getPermissions();
}
