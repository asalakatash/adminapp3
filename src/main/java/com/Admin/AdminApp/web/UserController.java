package com.Admin.AdminApp.web;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.usertype.UserCollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Admin.AdminApp.domain.Permission;
import com.Admin.AdminApp.domain.PermissionRepository;
import com.Admin.AdminApp.domain.RoleRepository;
import com.Admin.AdminApp.domain.RolesOnHP;
import com.Admin.AdminApp.domain.UserRepository;
import com.Admin.AdminApp.domain.UserRoleArray;
import com.Admin.AdminApp.domain.Users;
import com.Admin.AdminApp.domain.UsersOnHP;
import com.Admin.AdminApp.domain.UsersRoleArray;
import com.Admin.AdminApp.domain.UsersWithRole;


@RestController
public class UserController {
	@Autowired 
	private UserRepository repository;
	@Autowired 
	private PermissionRepository prepository;

	  @RequestMapping("/usersonhp")
	  public Set<UsersOnHP> getUsersOnHP() 
	  {
         return repository.getUsersOnHP();
      }
      @RequestMapping("/users")
      public Iterable<Users> getUsers() {
        return repository.findAll();
      }
      
      @RequestMapping("/userrole/{id}")
      public ArrayList<UsersRoleArray> getUsersRoleArray(@PathVariable long id){
    	  return repository.getUsersRoleArray(id);
      }
      
      @RequestMapping("/userswithrole")
      public Set<UsersWithRole> getUsersWithRole() {
        return repository.getUsersWithRole();
      }

	} 


