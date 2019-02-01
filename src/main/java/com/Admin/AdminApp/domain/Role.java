package com.Admin.AdminApp.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@Entity
@SqlResultSetMapping(
		name="RolesOnHPMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=RolesOnHP.class,
	            columns={
	                @ColumnResult(name="ROLE_NAME", type = String.class),
	                @ColumnResult(name="DESCRIPTION", type = String.class),
	                @ColumnResult(name="PER_NAME", type = String.class),
	                @ColumnResult(name="ASSIGNED", type = String.class)

	            }
	        )
	    }
	)
@NamedNativeQuery(name="Role.getRolesOnHP",
query=" select r.ROLE_NAME ,r.DESCRIPTION  , (SELECT STRING_AGG(p.PER_NAME , ' / ' ) "+
" from ROLE r1 join ROLE_PERMISSION pr on r1.ROLE_ID =pr.ROLE_ID "+
" join PERMISSION p on p.PER_ID =pr.PERMISSION_ID "+
  " where r1.ROLE_ID =r.ROLE_ID ) as PER_NAME,count(r.ROLE_NAME ) as ASSIGNED "+
" from ROLE r "+
 " join ROLE_PERMISSION pr on r.ROLE_ID =pr.ROLE_ID "+
 " join PERMISSION p on p.PER_ID =pr.PERMISSION_ID "+
" group by  r.ROLE_NAME ,r.ROLE_ID, r.DESCRIPTION ",
	resultSetMapping="RolesOnHPMapping")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long RoleId;
	@Column(unique=true)
	private String Role_name;
	private String Description;
	
	@ManyToMany(mappedBy = "roles")
	private Set<Users> users;
	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	 @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE})
    @JoinTable(name = "Role_Permission", joinColumns = @JoinColumn(name = "Role_Id", referencedColumnName = "RoleId"),
    inverseJoinColumns = @JoinColumn(name = "permission_Id", referencedColumnName = "perId"))
    private Set<Permission> Permissions;
	public Set<Permission> getPermissions() {
		return Permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		Permissions = permissions;
	}

	public Role() {
		super();
	}
    


	public Role(String role_name, String description, Set<Permission> permissions) {
		super();
		Role_name = role_name;
		Description = description;
		Permissions = permissions;
	}

	public Role(String role_name, String description) {
		super();
		Role_name = role_name;
		Description = description;
	}

	public String getRole_name() {
		return Role_name;
	}

	public void setRole_name(String role_name) {
		Role_name = role_name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	


}
