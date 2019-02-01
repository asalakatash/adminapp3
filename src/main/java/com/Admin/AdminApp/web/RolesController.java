package com.Admin.AdminApp.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Admin.AdminApp.domain.RoleRepository;
import com.Admin.AdminApp.domain.RolesOnHP;


@RestController
public class RolesController {
	@Autowired 
	private RoleRepository rolerepository;

	@RequestMapping("/rolesonhp")
	public Set<RolesOnHP> getRolesOnHP() 
	{
		return rolerepository.getRolesOnHP();	 
	}
	
	
}
