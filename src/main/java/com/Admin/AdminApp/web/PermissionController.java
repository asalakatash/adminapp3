package com.Admin.AdminApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Admin.AdminApp.domain.Permission;
import com.Admin.AdminApp.domain.PermissionRepository;

@RestController
public class PermissionController {
	@Autowired
	private PermissionRepository perRepository;
	
	@RequestMapping("/permissions")
	public Iterable<Permission> getpermissions() {
		return perRepository.findAll();
	}
}
